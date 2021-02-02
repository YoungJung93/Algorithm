package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1197_최소스패닝트리 {
	static class pair implements Comparable<pair> {
		int v1, v2, c;
		public pair(int v1, int v2, int c) {
			this.v1 = v1; this.v2 = v2; this.c = c;
		}
		public int compareTo(pair tar) {
			return this.c - tar.c;
		}
	}
	static int[] parents;
	static int V, E;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		parents = new int[V+1];
		for(int i=1; i<=V; i++) {
			parents[i] = i;
		}
		PriorityQueue<pair> pq = new PriorityQueue<>();
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int src = Integer.parseInt(st.nextToken());
			int tar = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			pq.offer(new pair(src, tar, w));
		}
		int answer = 0;
		while(!pq.isEmpty()) {
			pair cur = pq.poll();
			int src = find(cur.v1);
			int tar = find(cur.v2);
			if(src == tar) continue;
			union(src, tar);
			answer += cur.c;
		}
		System.out.println(answer);
	}
	static int find(int a) {
		if(a==parents[a]) return a;
		parents[a] = find(parents[a]);
		return parents[a];
	}
	static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot != bRoot) {
			parents[aRoot] = b;
		}
	}
}
