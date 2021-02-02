package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1260_DFS와BFS_인접행렬 {
	static int[][] adj;
	static int N, M, V;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		adj = new int[N+1][N+1];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[a][b] = 1;
			adj[b][a] = 1;
		}
		List<Integer> bfs_list = bfs();
		flag_dfs = new boolean[N+1];
		dfs_list = new ArrayList<>();
		flag_dfs[V] = true;
		dfs(V);
		
		for(int i=0, size=dfs_list.size(); i<size; i++) {
			System.out.print(dfs_list.get(i) + " ");
		}
		System.out.println();
		for(int i=0, size=bfs_list.size(); i<size; i++) {
			System.out.print(bfs_list.get(i) + " ");
		}
		System.out.println();
	}
	static boolean[] flag_dfs;
	static List<Integer> dfs_list;
	static void dfs(int v) {
		dfs_list.add(v);
		for(int i=1; i<=N; i++) {
			if(v == i) continue;
			if(adj[v][i]==0) continue;
			if(flag_dfs[i]) continue;
			flag_dfs[i] = true;
			dfs(i);
		}
	}
	static List<Integer> bfs() {
		List<Integer> list = new ArrayList<>();
		list.add(V);
		Queue<Integer> que = new LinkedList<>();
		que.offer(V);
		boolean[] flag = new boolean[N+1];
		flag[V] = true;
		while(!que.isEmpty()) {
			int cur = que.poll();
			for(int i=1; i<=N; i++) {
				if(cur==i) continue;
				if(adj[cur][i]==0) continue;
				if(flag[i]) continue;
				flag[i] = true;
				list.add(i);
				que.offer(i);
			}
		}
		return list;
	}
}
