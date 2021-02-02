package Problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2591_숫자카드 {
	static long[] arr;
	static long[] dp;
	static int len;
	static String inp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		inp = br.readLine();
		len = inp.length();
		if(len!=1) {
			arr = new long[len];
			dp = new long[len];
			arr[0] = 1;
			for(int i=1; i<len; i++) {
				int sub = Integer.parseInt(inp.substring(i-1, i+1));
				
				if(sub <= 34) {
					if(sub < 10) {
						arr[i] = 1;
					} else if(sub % 10 == 0) {
						arr[i] = 1;
					} else arr[i] = 2;
				}
				else {
					if(sub % 10 == 0) arr[i] = 0;
					else arr[i] = 1;
				}
			}
			dp[0] = 1;
			dp[1] = arr[1];
			for(int i=2; i<len; i++) {
				if(arr[i]==1) dp[i] = dp[i-1];
				else dp[i] = dp[i-2] + dp[i-1];
			}                                                    
			System.out.println(dp[len-1]);
		} else {
			System.out.println(1);
		}
	}
}
