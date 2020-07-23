#include <stdio.h> //입출력 헤더파일
#include <stdlib.h> //동적할당을 위한 헤더파일
#include <math.h> //pow함수를 위한 헤더파일

//앞으로 사용할 연결리스트를 먼저 정의한다
typedef struct ListNode {
	int coef;//계수에 해당하는 변수
	int exp;//지수에 해당하는 변수
	struct ListNode *link;//다음 노드를 가리키는 link
}ListNode;

//연결리스트 헤더
typedef struct ListHeader {
	int length; //연결리스트의 길이에 해당하는 변수
	ListNode *head;//헤더가 가리키는 연결리스트의 첫번째 노드
	ListNode *tail;//헤더가 가리키는 연결리스트의 마지막 노드
}ListHeader;

//입력받은 다항식의 항을 연결리스트에 삽입하는 함수
//plist는 연결 리스트의 헤더를 가리키는 포인터, coef는 계수, exp는 지수
void insert_node_last(ListHeader *plist, int coef, int exp) {
	ListNode *temp = (ListNode *)malloc(sizeof(ListNode)); //동적 메모리 할당
	if (temp == NULL) "메모리 할당 에러"; //temp가 NULL일 경우 에러
	temp->coef = coef; //받아온 coef 값을 temp의 coef 값으로 넣는다
	temp->exp = exp; //받아온 exp 값을 temp의 exp 값으로 넣는다
	temp->link = NULL; //temp는 마지막 노드이므로 temp의 link는 NULL
	if (plist->tail == NULL) { //연결리스트가 비어있는 경우
		plist->head = plist->tail = temp; //헤더의 head와 tail 모두에 temp를 연결
	}
	else { //비어있지 않은 경우
		plist->tail->link = temp; //tail의 link가 temp를 가리키게 하고
		plist->tail = temp; //헤더의 tail에 temp 연결
	}
	plist->length++; //노드가 추가되었으니 연결리스트의 길이는 +1된다.
}

//파일에서 값을 받아오는 함수
//main에서 파일입출력 포인터변수를 선언했으므로 인자로 fp를 받아와야 한다
void poly_read(ListHeader *plist, FILE* fp) {
	int n, coef, exp;
	fscanf(fp, "%d", &n);//첫번째 수를 불러와 n에 저장
	for (int i = 0; i < n; i++) { //n은 앞으로 나올 다항식의 항이 몇개인지 알려주는 수이므로 n만큼 반복문을 돌린다
		fscanf(fp, "%d %d", &coef, &exp); //한 행의 두 수를 모두 읽어와 각각 coef와 exp에 저장
		insert_node_last(plist, coef, exp); //insert_node_last 함수를 이용해 새로운 항을 연결리스트에 추가
	}
}

//두 다항식의 지수를 비교하여 덧셈을 하는 함수
void poly_add(ListHeader *plist1, ListHeader *plist2, ListHeader *plist3) {
	//덧셈을 하기 위해서는 우선 2개의 다항식 필요
	ListNode *a = plist1->head;
	ListNode *b = plist2->head;
	int sum; //지수가 같을 경우 해당 항들의 계수를 더할 때 사용
	while (a&&b) { //a와 b가 모두 NULL이 아닐 때 반복
		if (a->exp == b->exp) { //a와 b의 지수가 같을 경우
			sum = a->coef + b->coef; //각 항의 계수를 더해서 sum에 대입
			//sum이 0이 아닐 경우 연결리스트(list3이 될 것)에 계수(sum)와 지수(a의 지수값)을 추가
			if (sum != 0) insert_node_last(plist3, sum, a->exp);
			a = a->link; //a의 다음 노드로 
			b = b->link; //b의 다음 노드로
		}
		else if (a->exp > b->exp) { //a의 지수가 더 클 경우
			insert_node_last(plist3, a->coef, a->exp); //a의 항을 연결리스트에 추가
			a = a->link; //a의 다음 노드로
		}
		else { //b의 지수가 더 클 경우
			insert_node_last(plist3, b->coef, b->exp); //b의 항을 연결리스트에 추가
			b = b->link; //b의 다음 노드로
		}
	}
	//만약 a나 b 중의 하나가 먼저 끝나게 되면 남아있는 항들을 모두 결과 다항식으로 복사
	for (; a != NULL; a = a->link)
		insert_node_last(plist3, a->coef, a->exp);
	for (; b != NULL; b = b->link)
		insert_node_last(plist3, b->coef, b->exp);
}

//다항식에 값 x를 대입했을 때 결과를 반환하는 함수
//메인에서 x 값을 받으므로 파라미터로 x도 함께 받아와야 함
int poly_eval(ListHeader *plist, int x) {
	ListNode *p = plist->head;
	int a=0;
	int xpower;
	//계수만큼 몇승을 해주는 게 필요
	for (int i = 0; i<plist->length; i++) { //연결리스트의 마지막 노드까지 반복
		xpower = pow(x, p->exp); //해당 항의 지수만큼 x를 거듭제곱
		a = a + (p->coef) * xpower; //해당 항의 계수와 거듭제곱된 x를 곱하여 a에 대입
		p = p->link; //p는 다음 노드로 옮겨서 반복문 계속 실행
	}
	return a; //계산이 다 끝나면 a값 반환
}

//다항식 결과를 출력하는 함수
void poly_print(ListHeader *plist) {
	ListNode *p = plist->head;
	if (p == NULL) //p가 NULL일 경우 0을 출력
		printf("0");
	else {
		for (; p; p = p->link) { //순차적으로 연결리스트를 따라가며 반복
			printf("%dx^%d", p->coef, p->exp); //계수와 지수를 출력
			if (p->link != NULL) //만약 다음 해당 노드의 link가 NULL이 아니라면
				printf(" + "); //뒤에 또 다른 항이 나온다는 이야기이므로 + 출력
		}
	}
}

//초기화 함수
void init(ListHeader *plist) {
	plist->length = 0;
	plist->head = plist->tail = NULL;
}

int main() {

	//연결리스트 선언
	ListHeader list1, list2, list3;
	
	//초기화
	init(&list1);
	init(&list2);
	init(&list3);

	//파일포인터 선언
	FILE *fp;
	fp = fopen("poly5.txt", "r"); // txt파일을 cpp파일과 같은 곳에 뒀음
	
	//각각의 리스트에 해당하는 값을 읽어와 연결리스트에 저장
	poly_read(&list1, fp);
	//다항식 출력
	printf("p(x) = ");
	poly_print(&list1);

	//위와 같음
	poly_read(&list2, fp);
	printf("\nq(x) = ");
	poly_print(&list2);

	//위와 같음
	poly_add(&list1, &list2, &list3);
	printf("\nr(x) = ");
	poly_print(&list3);
	
	//대입할 값인 변수 x 선언
	int x;
	fscanf(fp, "%d", &x); //메모장에서 x에 해당하는 값 받아오기
	printf("\np(%d) = %d", x, poly_eval(&list1, x)); //x를 다항식에 대입한 결과 출력
	fscanf(fp, "%d", &x);//메모장에서 x에 해당하는 값 받아오기
	printf("\nq(%d) = %d", x, poly_eval(&list2, x));//x를 다항식에 대입한 결과 출력
	fscanf(fp, "%d", &x);//메모장에서 x에 해당하는 값 받아오기
	printf("\nr(%d) = %d", x, poly_eval(&list3, x));//x를 다항식에 대입한 결과 출력
	fclose(fp);//파일 닫기
}