package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2239_스도쿠 {
	static int[][] map;
	static final int size = 9;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[size][size];
		for(int i=0; i<size; i++) {
			String s = br.readLine();
			for(int j=0; j<size; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		sb = null;
		gkatn(0,0);
		System.out.println(sb.toString());
	}
	static void gkatn(int r, int c) {
		if(sb!=null) return;
		if(r==size) {
			if(isEnd()) {
				sb = new StringBuilder("");
				for(int i=0; i<size; i++) {
					for(int j=0; j<size; j++) {
						sb.append(map[i][j]);
					}
					sb.append("\n");
				}
			}
			return;
		}
		if(map[r][c] != 0) {
			if(c==(size-1)) gkatn(r+1, 0);
			else gkatn(r, c+1);
		} else {
			for(int i=1; i<10; i++) {
				if(isValid(r, c, i)) {
					map[r][c] = i;
					if(c==(size-1)) gkatn(r+1, 0);
					else gkatn(r, c+1);
					map[r][c] = 0;
				}
			}
		}
	}
	static boolean isEnd() {
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				if(map[i][j]==0) return false;
			}
		}
		return true;
	}
	static boolean isValid(int r, int c, int val) {
		// 행 검사
		for(int i=0; i<size; i++) {
			if(map[r][i]==val) return false;
		}
		// 열 검사
		for(int i=0; i<size; i++) {
			if(map[i][c]==val) return false;
		}
		// 3x3 사각형 검사
		int rr = (r/3)*3;
		int cc = (c/3)*3;
		for(int i=rr; i<rr+3; i++) {
			for(int j=cc; j<cc+3; j++) {
				if(map[i][j]==val) return false;
			}
		}
		return true;
	}
}
