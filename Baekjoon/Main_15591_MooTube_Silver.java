package Problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_15591_MooTube_Silver {
	static int N, Q;
	static final int MAX = 1000000001;
	static class Node implements Comparable<Node> {
		int no, usado;
		public Node(int tar, int usado) {
			this.no = tar; this.usado = usado;
		}
		@Override
		public int compareTo(Node n) {
			return Integer.compare(this.usado, n.usado);
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		@SuppressWarnings("unchecked")
		List<Node>[] adj = new List[N+1];
		for(int i=1; i<=N; i++) adj[i] = new ArrayList<>();
		
		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			adj[a].add(new Node(b, c));
			adj[b].add(new Node(a, c));
		}
		
		StringBuilder answer = new StringBuilder();
		
		for(int q=0; q<Q; q++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			int src = Integer.parseInt(st.nextToken());
			
			Queue<Node> que = new LinkedList<>();
			int[] usado = new int[N+1];
			Arrays.fill(usado, MAX);
			usado[src] = 0;
			
			for(Node node : adj[src]) {
				usado[node.no] = node.usado;
				que.offer(new Node(node.no, node.usado));
			}
			
			while(!que.isEmpty()) {
				Node cur = que.poll();
				for(Node node : adj[cur.no]) {
					if(usado[node.no] != MAX) continue;
					usado[node.no] = Math.min(cur.usado, node.usado);
					que.offer(new Node(node.no, usado[node.no]));
				}
			}
			
			int result = 0;
			for(int i=1; i<=N; i++) {
				if(i == src) continue;
				if(usado[i] >= k) result++;
			}
			answer.append(result).append("\n");
		}
		System.out.print(answer);
	}
}
