package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1238_파티 {
	static int N, M, X;
	static final int INF = Integer.MAX_VALUE;
	static List<pair>[] adj, radj;
	static class pair implements Comparable<pair> {
		int dst, time;
		public pair(int dst, int time) {
			this.dst = dst; this.time = time;
		}
		public int compareTo(pair p) {
			return Integer.compare(this.time, p.time);
		}
	}
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		adj = new List[N+1];
		radj = new List[N+1];
		for(int i=1; i<=N; i++) {
			adj[i] = new ArrayList<>();
			radj[i] = new ArrayList<>();
		}
		int[] dist = new int[N+1];
		int[] rdist = new int[N+1];
		Arrays.fill(dist, INF);
		Arrays.fill(rdist, INF);
		dist[X] = 0;
		rdist[X] = 0;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			adj[a].add(new pair(b,c));
			radj[b].add(new pair(a,c));
		}
		PriorityQueue<pair> pq = new PriorityQueue<>();
		pq.offer(new pair(X, dist[X]));
		boolean[] flag = new boolean[N+1];
		while(!pq.isEmpty()) {
			pair cur = pq.poll();
			if(flag[cur.dst]) continue;
			else flag[cur.dst] = true;
			for(pair p : adj[cur.dst]) {
				if(dist[p.dst] > (dist[cur.dst]==INF || p.time==INF ? INF : dist[cur.dst]+p.time)) {
					dist[p.dst] = dist[cur.dst]==INF || p.time==INF ? INF : dist[cur.dst]+p.time;
					pq.offer(new pair(p.dst, dist[p.dst]));
				}
			}
		}
		pq = new PriorityQueue<>();
		pq.offer(new pair(X, rdist[X]));
		flag = new boolean[N+1];
		while(!pq.isEmpty()) {
			pair cur = pq.poll();
			if(flag[cur.dst]) continue;
			else flag[cur.dst] = true;
			for(pair p : radj[cur.dst]) {
				if(rdist[p.dst] > (rdist[cur.dst]==INF || p.time==INF ? INF : rdist[cur.dst]+p.time)) {
					rdist[p.dst] = rdist[cur.dst]==INF || p.time==INF ? INF : rdist[cur.dst]+p.time;
					pq.offer(new pair(p.dst, rdist[p.dst]));
				}
			}
		}
		int answer = 0;
		for(int i=1; i<=N; i++) {
			if(dist[i]+rdist[i] > answer) answer = dist[i]+rdist[i];
		}
		System.out.println(answer);
	}
}
