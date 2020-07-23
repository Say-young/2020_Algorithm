#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int count;	//비교 횟수를 담을 변수

/*	삽입정렬 - 내림차순 정렬용	*/
void insertion_sort(double list[], int n) {
	int i, j;	//삽입 정렬에서만 사용할 변수이므로 함수 내부에서 선언
	double key;	//해당 차례에 맞는 위치를 찾을 값

	//원소의 개수(n)만큼 반복
	for (i = 1; i < n; i++) {
		key = list[i];
		//sort된 배열을 역으로 탐색하며 key값보다 작은 값이 있을 경우 위치 변경
		for (j = i - 1; j >= 0 && list[j] < key; j--) {
			list[j + 1] = list[j];
		}
		list[j + 1] = key;
	}
}

/*	병합정렬 - 오름차순 정렬용	*/
double sorted[100000]; // 추가 공간 필요하므로 미리 선언
void merge(double list[], int left, int mid, int right) {
	int i, j, k, l;
	// i는 정렬된 왼쪽리스트에 대한 인덱스
	// j는 정렬된 오른쪽리스트에 대한 인덱스
	// k는 정렬될 리스트에 대한 인덱스
	i = left;
	j = mid + 1;
	k = left;

	//분할된 list를 합병하는 과정
	while (i <= mid && j <= right) {
		if (list[i] <= list[j]) {
			sorted[k++] = list[i++];	//오름차순으로 정렬하려면 작은 원소부터 가져와야
		}
		else {
			sorted[k++] = list[j++];	//오름차순으로 정렬하려면 작은 원소부터 가져와야
		}
		count++;
	}
	
	//합치는 과정 이후 남은 원소가 있는 경우
	if (i > mid) { 
		for (l = j; l <= right; l++) {
			sorted[k++] = list[l];		// 남아 있는 원소들을 전체 복사
		}
	}
	else { 
		for (l = i; l <= mid; l++) {
			sorted[k++] = list[l];		// 남아 있는 원소들을 전체 복사
		}
	}

	//정렬 완료 후 배열에 정렬된 결과를 대입하기
	for (l = left; l <= right; l++) {
		list[l] = sorted[l];		// sorted의 원소들을 list로 복사
	}
}

void merge_sort(double list[], int left, int right) {
	int mid;
	if (left < right) {
		mid = (left + right) / 2;			// mid를 기준으로 list를 반으로 분할
		merge_sort(list, left, mid);		// (왼쪽)부분리스트 정렬
		merge_sort(list, mid + 1, right);	// (오른쪽) 부분리스트 정렬
		merge(list, left, mid, right);		// 부분리스트를 합병하며 정렬
	}
}

/*	퀵정렬에서 사용되는 swap을 함수로 따로 구현해둠	*/
void swap(double *x, double *y) { //param을 데이터의 주소로 지정
	double t;	// 임시로 값을 저장할 변수 t
	t = *x;		// 변수 x의 주소에 들어있는 값을 t에 대입
	*x = *y;	// x의 주소에 들어있는 값을 변수 y의 주소에 들어있는 값으로 대체
	*y = t;		// y의 주소에 들어있는 값을 t의 값으로 대체
}

/* 퀵정렬에 사용되는 분할 함수 */
double partition(double list[], int left, int right) {
	int low, high;
	double pivot;

	low = left;			// 가장 왼쪽 인덱스
	high = right + 1;	// 가장 오른쪽 인덱스
	pivot = list[left]; // 축값의 시작 지점은 가장 왼쪽 원소

	do {
		do {
			low++;
			count++;	//비교횟수 증가
		} while (low <= right && list[low] < pivot);
		//low>right 혹은 list[low]<=pivot이 되는 지점에서 빠져나감

		do {
			high--;
			count++;	//비교횟수 증가
		} while (high >= left && list[high] > pivot);

		if (low < high) {
			swap(&list[low], &list[high]);
			//만약 low가 high보다 작다면 low번째 원소와 high번째 원소 위치 바꾸기
		}

	} while (low < high); //low>=high이 되는 지점에서 빠져나감

	swap(&list[left], &list[high]); //left와 high 위치의 원소들을 swap
	return high; //high값 반환
}

/* 랜덤화 퀵정렬에 사용되는 분할 함수 */
double partition_rand(double list[], int left, int right) {
	int low, high;
	double pivot;

	//랜덤화 퀵정렬을 위한 pivot index를 선언.
	//랜덤하게 구한 pivot 값을 가장 left 위치로 옮김
	int randPivot = left + rand() % (right - left + 1);
	pivot = list[randPivot];
	list[randPivot] = list[left];
	list[left] = pivot;

	//랜덤한 pivot을 선정하는 것 이외엔 퀵정렬과 동일. 코드에 대한 주석은 생략.
	low = left;
	high = right + 1;
	pivot = list[left];

	do {
		do {
			low++;
			count++;
		} while (low <= right && list[low] < pivot);

		do {
			high--;
			count++;
		} while (high >= left && list[high] > pivot);

		if (low < high) {
			swap(&list[low], &list[high]);
		}
	} while (low < high);

	swap(&list[left], &list[high]);
	return high;
}

