package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1504_특정한최단경로 {
	static int N, E, v1, v2;
	static final int INF = Integer.MAX_VALUE;
	static int[] dist;
	static List<pair>[] adj;
	static class pair implements Comparable<pair> {
		int dst, dis;
		public pair(int dst, int dis) {
			this.dst = dst; this.dis = dis;
		}
		public int compareTo(pair p) {
			return Integer.compare(this.dis, p.dis);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		adj = new List[N+1];
		for(int i=1; i<=N; i++) adj[i] = new ArrayList<>();
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			adj[a].add(new pair(b,c));
			adj[b].add(new pair(a,c));
		}
		st = new StringTokenizer(br.readLine());
		v1 = Integer.parseInt(st.nextToken());
		v2 = Integer.parseInt(st.nextToken());
		int answer1 = 0;
		boolean flag = true;
		// 1 -> v1
		int dis = dijkstra(1, v1);
		if(dis != INF) answer1 += dis;
		else flag = false;
		// v1 -> v2
		if(flag) {
			dis = dijkstra(v1, v2);
			if(dis != INF) answer1 += dis;
			else flag = false;
		}
		// v2 -> N
		if(flag) {
			dis = dijkstra(v2, N);
			if(dis != INF) answer1 += dis;
			else flag = false;
		}
		if(!flag) answer1 = INF;
		
		int answer2 = 0;
		flag = true;
		// 1 -> v2
		dis = dijkstra(1, v2);
		if(dis != INF) answer2 += dis;
		else flag = false;
		// v2 -> v1
		if(flag) {
			dis = dijkstra(v2, v1);
			if(dis != INF) answer2 += dis;
			else flag = false;
		}
		// v2 -> N
		if(flag) {
			dis = dijkstra(v1, N);
			if(dis != INF) answer2 += dis;
			else flag = false;
		}
		if(!flag) answer2 = INF;
		
		int answer = Math.min(answer1, answer2);
		if(answer != INF) System.out.println(answer);
		else System.out.println(-1);
	}
	public static int dijkstra(int src, int des) {
		dist = new int[N+1];
		Arrays.fill(dist, INF);
		dist[src] = 0;
		boolean[] flag = new boolean[N+1];
		PriorityQueue<pair> pq = new PriorityQueue<>();
		pq.offer(new pair(src, dist[src]));
		while(!pq.isEmpty()) {
			pair cur = pq.poll();
			if(flag[cur.dst]) continue;
			else flag[cur.dst] = true;
			for(pair p : adj[cur.dst]) {
				if(dist[p.dst] > (dist[cur.dst]==INF || p.dis==INF ? INF : dist[cur.dst]+p.dis)) {
					dist[p.dst] = dist[cur.dst]==INF || p.dis==INF ? INF : dist[cur.dst]+p.dis;
				}
				pq.offer(new pair(p.dst, dist[p.dst]));
			}
		}
		return dist[des];
	}
}
