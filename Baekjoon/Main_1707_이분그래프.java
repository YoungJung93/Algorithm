package Problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1707_이분그래프 {
	static class pair {
		int no, count;
		public pair(int no, int count) {
			this.no = no; this.count = count;
		}
	}
	static List<Integer>[] adj;
	static int V, E;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			adj = new ArrayList[V+1];
			for(int i=1; i<=V; i++) {
				adj[i] = new ArrayList<>();
			}
			for(int i=0; i<E; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				adj[a].add(b);
				adj[b].add(a);
			}
			String answer = "YES";
			boolean[] flag = new boolean[V+1];
			int[] check = new int[V+1];
			for(int i=1; i<=V; i++) {
				if(flag[i]) continue;
				Queue<pair> que = new LinkedList<>();
				que.offer(new pair(i, 1));
				flag[i] = true;
				check[i] = 1;
				bfs : 
				while(!que.isEmpty()) {
					pair cur = que.poll();
					int cnt = cur.count==1 ? 2 : 1;
					for(int j=0,size=adj[cur.no].size(); j<size; j++) {
						int tar = adj[cur.no].get(j);
						if(!flag[tar]) {
							flag[tar] = true;
							check[tar] = cnt;
							que.offer(new pair(tar, cnt));
						} else {
							if(check[tar] != cnt) {
								answer = "NO";
								break bfs;
							}
						}
					}
				}
				if(answer.equals("NO")) break;
			}
			System.out.println(answer);
		}
	}
}
