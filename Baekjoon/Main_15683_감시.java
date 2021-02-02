package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15683_감시 {
	static int[] dr = {-1,1,0,0}, dc = {0,0,-1,1};	// 상하좌우
	static int[][][] dir = {	// dr과 dc의 인덱스로 CCTV 방향 저장 배열
			{},										
			{{0},{1},{2},{3}},						// 1번 CCTV 상,하,좌,우
			{{0,1}, {2,3}},							// 2번 CCTV 상하,좌우
			{{0,3}, {1,3}, {1,2}, {0,2}},			// 3번 CCTV 상우,하우,하좌,상좌
			{{0,1,2}, {0,1,3}, {0,2,3}, {1,2,3}},	// 4번 CCTV 상하좌,상하우,상좌우,하좌우
			{{0,1,2,3}}								// 5번 CCTV 상하좌우
	};
	static int[][] map;		// 기본 지도 저장할 배열
	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				int a = Integer.parseInt(st.nextToken());
				if(a==6) map[i][j] = -1;		// 벽일 경우 -1로 저장
				else map[i][j] = a;				// 나머지는 그대로 저장(벽, CCTV번호)
			}
		}
		res = Integer.MAX_VALUE;	// 결과값 저장할 변수
		go(0,0);					// 0행 0열부터 시작
		System.out.println(res);
	}
	static int res;
	static void go(int r, int c) {
		if(r==N) {					// 모든 맵을 본 경우 - 끝나는 경우
			int a = 0;
			for(int i=0; i<N; i++) {		// 모든 CCTV의 경우를 확인하고 0(사각지대)이 몇개 남았는지 셈
				for(int j=0; j<M; j++) {
					if(map[i][j]==0) a++;
				}
			}
			if(res>a) res=a;		// 사각지대의 갯수가 결과값보다 작으면 결과값 갱신
			return;
		}
		if(!(map[r][c]==1 || map[r][c]==2 || map[r][c]==3 || map[r][c]==4 || map[r][c]==5)) {
			// 현 위치가 CCTV 위치가 아니면 그냥 다음으로 넘어감
			if(c==M-1) go(r+1, 0);
			else go(r, c+1);
		} else {
			// 현 위치가 CCTV일 경우 map에 감시 범위를 체크해주고 다음으로 넘어갔다가 다시 체크 해제
			for (int i = 0, size = dir[map[r][c]].length; i < size; i++) {
				// CCTV 당 감시할 수 있는 방법의 수(dir[CCTV번호]의 길이)만큼 돌면서
				for (int j = 0, size_ = dir[map[r][c]][i].length; j < size_; j++) {
					// 맴에서 그 방향에 감시할 수 있는 부분에 (CCTV번호+5)만큼 더해서 표시해줌
					// 감시할 수 있는 범위에 벽이 있으면 바로 멈추고, CCTV가 있으면 그 부분만 무시하고 다음 부분으로 넘어감
					int k = 1;
					while (true) {
						int dx = r + dr[dir[map[r][c]][i][j]] * k;
						int dy = c + dc[dir[map[r][c]][i][j]] * k;
						if (dx < 0 || dy < 0 || dx >= N || dy >= M) break;
						if (map[dx][dy] >= 1 && map[dx][dy] <= 5) {k++; continue;}
						if (map[dx][dy] == -1) break;
						map[dx][dy] += (map[r][c] + 5);
						k++;
					}
				}
				// 감시할 수 있는 부분을 모두 표시했으면 맵에서 다음 부분으로 넘어감
				if (c == M - 1) go(r + 1, 0);
				else go(r, c + 1);
				// 감시 부분을 표시할 때와 같은 방법으로 표시 부분 해제
				for (int j = 0, size_ = dir[map[r][c]][i].length; j < size_; j++) {
					int k = 1;
					while (true) {
						int dx = r + dr[dir[map[r][c]][i][j]] * k;
						int dy = c + dc[dir[map[r][c]][i][j]] * k;
						if (dx < 0 || dy < 0 || dx >= N || dy >= M) break;
						if (map[dx][dy] >= 1 && map[dx][dy] <= 5) {k++; continue;}
						if (map[dx][dy] == -1) break;
						map[dx][dy] -= (map[r][c] + 5);
						k++;
					}
				}
			}
		}
	}
}
