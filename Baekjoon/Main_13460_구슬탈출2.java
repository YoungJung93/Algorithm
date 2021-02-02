package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_13460_구슬탈출2 {
	static int[][] map;
	static int N, M;
	static class pair {
		int r, c;
		public pair(int r, int c) {
			this.r = r; this.c = c;
		}
	}
	static pair tar;
	static int res;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		pair red = null, blue = null;
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				char c = s.charAt(j);
				if(c=='#') map[i][j] = -1;
				else if(c=='.') map[i][j] = 0;
				else if(c=='O') {
					map[i][j] = 1;
					tar = new pair(i, j);
				}
				else if(c=='R') {
					map[i][j] = 0;
					red = new pair(i, j);
				} else if(c=='B') {
					map[i][j] = 0;
					blue = new pair(i, j);
				}
			}
		}
		res = Integer.MAX_VALUE;
		dfs(red, blue, 0);
		if(res != Integer.MAX_VALUE) {
			System.out.println(res);
		} else {
			System.out.println(-1);
		}
	}
	static int[] dr = {-1,1,0,0}, dc = {0,0,-1,1};
	static void dfs(pair red, pair blue, int cnt) {
		if(cnt > 10 || cnt >= res) return;
		if(blue.r == tar.r && blue.c == tar.c) return;
		if(red.r == tar.r && red.c == tar.c) {
			if(!(blue.r == tar.r && blue.c == tar.c)) {
				if(cnt < res) res = cnt;
			}
			return;
		}
		if(red.r == blue.r && red.c == blue.c) return;
		
		for(int i=0; i<4; i++) {
			int dx = red.r+dr[i],dy = red.c+dc[i];
			int bx = blue.r+dr[i],by = blue.c+dc[i];
			while(true) {
				if(map[dx][dy]==1) break;
				if(map[dx][dy]==-1) {
					dx -= dr[i];
					dy -= dc[i];
					break;
				}
				dx += dr[i];
				dy += dc[i];
			}
			while(true) {
				if(map[bx][by]==-1) {
					bx -= dr[i];
					by -= dc[i];
					break;
				}
				if(map[bx][by]==1) break;
				bx += dr[i];
				by += dc[i];
			}
			if(dx==red.r && dy==red.c && bx==blue.r && by==blue.c) continue;
			if(dx==bx && dy==by && map[dx][dy]!=1) {
				if(i==0) {
					if(red.r < blue.r) bx++;
					else dx++;
				} else if(i==1) {
					if(red.r < blue.r) dx--;
					else bx--;
				} else if(i==2) {
					if(red.c < blue.c) by++;
					else dy++;
				} else {
					if(red.c < blue.c) dy--;
					else by--;
				}
			}
			dfs(new pair(dx, dy), new pair(bx, by), cnt+1);
		}
	}
}
