package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17142_연구소3 {
	static class pair {
		int r, c, cnt;
		public pair(int r, int c, int cnt) {
			this.r = r; this.c = c; this.cnt = cnt;
		}
	}
	static int[] comb;
	static pair[] virus;
	static int N, M, V;
	static int[][] map;
	static int[][] imsi;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		V = 0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				int a = Integer.parseInt(st.nextToken());
				if(a==0) map[i][j] = -1;
				else if(a==1) map[i][j] = -2;
				else if(a==2) V++;
			}
		}
		comb = new int[V];
		virus = new pair[V];
		for(int i=0, v=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == 0) {
					virus[v++] = new pair(i, j, 0);
				}
			}
		}
		for(int i=0; i<M; i++) {
			comb[i] = 1;
		}
		Arrays.sort(comb);
		int answer = Integer.MAX_VALUE;
		do {
			imsi = new int[N][N];
			for(int i=0; i<N; i++) imsi[i] = map[i].clone();
			bfs();
			boolean f = false;
			int res = 0;
			first : for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(imsi[i][j] == -1) {
						f = true; break first;
					}
					if(imsi[i][j] > res) res = imsi[i][j];
				}
			}
			if(!f) {
				if(res < answer) answer = res;
			}
		} while(nc());
		if(answer == Integer.MAX_VALUE) answer = -1;
		System.out.println(answer);
	}
	static int[] dr = {-1,1,0,0}, dc = {0,0,-1,1};
	static void bfs() {
		Queue<pair> que = new LinkedList<>();
		boolean[][] flag = new boolean[N][N];
		for(int i=0; i<V; i++) {
			if(comb[i] == 1) {
				que.offer(new pair(virus[i].r, virus[i].c, 0));
				flag[virus[i].r][virus[i].c] = true;
			}
		}
		while(!que.isEmpty()) {
			pair cur = que.poll();
			for(int i=0; i<4; i++) {
				int dx = cur.r + dr[i];
				int dy = cur.c + dc[i];
				if(dx<0 || dy<0 || dx>=N || dy>=N) continue;
				if(flag[dx][dy]) continue;
				if(imsi[dx][dy] == -1) {
					flag[dx][dy] = true;
					imsi[dx][dy] = cur.cnt + 1;
					que.offer(new pair(dx, dy, cur.cnt+1));
				} else if(imsi[dx][dy] == 0) {
					flag[dx][dy] = true;
					que.offer(new pair(dx, dy, cur.cnt+1));
				}
			}
		}
	}
	static boolean nc() {
		int i = V - 1;
		while(i>0 && comb[i-1] >= comb[i]) i--;
		if(i==0) return false;
		int j = V - 1;
		while(comb[i-1] >= comb[j]) j--;
		swap(i-1, j);
		j = V - 1;
		while(j > i) swap(i++, j--);
		return true;
	}
	static void swap(int x, int y) {
		int tmp = comb[x];
		comb[x] = comb[y];
		comb[y] = tmp;
	}
}
