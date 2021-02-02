package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14888_연산자끼워넣기 {
	static int[] arr;
	static int[] op;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		op = new int[4];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) {
			op[i] = Integer.parseInt(st.nextToken());
		}
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		dfs(1, arr[0]);
		System.out.println(max);
		System.out.println(min);
	}
	static int max, min;
	static void dfs(int ind, int sum) {
		if(ind == N) {
			if(sum>max) max = sum;
			if(sum<min) min = sum;
			return;
		}
		for(int i=0; i<4; i++) {
			if(op[i] > 0) {
				op[i]--;
				if(i==0) dfs(ind+1, sum+arr[ind]);
				if(i==1) dfs(ind+1, sum-arr[ind]);
				if(i==2) dfs(ind+1, sum*arr[ind]);
				if(i==3) dfs(ind+1, sum/arr[ind]);
				op[i]++;
			}
		}
	}
}
