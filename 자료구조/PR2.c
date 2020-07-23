#define _CRT_SECURE_NO_WARNINGS //파일 입출력 명령어 그대로 쓰기 위해 define
#include <stdio.h> //입출력 헤더파일
#include <stdlib.h> //동적할당을 위한 헤더파일
#include <time.h> //clock을 위한 헤더파일

//자주 쓰이는 swap 함수를 미리 구현해둠
void swap(double *x, double *y) { //value가 아닌 reference로 저장
	double t; //값을 임시로 저장해둘 변수
	t = *x; //x값을 t에 옮겨놓고
	*x = *y; //y값을 x에 대입
	*y = t; //t값을 y에 대입 -> x와 y의 값이 바뀜
}

//삽입정렬 함수 - 정렬되어 있는 앞 부분에 새로운 레코드를 올바른 위치에 삽입하는 과정 반복
void insertion_sort(double list[], int n) {
	int i, j;
	double key;
	for (i = 0; i < n; i++) { //n번 반복
		key = list[i]; //i번째 원소를 key에 대입
		for (j = i - 1; j >= 0 && list[j] > key; j--) //list의 j번째 원소가 key값보다 크면
			list[j + 1] = list[j]; //j+1번째로 해당 원소를 옮김
		list[j + 1] = key; //j--하며 위의 과정을 모두 거치고 난 후 j+1번째에 key값 넣기
	}
}

//퀵정렬에 필요한 분할 함수
double partition(double list[], int left, int right) {
	int low, high; //두 개의 인덱스 변수 사용
	double pivot;

	low = left;
	high = right + 1;
	pivot = list[left]; //축값은 리스트의 가장 왼쪽 원소라고 가정

	do {
		do
			low++; //low를 +1
		while (low <= right && list[low] < pivot); //low가 right보다 작고, list[low]가 축값보다 작을 동안 반복

		do
			high--; //high를 -1
		while (high >= left && list[high] > pivot); //high가 left보다 크고, list[high]가 축값보다 클 동안 반복

		if (low < high)
			swap(&list[low], &list[high]); //만약 low가 high보다 작다면 low번째 원소와 high번째 원소 위치 바꾸기
	} while (low < high); //low<high일동안 위 과정 반복

	swap(&list[left], &list[high]); //left번째 원소와 high번째 원소 위치 바꾸기
	return high; //high값 return
}

//퀵정렬 함수 - 축값을 중심으로 하나의 리스트를 두개로 분할하고 각 부분리스트를 다시 퀵정렬(재귀호출)
void quick_sort(double list[], int left, int right) {
	if (left < right) {
		int q = partition(list, left, right); //분할 함수로 축값 구해서
		quick_sort(list, left, q - 1); //축값보다 작은 부분리스트 다시 퀵정렬(축값제외)
		quick_sort(list, q + 1, right); //축값보다 큰 부분리스트 다시 퀵정렬(축값제외)
	}
}

//힙정렬에 필요한 adjust 함수
void adjust(double list[], int root, int n) {
	int child;
	double rootkey;
	rootkey = list[root]; //받아온 root번째의 원소를 대입
	child = 2 * root + 1; //해당 노드의 왼쪽 자식 노드
	while (child <= n - 1) {
		if ((child < n - 1) && (list[child] < list[child + 1]))
			child++;
		if (rootkey > list[child])
			break; //root값이 child번째 원소보다 큰 경우 멈춤
		else { //위의 경우가 모두 아닌 경우
			list[(child - 1) / 2] = list[child]; //root번째 원소의 자리에 child번째 원소 넣기
			child = 2 * child + 1; //child는 원래 child의 자식 노드로 내려감
		}
	}
	list[(child - 1) / 2] = rootkey; //child번째 원소의 자리에 root번째 원소에 원래 있던 값 대입(자리 교체)
}

//힙정렬 함수
void heap_sort(double list[], int n) {
	int i;
	for (i = (n - 1) / 2; i >= 0; i--) {
		adjust(list, i, n); //이진트리의 왼쪽/오른쪽 부분트리가 최대 힙일 때, 루트를 포함해 최대힙 되도록 조정
	}
	for (i = n - 2; i >= 0; i--) {
		swap(&list[0], &list[i + 1]); //리스트의 최댓값(루트)를 정렬된 왼편 부분 리스트의 마지막 노드와 교환
		adjust(list, 0, i + 1);//나머지 리스트를 최대 힙으로 재구성
	}
}

