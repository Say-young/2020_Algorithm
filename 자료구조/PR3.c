#define _CRT_SECURE_NO_WARNINGS //파일 입출력 명령어 그대로 쓰기 위해 define
#include <stdio.h> 
#include <stdlib.h> 

#define MAX_VERTEX 50
#define MAX_STACK_SIZE 1000

typedef struct GraphNode {
	int vertex;
	GraphNode *link;
}GraphNode;

typedef struct GraphType {
	int n; //정점의 개수
	GraphNode *adj_list[MAX_VERTEX];
}GraphType;

//노드 번호를 넣었다가 출력할 스택 선언
typedef struct {
	int stack[MAX_STACK_SIZE];
	int top;
} StackType;

//그래프 초기화 함수
void init_graph(GraphType *g)
{
	for (int i = 0; i < MAX_VERTEX; i++)
		g->adj_list[i] = NULL; //g의 adj_list 내용을 모두 비우고
	g->n = 0; //n값을 0으로 초기화
}

//vertex 삽입 함수
void insert_vertex(GraphType *g)
{
	if ((g->n) + 1 > MAX_VERTEX) //노드 개수가 adj_list의 인덱스보다 많다면
	{
		printf("정점의 수가 많아 스택에 담을 수 없습니다.\n"); //에러메세지 출력
		exit(-1); //종료
	}
	//아니라면
	g->n++; //n+1
}

//edge 삽입 함수
void insert_edge(GraphType *g, int u, int v) //파라미터로 graphtype 참조변수와 메모장의 정수 두 개를 받는다
{
	//만약 (에지가 출발하는) 정점의 번호가 n보다 크거나, (에지가 도착하는) 정점의 번호가 n보다 클 경우
	if (u >= g->n || v >= g->n)
	{
		//정점의 번호가 틀렸으므로 에러 메세지 출력
		printf("정점 번호가 올바르지 않습니다.\n");
		exit(-1);//종료
	}

	//node에 메모리 동적 할당
	GraphNode *node = (GraphNode*)malloc(sizeof(GraphNode));
	if (!node) //만약 node가 비어있다면
	{
		printf("메모리 할당 에러\n");
		exit(-1);
	}
	//메모리 할당이 제대로 이루어졌다면
	node->vertex = v; //node의 vertex에 v값을 대입
	node->link = g->adj_list[u]; //node의 link에 g의 adj_list[(에지가 도착하는)정점의 번호]를 대입
	g->adj_list[u] = node; //adj_list[(에지가 도착하는)정점의 번호]에 node를 대입
}

//스택 초기화 함수
void init(StackType *s)
{
	//스택의 초기화는 top을 가장 밑으로 내리는 것
	s->top = -1;
}

//스택이 비어있는지 확인하는 함수
int is_empty(StackType *s)
{
	//스택의 top이 -1이 맞는지 아닌지를 반환
	return (s->top == -1);
}

//스택이 꽉 차있는지 확인하는 함수
int is_full(StackType *s)
{
	//스택의 top이 최대사이즈-1과 같은지 다른지를 반환
	return (s->top == (MAX_STACK_SIZE - 1));

}

//스택 안에 원소를 넣는 함수
void push(StackType *s, int num)
{
	//만약 스택이 꽉 차있으면 원소를 넣을 수 없으므로 체크
	if (is_full(s)) {
		fprintf(stderr, "스택 포화 에러\n");
		return;
	}
	//스택이 비어있다면 top+1의 인덱스에 원소 num 넣기
	else s->stack[++(s->top)] = num;
}

//스택 안에서 원소를 꺼내는 함수
int pop(StackType *s)
{
	//스택이 비어있으면 꺼낼 원소가 없으므로 체크
	if (is_empty(s)) {
		fprintf(stderr, "스택 공백 에러\n");
		exit(1);
	}
	//만약 스택 안에 꺼낼 원소가 있다면 먼저 top의 인덱스의 원소를 반환한 후 top-1
	else return s->stack[(s->top)--];
}

//위상정렬함수
int top_sort(GraphType *g)
{
	int i, u, v;
	StackType s; //스택 선언
	GraphNode *node;

	int *in_degree = (int*)malloc(sizeof(int)*g->n); //각 정점의 차수를 계산하기 위한 배열. 메모리 동적할당

	for (i = 0; i < g->n; i++)
		in_degree[i] = 0; // 모든 배열의 값 0으로 초기화 

	for (i = 0; i < g->n; i++)
	{
		node = g->adj_list[i]; //node에 adj_list[i]의 값을 대입하는데
		while (node != NULL) //node가 null이 아니면
		{
			in_degree[node->vertex]++; // 정점 i에 도착하는 간선수(차수) +1
			node = node->link; //다음 link로 건너가서 null을 만날 때까지 이 과정 반복
		}
	}

	//스택 초기화
	init(&s);

	for (i = 0; i < g->n; i++)
	{
		if (in_degree[i] == 0)
			push(&s, i);// 차수가 0인 정점을 스택에 저장
	}

	printf("위상 정렬 결과 = ");
	while (!is_empty(&s)) // 결과를 출력하려면 스택이 비어있지 않아야
	{
		v = pop(&s); // 진입 차수가 없는 정점 v 
		printf("%d ", v); //정점(vertex) v 출력
		node = g->adj_list[v]; // 차수가 0인 정점을 출력했으므로 해당 정점은 사라진 것과 마찬가지. 정점의 차수 변경

		while (node != NULL)
		{
			u = node->vertex; //node의 정점을 u에 대입
			in_degree[u]--; // u의 차수 감소하고(v에서 u로 도착하는 간선이었는데 v가 이제 없으니까) 
			if (in_degree[u] == 0) {
				push(&s, u); //정점 u를 스택에 저장
			}
			node = node->link; // 연결된 모든 간선을 제거
		}
	}

	if (in_degree[u] != 0) //아직 모든 정점을 출력하지 않았는데 내향 차수가 0인 정점이 없는 경우
		printf("불가능"); //불가능 메세지 출력

	free(in_degree); //다 끝난 후 동적 할당 해제
	return 0;
}

//메인함수
int main()
{
	GraphType graph; //graph 선언
	init_graph(&graph); //graph 초기화

	int n, e, v, u;
	FILE *fp;//파일포인터 선언
	fp = fopen("파일경로\\dag1.txt", "r"); //메모장 열기
	fscanf(fp, "%d %d", &n, &e); //첫 줄의 n은 총 정점의 수, e는 총 에지의 수

	for (int i = 0; i < n; i++)
		insert_vertex(&graph); //총 정점의 개수 n만큼 정점 추가

	for (int i = 0; i < e; i++) { //총 에지의 개수 e만큼 반복
		fscanf(fp, "%d %d", &v, &u); //메모장의 수를 두 개씩 불러와 각각 저장하고
		insert_edge(&graph, v, u); //해당 에지 삽입
	}

	top_sort(&graph); //삽입이 끝난 후 위상정렬
	fclose(fp); //파일 닫기
	return 0; 
}