package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_15906_변신이동게임 {
	static class pair implements Comparable<pair> {
		int mode, r, c, turn;
		public pair(int mode, int r, int c, int turn) {
			this.mode = mode; this.r = r;
			this.c = c; this.turn = turn;
		}
		public int compareTo(pair o) {
			return Integer.compare(this.turn, o.turn);
		}
	}
	static int[] dr = {-1,1,0,0}, dc = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken())-1;
		int C = Integer.parseInt(st.nextToken())-1;
		PriorityQueue<pair> pq = new PriorityQueue<>();
		pq.offer(new pair(0, 0, 0, 0));
		char[][] map = new char[N][N];
		int[][][] memo = new int[2][N][N];
		for(int i=0; i<2; i++) {
			for(int j=0; j<N; j++) {
				Arrays.fill(memo[i][j], Integer.MAX_VALUE);
			}
		}
		memo[0][0][0] = 0;
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<N; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		while(!pq.isEmpty()) {
			pair cur = pq.poll();
			if(cur.mode == 0) {	// 일반 모드일 때
				// 변신모드로 바꿔서 이동
				for(int i=0; i<4; i++) {
					int dx = cur.r + dr[i];
					int dy = cur.c + dc[i];
					boolean f = false;
					while(true) {
						if(dx<0 || dy<0 || dx>=N || dy>=N) break;
						if(map[dx][dy] == '#') {
							f = true;
							break;
						}
						dx += dr[i];
						dy += dc[i];
					}
					if(f) {
						if(cur.turn+t+1 < memo[1][dx][dy]) {
							memo[1][dx][dy] = cur.turn+t+1;
						} else continue;
						pq.offer(new pair(1, dx, dy, cur.turn+t+1));
					}
				}
				// 일반모드로 상하좌우 1칸씩 이동
				for(int i=0; i<4; i++) {
					int dx = cur.r + dr[i];
					int dy = cur.c + dc[i];
					if(dx<0 || dy<0 || dx>=N || dy>=N) continue;
					if(cur.turn+1 < memo[0][dx][dy]) {
						memo[0][dx][dy] = cur.turn+1;
					} else continue;
					pq.offer(new pair(cur.mode, dx, dy, cur.turn+1));
				}
			} else { // 변신 모드일 때
				// 일반모드로 바꿔서 상하좌우 1칸씩 이동
				for(int i=0; i<4; i++) {
					int dx = cur.r + dr[i];
					int dy = cur.c + dc[i];
					if(dx<0 || dy<0 || dx>=N || dy>=N) continue;
					if(cur.turn+1 < memo[0][dx][dy]) {
						memo[0][dx][dy] = cur.turn+1;
					} else continue;
					pq.offer(new pair(0, dx, dy, cur.turn+1));
				}
				// 변신모드로 상하좌우 워프지점으로 이동
				for(int i=0; i<4; i++) {
					int dx = cur.r + dr[i];
					int dy = cur.c + dc[i];
					boolean f = false;
					while(true) {
						if(dx<0 || dy<0 || dx>=N || dy>=N) break;
						if(map[dx][dy] == '#') {
							f = true;
							break;
						}
						dx += dr[i];
						dy += dc[i];
					}
					if(f) {
						if(cur.turn+1 < memo[1][dx][dy]) {
							memo[1][dx][dy] = cur.turn+1;
						} else continue;
						pq.offer(new pair(cur.mode, dx, dy, cur.turn+1));
					}
				}
			}
		}
		System.out.println(Math.min(memo[0][R][C], memo[1][R][C]));
	}
}
