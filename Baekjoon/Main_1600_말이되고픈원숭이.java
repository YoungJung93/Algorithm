package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1600_말이되고픈원숭이 {
	static class monkey {
		int r, c, cnt, k;
		public monkey(int r, int c, int cnt, int k) {
			this.r = r; this.c = c;
			this.cnt = cnt; this.k = k;
		}
	}
	static int[][] map;
	static int K, W, H;
	static int[] dr = {-1,1,0,0,-1,-2,-2,-1,1,2,2,1};
	static int[] dc = {0,0,-1,1,-2,-1,1,2,2,1,-1,-2};
	static int answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		for(int i=0; i<H; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		if(H==1 && W==1) {
			if(map[0][0]==1) answer = -1;
			else answer = 0;
		} else {
			Queue<monkey> que = new LinkedList<monkey>();
			boolean[][][] flag = new boolean[K+1][H][W];
			flag[0][0][0] = true;
			que.offer(new monkey(0, 0, 0, 0));
			answer = -1;
			
			bfs : while(!que.isEmpty()) {
				monkey cur = que.poll();
				int limit = 4;
				if(cur.k < K) limit = 12;
				for(int i=0; i<limit; i++) {
					int dx = cur.r + dr[i];
					int dy = cur.c + dc[i];
					if(dx<0 || dx>=H || dy<0 || dy>=W) continue;
					if(dx==H-1 && dy==W-1) {
						answer = cur.cnt+1;
						break bfs;
					}
					if(map[dx][dy]==1) continue;
					if(i>=4) {
						if(flag[cur.k+1][dx][dy]) continue;
						flag[cur.k+1][dx][dy] = true;
						que.offer(new monkey(dx, dy, cur.cnt+1, cur.k+1));
					} else {
						if(flag[cur.k][dx][dy]) continue;
						flag[cur.k][dx][dy] = true;
						que.offer(new monkey(dx, dy, cur.cnt+1, cur.k));
					}
				}
			}
		}
		
		System.out.println(answer);
	}
}