//메인 함수
int main() {

	//소속 : 컴퓨터공학전공
	//학번 : 1871047
	//이름 : 장세영

	FILE *fp;//파일포인터 선언
	fp = fopen("파일경로\\d_data3.txt", "r");
	double *list; //double형을 담을 리스트 참조변수 선언
	int n;

	if (fp != NULL) {
		fscanf(fp, "%d", &n);//첫번째 수를 불러와 n에 저장
		list = (double *)malloc(sizeof(double) * n); //배열에 n개만큼 메모리 동적 할당.
		printf("입력 파일 = d_data3.txt (n = %d)\n", n);

		printf("\n\n<삽입정렬>\n");
		for (int i = 0; i < n; i++) { //n은 앞으로 나올 다항식의 항이 몇개인지 알려주는 수이므로 n만큼 반복문을 돌림
			fscanf(fp, "%lf", &list[i]); //빈칸을 기준으로 수를 구분하여 읽어와 배열에 순서대로 저장
		}
		clock_t start = clock(); // 시작 시간 저장
		insertion_sort(list, n); //삽입정렬 실행
		clock_t end = clock(); // 코드가 끝난 시간 저장
		printf("정렬 결과 = ");
		for (int i = 0; i < 10; i++) {
			printf("%lf ", list[i]); //앞에서부터 10개
		}
		for (int i = n - 10; i < n; i++) {
			printf("%lf ", list[i]); //뒤에서부터 10개
		}
		printf("\n소요시간 : %lf\n", (double)(end - start) / CLOCKS_PER_SEC);//소요시간출력


		printf("\n\n<퀵정렬>\n");
		fseek(fp, 0, SEEK_SET); //파일의 첫번째로 다시 돌아감
		fscanf(fp, "%d", &n);//첫번째 수를 불러와 n에 저장
		for (int i = 0; i < n; i++) { //n은 앞으로 나올 다항식의 항이 몇개인지 알려주는 수이므로 n만큼 반복문을 돌림
			fscanf(fp, "%lf", &list[i]); //빈칸을 기준으로 수를 구분하여 읽어와 배열에 순서대로 저장
		}
		start = clock(); // 시작 시간 저장
		quick_sort(list, 0, n - 1); //퀵정렬 실행
		end = clock(); // 코드가 끝난 시간 저장
		printf("정렬 결과 = ");
		for (int i = 0; i < 10; i++) {
			printf("%lf ", list[i]); //앞에서부터 10개
		}
		for (int i = n - 10; i < n; i++) {
			printf("%lf ", list[i]); //뒤에서부터 10개
		}
		printf("\n소요시간 : %lf\n", (double)(end - start) / CLOCKS_PER_SEC);//소요시간출력



		printf("\n\n<힙정렬>\n");
		fseek(fp, 0, SEEK_SET);//파일의 첫번째로 다시 돌아감
		fscanf(fp, "%d", &n);//첫번째 수를 불러와 n에 저장
		for (int i = 0; i < n; i++) { //n은 앞으로 나올 다항식의 항이 몇개인지 알려주는 수이므로 n만큼 반복문을 돌림
			fscanf(fp, "%lf", &list[i]); //빈칸을 기준으로 수를 구분하여 읽어와 배열에 순서대로 저장
		}
		start = clock(); // 시작 시간 저장
		heap_sort(list, n); //힙정렬 실행
		end = clock(); // 코드가 끝난 시간 저장
		printf("정렬 결과 = ");
		for (int i = 0; i < 10; i++) {
			printf("%lf ", list[i]); //앞에서부터 10개
		}
		for (int i = n - 10; i < n; i++) {
			printf("%lf ", list[i]); //뒤에서부터 10개
		}
		printf("\n소요시간 : %lf\n", (double)(end - start) / CLOCKS_PER_SEC);//소요시간출력

		free(list); //동적할당 받은 메모리를 free 처리
		fclose(fp);//파일 닫기
	}
	else
		printf("파일 읽어오기 실패");
}
