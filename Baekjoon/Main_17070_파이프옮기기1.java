package Problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17070_파이프옮기기1 {
	static int[][] dr = {
			// 가로일 때
			{0,1},
			// 세로일 때
			{1,1},
			// 대각선일 때
			{0,1,1}
	};
	static int[][] dc = {
			// 가로일 때
			{1,1},
			// 세로일 때
			{0,1},
			// 대각선일 때
			{1,0,1}
	};
	static int N, answer;
	static int[][] map;
	static boolean[][] flag;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		flag = new boolean[N][N];
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		answer = 0;
		dfs(0, 0, 0, 1, 0);
		System.out.println(answer);
	}
	public static void dfs(int sr, int sc, int er, int ec, int dir) {
		if(er == N-1 && ec == N-1) {
			answer++;
			return;
		}
		for(int i=0, size=dr[dir].length; i<size; i++) {
			if((dir == 0 && i == 1) || (dir == 1 && i == 1) || 
					(dir == 2 && i == 2)) {
				int dx = er + dr[dir][i];
				int dy = ec + dc[dir][i];
				if(dx < 0 || dy < 0 || dx >= N || dy >= N) continue;
				if(map[dx][dy] == 1 || map[dx-1][dy] == 1 || map[dx][dy-1] == 1) continue;
				dfs(er, ec, dx, dy, 2);
			} else {
				int dx = er + dr[dir][i];
				int dy = ec + dc[dir][i];
				if(dx < 0 || dy < 0 || dx >= N || dy >= N) continue;
				if(map[dx][dy] == 1) continue;
				if(dir == 2) {
					if(i == 0) {
						dfs(er, ec, dx, dy, 0);
					} else {
						dfs(er, ec, dx, dy, 1);
					}
				} else {
					dfs(er, ec, dx, dy, dir);
				}
			}
		}
	}
}
