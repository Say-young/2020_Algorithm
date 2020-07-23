#include <stdio.h>
#include <stdlib.h>

int M, n;					//외부 파일에서 받아올 배낭 크기 변수와 노드 개수 변수 선언
int* bestset, *include;	//해벡터를 저장할 배열 선언
int maxprofit;				//최대 이윤을 저장할 변수

//모든 작업을 한번에 처리하기 위해서 구조체 선언
struct PW {
	int* pi;			//내림차순 정렬할 pi
	int* wi;			//내림차순 정렬할 wi
	float* pw;			//내림차순 정렬하는데 기준이 될 pi/wi
	int* idx;			//index
};

/* 삽입정렬 - 내림차순 정렬용 */
void insertion_sort(int p[], int w[], struct PW pw) {
	float key = 0;
	int j = 0, k = 0;
	for (int i = 0; i < n; i++) {							//삽입정렬을 이용한 내림차순 정렬
		key = pw.pw[i];										//비교 기준값인 key값 설정
		k = pw.idx[i];
		for (j = i - 1; j >= 0 && pw.pw[j] < key; j--) {    //key값보다 앞에 있는 원소 중 만약 key값보다 작은 원소가 있다면
			pw.pw[j + 1] = pw.pw[j];						//뒤로 옮기기
			pw.pi[j + 1] = pw.pi[j];
			pw.wi[j + 1] = pw.wi[j];
			pw.idx[j + 1] = pw.idx[j];
		}
		pw.pw[j + 1] = key;									//맨 앞에 남은 자리에 key값에 저장해뒀던 값 저장
		pw.pi[j + 1] = p[i];								//pi, wi도 함께 저장(pi/wi 내림차순 순서대로 DFS에 사용되므로)
		pw.wi[j + 1] = w[i];
		pw.idx[j + 1] = k;
	}
}

//해당 노드가 promising 한지 확인하는 함수
bool promising(int i, int profit, int weight, struct PW pw) {
	int j, k;
	int totweight;											//해당 노드의 시점에서 가질 수 있는 최대 wi
	float bound;											//upperbound(최대 이윤)

	if (weight > M) {
		return false;										//노드의 wi가 M를 초과한 경우는 nonpromising하다
	}
	else {
		j = i;
		bound = profit;										//현재 pi부터 bound 계산
		totweight = weight;									//현재 wi부터 totweight 계산
		while (j < n && totweight + pw.wi[j] <= M) {		//이후 노드의 wi를 더했을 때 totweight가 M을 넘지 않을 때까지 더함 
			totweight += pw.wi[j];							//해당 노드 이후의 pi 더함
			bound = bound + pw.pi[j];						//해당 노드 이후의 wi 더함
			j++;											//위의 조건을 만족할 때까지 계속 반복
		}
		k = j;
		if (k < n) bound += (M - totweight)*(pw.pi[k]/pw.wi[k]);		//만약 모든 노드를 위에서 더하지 못했다면 다음 노드의 pi 중 (M-totweight)/wi만큼 더함
		return (bound > maxprofit);										//maxprofit이 이후 더 커질 가능성이 있다면 (bound가 현재의 maxprofit보다 크다면) promising하다
	}
}

/* 배낭 DFS (with branch-and-bound) 함수 */
void knapsack(int i, int profit, int weight, struct PW pw) {
	if (weight <= M && profit > maxprofit) {					//최대 무게를 넘지 않으면서 현재 best solution이면 저장
		maxprofit = profit;										//최대 이윤을 maxprofit 저장
		for (int k = 1; k <= n; k++) {								//best solution을 저장하는 bestset 배열에 현재 solution 저장
			bestset[k] = include[k];
		}
	}
	if (promising(i, profit, weight, pw)) {							//현재 노드가 promising한지 확인. true일 경우만 아래 코드 실행.
		include[i + 1] = 1;											//다음 순서의 노드를 포함하는 경우
		knapsack(i + 1, profit + pw.pi[i], weight + pw.wi[i], pw);  //다음 노드의 pi와 wi를 더해서 재귀적으로 knapsack 실행
		include[i + 1] = 0;											//다음 순서의 노드를 포함하지 않는 경우
		knapsack(i + 1, profit, weight, pw);						//현재와 동일한(다음 노드의 것을 더하지 않은) pi와 wi로 재귀적으로 knapsack 실행
	}
}

