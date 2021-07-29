package Problem;

public class Solution_가장큰정사각형찾기 {

	public static void main(String[] args) {
		int[][] board = {
//				{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}
//				{0,0,1,1},{1,1,1,1}
//				{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1}
				{1}
		};
		
		int answer = solution(board);
		System.out.println(answer);
	}
	public static int solution(int[][] board) {
        int answer = 0;

        final int R = board.length;
        final int C = board[0].length;
        int[][] dp = new int[R][C];
        int maxSize = 0;
        for(int i=0; i<R; i++) {
        	if(board[i][0] == 1) maxSize = 1;
        	dp[i][0] = board[i][0];
        }
        for(int i=0; i<C; i++) {
        	if(board[0][i] == 1) maxSize = 1;
        	dp[0][i] = board[0][i];
        }
        
        
        for(int r=1; r<R; r++) {
        	for(int c=1; c<C; c++) {
        		if(board[r][c] == 0) continue;
        		dp[r][c] = Math.min(Math.min(dp[r-1][c], dp[r][c-1]), dp[r-1][c-1]) + 1;
        		maxSize = Math.max(maxSize, dp[r][c]);
        	}
        }
        answer = maxSize * maxSize;
        
        return answer;
    }
}
