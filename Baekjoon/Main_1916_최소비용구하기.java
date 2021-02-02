package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1916_최소비용구하기 {
	static int N, M;
	static List<pair>[] adj;
	static int[] dist;
	static final int INF = Integer.MAX_VALUE;
	static class pair implements Comparable<pair> {
		int dst, cost;
		public pair(int dst, int cost) {
			this.dst = dst; this.cost = cost;
		}
		public int compareTo(pair p) {
			return Integer.compare(this.cost, p.cost);
		}
	}
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		adj = new List[N+1];
		dist = new int[N+1];
		for(int i=1; i<=N; i++) adj[i] = new ArrayList<>();
		Arrays.fill(dist, INF);
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			adj[a].add(new pair(b,c));
		}
		st = new StringTokenizer(br.readLine());
		int src = Integer.parseInt(st.nextToken());
		int des = Integer.parseInt(st.nextToken());
		
		PriorityQueue<pair> pq = new PriorityQueue<>();
		boolean[] flag = new boolean[N+1];
		dist[src] = 0;
		pq.offer(new pair(src, dist[src]));
		while(!pq.isEmpty()) {
			pair cur = pq.poll();
			if(flag[cur.dst]) continue;
			else flag[cur.dst] = true;
			for(pair p : adj[cur.dst]) {
				if(dist[p.dst] > (dist[cur.dst]==INF || p.cost==INF ? INF : dist[cur.dst]+p.cost)) {
					dist[p.dst] = dist[cur.dst]==INF || p.cost==INF ? INF : dist[cur.dst]+p.cost;
					pq.offer(new pair(p.dst, dist[p.dst]));
				}
			}
		}
		System.out.println(dist[des]);
	}
}
