package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_4811_알약 {
	static int N;
	static long[][] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N == 0) break;
			long answer = 0;
			dp = new long[N+1][N+1];
			if(N==1) answer = 1;
			else if(N==2) answer = 2;
			else {
				dp[3][3] = 1;
				for(int i=4; i<=N; i++) {
					for(int j=i; j>=3; j--) {
						long sum = 0;
						for(int k=j-1; k<i; k++) {
							sum += dp[i-1][k];
						}
						dp[i][j] = sum;
					}
				}
				long[] sum = new long[N+1];
				sum[2] = 2;
				for(int i=3; i<=N; i++) sum[i] = sum[i-1] + i;
				for(int i=1; i<=N; i++) {
					answer += sum[i] * dp[N][i];
				}
			}
			System.out.println(answer);
		}
	}
}
