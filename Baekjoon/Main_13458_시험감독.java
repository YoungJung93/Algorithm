package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_13458_시험감독 {
	static int N, B, C;
	static int[] A;
	static int[] result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		result = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		for(int i=0; i<N; i++) {
			result[i]++; A[i] -= B;
			if(A[i]<=0) continue;
			result[i] += A[i]/C;
			if(A[i]%C!=0) result[i]++;
		}
		long res = 0;
		for(int i=0; i<N; i++) {
			res += result[i];
		}
		System.out.println(res);
	}
}
