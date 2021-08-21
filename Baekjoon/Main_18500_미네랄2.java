package Problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_18500_미네랄2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		int[] dr = {-1,1,0,0};
		int[] dc = {0,0,-1,1};
		int[][] map = new int[R][C];
		for(int r=0; r<R; r++) {
			String s = br.readLine();
			for(int c=0; c<C; c++) {
				char ch = s.charAt(c);
				if(ch == '.') {
					map[r][c] = 0;
				} else {
					map[r][c] = 1;
				}
			}
		}
		
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int token=0; token<N; token++) {
			int h = Integer.parseInt(st.nextToken()) - 1;
			int r = R - h - 1;
			boolean isBreak = false;
			if((token & 1) == 0) {
				// 왼 -> 오
				for(int c=0; c<C; c++) {
					if(map[r][c] == 1) {
						map[r][c] = 0;
						isBreak = true;
						break;
					}
				}
			} else {
				// 오 -> 왼
				for(int c=C-1; c>=0; c--) {
					if(map[r][c] == 1) {
						map[r][c] = 0;
						isBreak = true;
						break;
					}
				}
			}
			
			if(isBreak) {
				int[][] check = new int[R][C];
				boolean[][] flag = new boolean[R][C];
				for(int c=0; c<C; c++) {
					if(map[R-1][c] == 1) {
						Queue<Integer> que = new LinkedList<>();
						que.offer(R-1); que.offer(c);
						flag[R-1][c] = true;
						check[R-1][c] = -1;
						while(!que.isEmpty()) {
							int rr = que.poll();
							int cc = que.poll();
							for(int i=0; i<4; i++) {
								int dx = rr + dr[i];
								int dy = cc + dc[i];
								if(dx<0 || dy<0 || dx>=R || dy>=C) continue;
								if(map[dx][dy] == 0 || flag[dx][dy]) continue;
								flag[dx][dy] = true;
								check[dx][dy] = -1;
								que.offer(dx); que.offer(dy);
							}
						}
					}
				}
				int a = 1;
				for(int i=0; i<R; i++) {
					for(int j=0; j<C; j++) {
						if(!flag[i][j] && map[i][j] == 1) {
							Queue<Integer> que = new LinkedList<>();
							que.offer(i); que.offer(j);
							flag[i][j] = true;
							check[i][j] = a;
							while(!que.isEmpty()) {
								int rr = que.poll();
								int cc = que.poll();
								for(int k=0; k<4; k++) {
									int dx = rr + dr[k];
									int dy = cc + dc[k];
									if(dx<0 || dy<0 || dx>=R || dy>=C) continue;
									if(!(map[dx][dy]==1) || check[dx][dy]==a) continue;
									check[dx][dy] = a;
									flag[dx][dy] = true;
									que.offer(dx); que.offer(dy);
								}
							}
							a++;
						}
					}
				}
				int[] howFall = new int[a];
				Arrays.fill(howFall, 101);
				for(int i=0; i<R; i++) {
					for(int j=0; j<C; j++) {
						if(check[i][j] > 0) {
							int fall = 101;
							int dx = i+1;
							while(dx<R) {
								if(check[dx][j]==check[i][j]) break;
								if(check[dx][j]==-1) {
									fall = dx-i-1;
									break;
								}
								dx++;
							}
							if(dx==R) fall = dx-i-1;
							if(howFall[check[i][j]] > fall) {
								howFall[check[i][j]] = fall;
							}
						}
					}
				}
				
				for(int i=R-1; i>=0; i--) {
					for(int j=0; j<C; j++) {
						if(check[i][j] > 0) {
							int fall = howFall[check[i][j]];
							map[i+fall][j] = map[i][j];
							map[i][j] = 0;
						}
					}
				}
			}
		}
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j] == 0) System.out.print(".");
				else System.out.print("x");
			}
			System.out.println();
		}
	}
}
