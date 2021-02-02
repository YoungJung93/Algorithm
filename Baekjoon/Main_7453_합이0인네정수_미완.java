package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_7453_합이0인네정수 {
	static int[] A, B, C, D, AB, CD;
	static int n;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		A = new int[n];
		B = new int[n];
		C = new int[n];
		D = new int[n];
		AB = new int[n*n];
		CD = new int[n*n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			A[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());
			C[i] = Integer.parseInt(st.nextToken());
			D[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				AB[i*n+j] = A[i] + B[j];
				CD[i*n+j] = C[i] + D[j];
			}
		}
		Arrays.sort(AB);
		Arrays.sort(CD);
		int answer = 0;
		int Lbound = 0, Rbound = n*n-1;
		int Lzero = 0, Rzero = 0;
		while(Lbound < n*n) {
			if(AB[Lbound] < 0) Lbound++;
			else if(AB[Lbound] == 0) Lzero++;
			else break;
		}
		while(Rbound >= 0) {
			if(CD[Rbound] > 0) Rbound--;
			else if(CD[Rbound] == 0) Rzero++;
			else break;
		}
		int left = 0, right = n*n-1;
//		for(int i=0; i<n*n; i++) {
//			System.out.print(AB[i] + " ");
//		}
//		System.out.println();
//		for(int i=n*n-1; i>=0; i--) {
//			System.out.print(CD[i] + " ");
//		}
//		System.out.println();
		while(left < Lbound && right > Rbound) {
			int a = AB[left];
			int b = CD[right];
			if(Math.abs(a) > Math.abs(b)) {
				left++;
			} else if(Math.abs(a) < Math.abs(b)) {
				right--;
			} else {
				int Lea = 0, Rea = 0;
				for(int i=left; i<Lbound; i++) {
					if(AB[i] == a) Lea++;
					else break;
				}
				for(int i=right; i>Rbound; i--) {
					if(CD[i] == b) Rea++;
					else break;
				}
				System.out.println("left : " + left + ", right : " + right);
				answer += (Lea * Rea);
				left += Lea;
				right -= Rea;
			}
		}
		left = Lbound + Lzero;
		right = Rbound - Rzero;
		while(left < Lbound && right > Rbound) {
			int a = AB[left];
			int b = CD[right];
			if(Math.abs(a) < Math.abs(b)) {
				left++;
			} else if(Math.abs(a) > Math.abs(b)) {
				right--;
			} else {
				int Lea = 0, Rea = 0;
				for(int i=left; i<Lbound; i++) {
					if(AB[i] == a) Lea++;
					else break;
				}
				for(int i=right; i>Rbound; i--) {
					if(CD[i] == b) Rea++;
					else break;
				}
				answer += (Lea * Rea);
				left += Lea;
				right -= Rea;
			}
		}
		System.out.println(answer);
	}
}
