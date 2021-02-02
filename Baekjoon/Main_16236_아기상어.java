package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16236_아기상어 {
	static int[][] map;
	static int val, n, cnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		int x=0, y=0;
		val=2; cnt=0;
		int result=0;
		for(int i=0; i<n ;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				int a = Integer.parseInt(st.nextToken());
				if(a==9) {					
					map[i][j] = 0;
					x=i; y=j;
				} else {
					map[i][j] = a;
				}
			}
		}
		while(true) {
			int[] arr = nextFish(x, y);
			if(arr==null) break;
			if(++cnt==val) {
				val++; cnt=0;
			}
			x = arr[0];
			y = arr[1];
			map[x][y] = 0;
			result+=arr[2];
		}
		System.out.println(result);
	}
	static int[] nextFish(int x, int y) {
		int r=-1, c=-1, min=Integer.MAX_VALUE;
		for(int i=0;i<n;i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j]!=0 && map[i][j]<val) {
					int dis = dis(new pair(x,y,0),i,j);
					if(dis!=-1 && dis<min) {
						min=dis;
						r = i;
						c = j;
					}
				}
			}
		}
		if(r==-1 && c==-1) return null;
		return new int[] {r, c, min};
	}
	static int dis(pair p, int r, int c) {
		// 못가면 -1
		boolean[][] flag = new boolean[n][n];
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		for(int i=0; i<n; i++) {
			for(int j=0; j<n ; j++) {
				if(map[i][j]==0) flag[i][j] = true;
				else if(map[i][j]<=val) flag[i][j] = true;
				else flag[i][j] = false;
			}
		}
		Queue<pair> que = new LinkedList<>();
		que.offer(p);
		flag[p.x][p.y] = false;
		while(!que.isEmpty()) {
			pair cur = que.poll();
			int xx = cur.x;
			int yy = cur.y;
			int ct = cur.cnt;
			if(xx==r && yy==c) {
				return ct;
			}
			for(int i=0; i<4; i++) {
				int dx = xx+dr[i];
				int dy = yy+dc[i];
				if(dx<0 || dy<0 || dx>=n || dy>=n) continue;
				if(flag[dx][dy]) {
					que.offer(new pair(dx, dy, ct+1));
					flag[dx][dy] = false;
				}
			}
		}
		return -1;
	}
	static class pair {
		public int x, y, cnt;
		public pair(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
}