package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17780_새로운게임 {
	static int[][] map;
	static StringBuilder[][] cnt;
	static mal[] mals;
	static int[] dr = {0,0,-1,1};
	static int[] dc = {1,-1,0,0};
	static int n, k;
	static class mal{
		public int x,  y, dir;
		public mal(int x, int y, int dir) {
			this.x = x; this.y = y; this.dir = dir;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new int[n+1][n+1];
		cnt = new StringBuilder[n+1][n+1];
		mals = new mal[k];
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				cnt[i][j] = new StringBuilder();
			}
		}
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken())-1;
			mals[i] = new mal(r, c, d);
			cnt[r][c].append(i);
		}
		int turn = 0;	// 턴 수
		while(!isEnd() && turn <= 1000) {
			boolean f = false; // 파랑/벽 나올 경우 true;
			for(int i=0; i<k; i++) {
				mal cur = mals[i];
				if((cnt[cur.x][cur.y].charAt(0)-'0') != i) continue;	// 해당 말이 맨 아래에 위치해있지 않으면 컨티뉴
				int dx = cur.x + dr[cur.dir];
				int dy = cur.y + dc[cur.dir];
				if(dx<1 || dy<1 || dx>n || dy>n) {	// 벗어났을 때
					if(f) {
						f = false;
						continue;
					}
					f = true;
					if(cur.dir==0 || cur.dir==2) cur.dir++;
					else cur.dir--;
					--i; continue;
				}
				switch(map[dx][dy]) {
				case 0 :
					if(f) f=false;
					move(cur.x, cur.y, cur.dir);
					break;
				case 1 :
					if(f) f=false;
					cnt[cur.x][cur.y].reverse();
					move(cur.x, cur.y, cur.dir);
					break;
				case 2 :
					if(f) {
						f = false;
						continue;
					}
					f = true;
					if(cur.dir==0 || cur.dir==2) cur.dir++;
					else cur.dir--;
					--i;
					break;
				}
 			}
			turn++;
		}
		if(turn>1000) turn = -1;
		System.out.println(turn);
	}
	static void move(int r, int c, int d) {
		int dx = r + dr[d];
		int dy = c + dc[d];
		for(int i=0, size=cnt[r][c].length(); i<size; i++) {
			char a = cnt[r][c].charAt(i);
			cnt[dx][dy].append(a);
			mals[a-'0'].x = dx;
			mals[a-'0'].y = dy;
		}
		cnt[r][c].setLength(0);
	}
	static boolean isEnd() {
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(cnt[i][j].length()>=4) return true;
			}
		}
		return false;
	}
}