/* 퀵정렬 - 축값을 중심으로 하나의 리스트를 두개로 나누고, 각 부분리스트를 재정렬(재귀) */

//퀵정렬과 랜덤화 퀵정렬을 구분하는 조건(i)을 임의로 추가함
void quick_sort(double list[], int left, int right, int i) {
	if (left < right) {
		int q;			//분할 함수로 축값 구하기
		if (i == 0) {
			q = partition(list, left, right);		//일반 퀵정렬용 분할
			quick_sort(list, left, q - 1, 0);		//축값보다 작은 부분리스트 다시 퀵정렬(축값제외)
			quick_sort(list, q + 1, right, 0);		//축값보다 큰 부분리스트 다시 퀵정렬(축값제외)
		}
		else {
			q = partition_rand(list, left, right);	//랜덤화 퀵정렬용 분할
			quick_sort(list, left, q - 1, 1);
			quick_sort(list, q + 1, right, 1);
		}
	}
}

//메인 함수
int main() {

	/*	1. 정렬 되지 않은 랜덤 난수 파일 출력	*/

	FILE *fp;	//파일 입출력을 위해 파일 포인터를 선언하는 과정
	fp = fopen("파일경로\\data_100000.txt", "w");

	int n = 100000;				//문제에서 주어지는 값. 난수 생성 개수를 의미
	fprintf(fp, "%d\n", n);		//파일의 첫줄에 난수 생성 개수 출력

	srand(time(NULL));
	for (int i = 0; i < n; i++) {
		double random = rand() + ((double)rand() / RAND_MAX);	//소수점 4자리로 난수 변형
		fprintf(fp, "%.4lf ", random);							//파일에 출력
	}
	fclose(fp);


	/*	2. 내림차순 정렬된 랜덤 난수 파일 출력	*/
	//동일한 배열이 랜덤할 때와 내림차순으로 정렬되어 있을 때의 오름차순 정렬 속도를 비교해야
	//하기 때문에 1번에서 생성한 배열을 읽어와 내림차순으로 정렬한 후 새로운 파일에 출력

	fp = fopen("파일경로\\data_100000.txt", "r");	//읽기모드
	double *list; //double형을 담을 리스트 참조변수 선언

	fscanf(fp, "%d", &n);	//원소의 개수 확인
	list = (double *)malloc(sizeof(double) * n);	//n만큼 메모리 동적 할당
	for (int i = 0; i < n; i++) {
		fscanf(fp, "%lf", &list[i]);	//파일의 원소를 순서대로 모두 읽어와 배열에 저장
	}

	insertion_sort(list, n); //삽입정렬 실행(내림차순 정렬)

	//내림차순 정렬된 배열을 파일에 다시 출력하기 위해 파일포인터 재선언
	fp = fopen("파일경로\\data_100000_ordered.txt", "w");	//쓰기모드
	
	fprintf(fp, "%d\n", n);					//파일의 첫줄에 난수 생성 개수 출력
	for (int i = 0; i < n; i++) {
		fprintf(fp, "%.4lf ", list[i]);		//파일에 출력
	}
	fclose(fp);


	/*	3. 각 정렬에 따라 두 데이터를 오름차순 정렬	*/

	if (fp != NULL) {
		// 각 파일의 데이터들을 읽어오기
		double *list1, *list2;

		// 무작위 데이터
		fp = fopen("파일경로\\data_100000.txt", "r");	//읽기모드
		fscanf(fp, "%d", &n);	//원소의 개수 확인
		list1 = (double *)malloc(sizeof(double) * n);	//n만큼 메모리 동적 할당
		for (int i = 0; i < n; i++) {
			fscanf(fp, "%lf", &list1[i]);	//파일의 원소를 순서대로 모두 읽어와 배열에 저장
		}

		//내림차순 정렬 데이터
		fp = fopen("파일경로\\data_100000_ordered.txt", "r");	//읽기모드
		fscanf(fp, "%d", &n);	//원소의 개수 확인
		list2 = (double *)malloc(sizeof(double) * n);	//n만큼 메모리 동적 할당
		for (int i = 0; i < n; i++) {
			fscanf(fp, "%lf", &list2[i]);	//파일의 원소를 순서대로 모두 읽어와 배열에 저장
		}
		fclose(fp);

		/*	3-1. 병합정렬 */
		printf("\n<1. 병합정렬>의 정렬 후 결과\n\n");
		count = 0;
		clock_t start = clock(); // 시작 시간 저장	
		merge_sort(list1, 0, n-1);
		clock_t end = clock(); // 코드가 끝난 시간 저장
		printf("앞부분 10개 : ");
		for (int i = 0; i < 10; i++) {
			printf("%.4lf ", list1[i]); //앞에서부터 10개
		}
		printf("\n뒷부분 10개 : ");
		for (int i = n - 10; i < n; i++) {
			printf("%.4lf ", list1[i]); //뒤에서부터 10개
		}
		//비교횟수출력
		printf("\ndata_%d.txt의 병합정렬 비교 횟수 : %d", n, count);
		//소요시간출력
		printf("\ndata_%d.txt의 병합정렬 소요 시간 : %lf\n\n", n, (double)(end - start) / CLOCKS_PER_SEC);

		count = 0;
		start = clock(); // 시작 시간 저장
		merge_sort(list2, 0, n-1);
		end = clock(); // 코드가 끝난 시간 저장
		printf("앞부분 10개 : ");
		for (int i = 0; i < 10; i++) {
			printf("%.4lf ", list2[i]); //앞에서부터 10개
		}
		printf("\n뒷부분 10개 : ");
		for (int i = n - 10; i < n; i++) {
			printf("%.4lf ", list2[i]); //뒤에서부터 10개
		}
		//비교횟수출력
		printf("\ndata_%d_ordered.txt의 병합정렬 비교 횟수 : %d", n, count);
		//소요시간출력
		printf("\ndata_%d_ordered.txt의 병합정렬 소요 시간 : %lf\n\n", n, (double)(end - start) / CLOCKS_PER_SEC);


		/*	3-2. 퀵정렬	*/
		//정렬을 제외한 나머지는 모두 3-1과 같으므로 주석 생략
		fp = fopen("파일경로\\data_100000.txt", "r");
		fscanf(fp, "%d", &n);
		for (int i = 0; i < n; i++) {
			fscanf(fp, "%lf", &list1[i]);
		}
		fp = fopen("파일경로\\data_100000_ordered.txt", "r");
		fscanf(fp, "%d", &n);
		for (int i = 0; i < n; i++) {
			fscanf(fp, "%lf", &list2[i]);
		}

		printf("\n\n<2. 퀵정렬>의 정렬 후 결과\n\n");
		count = 0;
		start = clock();
		quick_sort(list1, 0, n - 1, 0);
		end = clock();
		printf("앞부분 10개 : ");
		for (int i = 0; i < 10; i++) {
			printf("%.4lf ", list1[i]);
		}
		printf("\n뒷부분 10개 : ");
		for (int i = n - 10; i < n; i++) {
			printf("%.4lf ", list1[i]);
		}
		printf("\ndata_%d.txt의 퀵정렬 비교 횟수 : %d", n, count);
		printf("\ndata_%d.txt의 퀵정렬 소요 시간 : %lf\n\n", n, (double)(end - start) / CLOCKS_PER_SEC);

		count = 0;
		start = clock();
		quick_sort(list2, 0, n - 1, 0);
		end = clock();
		printf("앞부분 10개 : ");
		for (int i = 0; i < 10; i++) {
			printf("%.4lf ", list2[i]);
		}
		printf("\n뒷부분 10개 : ");
		for (int i = n - 10; i < n; i++) {
			printf("%.4lf ", list2[i]);
		}
		printf("\ndata_%d_ordered.txt의 퀵정렬 비교 횟수 : %d", n, count);
		printf("\ndata_%d_ordered.txt의 퀵정렬 소요 시간 : %lf\n\n", n, (double)(end - start) / CLOCKS_PER_SEC);


		/*	3-3. 랜덤한 퀵정렬*/
		fp = fopen("파일경로\\data_100000.txt", "r");
		fscanf(fp, "%d", &n);
		for (int i = 0; i < n; i++) {
			fscanf(fp, "%lf", &list1[i]);
		}
		fp = fopen("파일경로\\data_100000_ordered.txt", "r");
		fscanf(fp, "%d", &n);
		for (int i = 0; i < n; i++) {
			fscanf(fp, "%lf", &list2[i]);
		}

		printf("\n\n<3. 랜덤화 퀵정렬>의 정렬 후 결과\n\n");
		count = 0;
		start = clock();
		quick_sort(list1, 0, n - 1, 1);
		end = clock();
		printf("앞부분 10개 : ");
		for (int i = 0; i < 10; i++) {
			printf("%.4lf ", list1[i]);
		}
		printf("\n뒷부분 10개 : ");
		for (int i = n - 10; i < n; i++) {
			printf("%.4lf ", list1[i]);
		}
		printf("\ndata_%d.txt의 랜덤화 퀵정렬 비교 횟수 : %d", n, count);
		printf("\ndata_%d.txt의 랜덤화 퀵정렬 소요 시간 : %lf\n\n", n, (double)(end - start) / CLOCKS_PER_SEC);

		count = 0;
		start = clock();
		quick_sort(list2, 0, n - 1, 1);
		end = clock();
		printf("앞부분 10개 : ");
		for (int i = 0; i < 10; i++) {
			printf("%.4lf ", list2[i]);
		}
		printf("\n뒷부분 10개 : ");
		for (int i = n - 10; i < n; i++) {
			printf("%.4lf ", list2[i]);
		}
		printf("\ndata_%d_ordered.txt의 랜덤화 퀵정렬 비교 횟수 : %d", n, count);
		printf("\ndata_%d_ordered.txt의 랜덤화 퀵정렬 소요 시간 : %lf\n\n", n, (double)(end - start) / CLOCKS_PER_SEC);

		free(list); free(list1); free(list2);	//동적할당 받은 메모리를 free 처리
		fclose(fp);//파일 닫기
	}
	else
		printf("파일 읽어오기 실패");
}