package Problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1987_알파벳 {
	static char[][] map;
	static int R, C, res;
	static boolean[][] flag;
	static int[] dr = {-1,1,0,0}, dc = {0,0,-1,1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		flag = new boolean[R][C];
		for(int i=0; i<R; i++) {
			String s = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		res = 0;
		dfs(0, 0, 1, (1<<(int)(map[0][0]-'A')));
		System.out.println(res);
	}
	static void dfs(int r, int c, int cnt, int mask) {
		if(cnt > res) res = cnt;
		for(int i=0; i<4; i++) {
			int dx = r + dr[i];
			int dy = c + dc[i];
			if(dx<0 || dy<0 || dx>=R || dy>=C) continue;
			if(flag[dx][dy]) continue;
			if((mask & (1<<(int)(map[dx][dy]-'A'))) == 0) {
				flag[dx][dy] = true;
				dfs(dx, dy, cnt+1, (mask | (1<<(int)(map[dx][dy]-'A'))));
				flag[dx][dy] = false;
			}
		}
	}
}
