package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1697_숨바꼭질 {
	static class pair {
		int pos, time;
		public pair(int pos, int time) {
			this.pos = pos; this.time = time;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		pair subin = new pair(Integer.parseInt(st.nextToken()), 0);
		int brother = Integer.parseInt(st.nextToken());
		if (subin.pos != brother) {
			boolean[] flag = new boolean[100001];
			flag[subin.pos] = true;
			Queue<pair> que = new LinkedList<pair>();
			que.offer(subin);
			int answer = 0;
			while (!que.isEmpty()) {
				pair cur = que.poll();
				if (cur.pos > 0) {
					int dx = cur.pos - 1;
					if (dx == brother) {
						answer = cur.time + 1;
						break;
					}
					if (!flag[dx]) {
						flag[dx] = true;
						que.offer(new pair(dx, cur.time + 1));
					}
				}
				if (cur.pos < 100000) {
					int dx = cur.pos + 1;
					if (dx == brother) {
						answer = cur.time + 1;
						break;
					}
					if (!flag[dx]) {
						flag[dx] = true;
						que.offer(new pair(dx, cur.time + 1));
					}
				}
				if (cur.pos <= 50000) {
					int dx = cur.pos * 2;
					if (dx == brother) {
						answer = cur.time + 1;
						break;
					}
					if (!flag[dx]) {
						flag[dx] = true;
						que.offer(new pair(dx, cur.time + 1));
					}
				}
			}
			System.out.println(answer);
		} else System.out.println(0);
	}
}
