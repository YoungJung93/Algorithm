package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2174_로봇시뮬레이션 {
	static class Robot {
		int no, dir;
		public Robot(int no, int dir) {
			this.no = no; this.dir = dir;
		}
	}
	static Robot[][] map;
	static int R, C, N, M;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new Robot[R+1][C+1];
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for(int i=1; i<=N; i++) {
			int a, b, d;
			char c;
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken()); 	// 열(그대로)
			b = Integer.parseInt(st.nextToken()); 	// 행(R-(b-1))
			b = R - (b-1);
			c = st.nextToken().charAt(0);	// 방향
			if(c=='E') d = 1;
			else if(c=='W') d = 3;
			else if(c=='S') d = 2;
			else d = 4;
			map[b][a] = new Robot(i, d);
		}
		String result = "OK";
		for(int i=0; i<M; i++) {
			int no, re;
			char command;
			st = new StringTokenizer(br.readLine());
			no = Integer.parseInt(st.nextToken());
			command = st.nextToken().charAt(0);
			re = Integer.parseInt(st.nextToken());
			int x=1, y=1;
			first : for(x=1; x<=R; x++) {
				for(y=1; y<=C; y++) {
					if(map[x][y] != null && map[x][y].no == no) break first;
				}
			}
			if(command == 'L') {
				while(re-->0) rotate(1, x, y);
			} else if(command == 'R') {
				while(re-->0) rotate(2, x, y);
			} else {
				int dir = map[x][y].dir;
				if(dir == 1) {	// 오른쪽
					int dy = y + re;
					int dx = x;
					boolean f = false, ff = false;
					for(int a = y+1; a<=dy; a++) {
						if(a > C) {
							ff = true;
							break;
						}
						if(map[x][a] != null) {
							f = true;
							dy = a;
							break;
						}
					}
					if(f) {
						result = "Robot " + map[x][y].no + " crashes into robot " + map[dx][dy].no;
						break;
					}
					if(ff) {
						result = "Robot " + map[x][y].no + " crashes into the wall";
						break;
					}
					map[dx][dy] = map[x][y];
					map[x][y] = null;
				} else if(dir == 2) {	// 아래쪽
					int dy = y;
					int dx = x + re;
					boolean f = false, ff = false;
					for(int a=x+1; a<=dx; a++) {
						if(a > R) {
							ff = true;
							break;
						}
						if(map[a][y] != null) {
							f = true;
							dx = a;
							break;
						}
					}
					if(f) {
						result = "Robot " + map[x][y].no + " crashes into robot " + map[dx][dy].no;
						break;
					}
					if(ff) {
						result = "Robot " + map[x][y].no + " crashes into the wall";
						break;
					}
					map[dx][dy] = map[x][y];
					map[x][y] = null;
				} else if(dir == 3) {	// 왼쪽
					int dy = y - re;
					int dx = x;
					boolean f = false, ff = false;
					for(int a=y-1; a>=dy; a--) {
						if(a < 1) {
							ff = true;
							break;
						}
						if(map[x][a] != null) {
							f = true;
							dy = a;
							break;
						}
					}
					if(f) {
						result = "Robot " + map[x][y].no + " crashes into robot " + map[dx][dy].no;
						break;
					}
					if(ff) {
						result = "Robot " + map[x][y].no + " crashes into the wall";
						break;
					}
					map[dx][dy] = map[x][y];
					map[x][y] = null;
				} else {	// 위쪽
					int dy = y;
					int dx = x - re;
					boolean f = false, ff = false;
					for(int a=x-1; a>=dx; a--) {
						if(a < 1) {
							ff = true;
							break;
						}
						if(map[a][y] != null) {
							f = true;
							dx = a;
							break;
						}
					}
					if(f) {
						result = "Robot " + map[x][y].no + " crashes into robot " + map[dx][dy].no;
						break;
					}
					if(ff) {
						result = "Robot " + map[x][y].no + " crashes into the wall";
						break;
					}
					map[dx][dy] = map[x][y];
					map[x][y] = null;
				}
			}
		}
		System.out.println(result);
	}
	static void rotate(int f, int r, int c) {	// f가 1이면 왼쪽, 2이면 오른쪽
		int dir = map[r][c].dir;
		if(f==1) {
			dir--;
			if(dir==0) dir = 4;
		} else {
			dir++;
			if(dir==5) dir = 1;
		}
		map[r][c].dir = dir;
	}
}
