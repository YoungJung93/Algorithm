package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3109_빵집 {
	static boolean[][] map; 
	static int n, m, result;
	static int[] dr, dc;
	public static void main(String[] args) throws IOException {
		dr = new int[] {-1, 0, 1};
		dc = new int[] {1, 1, 1};
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new boolean[n][m];
		result = 0;
		for(int i=0; i<n; i++) {
			String s = br.readLine();
			for(int j=0; j<m; j++) {
				if(s.charAt(j)=='.') map[i][j] = true;
			}
		}
		int res = 0;
		for(int i=0; i<n; i++) {
			if(dfs(i, 0, 0)) {
				res++;
			}
		}
		System.out.println(res);
	}
	static boolean dfs(int x, int y, int cnt) {
		if(cnt==m-1) return true;
		for(int i=0; i<3; i++) {
			int dx = x + dr[i];
			int dy = y + dc[i];
			if(dx<0 || dy<0 || dx>=n || dy >= m) continue;
			if(map[dx][dy]) {
				map[dx][dy] = false;
				if(dfs(dx, dy, cnt+1)) return true;
//				map[dx][dy] = true;
			}
		}
		return false;
	}
}