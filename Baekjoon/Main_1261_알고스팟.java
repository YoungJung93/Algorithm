package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1261_알고스팟 {
	static class pair implements Comparable<pair> {
		int x, y, wall;
		public pair(int x, int y, int wall) {
			this.x = x; this.y = y; this.wall = wall;
		}
		public int compareTo(pair o) {
			return Integer.compare(this.wall, o.wall);
		}
	}
	static int N, M, res;
	static int[][] map;
	static boolean[][] flag;
	static int[] dr = {-1,1,0,0}, dc = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		flag = new boolean[N][M];
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		res = 0;
		PriorityQueue<pair> pq = new PriorityQueue<>();
		pq.offer(new pair(0, 0, 0));
		flag[0][0] = true;
		bfs : while(!pq.isEmpty()) {
			pair cur = pq.poll();
			for(int i=0; i<4; i++) {
				int dx = cur.x + dr[i];
				int dy = cur.y + dc[i];
				if(dx<0 || dy<0 || dx>=N || dy>=M) continue;
				if(flag[dx][dy]) continue;
				if(dx==N-1 && dy==M-1) {
					res = cur.wall;
					break bfs;
				}
				flag[dx][dy] = true;
				if(map[dx][dy]==1) pq.offer(new pair(dx, dy, cur.wall+1));
				else pq.offer(new pair(dx, dy, cur.wall));
			}
		}
		System.out.println(res);
	}
}
