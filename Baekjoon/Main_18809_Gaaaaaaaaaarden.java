package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_18809_Gaaaaaaaaaarden {
	static class pair {
		int r, c, time;
		public pair(int r, int c, int time) {
			this.r = r; this.c = c; this.time = time;
		}
	}
	static int[][] map;
	static int N, M, G, R;
	static int[][] bayang;
	static int blen;
	static int[] green, red;
	static int[] dr = {-1,1,0,0}, dc = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		blen = 0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				int a = Integer.parseInt(st.nextToken());
				map[i][j] = a;
				if(a==2) blen++;
			}
		}
		bayang = new int[blen][2];
		for(int i=0, b=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 2) {
					bayang[b][0] = i;
					bayang[b++][1] = j;
				}
			}
		}
		
		green = new int[blen];
		red = new int[blen];
		for(int i=0; i<G; i++) green[i] = 1;
		Arrays.sort(green);
		int answer = 0;
		do {
			for(int i=0; i<R; i++) red[i] = 1;
			Arrays.sort(red);
			do {
				if(conf()) {
					int[][][] arr = new int[N][M][2];
					Queue<pair> que = new LinkedList<>();
					for(int i=0; i<N; i++) {
						for(int j=0; j<M; j++) {
							arr[i][j][0] = map[i][j];
						}
					}
					for(int i=0; i<blen; i++) {
						if(green[i] == 1) {
							arr[bayang[i][0]][bayang[i][1]][0] = 3;
							que.offer(new pair(bayang[i][0], bayang[i][1], 0));
						}
					}
					for(int i=0; i<blen; i++) {
						if(red[i] == 1) {
							arr[bayang[i][0]][bayang[i][1]][0] = 4;
							que.offer(new pair(bayang[i][0], bayang[i][1], 0));
						}
					}
					while(!que.isEmpty()) {
						pair cur = que.poll();
						if(arr[cur.r][cur.c][0] == 3) {
							for(int i=0; i<4; i++) {
								int dx = cur.r + dr[i];
								int dy = cur.c + dc[i];
								if(dx<0 || dy<0 || dx>=N || dy>=M) continue;
								if(arr[dx][dy][0]==0 || arr[dx][dy][0]==3 || arr[dx][dy][0]==5) continue;
								if(arr[dx][dy][0]==4) {
									if(arr[dx][dy][1] == cur.time+1) {
										arr[dx][dy][0] = 5;
									}
									continue;
								}
								arr[dx][dy][0] = 3;
								arr[dx][dy][1] = cur.time+1;
								que.offer(new pair(dx, dy, cur.time+1));
							}
						} else if(arr[cur.r][cur.c][0] == 4) {
							for(int i=0; i<4; i++) {
								int dx = cur.r + dr[i];
								int dy = cur.c + dc[i];
								if(dx<0 || dy<0 || dx>=N || dy>=M) continue;
								if(arr[dx][dy][0]==0 || arr[dx][dy][0]==4 || arr[dx][dy][0]==5) continue;
								if(arr[dx][dy][0]==3) {
									if(arr[dx][dy][1] == cur.time+1) {
										arr[dx][dy][0] = 5;
									}
									continue;
								}
								arr[dx][dy][0] = 4;
								arr[dx][dy][1] = cur.time+1;
								que.offer(new pair(dx, dy, cur.time+1));
							}
						}
					}
					int res = 0;
					for(int i=0; i<N; i++) {
						for(int j=0; j<M; j++) {
							if(arr[i][j][0]==5) res++;
						}
					}
					if(res>answer) answer = res;
				}
			} while(npR());
		} while(npG());
		
		System.out.println(answer);
	}
	static boolean conf() {
		for(int i=0; i<blen; i++) {
				if(green[i] == 1 && red[i] == 1) return false;
		}
		return true;
	}
	static boolean npG() {
		int i=blen-1;
		while(i>0 && green[i-1] >= green[i]) i--;
		if(i==0) return false;
		int j=blen-1;
		while(green[i-1] >= green[j]) j--;
		swapG(i-1, j);
		j=blen-1;
		while(i<j) swapG(i++, j--);
		return true;
	}
	static void swapG(int x, int y) {
		int tmp = green[x];
		green[x] = green[y];
		green[y] = tmp;
	}
	static boolean npR() {
		int i=blen-1;
		while(i>0 && red[i-1] >= red[i]) i--;
		if(i==0) return false;
		int j=blen-1;
		while(red[i-1] >= red[j]) j--;
		swapR(i-1, j);
		j=blen-1;
		while(i<j) swapR(i++, j--);
		return true;
	}
	static void swapR(int x, int y) {
		int tmp = red[x];
		red[x] = red[y];
		red[y] = tmp;
	}
}