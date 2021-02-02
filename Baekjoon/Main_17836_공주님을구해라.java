package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17836_공주님을구해라 {
	static class knight{
		public int x, y, cnt;
		public knight(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	static int[][] map;
	static boolean[][] flag;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int n, m, t, res, gx, gy;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		map = new int[n+1][m+1];
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=m; j++) {
				int a = Integer.parseInt(st.nextToken());
				if(a==2) {
					gx = i; gy = j;
				}
				map[i][j] = a;
			}
		}
		int dist = Math.abs(n-gx) + Math.abs(m-gy);
		int one = 0, two = 0;
		String result = "";
		res = Integer.MAX_VALUE;
		flag = new boolean[n+1][m+1];
		bfs(n, m);
		one = res;
		res = Integer.MAX_VALUE;
		flag = new boolean[n+1][m+1];
		bfs(gx, gy);
		two = res;
		if(one==Integer.MAX_VALUE && two==Integer.MAX_VALUE) result="Fail";
		else if((two+dist)>t) {
			if(one==Integer.MAX_VALUE) result="Fail";
			else result=one+"";
		}
		else if(one<(two+dist)) result=one+"";
		else result=(two+dist)+"";
		System.out.println(result);
	}
	static void bfs(int dstx, int dsty) {
		Queue<knight> que = new LinkedList<knight>();
		que.offer(new knight(1, 1, 0));
		flag[1][1] = true;
		while(!que.isEmpty()) {
			knight k = que.poll();
			if(k.cnt>t) return;
			if(k.x==dstx && k.y==dsty) { res = k.cnt; return; }
			for(int i=0; i<4; i++) {
				int dx = k.x + dr[i];
				int dy = k.y + dc[i];
				if(dx<1 || dy<1 || dx>n || dy>m) continue;
				if(flag[dx][dy]) continue;
				if(map[dx][dy]==1) continue;
				que.offer(new knight(dx, dy, k.cnt+1));
				flag[dx][dy] = true;
			}
		}
	}
}
