package Problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1003_피보나치함수 {
	static int zero, one;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			int n = Integer.parseInt(br.readLine());
			int[][] dp = new int[n+1][2];
			if(n == 0) {
				System.out.println("1 0");
				continue;
			} else if(n == 1) {
				System.out.println("0 1");
				continue;
			}
			dp[0][0] = 1;
			dp[1][1] = 1;
			for(int i=2; i<=n; i++) {
				dp[i][0] = dp[i-1][0] + dp[i-2][0];
				dp[i][1] = dp[i-1][1] + dp[i-2][1];
			}
			System.out.println(dp[n][0] + " " + dp[n][1]);
		}
	}
}
