package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_13913_숨바꼭질4 {
	static class subin {
		int pos, cnt;
		StringBuilder path;
//		String path;
		public subin(int pos, int cnt, StringBuilder sb) {
			this.pos = pos; this.cnt = cnt;
			this.path = sb;
		}
	}
	static int N, K;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		if(N > K) {
			System.out.println(N-K);
			for(int i=N; i>=K; i--) {
				System.out.print(i + " ");
			}
			System.out.println();
		} else if(N==K) {
			System.out.println(0);
			System.out.println(N);
		} else {
			Queue<subin> que = new LinkedList<>();
			boolean[] flag = new boolean[200001];
			flag[N] = true;
			que.offer(new subin(N, 0, new StringBuilder(Integer.toString(N))));
			int answer = 0;
			StringBuilder res = new StringBuilder();
//			String res = "";
			while(!que.isEmpty()) {
				subin cur = que.poll();
				if(cur.pos > 0) {
					int dx = cur.pos - 1;
					if(!flag[dx]) {
						flag[dx] = true;
						if(dx == K) {
							answer = cur.cnt+1;
//							res = cur.path + " "+ dx;
							res = cur.path.append(" ").append(dx);
							break;
						}
						que.offer(new subin(dx, cur.cnt+1, new StringBuilder(cur.path).append(" ").append(dx)));
//						que.offer(new subin(dx, cur.cnt+1, cur.path + " " + dx));
					}
				}
				if(cur.pos < K && cur.pos < 100000) {
					int dx = cur.pos + 1;
					if(!flag[dx]) {
						flag[dx] = true;
						if(dx == K) {
							answer = cur.cnt+1;
//							res = cur.path + " "+ dx;
							res = cur.path.append(" ").append(dx);
							break;
						}
						que.offer(new subin(dx, cur.cnt+1, new StringBuilder(cur.path).append(" ").append(dx)));
//						que.offer(new subin(dx, cur.cnt+1, cur.path + " " + dx));
					}
				}
				if(cur.pos < K && cur.pos <= 100000) {
					int dx = cur.pos * 2;
					if(!flag[dx]) {
						flag[dx] = true;
						if(dx == K) {
							answer = cur.cnt+1;
//							res = cur.path + " "+ dx;
							res = cur.path.append(" ").append(dx);
							break;
						}
						que.offer(new subin(dx, cur.cnt+1, new StringBuilder(cur.path).append(" ").append(dx)));
//						que.offer(new subin(dx, cur.cnt+1, cur.path + " " + dx));
					}
				}
			}
			System.out.println(answer);
			System.out.println(res);
		}
	}
}
