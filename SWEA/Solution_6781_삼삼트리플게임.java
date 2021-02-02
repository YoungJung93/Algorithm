package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_6781_삼삼트리플게임 {
	static final int MAX = 9;
	static char[] R, G, B;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int i=1; i<=T; ++i) {
			String res = "";
			String n = br.readLine();
			String c = br.readLine();
			R = new char[MAX];
			G = new char[MAX];
			B = new char[MAX];
			r=0; g=0; b=0;
			for(int j=0; j<MAX; ++j) {
				char ch = c.charAt(j);
				switch(ch) {
				case 'R' :
					R[r++] = n.charAt(j);
					break;
				case 'G' :
					G[g++] = n.charAt(j);
					break;
				case 'B' :
					B[b++] = n.charAt(j);
					break;
				}
			}
			R = Arrays.copyOfRange(R, 0, r);
			G = Arrays.copyOfRange(G, 0, g);
			B = Arrays.copyOfRange(B, 0, b);
			result=0;
			r/=3; g/=3; b/=3;
			if(r!=0) {
				flag=false; per(1, 0);
			}
			if(g!=0) {
				flag=false; per(2, 0);
			}
			if(b!=0) {
				flag=false; per(3, 0);
			}
			if(result==3) res = "Win";
			else res = "Continue";
			System.out.println("#" + i + " " + res);
		}
	}
	static boolean isSame(char x, char y, char z) {
		if(x==y && y==z) return true;
		return false;
	}
	static boolean isCsq(char x, char y, char z) {
		if(x==y-1 && y==z-1) return true;
		return false;
	}
	static int r,g,b;
	static int result;
	static boolean flag;
	static void per(int ind, int cnt) {
		if (!flag && ind==1 && r!=0) {
			if (cnt == R.length) {
				if(r==1) {
					if(isSame(R[0], R[1], R[2]) || isCsq(R[0], R[1], R[2])) {
						result++; flag=true; return;
					}
				} else if(r==2) {
					if((isSame(R[0], R[1], R[2]) || isCsq(R[0], R[1], R[2]))
						&& (isSame(R[3], R[4], R[5]) || isCsq(R[3], R[4], R[5]))) {
						result+=2; flag=true; return;
					}
				} else {
					if((isSame(R[0], R[1], R[2]) || isCsq(R[0], R[1], R[2]))
							&& (isSame(R[3], R[4], R[5]) || isCsq(R[3], R[4], R[5]))
							&& (isSame(R[6], R[7], R[8]) || isCsq(R[6], R[7], R[8]))){
						result+=3; flag=true; return;
					}
				}
			}
			for (int i = cnt, size = R.length; i < size; ++i) {
				swap(ind, cnt, i);
				per(ind, cnt + 1);
				swap(ind, i, cnt);
			} 
		} else if (!flag && ind==2 && g!=0) {
			if (cnt == G.length) {
				if(g==1) {
					if(isSame(G[0], G[1], G[2]) || isCsq(G[0], G[1], G[2])) {
						result++; flag=true; return;
					}
				} else if(g==2) {
					if((isSame(G[0], G[1], G[2]) || isCsq(G[0], G[1], G[2]))
						&& (isSame(G[3], G[4], G[5]) || isCsq(G[3], G[4], G[5]))) {
						result+=2; flag=true; return;
					}
				} else {
					if((isSame(G[0], G[1], G[2]) || isCsq(G[0], G[1], G[2]))
							&& (isSame(G[3], G[4], G[5]) || isCsq(G[3], G[4], G[5]))
							&& (isSame(G[6], G[7], G[8]) || isCsq(G[6], G[7], G[8]))){
						result+=3; flag=true; return;
					}
				}
			}
			for (int i = cnt, size = G.length; i < size; ++i) {
				swap(ind, cnt, i);
				per(ind, cnt + 1);
				swap(ind, cnt, i);
			} 
		} else if (!flag && ind==3 && b!=0) {
			if (cnt == B.length) {
				if(b==1) {
					if(isSame(B[0], B[1], B[2]) || isCsq(B[0], B[1], B[2])) {
						result++; flag=true; return;
					}
				} else if(b==2) {
					if((isSame(B[0], B[1], B[2]) || isCsq(B[0], B[1], B[2]))
						&& (isSame(B[3], B[4], B[5]) || isCsq(B[3], B[4], B[5]))) {
						result+=2; flag=true; return;
					}
				} else {
					if((isSame(B[0], B[1], B[2]) || isCsq(B[0], B[1], B[2]))
							&& (isSame(B[3], B[4], B[5]) || isCsq(B[3], B[4], B[5]))
							&& (isSame(B[6], B[7], B[8]) || isCsq(B[6], B[7], B[8]))){
						result+=3; flag=true; return;
					}
				}
			}
			for (int i = cnt, size = B.length; i < size; ++i) {
				swap(ind, cnt, i);
				per(ind, cnt + 1);
				swap(ind, cnt, i);
			} 
		}
	}
	static void swap(int ind, int i, int j) {
		if(ind==1) {
			char tmp = R[i];
			R[i] = R[j];
			R[j] = tmp;
		} else if(ind==2) {
			char tmp = G[i];
			G[i] = G[j];
			G[j] = tmp;
		} else {
			char tmp = B[i];
			B[i] = B[j];
			B[j] = tmp;
		}
	}
}