int main() {

	/*	1. 파일에서 정보를 가져오기	*/
	FILE *fp;											//파일 입출력을 위해 파일 포인터를 선언하는 과정
	fp = fopen("파일경로\\p2data1.txt", "r");

	fscanf(fp, "%d", &n);								//파일에서 읽어온 노드 개수를 n에 저장

	bestset = (int *)malloc((n + 1) * sizeof(int));     //최종 해벡터를 저장할 배열
	include = (int *)malloc((n + 1) * sizeof(int));     //현재의 best solution을 저장할 배열
	for (int i = 0; i <= n; i++) {                      //bestset, include 초기화 작업
		include[i] = 0;
		bestset[i] = 0;
	}
	int * index = (int *)malloc(n * sizeof(int));          //해벡터를 원래(파일에서 읽어온) 노드 순서로 변환할 때 사용할 인덱스 배열
	int * fin_bestset = (int *)malloc(n * sizeof(int));    //원래 파일에서 읽어온 순서대로 해백터를 저장하기 위해 선언한 배열

	int* p = (int *)malloc(n * sizeof(int));               //파일에서 pi 받아와서 저장할 배열
	int* w = (int *)malloc(n * sizeof(int));               //파일에서 wi 받아와서 저장할 배열
	float* pw = (float *)malloc(n * sizeof(float));        //파일에서 받아온 pi,wi로 pi/wi 계산해서 저장할 배열

	int* sorted_p = (int *)malloc(n * sizeof(int));        //정렬해서 저장될 pi를 위한 배열
	int* sorted_w = (int *)malloc(n * sizeof(int));        //정렬해서 저장될 wi를 위한 배열
	float* sorted_pw = (float *)malloc(n * sizeof(float)); //정렬해서 저장될 pi/wi를 위한 배열

	//아래는 파일에서 읽어온 정보들을 저장하는 과정
	for (int i = 0; i < n; i++) {
		fscanf(fp, "%d", &p[i]);
	}
	for (int i = 0; i < n; i++) {
		fscanf(fp, "%d", &w[i]);
	}
	for (int i = 0; i < n; i++) {
		pw[i] = (float)p[i] / w[i];
	}

	//사용할 배열들을 복사 및 초기화
	for (int i = 0; i < n; i++) {
		sorted_p[i] = p[i];
	}
	for (int i = 0; i < n; i++) {
		sorted_w[i] = w[i];
	}
	for (int i = 0; i < n; i++) {
		sorted_pw[i] = pw[i];
	}
	for (int i = 0; i < n; i++) {
		index[i] = i;
	}

	//M(kanpsack capacity) 읽어와서 저장
	fscanf(fp, "%d ", &M);

	//구조체 변수 선언 및 위에서 선언한 배열 대입
	struct PW pw_init;
	pw_init.pi = sorted_p;
	pw_init.wi = sorted_w;
	pw_init.pw = sorted_pw;
	pw_init.idx = index;


	/*	2. knapsack 실행 및 결과 출력용 배열 준비	*/
	insertion_sort(p, w, pw_init);					//pi, wi, pi/wi를 정렬해 각각 구조체의 해당 배열에 저장
	knapsack(0, 0, 0, pw_init);						//Knapsack(dfs) 실행. pi와 wi는 0으로 초기화
	int j = 0;										//해벡터를 원래 obj 순서대로 출력하는데 사용할 변수
	for (int i = 0; i < n; i++) {					//내림차순으로 정렬된 노드의 순서대로 정해진 bestset를 원래 노드 순서대로 변경하는 과정
		j = index[i];								//index에 저장된 노드의 원래 순서를 불러와서 j에 저장
		fin_bestset[j] = bestset[i + 1];			//result의 j 위치에 해당 노드의 해벡터 결과 저장 -> 출력시 원래 노드 순서대로 출력됨
	}


	/*	3. 결과 출력  */
	printf("n = %d", n);
	printf("\npi = ");
	for (int i = 0; i < n; i++) {
		printf("%d ", p[i]);
	}
	printf("\nwi = ");
	for (int i = 0; i < n; i++) {
		printf("%d ", w[i]);
	}
	printf("\npi/wi = ");;
	for (int i = 0; i < n; i++) {
		printf("%.1f ", pw[i]);
	}
	printf("\nM = %d", M);

	printf("\n\nThe maximun profit is $%d", maxprofit);
	printf("\nThe solution vector X = (%d", fin_bestset[0]);
	for (int i = 1; i < n; i++) {
		printf(", %d", fin_bestset[i]);
	}
	printf(")\n");
}