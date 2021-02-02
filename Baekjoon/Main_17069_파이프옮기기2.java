package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17069_파이프옮기기2 {
	static long[][][] dp;
	static int[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		dp = new long[n+1][n+1][3];
		map = new int[n+1][n+1];
		for(int i=1; i<=n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1; j<=n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dp[1][2][0] = 1;
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n ;j++) {
				if(map[i][j]==1) continue;
				if((i==1 && j==1) || (i==1 && j==2)) continue;
				int res = 0;
				// 왼쪽에서 오는 경우(가로, 대각선)
				if(j-1>=1 && map[i][j]==0) {
					dp[i][j][0] += dp[i][j-1][0];
					dp[i][j][0] += dp[i][j-1][2];
				}
				// 위쪽에서 오는 경우(세로, 대각선)
				if(i-1>=1 && map[i][j]==0) {
					dp[i][j][1] += dp[i-1][j][1];
					dp[i][j][1] += dp[i-1][j][2];
				}
				// 왼위 대각선쪽에서 오는 경우(가로, 세로, 대각선)
				if(i-1>=1 && j-1>=1 && map[i-1][j]==0 && map[i][j-1]==0 && map[i][j]==0) {
					dp[i][j][2] += dp[i-1][j-1][0];
					dp[i][j][2] += dp[i-1][j-1][1];
					dp[i][j][2] += dp[i-1][j-1][2];
				}
			}
		}
		System.out.println((dp[n][n][0]+dp[n][n][1]+dp[n][n][2]));
	}
}
