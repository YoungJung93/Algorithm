package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7576_토마토 {
	static class tomato {
		int r, c, stat, days;
		public tomato(int r, int c, int stat, int days) {
			this.r = r; this.c = c;
			this.stat = stat; this.days = days;
		}
	}
	static tomato[][] map;
	static int N, M;
	static int[] dr = {-1,1,0,0}, dc = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new tomato[N][M];
		Queue<tomato> que = new LinkedList<tomato>();
		boolean[][] flag = new boolean[N][M];
		boolean f = false;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				int stat = Integer.parseInt(st.nextToken());
				map[i][j] = new tomato(i, j, stat, 0);
				if(stat == 1) {
					que.offer(new tomato(i, j, stat, 0));
					flag[i][j] = true;
				}
				if(!f && stat == 0) f = true;
			}
		}
		if(f) {
			int answer = 0;
			while (!que.isEmpty()) {
				tomato cur = que.poll();
				for (int i = 0; i < 4; i++) {
					int dx = cur.r + dr[i];
					int dy = cur.c + dc[i];
					if (dx < 0 || dx >= N || dy < 0 || dy >= M) continue;
					if (flag[dx][dy]) continue;
					if (map[dx][dy].stat == -1) continue;
					answer = cur.days+1;
					flag[dx][dy] = true;
					que.offer(new tomato(dx, dy, 1, cur.days + 1));
					map[dx][dy].stat = 1;
				}
			}
			f = true;
			first: for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j].stat == 0) {
						f = false;
						break first;
					}
				}
			}
			if (!f) System.out.println(-1);
			else System.out.println(answer);
		} else {
			System.out.println(0);
		}
	}
}
