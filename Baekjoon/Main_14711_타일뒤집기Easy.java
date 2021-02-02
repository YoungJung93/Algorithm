package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_14711_타일뒤집기Easy {
	static boolean[][] flag;
	static int[][] map;
	static int N;
	static int[] dr = {-1,1,0,0}, dc = {0,0,-1,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		flag = new boolean[N][N];
		map = new int[N][N];
		String s = br.readLine();
		for(int i=0; i<N; i++) {
			char c = s.charAt(i);
			if(c == '#') map[0][i] = 1;
			else map[0][i] = 0;
		}
		for(int i=1; i<N; i++) {
			flagUpdate(i-1);
			mapUpdate(i);
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j]==1) System.out.print("#");
				else System.out.print(".");
			}
			System.out.println();
		}
	}
	static void mapUpdate(int r) {
		for(int i=0; i<N; i++) {
			if(flag[r-1][i]) map[r][i] = 1;
		}
	}
	static void flagUpdate(int r) {	// r행에 있는 검은 판을 뒤집는다.
		for(int i=0; i<N; i++) {
			if(map[r][i]==1) {
				for(int j=0; j<4; j++) {
					int dx = r + dr[j];
					int dy = i + dc[j];
					if(dx<0 || dy<0 || dx>=N || dy>=N) continue;
					if(flag[dx][dy]) flag[dx][dy] = false;
					else flag[dx][dy] = true;
				}
			}
		}
	}
}
