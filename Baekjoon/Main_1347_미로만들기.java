package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1347_미로만들기 {
	static int[][] map;
	static boolean[][] flag;
	static String path;
	static int n, r, c;
	static int[] dr = {1,0,-1,0}, dc = {0,-1,0,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		path = br.readLine();
		map = new int[101][101];
		flag = new boolean[101][101];
		flag[50][50] = true;
		r = 50; c = 50;
		drawMap();
		int lr = 101, lc = 101, rr = 0, rc = 0;
		for(int i=0; i<101; i++) {
			for(int j=0; j<101; j++) {
				if(flag[i][j]) {
					if(i < lr) lr = i;
					if(j < lc) lc = j;
					if(i > rr) rr = i;
					if(j > rc) rc = j;
				}
			}
		}
		for(int i=lr; i<=rr; i++) {
			for(int j=lc; j<=rc; j++) {
				if(flag[i][j]) System.out.print(".");
				else System.out.print("#");
			}
			System.out.println();
		}
	}
	static void drawMap() {
		for(int i=0, size=path.length(); i<size; i++) {
			char p = path.charAt(i);
			if(p == 'F') {
				int dx = r + dr[map[r][c]];
				int dy = c + dc[map[r][c]];
				map[dx][dy] = map[r][c];
				r = dx; c = dy;
				flag[r][c] = true;
			} else if(p == 'L') {
				map[r][c] = map[r][c]==0 ? 3 : map[r][c]-1;
			} else {
				map[r][c] = map[r][c]==3 ? 0 : map[r][c]+1;
			}
		}
	}
}
