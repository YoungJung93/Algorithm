package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17136_색종이붙이기 {
	static final int MAX_SIZE = 10;
	static int[][] map, map1;
	public static void main(String[] args) throws IOException {
		map = new int[MAX_SIZE][MAX_SIZE];
		map1 = new int[MAX_SIZE][MAX_SIZE];
		int result = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean f = false;
		for(int i=0; i<MAX_SIZE; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<MAX_SIZE; j++) {
				int a = Integer.parseInt(st.nextToken());
				map[i][j] = a;
				map1[i][j] = a;
				if(a!=0) f=true;				
			}
		}
		if(f) {
			int result1 = 0, result2 = 0, result3 = 0, result4 = 0;	// 맨위 왼쪽부터
			first:for(int k=5; k>0; k--) {
				int cnt = 5;
				for(int i=0; i<MAX_SIZE; i++) {
					for(int j=0; j<MAX_SIZE; j++) {
						if(map[i][j]==1 && isFill(k, i, j, 1)) {
							if(--cnt < 0) {
								if(k==1) {
									result1 = -1; break first;
								}
								else {
									continue first;
								}
							} else {
								fill(k, i, j, 1);
								result1++;
							}
						}
					}
				}
			}
			first:for(int k=5; k>0; k--) {	// 맨위 오른쪽부터
				int cnt = 5;
				for(int i=0; i<MAX_SIZE; i++) {
					for(int j=MAX_SIZE; j>=0; j--) {
						if(map[i][j]==1 && isFill(k, i, j, 2)) {
							if(--cnt < 0) {
								if(k==1) {
									result2 = -1; break first;
								}
								else {
									continue first;
								}
							} else {
								fill(k, i, j, 2);
								result2++;
							}
						}
					}
				}
			}
			first:for(int k=5; k>0; k--) {	// 맨아래 왼쪽부터
				int cnt = 5;
				for(int i=0; i<MAX_SIZE; i++) {
					for(int j=MAX_SIZE; j>=0; j--) {
						if(map[i][j]==1 && isFill(k, i, j, 3)) {
							if(--cnt < 0) {
								if(k==1) {
									result3 = -1; break first;
								}
								else {
									continue first;
								}
							} else {
								fill(k, i, j, 3);
								result3++;
							}
						}
					}
				}
			}
			first:for(int k=5; k>0; k--) {	// 맨아래 오른쪽부터
				int cnt = 5;
				for(int i=MAX_SIZE-1; i>=0; i--) {
					for(int j=MAX_SIZE-1; j>=0; j--) {
						if(map1[i][j]==1 && isFill(k, i, j, 4)) {
							if(--cnt < 0) {
								if(k==1) {
									result4 = -1; break first;
								}
								else {
									continue first;
								}
							} else {
								fill(k, i, j, 4);
								result4++;
							}
						}
					}
				}
			}
			if(result2!=-1 && result1==-1) result1 = result2; 
			else if(!(result1!=-1 && result2==-1)) result1 = result1 >= result2 ? result2 : result1;
				
			if(result4!=-1 && result3==-1) result3 = result4; 
			else if(!(result3!=-1 && result4==-1)) result3 = result3 >= result4 ? result4 : result3;
			
			if(result3!=-1 && result1==-1) result = result3;
			else if(result1!=-1 && result3==-1) result = result1;
			else result = result1>=result3 ? result3 : result1;
		}
		System.out.println(result);
	}
	static void fill(int size, int r, int c, int f) {
		if (f==1) {
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					map[r + i][c + j] = 2;
				}
			} 
		} else if(f==2) {
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					map[r + i][c + j] = 2;
				}
			} 
		} else if(f==3) {
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					map[r + i][c + j] = 2;
				}
			} 
		} else {
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					map1[r - i][c - j] = 2;
				}
			} 
		}
	}
	static boolean isFill(int size, int r, int c, int f) {
		if (f==1) {
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					if (r+i>=MAX_SIZE || c+j>=MAX_SIZE || map[r + i][c + j] != 1)
						return false;
				}
			}
			return true;
		} else if (f==2) {
			for (int i = 0; i < size; i++) {
				for (int j = size-1; j >= 0; j--) {
					if (r+i>=MAX_SIZE || c-j<0 || map[r + i][c + j] != 1)
						return false;
				}
			}
			return true;
		} else if (f==3) {
			for (int i = size-1; i >= 0; i++) {
				for (int j = 0; j < size; j++) {
					if (r-i<0 || c+j>=MAX_SIZE || map[r + i][c + j] != 1)
						return false;
				}
			}
			return true;
		} else {
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					if (r-i<0 || c-j<0 || map1[r - i][c - j] != 1)
						return false;
				}
			}
			return true;
		}
	}
}
