package Problem;

import java.util.Arrays;

public class Solution_DP_카드게임 {
	static int[] left, right;
	static int answer;
	static int[][] dp;
	public static void main(String[] args) {
		left = new int[] {
			3,2,5	
		};
		right = new int[] {
			2,4,1
		};
		answer = 0;
		
		dp = new int[left.length+1][right.length+1];
		for(int i=0; i<=left.length; i++) {
			Arrays.fill(dp[i], -1);
		}
		answer = go(left, right, 0, 0);
		
		
		System.out.println(answer);
	}
	static int go(int[] left, int[] right, int l, int r) {
		if(l >= left.length || r >= right.length) {
			dp[l][r] = 0;
			return dp[l][r];
		}
		if(dp[l][r] != -1) return dp[l][r];
		if(left[l] > right[r]) {
			dp[l][r] = Math.max(dp[l][r], go(left, right, l, r+1) + right[r]);
		}
		dp[l][r] = Math.max(dp[l][r], go(left, right, l+1, r+1));
		dp[l][r] = Math.max(dp[l][r], go(left, right, l+1, r));
		return dp[l][r];
	}
}
