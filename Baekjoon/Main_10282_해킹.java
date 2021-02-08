package Problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_10282_해킹 {
	static class pair implements Comparable<pair> {
		int ind, sec;
		public pair(int ind, int sec) {
			this.ind = ind; this.sec = sec;
		}
		public int compareTo(pair o) {
			return Integer.compare(this.sec, o.sec);
		}
	}
	static int n, d, c;
	static final int MAX = Integer.MAX_VALUE;
	static List<pair>[] adj;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			adj = new List[n+1];
			for(int i=1; i<=n; i++) adj[i] = new ArrayList<>();
			for(int i=0; i<d; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				adj[b].add(new pair(a, s));
			}
			int[] dist = new int[n+1];
			Arrays.fill(dist, MAX);
			dist[c] = 0;
			boolean[] flag = new boolean[n+1];
			PriorityQueue<pair> pq = new PriorityQueue<>();
			pq.offer(new pair(c, 0));
			while(!pq.isEmpty()) {
				pair cur = pq.poll();
				if(flag[cur.ind]) {
					continue;
				} else {
					flag[cur.ind] = true;
				}
				for(pair p : adj[cur.ind]) {
					if(dist[p.ind] > ((dist[cur.ind]!=MAX && p.sec!=MAX) ? (dist[cur.ind]+p.sec) : MAX)) {
						dist[p.ind] = (dist[cur.ind]!=MAX && p.sec!=MAX) ? (dist[cur.ind]+p.sec) : MAX;
					}
					pq.offer(new pair(p.ind, dist[p.ind]));
				}
			}
			int ans_num = 0;
			int ans_sec = 0;
			for(int i=1; i<=n; i++) {
				if(dist[i] == MAX) continue;
				ans_num++;
				if(dist[i] > ans_sec) ans_sec = dist[i];
			}
			System.out.println(ans_num + " " + ans_sec);
		}
	}
}
