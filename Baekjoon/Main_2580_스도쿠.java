package Problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2580_스도쿠 {
	static int[][] map;
	static boolean[][] rowFlag, colFlag, subMapFlag;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[9][9];
		StringTokenizer st;
		for(int i=0; i<9; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<9; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		rowFlag = new boolean[9][10];
		colFlag = new boolean[9][10];
		subMapFlag = new boolean[9][10];
		
		for(int r=0; r<9; r++) {
			for(int c=0; c<9; c++) {
				if(map[r][c] == 0) continue;
				rowFlag[r][map[r][c]] = true;
				colFlag[c][map[r][c]] = true;
				int mapNum = subMapNum(r, c);
				subMapFlag[mapNum][map[r][c]] = true;
			}
		}
		
		isEnd = false;
		result = new int[9][9];
		go(0, 0);
		
		for(int r=0; r<9; r++) {
			for(int c=0; c<9; c++) {
				System.out.print(result[r][c] + " ");
			}
			System.out.println();
		}
	}
	static boolean isEnd;
	static int[][] result;
	public static void go(int r, int c) {
		if(isEnd) return;
		if(r >= 9) return;
		if(map[r][c] != 0) {
			if(r==8 && c==8) {
				isEnd = true;
				for(int rr=0; rr<9; rr++) {
					result[rr] = map[rr].clone();
				}
				return;
			}
			if(c == 8) go(r+1, 0);
			else go(r, c+1);
		} else {
			for(int i=1; i<=9; i++) {
				if(isEnd) return;
				if(isPossible(r, c, i)) {
					map[r][c] = i;
					int mapNum = subMapNum(r, c);
					rowFlag[r][i] = true;
					colFlag[c][i] = true;
					subMapFlag[mapNum][i] = true;
					if(r == 8 && c == 8) {
						isEnd = true;
						for(int rr=0; rr<9; rr++) {
							result[rr] = map[rr].clone();
						}
						return;
					}
					if(c == 8) go(r+1, 0);
					else go(r, c+1);
					map[r][c] = 0;
					rowFlag[r][i] = false;
					colFlag[c][i] = false;
					subMapFlag[mapNum][i] = false;
				}
			}
		}
		
	}
	public static int subMapNum(int r, int c) {
		int rr = r / 3;
		int cc = c / 3;
		return rr*3 + cc;
	}
	public static boolean isPossible(int r, int c, int num) {
		int mapNum = subMapNum(r, c);
		if(rowFlag[r][num]) return false;
		if(colFlag[c][num]) return false;
		if(subMapFlag[mapNum][num]) return false;
		return true;
	}
}
