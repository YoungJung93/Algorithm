package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_11724_연결요소의개수_DFS {
	static List<Integer>[] adj;
	static int N, M;
	static boolean[] flag;
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		adj = new List[N+1];
		for(int i=1; i<=N; i++) adj[i] = new ArrayList<Integer>();
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[a].add(b);
			adj[b].add(a);
		}
		flag = new boolean[N+1];
		int answer = 0;
		for(int i=1; i<=N; i++) {
			if(!flag[i]) {
				dfs(i);
				answer++;
			}
		}
		System.out.println(answer);
	}
	static void dfs(int v) {
		flag[v] = true;
		for(int i=0, size=adj[v].size(); i<size; i++) {
			if(!flag[adj[v].get(i)]) {
				dfs(adj[v].get(i));
			}
		}
	}
}
