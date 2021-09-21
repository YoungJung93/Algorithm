package Problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1106_호텔 {
	static int c, n, res;
	static int[][] info;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		c = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		info = new int[n][2];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			// 비용
			info[i][0] = Integer.parseInt(st.nextToken());
			// 비용으로 얻을 수 있는 고객의 수
			info[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[c+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		for(int i=1; i<=c; i++) {
			for(int j=0; j<n; j++) {
				if((i-info[j][1]) > 0) {
					dp[i] = Math.min(dp[i], dp[i-info[j][1]]+info[j][0]);
				} else {
					dp[i] = Math.min(dp[i], info[j][0]);
				}
			}
		}
		
		System.out.println(dp[c]);
	}
}
