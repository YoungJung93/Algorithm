package Problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1189_컴백홈 {
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int R, C, K, answer;
	static int[][] map;
	static boolean[][] flag;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		for(int i=0; i<R; i++) {
			String s = br.readLine();
			for(int j=0; j<C; j++) {
				char c = s.charAt(j);
				if(c == 'T') {
					map[i][j] = -1;
				}
			}
		}
		flag = new boolean[R][C];
		flag[R-1][0] = true;
		answer = 0;
		go(R-1, 0, 1);
		
		System.out.println(answer);
	}
	public static void go(int r, int c, int cnt) {
		if(cnt > K) return;
		if(cnt == K) {
			if(r == 0 && c == C-1) {
				answer++;
			}
			return;
		}
		for(int i=0; i<4; i++) {
			int dx = r + dr[i];
			int dy = c + dc[i];
			if(dx<0 || dy<0 || dx>=R || dy>=C) continue;
			if(flag[dx][dy] || map[dx][dy] == -1) continue;
			flag[dx][dy] = true;
			go(dx, dy, cnt+1);
			flag[dx][dy] = false;
		}
	}
}
