package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2206_벽부수고이동하기 {
	static boolean[][] map;
	static int N, M;
	static int[] dr = {-1,1,0,0}, dc = {0,0,-1,1};
	static class pair {
		int f, r, c, cnt;
		public pair(int f, int r, int c, int cnt) {
			this.f = f; this.r = r; this.c = c; this.cnt = cnt;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new boolean[N][M];
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				char c = s.charAt(j);
				if(c == '1') map[i][j] = true;
			}
		}
		int answer = -1;
		boolean[][][] flag = new boolean[2][N][M];
		Queue<pair> que = new LinkedList<>();
		que.offer(new pair(0,0,0,1));
		flag[0][0][0] = true;
		bfs :
		while(!que.isEmpty()) {
			pair cur = que.poll();
			if(cur.r == N-1 && cur.c == M-1) {
				answer = cur.cnt;
				break;
			}
			for(int i=0; i<4; i++) {
				int dx = cur.r + dr[i];
				int dy = cur.c + dc[i];
				if(dx<0 || dy<0 || dx>=N || dy>=M) continue;
				if(dx == N-1 && dy == M-1) {
					answer = cur.cnt + 1;
					break bfs;
				}
				if(cur.f == 0) {
					if(map[dx][dy]) {
						if(flag[1][dx][dy]) continue;
						que.offer(new pair(1, dx, dy, cur.cnt+1));
						flag[1][dx][dy] = true;
					} else {
						if(flag[0][dx][dy]) continue;
						que.offer(new pair(0, dx, dy, cur.cnt+1));
						flag[0][dx][dy] = true;
					}
				} else {
					if(map[dx][dy]) continue;
					else {
						if(flag[1][dx][dy]) continue;
						que.offer(new pair(1, dx, dy, cur.cnt+1));
						flag[1][dx][dy] = true;
					}
				}
			}
		}
		System.out.println(answer);
	}
}
