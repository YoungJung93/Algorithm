package Problem;

public class Solution_피보나치수 {

	public static void main(String[] args) {
//		int n = 3;
		int n = 5;
		
		System.out.println(solution(n));
	}
	public static int solution(int n) {
        int answer = 0;
        
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2; i<=n; i++) {
        	dp[i] = (dp[i-2] + dp[i-1]) % 1234567;
        }
        answer = dp[n];
        
        return answer;
    }
}
