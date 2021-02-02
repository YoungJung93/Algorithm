package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_5373_큐빙 {
	static int[][][] cube;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int t=0; t<T; t++) {
			cube = new int[][][] {
				{ {1,1,1}, {1,1,1}, {1,1,1} },	// 위
				{ {2,2,2}, {2,2,2}, {2,2,2} },	// 아래
				{ {3,3,3}, {3,3,3}, {3,3,3} },	// 앞
				{ {4,4,4}, {4,4,4}, {4,4,4} },	// 뒤
				{ {5,5,5}, {5,5,5}, {5,5,5} },	// 왼
				{ {6,6,6}, {6,6,6}, {6,6,6} }	// 오른
			};
			int r = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<r; i++) {
				String s = st.nextToken();
				char c = s.charAt(0);
				char dir = s.charAt(1);
				if(c == 'U') {
					rotateU();
					if(dir == '-') {
						rotateU();
						rotateU();
					}
				}
				else if(c == 'D') {
					rotateD();
					if(dir == '-') {
						rotateD();
						rotateD();
					}
				}
				else if(c == 'F') {
					rotateF();
					if(dir == '-') {
						rotateF();
						rotateF();
					}
				}
				else if(c == 'B') {
					rotateB();
					if(dir == '-') {
						rotateB();
						rotateB();
					}
				}
				else if(c == 'L') {
					rotateL();
					if(dir == '-') {
						rotateL();
						rotateL();
					}
				}
				else {
					rotateR();
					if(dir == '-') {
						rotateR();
						rotateR();
					}
				}
			}
			for(int i=0; i<3; i++) {
				for(int j=0; j<3; j++) {
					if(cube[0][i][j] == 1) System.out.print("w");
					else if(cube[0][i][j] == 2) System.out.print("y");
					else if(cube[0][i][j] == 3) System.out.print("r");
					else if(cube[0][i][j] == 4) System.out.print("o");
					else if(cube[0][i][j] == 5) System.out.print("g");
					else System.out.print("b");
				}
				System.out.println();
			}
		}
	}
	static void rotateU() {
		int a = cube[3][0][2], b = cube[3][0][1], c = cube[3][0][0];
		cube[3][0][2] = cube[4][0][2]; cube[3][0][1] = cube[4][0][1]; cube[3][0][0] = cube[4][0][0];
		cube[4][0][2] = cube[2][0][2]; cube[4][0][1] = cube[2][0][1]; cube[4][0][0] = cube[2][0][0];
		cube[2][0][2] = cube[5][0][2]; cube[2][0][1] = cube[5][0][1]; cube[2][0][0] = cube[5][0][0];
		cube[5][0][2] = a; cube[5][0][1] = b; cube[5][0][0] = c;
		
		int[][] imsi = new int[3][3];
		imsi[0][0] = cube[0][2][0]; imsi[0][1] = cube[0][1][0]; imsi[0][2] = cube[0][0][0];
		imsi[1][0] = cube[0][2][1]; imsi[1][1] = cube[0][1][1]; imsi[1][2] = cube[0][0][1];
		imsi[2][0] = cube[0][2][2]; imsi[2][1] = cube[0][1][2]; imsi[2][2] = cube[0][0][2];
		for(int i=0; i<3; i++) cube[0][i] = imsi[i].clone();
	}
	static void rotateD() {
		int a = cube[2][2][0], b = cube[2][2][1], c = cube[2][2][2];
		cube[2][2][0] = cube[4][2][0]; cube[2][2][1] = cube[4][2][1]; cube[2][2][2] = cube[4][2][2];
		cube[4][2][0] = cube[3][2][0]; cube[4][2][1] = cube[3][2][1]; cube[4][2][2] = cube[3][2][2];
		cube[3][2][0] = cube[5][2][0]; cube[3][2][1] = cube[5][2][1]; cube[3][2][2] = cube[5][2][2];
		cube[5][2][0] = a; cube[5][2][1] = b; cube[5][2][2] = c;
		
		int[][] imsi = new int[3][3];
		imsi[0][0] = cube[1][2][0]; imsi[0][1] = cube[1][1][0]; imsi[0][2] = cube[1][0][0];
		imsi[1][0] = cube[1][2][1]; imsi[1][1] = cube[1][1][1]; imsi[1][2] = cube[1][0][1];
		imsi[2][0] = cube[1][2][2]; imsi[2][1] = cube[1][1][2]; imsi[2][2] = cube[1][0][2];
		for(int i=0; i<3; i++) cube[1][i] = imsi[i].clone();
	}
	static void rotateF() {
		int a = cube[0][2][0], b = cube[0][2][1], c = cube[0][2][2];
		cube[0][2][0] = cube[4][2][2]; cube[0][2][1] = cube[4][1][2]; cube[0][2][2] = cube[4][0][2];
		cube[4][2][2] = cube[1][0][2]; cube[4][1][2] = cube[1][0][1]; cube[4][0][2] = cube[1][0][0];
		cube[1][0][2] = cube[5][0][0]; cube[1][0][1] = cube[5][1][0]; cube[1][0][0] = cube[5][2][0];
		cube[5][0][0] = a; cube[5][1][0] = b; cube[5][2][0] = c;
		
		int[][] imsi = new int[3][3];
		imsi[0][0] = cube[2][2][0]; imsi[0][1] = cube[2][1][0]; imsi[0][2] = cube[2][0][0];
		imsi[1][0] = cube[2][2][1]; imsi[1][1] = cube[2][1][1]; imsi[1][2] = cube[2][0][1];
		imsi[2][0] = cube[2][2][2]; imsi[2][1] = cube[2][1][2]; imsi[2][2] = cube[2][0][2];
		for(int i=0; i<3; i++) cube[2][i] = imsi[i].clone();
	}
	static void rotateB() {
		int a = cube[0][0][2], b = cube[0][0][1], c = cube[0][0][0];
		cube[0][0][2] = cube[5][2][2]; cube[0][0][1] = cube[5][1][2]; cube[0][0][0] = cube[5][0][2];
		cube[5][2][2] = cube[1][2][0]; cube[5][1][2] = cube[1][2][1]; cube[5][0][2] = cube[1][2][2];
		cube[1][2][0] = cube[4][0][0]; cube[1][2][1] = cube[4][1][0]; cube[1][2][2] = cube[4][2][0];
		cube[4][0][0] = a; cube[4][1][0] = b; cube[4][2][0] = c;
		
		int[][] imsi = new int[3][3];
		imsi[0][0] = cube[3][2][0]; imsi[0][1] = cube[3][1][0]; imsi[0][2] = cube[3][0][0];
		imsi[1][0] = cube[3][2][1]; imsi[1][1] = cube[3][1][1]; imsi[1][2] = cube[3][0][1];
		imsi[2][0] = cube[3][2][2]; imsi[2][1] = cube[3][1][2]; imsi[2][2] = cube[3][0][2];
		for(int i=0; i<3; i++) cube[3][i] = imsi[i].clone();
	}
	static void rotateR() {
		int a = cube[0][2][2], b = cube[0][1][2], c = cube[0][0][2];
		cube[0][2][2] = cube[2][2][2]; cube[0][1][2] = cube[2][1][2]; cube[0][0][2] = cube[2][0][2];
		cube[2][2][2] = cube[1][2][2]; cube[2][1][2] = cube[1][1][2]; cube[2][0][2] = cube[1][0][2];
		cube[1][2][2] = cube[3][0][0]; cube[1][1][2] = cube[3][1][0]; cube[1][0][2] = cube[3][2][0];
		cube[3][0][0] = a; cube[3][1][0] = b; cube[3][2][0] = c;
		
		int[][] imsi = new int[3][3];
		imsi[0][0] = cube[5][2][0]; imsi[0][1] = cube[5][1][0]; imsi[0][2] = cube[5][0][0];
		imsi[1][0] = cube[5][2][1]; imsi[1][1] = cube[5][1][1]; imsi[1][2] = cube[5][0][1];
		imsi[2][0] = cube[5][2][2]; imsi[2][1] = cube[5][1][2]; imsi[2][2] = cube[5][0][2];
		for(int i=0; i<3; i++) cube[5][i] = imsi[i].clone();
	}
	static void rotateL() {
		int a = cube[0][0][0], b = cube[0][1][0], c = cube[0][2][0];
		cube[0][0][0] = cube[3][2][2]; cube[0][1][0] = cube[3][1][2]; cube[0][2][0] = cube[3][0][2];
		cube[3][2][2] = cube[1][0][0]; cube[3][1][2] = cube[1][1][0]; cube[3][0][2] = cube[1][2][0];
		cube[1][0][0] = cube[2][0][0]; cube[1][1][0] = cube[2][1][0]; cube[1][2][0] = cube[2][2][0];
		cube[2][0][0] = a; cube[2][1][0] = b; cube[2][2][0] = c;
		
		int[][] imsi = new int[3][3];
		imsi[0][0] = cube[4][2][0]; imsi[0][1] = cube[4][1][0]; imsi[0][2] = cube[4][0][0];
		imsi[1][0] = cube[4][2][1]; imsi[1][1] = cube[4][1][1]; imsi[1][2] = cube[4][0][1];
		imsi[2][0] = cube[4][2][2]; imsi[2][1] = cube[4][1][2]; imsi[2][2] = cube[4][0][2];
		for(int i=0; i<3; i++) cube[4][i] = imsi[i].clone();
	}
}
