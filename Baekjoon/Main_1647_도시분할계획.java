package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1647_도시분할계획 {
	static class dest implements Comparable<dest> {
		public int src, dst, w;
		public dest(int src, int dst, int w) {
			this.dst = dst; this.w = w; this.src = src;
		}
		public int compareTo(dest o) {
			return Integer.compare(this.w, o.w);
		}
		
	}
	static int res, n, m;
	static List<dest>[] list;
	static List<dest>[] area1;
	static List<dest>[] area2;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		list = new ArrayList[n+1];
		for(int i=0; i<=n; i++) list[i] = new ArrayList<>();
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list[a].add(new dest(a,b,c));
			list[b].add(new dest(b,a,c));
		}
		
		res = 0; max = 0;
		li = new ArrayList<>();
		prim(1);
		System.out.println(res-max);
	}
	static int max;
	static List<dest> li;
	static void prim(int base) {
		boolean[] flag = new boolean[n+1];
		flag[base] = true;
		PriorityQueue<dest> que = new PriorityQueue<>();
		for(int i=0, size=list[base].size(); i<size; i++) {
			que.offer(list[base].get(i));
		}
		while(!que.isEmpty()) {
			dest cur = que.poll();
			if(!flag[cur.dst]) {
				flag[cur.dst] = true;
				for(int i=0, size=list[cur.dst].size(); i<size; i++) {
					que.offer(list[cur.dst].get(i));
				}
				if(max<cur.w) max = cur.w;
				res += cur.w;
			}
		}
	}
}
