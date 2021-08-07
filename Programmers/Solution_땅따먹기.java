package Problem;

public class Solution_땅따먹기 {

	public static void main(String[] args) {
		int[][] land = new int[][] {
			{1,2,3,5},{5,6,7,8},{4,3,2,1}
		};
		
		int answer = solution(land);
		System.out.println(answer);
	}
	public static int solution(int[][] land) {
        int answer = 0;
        
        int N = land.length;
        
        int[][] dp = new int[N][4];
        for(int i=0; i<4; i++) {
        	dp[0][i] = land[0][i];
        }
        
        for(int r=1; r<N; r++) {
        	int exr = r-1;
        	for(int c=0; c<4; c++) {
        		for(int exc=0; exc<4; exc++) {
        			if(c == exc) continue;
        			dp[r][c] = Math.max(dp[r][c], dp[exr][exc]);
        		}
        		dp[r][c] += land[r][c];
        	}
        }
        
        for(int i=0; i<4; i++) {
        	if(dp[N-1][i] > answer) answer = dp[N-1][i];
        }
       
        return answer;
    }
}
