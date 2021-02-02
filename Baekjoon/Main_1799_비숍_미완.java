package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1799_비숍 {
	static class pair {
		int r, c;
		public pair(int r, int c) {
			this.r = r; this.c = c;
		}
	}
	static int[][] map;
	static int N, len;
	static List<pair> bishop;
	static int[][] flag;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		bishop = new ArrayList<pair>();
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				int a = Integer.parseInt(st.nextToken());
				if(a==1) {
					map[i][j] = 0;
					bishop.add(new pair(i, j));
				}
				else map[i][j] = -1;
			}
		}
		len = bishop.size();
		flag = new int[N][N];
		res = 0;
		dfs(0, 0);
		System.out.println(res);
	}
	static int res;
	static int[] dr = {-1,-1,1,1}, dc = {-1,1,-1,1};
	static void dfs(int ind, int cnt) {
		if(len-ind+cnt <= res) return; 
		if(ind == len) {
			if(cnt > res) res = cnt;
			return;
		}
		pair cur = bishop.get(ind);
		if(flag[cur.r][cur.c]==0) {
			// 비숍을 놓고 다음으로 갈 수 있음
			for(int i=0; i<4; i++) {
				int dx = cur.r + dr[i];
				int dy = cur.c + dc[i];
				while(true) {
					if(dx<0 || dy<0 || dx>=N || dy>=N) break;
					flag[dx][dy]++;
					dx += dr[i];
					dy += dc[i];
				}
			}
			dfs(ind+1, cnt+1);
			for(int i=0; i<4; i++) {
				int dx = cur.r + dr[i];
				int dy = cur.c + dc[i];
				while(true) {
					if(dx<0 || dy<0 || dx>=N || dy>=N) break;
					flag[dx][dy]--;
					dx += dr[i];
					dy += dc[i];
				}
			}
		}
		dfs(ind+1, cnt);
	}
}
