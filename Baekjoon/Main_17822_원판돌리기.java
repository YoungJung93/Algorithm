package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17822_원판돌리기 {
	static int[][] circle;
	static int N, M, T;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		circle = new int[N+1][M];
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				circle[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0; i<T; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			rotate(x, d, k);
			
			boolean f = false;
			int[] dr = {-1,1,0,0}, dc = {0,0,-1,1};
			for(int r=1; r<=N; r++) {
				for(int c=0; c<M; c++) {
					if(circle[r][c]==0) continue;
					int base = circle[r][c];
					boolean ff = false;
					
					Queue<Integer> que = new LinkedList<Integer>();
					que.offer(r); que.offer(c);
					while(!que.isEmpty()) {
						int xx = que.poll();
						int yy = que.poll();
						for(int a=0; a<4; a++) {
							int dx = xx + dr[a];
							int dy = yy + dc[a];
							if(dx<1 || dx>N) continue;
							if(dy<0) dy+=M;
							if(dy>=M) dy-=M;
							if(circle[dx][dy]==0) continue;
							if(circle[dx][dy] == base) {
								que.offer(dx); que.offer(dy);
								circle[dx][dy] = 0;
								f = true;
								ff = true;
							}
						}
					}
					
					if(ff) circle[r][c] = 0;
				}
			}
			if(!f) {
				int ea = 0, sum = 0;
				for(int r=1; r<=N; r++) {
					for(int c=0; c<M; c++) {
						if(circle[r][c] == 0) continue;
						ea++;
						sum += circle[r][c];
					}
				}
				double avr = (double)sum/(double)ea;
				for(int r=1; r<=N; r++) {
					for(int c=0; c<M; c++) {
						if(circle[r][c] == 0) continue;
						if(circle[r][c] > avr) circle[r][c]--;
						else if(circle[r][c] < avr) circle[r][c]++;
					}
				}
			}
		}
		int answer = 0;
		for(int i=1; i<=N; i++) {
			for(int j=0; j<M; j++) {
				answer += circle[i][j];
			}
		}
		
		System.out.println(answer);
	}
	static void rotate(int x, int d, int k) {
		if(d==0) {
			for(int i=x; i<=N; i+=x) {
				int[] arr = new int[M];
				for(int j=0; j<M; j++) {
					if(j+k >= M) arr[j+k-M] = circle[i][j];
					else arr[j+k] = circle[i][j];
				}
				circle[i] = arr.clone();
			}
		} else {
			for(int i=x; i<=N; i+=x) {
				int[] arr = new int[M];
				for(int j=0; j<M; j++) {
					if(j-k < 0) arr[j-k+M] = circle[i][j];
					else arr[j-k] = circle[i][j];
				}
				circle[i] = arr.clone();
			}
		}
	}
}
