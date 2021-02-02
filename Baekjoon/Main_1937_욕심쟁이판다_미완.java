package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1937_욕심쟁이판다 {
	static int n, res;
	static int[][] map;
	static int[][] max;
	static boolean[][] flag;
	static int[] dr = {-1,1,0,0}, dc = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		max = new int[n][n];
		for(int i=0; i<n; i++) {
			Arrays.fill(max[i], -1);
		}
		StringTokenizer st;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int result = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				flag = new boolean[n][n];
				res = 0;
				flag[i][j] = true;
				dfs(i, j, 1);
				if(res > result) result = res;
				max[i][j] = res;
			}
		}
		System.out.println(result);
	}
	static void dfs(int r, int c, int cnt) {
		if(cnt>res) res = cnt;
		for(int i=0; i<4; i++) {
			int dx = r + dr[i];
			int dy = c + dc[i];
			if(dx<0 || dx>=n || dy<0 || dy>=n) continue;
			if(flag[dx][dy]) continue;
			if(map[dx][dy] <= map[r][c]) continue;
			if(max[dx][dy]!=-1) {
				int a = cnt + max[dx][dy];
				if(a>res) res = a;
				continue;
			}
			flag[dx][dy] = true;
			dfs(dx, dy, cnt+1);
			flag[dx][dy] = false;
		}
	}
}
