#define _CRT_SECURE_NO_WARNINGS //파일 입출력 명령어 그대로 쓰기 위해 define
#include <stdio.h> 
#include <stdlib.h>

//파일에서 정보를 읽어와 인접 행렬로 표현하기
void init_graph(FILE *fp, int **numv, int n, int e)
{
	int v1, v2, w; //사용할 변수를 정의

	//2차원 배열 초기화 - 에지가 없는 경우 가중치를 9999로 해야하므로 미리 9999로 초기화
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			numv[i][j] = 9999;
			if (i == j) {
				numv[i][j] = 0; //시작정점과 끝정점이 같다면 가중치는 0
			}
		}
	}

	//에지 e개만큼 반복
	for (int i = 0; i < e; i++) {
			fscanf(fp, "%d %d %d", &v1, &v2, &w); //시작, 끝 정점과 가중치를 받아옴
			numv[(v1 - 1)][(v2 - 1)] = w;
	}

	printf("Adjacency matrix\n");
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			printf("\t%4d", numv[i][j]);
		}
		printf("\n");
	}
}

//현재 distance 배열에서 가장 작은 가중치 값을 갖고 있는 배열의 인덱스(정점)을 찾아 반환하기
int choose(int distance[], int n, int found[]) {

	int i, min, minpos;
	min = INT_MAX;
	minpos = -1;

	//최솟값 min을 찾는 반복문. 방문한 적 없는 점에 대해 dis배열의 값들을 비교
	for (i = 0; i < n; i++) {
		//방문된 적 없는 정점이며 현재까지의 최소값 min보다 작다면
		if (distance[i] < min && found[i] == false) {
			min = distance[i]; //최소값을 의미하는 min 업데이트
			minpos = i; //최소값이 등장한 해당 정점의 인덱스를 minpos에 저장
		}
	}
	return minpos;
}

//Dijkstra 알고리즘을 사용해 최단 거리 구하기
void shortest_path(int distance[], int **numv, int n, int found[], int start) {
	int i, u, w;

	//시작 정점을 기준으로 했을 때의 가중치와 distance 배열 초기화
	for (i = 0; i < n; i++) {
		distance[i] = numv[start][i];
		found[i] = false; //만난 적 없는 정점
	}
	found[start] = true; //시작 정점은 만난 적 있음 true
	distance[start] = 0;

	//시작 정점을 선택했으므로 n-1만큼 반복
	for (i = 0; i < n - 1; i++) {
		u = choose(distance, n, found); //현재 distance 배열에서 가장 작은 값이 위치한 인덱스
		found[u] = true; //u번 정점을 선택함 (방문)

		//위의 점을 선택함으로써 다른 점들에 대한 가중치를 갱신해야 할 경우를 체크
		for (w = 0; w < n; w++) {
			//아직 선택되지 않은 점들 중
			if (found[w] == false) {
				//현재 그 점까지의 거리와 정점 w까지의 거리가 기존의 정점 w까지의 거리보다 가깝다면 업데이트
				if (distance[u] + numv[u][w] < distance[w]) {
					distance[w] = distance[u] + numv[u][w];
				}
			}
		}
	}
	printf(" Shortest paths from v%d = (%d", start + 1, distance[0]);
	for (int i = 1; i < n; i++) {
		printf(", %d", distance[i]);
	}
	printf(")\n");
}

int main()
{
	int n, e;
	FILE *fp;//파일포인터 선언
	fp = fopen("파일 경로", "r"); //메모장 열기
	fscanf(fp, "%d %d", &n, &e); //첫 줄의 n은 총 정점의 수, e는 총 에지의 수

	//2차원 배열 동적 할당
	int **numv;
	numv = (int**)malloc(sizeof(int*) * n);
	for (int a = 0; a < n; a++) {
		numv[a] = (int*)malloc(sizeof(int) * n);
	}

	printf("graph1.txt\n");
	init_graph(fp, numv, n, e); //파일에서 정보를 읽어와 인접 행렬로 표현하기
	printf("\n");

	int *distance = (int*)malloc(sizeof(int) * n); //시작 정점으로부터의 최단 경로 거리
	int *found = (int*)malloc(sizeof(int) * n); //방문한 정점 표시
	
	//정점의 개수에 따라 shortest path를 출력
	for (int start = 0; start < n; start++) {
		shortest_path(distance, numv, n, found, start);
	}

	fclose(fp); //파일 닫기
	return 0;
}