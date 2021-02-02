package Problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_3187_양치기꿍 {
	static int R, C;
	static char[][] map;
	static boolean[][] flag;
	static int[] dr = {-1,1,0,0}, dc = {0,0,-1,1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for(int i=0; i<R; i++) {
			String s = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j] == 'v') {
					int[] tmp = cal(i, j);
					if(tmp[0] >= tmp[1]) eat(i, j, 'k');
					else eat(i, j, 'v');
				}
			}
		}
		int[] answer = new int[2];
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j] == 'v') answer[1]++;
				else if(map[i][j] == 'k') answer[0]++;
			}
		}
		System.out.println(answer[0] + " " + answer[1]);
	}
	// 늑대의 위치 (r,c)에서 시작하여 늑대와 양의 수를 세서 리턴한다.
	static int[] cal(int r, int c) {
		int[] res = new int[2];
		Queue<Integer> que = new LinkedList<>();
		flag = new boolean[R][C];
		que.offer(r); que.offer(c);
		flag[r][c] = true;
		res[0]++;
		while(!que.isEmpty()) {
			int x = que.poll();
			int y = que.poll();
			for(int i=0; i<4; i++) {
				int dx = x + dr[i];
				int dy = y + dc[i];
				if(dx<0 || dy<0 || dx>=R || dy>=C) continue;
				if(map[dx][dy] == '#') continue;
				if(flag[dx][dy]) continue;
				flag[dx][dy] = true;
				if(map[dx][dy] == 'v') res[0]++;
				else if(map[dx][dy] == 'k') res[1]++;
				que.offer(dx); que.offer(dy);
			}
		}
		return res;
	}
	// map의 (r,c)에서 시작하여 ch를 찾아 .으로 바꿔준다.
	static void eat(int r, int c, char ch) {
		Queue<Integer> que = new LinkedList<>();
		flag = new boolean[R][C];
		que.offer(r); que.offer(c);
		flag[r][c] = true;
		if(map[r][c] == ch) map[r][c] = '.';
		while(!que.isEmpty()) {
			int x = que.poll();
			int y = que.poll();
			for(int i=0; i<4; i++) {
				int dx = x + dr[i];
				int dy = y + dc[i];
				if(dx<0 || dy<0 || dx>=R || dy>=C) continue;
				if(map[dx][dy] == '#') continue;
				if(flag[dx][dy]) continue;
				flag[dx][dy] = true;
				if(map[dx][dy] == ch) map[dx][dy] = '.';
				que.offer(dx); que.offer(dy);
			}
		}
	}
}
