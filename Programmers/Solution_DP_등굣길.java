package Problem;

public class Solution_DP_등굣길 {
	static int m, n, puddles[][];
	static int answer;
	public static void main(String[] args) {
		m = 4;
		n = 3;
		puddles = new int[][] {
			{2,2}
//			{1,5}
		};
		
		answer = 0;
		
		int[][] map = new int[n+1][m+1];
		map[1][1] = 1;
		for(int i=0, size=puddles.length; i<size; i++) {
			map[puddles[i][1]][puddles[i][0]] = -1;
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if(i==1 && j==1) continue;
				if (map[i][j] == -1) continue;
				int a = 0;
				if (i - 1 >= 1 && map[i - 1][j] != -1) a += map[i - 1][j];
				if (j - 1 >= 1 && map[i][j - 1] != -1) a += map[i][j - 1];
				map[i][j] = a % 1000000007;
			}
		}
		answer = map[n][m] % 1000000007;
		
		System.out.println(answer);
		
	}
}
