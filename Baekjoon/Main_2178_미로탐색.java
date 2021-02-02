package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2178_미로탐색 {
	static class pair {
		int r, c, cnt;
		public pair(int r, int c, int cnt) {
			this.r = r; this.c = c; this.cnt = cnt;
		}
	}
	static int[][] map;
	static int N, M;
	static int[] dr = {-1,1,0,0}, dc = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		Queue<pair> que = new LinkedList<pair>();
		boolean[][] flag = new boolean[N][M];
		que.offer(new pair(0, 0, 1));
		flag[0][0] = true;
		int answer = 0;
		bfs : while(!que.isEmpty()) {
			pair cur = que.poll();
			for(int i=0; i<4; i++) {
				int dx = cur.r + dr[i];
				int dy = cur.c + dc[i];
				if(dx<0 || dx>=N || dy<0 || dy>=M) continue;
				if(flag[dx][dy]) continue;
				if(map[dx][dy]==0) continue;
				if(dx==N-1 && dy==M-1) {
					answer = cur.cnt+1;
					break bfs;
				}
				flag[dx][dy] = true;
				que.offer(new pair(dx, dy, cur.cnt+1));
			}
		}
		System.out.println(answer);
	}
}
