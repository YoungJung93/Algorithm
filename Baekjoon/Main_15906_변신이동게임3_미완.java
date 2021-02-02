package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_15906_변신이동게임3_미완 {
	static int N, T, R, C;
	static int[][] map;
	static boolean[][][] flag;
	static int[] dr = {-1,1,0,0}, dc = {0,0,-1,1};
	static class pair {
		int r, c, cnt, t, mode;
		public pair(int r, int c, int cnt, int t, int mode) {
			this.r = r; this.c = c;
			this.cnt = cnt; this.t = t; this.mode = mode;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken())-1;
		C = Integer.parseInt(st.nextToken())-1;
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<N; j++) {
				char c = s.charAt(j);
				if(c == '.') map[i][j] = 0;
				else map[i][j] = 1;
			}
		}
		flag = new boolean[2][N][N];
		Queue<pair> que = new LinkedList<pair>();
		que.offer(new pair(0,0,0,0,0));
		if(T==0) que.offer(new pair(0,0,0,0,1));
		flag[0][0][0] = true;
		int result = 0;
		bfs : while(!que.isEmpty()) {
			pair p = que.poll();
			if(p.r==R || p.c==C) {
				result = p.cnt;
				break;
			}
			if(p.mode == 0) {
				for(int i=0; i<4; i++) {
					int dx = p.r + dr[i];
					int dy = p.c + dc[i];
					if(dx<0 || dy<0 || dx>=N || dy>=N) continue;
					if(dx==R && dy==C) {
						result = p.cnt+1;
						break bfs;
					}
					if(flag[0][dx][dy]) continue;
					flag[0][dx][dy] = true;
					if(p.t >= T) que.offer(new pair(dx, dy, p.cnt+1, p.t+1-T, 1));
					que.offer(new pair(dx, dy, p.cnt+1, p.t+1, 0));
				}
			} else {
				first : for(int i=0; i<4; i++) {
					int dx = p.r;
					int dy = p.c;
					while(true) {
						dx += dr[i];
						dy += dc[i];
						if(dx<0 || dy<0 || dx>=N || dy>=N) continue first;
						if(map[dx][dy] == 1) break;
					}
					if(dx==R && dy==C) {
						result = p.cnt+1;
						break bfs;
					}
					if(flag[1][dx][dy]) continue;
					flag[1][dx][dy] = true;
					que.offer(new pair(dx, dy, p.cnt+1, p.t+1, 1));
					dx = p.r + dr[i];
					dy = p.c + dc[i];
					if(dx<0 || dy<0 || dx>=N || dy>=N) continue;
					if(flag[0][dx][dy]) continue;
					que.offer(new pair(dx, dy, p.cnt+1, p.t+1, 0));
				}
			}
		}
		System.out.println(result);
	}
}
