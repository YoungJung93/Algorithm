package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14620_꽃길 {
	static int N, res;
	static int[][] map;
	static boolean[][] flag;
	static int[] dr = {-1,1,0,0}, dc = {0,0,-1,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		res = Integer.MAX_VALUE;
		for(int i=1; i<N-1; i++) {
			for(int j=1; j<N-1; j++) {
				flag = new boolean[N][N];
				int r = map[i][j];
				flag[i][j] = true;
				for(int k=0; k<4; k++) {
					int dx = i + dr[k];
					int dy = j + dc[k];
					flag[dx][dy] = true;
					r += map[dx][dy];
				}
				dfs(i, j, r, 1);
			}
		}
		System.out.println(res);
	}
	static void dfs(int r, int c, int total, int cnt) {
		if(cnt == 3) {
			if(res > total) res = total;
			return;
		}
		for(int i=r; i<N-1; i++) {
			for(int j=1; j<N-1; j++) {
				if(i==r && j<=c) continue;
				int t = isFlower(i, j);
				if(t != -1) {
					flag[r][c] = true;
					for(int k=0; k<4; k++) {
						int dx = i + dr[k];
						int dy = j + dc[k];
						flag[dx][dy] = true;
					}
					dfs(i, j, total+t, cnt+1);
					flag[r][c] = false;
					for(int k=0; k<4; k++) {
						int dx = i + dr[k];
						int dy = j + dc[k];
						flag[dx][dy] = false;
					}
				}
			}
		}
	}
	static int isFlower(int r, int c) {
		if(flag[r][c]) return -1;
		boolean f = true;
		int t = map[r][c];
		for(int i=0; i<4; i++) {
			int dx = r + dr[i];
			int dy = c + dc[i];
			if(dx<0 || dy<0 || dx>=N || dy>=N) {
				f = false; break;
			}
			if(flag[dx][dy]) {
				f = false; break;
			}
			t += map[dx][dy];
		}
		if(!f) return -1;
		else return t;
	}
}
