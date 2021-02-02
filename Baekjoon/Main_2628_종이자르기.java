package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2628_종이자르기 {
	static class pair {
		public int xs, xe, ys, ye;
		public pair(int xs, int xe, int ys, int ye) {
			this.xs = xs;
			this.xe = xe;
			this.ys = ys;
			this.ye = ye;
		}
		public int getArea() {
			return (xe-xs)*(ye-ys);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		Queue<pair> que = new LinkedList<pair>();
		que.offer(new pair(0, m, 0, n));
		int k = Integer.parseInt(br.readLine());
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int size = que.size();
			for(int j=0; j<size; j++) {
				pair cur = que.poll();
				if(a==1) {
					if(b>cur.xs && b<cur.xe) {
						que.offer(new pair(cur.xs, b, cur.ys, cur.ye));
						que.offer(new pair(b, cur.xe, cur.ys, cur.ye));
					} else {
						que.offer(cur);
					}
				} else {
					if(b>cur.ys && b<cur.ye) {
						que.offer(new pair(cur.xs, cur.xe, cur.ys, b));
						que.offer(new pair(cur.xs, cur.xe, b, cur.ye));
					} else {
						que.offer(cur);
					}
				}
			}
		}
		int max = 0;
		while(!que.isEmpty()) {
			pair p = que.poll();
			if(max < p.getArea()) max = p.getArea();
		}
		System.out.println(max);
	}
}	
