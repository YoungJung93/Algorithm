package Problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1182_부분수열의합 {
	static int N, S, res;
	static int[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		res = 0;
		go(0, 0, 0);
		
		System.out.println(res);
	}
	public static void go(int ind, int sum, int select) {
		if(ind == N) {
			if(select > 0 && sum == S) {
				res++;
			}
			return;
		}
		go(ind+1, sum+arr[ind], select+1);
		go(ind+1, sum, select);
	}
}
