package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2933_미네랄 {
	static class pair{
		public int x, y;
		public pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int R, C;
	static char[][] map;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for(int i=0; i<R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			int a = R - Integer.parseInt(st.nextToken()); // 높이
			boolean cur = destroyMineral(i, a);			// 미네랄 파괴
			if(!cur) continue;
			// 공중에 떠 잇는 미네랄이 있는지 확인 (isFloat())
			// 확인 후 있으면 떨어뜨리기
			boolean[][] flag = isFloat();
			if(flag==null) continue;
			ff : while(true) {
				for (int j = R - 1; j >= 0; j--) {
					for (int k = 0; k < C; k++) {
						if(flag[j][k]) {
							if(j==R-1 || (map[j+1][k]=='x' && !flag[j+1][k])) {
								break ff;
							}
						}
					}
				}
				for (int j = R - 1; j >= 0; j--) {
					for (int k = 0; k < C; k++) {
						if(flag[j][k]) {
							flag[j][k] = false;
							flag[j+1][k] = true;
							map[j][k] = '.';
							map[j+1][k] = 'x';
						}
					}
				}
			}
		}
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

	static boolean[][] isFloat(){		// 공중에 떠 있는 미네랄이 없으면 null을 리턴
		boolean[][] flag = new boolean[R][C];
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j]=='x') flag[i][j]=true;
			}
		}
		Queue<pair> que = new LinkedList<pair>();
		for(int i=0; i<C; i++) {
			if(flag[R-1][i]) {
				que.offer(new pair(R-1, i));
				flag[R-1][i] = false;
				while(!que.isEmpty()) {
					pair p = que.poll();
					for(int j=0; j<dr.length; j++) {
						int dx = p.x + dr[j];
						int dy = p.y + dc[j];
						if(dx<0 || dy<0 || dx>=R || dy>=C) continue;
						if(flag[dx][dy]) {
							flag[dx][dy] = false;
							que.offer(new pair(dx, dy));
						}
					}
				}
			}
		}
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(flag[i][j]) return flag;
			}
		}
		return null;
	}
	
	static boolean destroyMineral(int t, int h) {	// h 높이의 미네랄을 하나 파괴하고 그 높이의 열 값을 리턴, 없으면 -1 리턴
		if(t%2==0) {
			for(int i=0; i<C; i++) {
				if(map[h][i]=='x') {
					map[h][i] = '.';
					return true;
				}
			}
		} else {
			for(int i=C-1; i>=0; i--) {
				if(map[h][i]=='x') {
					map[h][i] = '.';
					return true;
				}
			}
		}
		return false;
	}
}
