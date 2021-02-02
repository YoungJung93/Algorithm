package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_3055_탈출 {
	static class pair{
		public int x, y, cnt;
		public pair(int x, int y, int cnt) {
			this.x = x; this.y = y; this.cnt = cnt;
		}
	}
	static int[][] map;
	static boolean[][] flag;
	static int r, c;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static pair src, dst;
	public static void main(String[] args) throws IOException {
//		Runtime.getRuntime().gc();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new int[r][c];
		flag = new boolean[r][c];
		src=null; dst=null;
		for(int i=0; i<r; i++) {
			String s = br.readLine();
			for(int j=0; j<c; j++) {
				char ch = s.charAt(j);
				switch(ch) {
				case '.' : map[i][j] = 0; break;
				case 'X' : map[i][j] = -1; break;
				case 'S' : 
					src = new pair(i, j, 0);
					map[i][j] = 1; break;
				case 'D' : 
					dst = new pair(i, j, 0);
					map[i][j] = 2; break;
				case '*' : map[i][j] = 3; break;
				}
			}
		}
		int res = bfs(src);
		String result = "";
		if(res==-1) result = "KAKTUS";
		else result = res+"";
		System.out.println(result);
//		long used = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
//
//		System.out.println("used memory is " + used + " bytes");
	}
	static int bfs(pair p) {
		
		Queue<pair> que = new LinkedList<>();
		que.offer(p);
		flag[p.x][p.y] = true;
		int cou = 0;
		ghdtn();
		while (!que.isEmpty()) {
			pair cur = que.poll();
			if(cur.x==dst.x && cur.y==dst.y) return cur.cnt;
			if(cou != cur.cnt) {
				cou = cur.cnt; ghdtn();
			}
			for (int i = 0; i < 4; i++) {
				int dx = cur.x + dr[i];
				int dy = cur.y + dc[i];
				if(dx<0 || dy<0 || dx>=r || dy>=c) continue;
				if(flag[dx][dy]) continue;
				if(map[dx][dy]==0 || map[dx][dy]==2) {
					que.offer(new pair(dx,dy,cur.cnt+1));
					flag[dx][dy] = true;
				}
			}
		}
		return -1;
	}
	
	static void ghdtn() {
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				if(map[i][j]==3) {
					for(int k=0; k<4; k++) {
						int dx = i+dr[k];
						int dy = j+dc[k];
						if(dx<0 || dy<0 || dx>=r || dy>=c) continue;
						if(map[dx][dy]==0) map[dx][dy] = 4;
					}
				}
			}
		}
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				if(map[i][j]==4) map[i][j]=3;
			}
		}
	}
}
