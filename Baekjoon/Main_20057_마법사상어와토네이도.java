package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_20057_마법사상어와토네이도 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] dr = {
				{-1,-1,0,0,0,0,1,1,2},		// 아래
				{-2,-1,-1,-1,0,1,1,1,2},	// 오른
				{-2,-1,-1,0,0,0,0,1,1},		// 위
				{-2,-1,-1,-1,0,1,1,1,2}		// 왼
		};
		int[][] dc = {
				{-1,1,-2,-1,1,2,-1,1,0},	// 아래
				{0,-1,0,1,2,-1,0,1,0},		// 오른
				{0,-1,1,-2,-1,1,2,-1,1},	// 위
				{0,-1,0,1,-2,-1,0,1,0}		// 왼
		};
		int[][] spread = {
				{1,1,2,7,7,2,10,10,5},	// 아래
				{2,1,7,10,5,1,7,10,2},	// 오른
				{5,10,10,2,7,7,2,1,1},	// 위
				{2,10,7,1,5,10,7,1,2}	// 왼
		};
		
		StringTokenizer st;
		int[][] map = new int[N][N];
		int answer = 0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int x = N / 2;
		int y = N / 2;
		int dir = 3;
		base : 
		for(int tmp=1; ;tmp++) {
			// y축
			for(int i=1; i<=tmp; i++) {
				if(tmp % 2 == 1) y--;
				else y++;
				int sand = map[x][y];
				map[x][y] = 0;
				int spread_sand = 0;
				for(int j=0; j<9; j++) {
					int dx = x + dr[dir][j];
					int dy = y + dc[dir][j];
					int s = (sand * spread[dir][j])/100;
					if(dx<0 || dy<0 || dx>=N || dy>=N) {
						answer += s;
					} else {
						map[dx][dy] += s;
					}
					spread_sand += s;
				}
				sand -= spread_sand;
				if(tmp % 2 == 1) {
					if(y > 0) map[x][y-1] += sand;
					else answer += sand;
				} else {
					if(y < N-1) map[x][y+1] += sand;
					else answer += sand;
				}
				if(x == 0 && y == 0) break base;
			}
			dir++;
			if(dir > 3) dir = 0;
			// x축
			for(int i=1; i<=tmp; i++) {
				if(tmp % 2 == 1) x++;
				else x--;
				int sand = map[x][y];
				map[x][y] = 0;
				int spread_sand = 0;
				for(int j=0; j<9; j++) {
					int dx = x + dr[dir][j];
					int dy = y + dc[dir][j];
					int s = (sand * spread[dir][j])/100;
					if(dx<0 || dy<0 || dx>=N || dy>=N) {
						answer += s;
					} else {
						map[dx][dy] += s;
					}
					spread_sand += s;
				}
				sand -= spread_sand;
				if(tmp % 2 == 1) {
					if(x < N-1) map[x+1][y] += sand;
					else answer += sand;
				} else {
					if(x > 0) map[x-1][y] += sand;
					else answer += sand;
				}
				if(x == 0 && y == 0) break base;
			}
			dir++;
			if(dir > 3) dir = 0;
		}
		System.out.println(answer);
	}
}
