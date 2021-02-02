package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1637_날카로운눈 {
	static int N;
	static int[] A, B, C;
	static int min, max;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		A = new int[N];
		B = new int[N];
		C = new int[N];
		min = Integer.MAX_VALUE; max = Integer.MIN_VALUE;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(a<min) min = a;
			if(c>max) max = c;
			A[i] = a; B[i] = b; C[i] = c;
		}
		int answer = 0;
		int left = min, right = max;
		boolean ff = true;
		while(true) {
			int cen = (right+left)/2;
			int ea = 0;
			for(int i=0; i<N; i++) {
				int k = 0;
				while(A[i] + k*B[i] <= C[i]) {
					int sum = A[i] + k*B[i];
					if(sum <= cen) ea++;
					else break;
					k++;
				}
			}
			if(ea%2==1) right = cen;
			else left = cen;
			if(right==left) {
				answer = right; break;
			} else if(right == left+1) {
				int rea = 0, lea = 0;
				for(int i=0; i<N; i++) {
					int k = 0;
					while(A[i] + k*B[i] <= C[i]) {
						int sum = A[i] + k*B[i];
						if(sum <= right) rea++;
						else break;
						k++;
					}
				}
				if(rea%2==1) {
					answer = right; break;
				}
				for(int i=0; i<N; i++) {
					int k = 0;
					while(A[i] + k*B[i] <= C[i]) {
						int sum = A[i] + k*B[i];
						if(sum <= left) lea++;
						else break;
						k++;
					}
				}
				if(lea%2==1) {
					answer = left; break;
				}
				ff = false; break;
			}
		}
		if(!ff) System.out.println("NOTHING");
		else {
			int ea = 0;
			for(int i=0; i<N; i++) {
				int k = 0;
				while(A[i] + k*B[i] <= C[i]) {
					int sum = A[i] + k*B[i];
					if(sum == answer) {
						ea++; break;
					}
					k++;
				}
			}
			if(ea%2==0) System.out.println("NOTHING");
			else System.out.println(answer + " " + ea);
		}
	}
}
