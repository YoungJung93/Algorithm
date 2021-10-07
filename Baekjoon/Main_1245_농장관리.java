package Problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1245_농장관리 {
	static class Pos {
		int r, c, h;
		public Pos(int r, int c, int h) {
			this.r = r;
			this.c = c;
			this.h = h;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int[][] map = new int[R][C];
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int answer = 0;
		int[] dr = {-1,-1,-1,0,0,1,1,1};
		int[] dc = {-1,0,1,-1,1,-1,0,1};
		boolean[][] flag = new boolean[R][C];
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(flag[i][j] || map[i][j]==0) continue;
				boolean isPeak = true;
				Queue<Pos> que = new LinkedList<>();
				flag[i][j] = true;
				que.offer(new Pos(i, j, map[i][j]));
				while(!que.isEmpty()) {
					Pos cur = que.poll();
					for(int k=0; k<8; k++) {
						int dx = cur.r + dr[k];
						int dy = cur.c + dc[k];
						if(dx<0 || dy<0 || dx>=R || dy>=C) continue;
						if(map[dx][dy] == cur.h) {
							if(flag[dx][dy]) continue;
							que.offer(new Pos(dx, dy, cur.h));
							flag[dx][dy] = true;
						} else if(isPeak && map[dx][dy] < cur.h) {
							continue;
						} else if(isPeak && map[dx][dy] > cur.h) {
							isPeak = false;
						}
					}
				}
				if(isPeak) answer++;
			}
		}
		
		System.out.println(answer);
	}

}
