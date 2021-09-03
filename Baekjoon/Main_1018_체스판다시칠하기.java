package Problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1018_체스판다시칠하기 {
	static int N, M;
	static int[][] map, chess[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		chess = new int[][][] {
			{
				{1,0,1,0,1,0,1,0},
				{0,1,0,1,0,1,0,1},
				{1,0,1,0,1,0,1,0},
				{0,1,0,1,0,1,0,1},
				{1,0,1,0,1,0,1,0},
				{0,1,0,1,0,1,0,1},
				{1,0,1,0,1,0,1,0},
				{0,1,0,1,0,1,0,1}
			},
			{
				{0,1,0,1,0,1,0,1},
				{1,0,1,0,1,0,1,0},
				{0,1,0,1,0,1,0,1},
				{1,0,1,0,1,0,1,0},
				{0,1,0,1,0,1,0,1},
				{1,0,1,0,1,0,1,0},
				{0,1,0,1,0,1,0,1},
				{1,0,1,0,1,0,1,0}
			}
		};
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				char c = s.charAt(j);
				if(c == 'W') map[i][j] = 0;
				else map[i][j] = 1;
			}
		}
		
		int answer = Integer.MAX_VALUE;
		for(int i=0; i<=N-8; i++) {
			for(int j=0; j<=M-8; j++) {
				int fill = go(i, j);
				if(fill < answer) answer = fill;
			}
		}
		
		System.out.println(answer);
	}
	public static int go(int r, int c) {
		int answer = Integer.MAX_VALUE;
		for (int k = 0; k < 2; k++) {
			int result = 0;
			for (int i = r; i < r + 8; i++) {
				for (int j = c; j < c + 8; j++) {
					if (map[i][j] != chess[k][i-r][j-c]) result++;
				}
			}
			if(answer > result) answer= result;
		}
		return answer;
	}
}
