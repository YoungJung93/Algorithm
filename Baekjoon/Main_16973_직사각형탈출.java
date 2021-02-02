package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16973_직사각형탈출 {
	static class wlrtk {
		public int lux, luy, rdx, rdy, cnt;
		public wlrtk(int lux, int luy, int rdx, int rdy, int cnt) {
			this.lux = lux; this.luy = luy; this.cnt = cnt;
			this.rdx = rdx; this.rdy = rdy;
		}
	}
	static int[][] map;
	static boolean[][] flag;
	static int n, m, destX, destY;
	static wlrtk wlrtk;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n+1][m+1];
		flag = new boolean[n+1][m+1];
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		wlrtk = new wlrtk(a, b, a + r - 1, b + c - 1, 0);
		destX = Integer.parseInt(st.nextToken()); destY = Integer.parseInt(st.nextToken());
		bfs(wlrtk.lux, wlrtk.luy);
		System.out.println(res);
	}
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int res = -1;
	static void bfs(int x, int y) {
		Queue<wlrtk> que = new LinkedList<wlrtk>();
		que.offer(wlrtk);
		flag[x][y] = true;
		while(!que.isEmpty()) {
			wlrtk cur = que.poll();
			int xx = cur.lux; int rx = cur.rdx;
			int yy = cur.luy; int ry = cur.rdy;
			int cnt = cur.cnt;
			if(xx==destX && yy==destY) {
				res = cnt;
				return;
			}
			label : for(int i=0; i<4; i++) {
				int dx = xx + dr[i], ex = rx + dr[i];
				int dy = yy + dc[i], ey = ry + dc[i];
				if(dx<1 || dy<1 || ex>n || ey>m) continue;
				if(flag[dx][dy]) continue;
				if(i==0) {
					for(int k=dy; k<=ey; k++) {
						if(map[dx][k]==1) continue label;
					}
				} else if(i==1) {
					for(int k=dy; k<=ey; k++) {
						if(map[ex][k]==1) continue label;
					}
				} else if(i==2) {
					for(int k=dx; k<=ex; k++) {
						if(map[k][dy]==1) continue label;
					}
				} else {
					for(int k=dx; k<=ex; k++) {
						if(map[k][ey]==1) continue label;
					}
				}
//				for(int j=dx; j<=ex; j++) {
//					for(int k=dy; k<=ey; k++) {
//						if(map[j][k]==1) continue label;
//					}
//				}
				flag[dx][dy] = true;
				que.offer(new wlrtk(dx, dy, ex, ey, cnt+1));
			}
		}
	}
}