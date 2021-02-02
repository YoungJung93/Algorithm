package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14501_퇴사 {
	static int[][] arr;
	static int N, res;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][2];
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[N+1];
		for(int i=0; i<N; i++) {
			int base = arr[i][1] + dp[i];
			for(int j=i+arr[i][0]; j<=N; j++) {
				dp[j] = Math.max(dp[j], base);
			}
		}
		
		int answer = 0;
		for(int i=0; i<=N; i++) {
			if(dp[i] > answer) answer = dp[i];
		}
		System.out.println(answer);
	}
}
