package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2573_빙산 {
	static int N, M;
	static int[][] map, sub;
	static boolean[][] flag;
	static int[] dr = {-1,1,0,0}, dc = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		sub = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int dung = 0;
		int time = 0;
		while(true) {
			update();
			time++;
			dung = go();
			if(dung==1) break;
			if(isEnd()) {
				time = 0; break;
			}
		}
		System.out.println(time);
	}
	
	static boolean isEnd() {
		boolean f = true;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]!=0) f = false;
			}
		}
		return f;
	}
	static int go() {
		flag = new boolean[N][M];
		int res = 0;
		for(int i=1; i<N-1; i++) {
			for(int j=1; j<M-1; j++) {
				if(map[i][j]!=0 && !flag[i][j]) {
					res++;
					if(res>=2) return 1;
					Queue<Integer> que = new LinkedList<>();
					que.offer(i); que.offer(j);
					flag[i][j] = true;
					while(!que.isEmpty()) {
						int x = que.poll();
						int y = que.poll();
						for(int k=0; k<4; k++) {
							int dx = x + dr[k];
							int dy = y + dc[k];
							if(map[dx][dy]!=0 && !flag[dx][dy]) {
								flag[dx][dy] = true;
								que.offer(dx);
								que.offer(dy);
							}
						}
					}
				}
			}
		}
		return 0;
	}
	
	static void update() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				sub[i][j] = 0;
			}
		}
		// 주변 0의 갯수 세서 sub 배열에 저장
		for(int i=1; i<N-1; i++) {
			for(int j=1; j<M-1; j++) {
				if(map[i][j]!=0) {
					int z = 0;
					for(int k=0; k<4; k++) {
						int dx = i + dr[k];
						int dy = j + dc[k];
						if(map[dx][dy]==0) z++;
					}
					sub[i][j] = z;
				}
			}
		}
		// map 배열의 값에서 sub 배열의 값 빼기
		for(int i=1; i<N-1; i++) {
			for(int j=1; j<M-1; j++) {
				map[i][j] -= sub[i][j];
				if(map[i][j]<0) map[i][j]=0;
			}
		}
	}
}

/* 
5 7
0 0 0 0 0 0 0
0 0 2 4 1 0 0
0 1 0 1 5 0 0
0 5 4 1 2 0 0
0 0 0 0 0 0 0
*/