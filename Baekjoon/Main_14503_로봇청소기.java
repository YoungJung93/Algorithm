package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14503_로봇청소기 {
	static int N, M;
	static int[][] map;
	static class pos {
		int r, c, d;
		public pos(int r, int c, int d) {
			this.r = r; this.c = c; this.d = d;
		}
	}
	static pos robot;
	static int[] dr = {-1,0,1,0}, dc = {0,1,0,-1};
	static boolean[][] flag;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		flag = new boolean[N][M];
		st = new StringTokenizer(br.readLine());
		robot = new pos(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int answer = 0;
		flag[robot.r][robot.c] = true; 
		while(true) {
			answer++;
			boolean f = false;
			int dx = robot.r;
			int dy = robot.c;
			int dir = robot.d;
			for(int i=0, d=dir-1; i<4; i++,d--) {
				if(d<0) d = 3;
				int x = robot.r + dr[d];
				int y = robot.c + dc[d];
				if(x<0 || y<0 || x>=N || y>=M) continue;
				if(flag[x][y] || map[x][y]==1) continue;
				dx = x; dy = y; dir = d;
				f = true; break;
			}
			if(!f) {
				if(map[robot.r+dr[(robot.d+2)%4]][robot.c+dc[(robot.d+2)%4]] == 0) {
					robot = new pos(robot.r+dr[(robot.d+2)%4], robot.c+dc[(robot.d+2)%4], robot.d);
					answer--;
					continue;
				} else {
					break;
				}
			}
			flag[dx][dy] = true;
			robot = new pos(dx, dy, dir);
		}
		System.out.println(answer);
	}
}
