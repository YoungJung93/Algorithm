package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_11725_트리의부모찾기 {
	static int N;
	static List<Integer>[] adj;
	static int[] ance;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		adj = new List[N+1];
		for(int i=1; i<=N; i++) adj[i] = new ArrayList<>();
		ance = new int[N+1];
		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[a].add(b);
			adj[b].add(a);
		}
		dfs(1);
		for(int i=2; i<=N; i++) {
			System.out.println(ance[i]);
		}
	}
	static void dfs(int cur) {
		for(int i=0, size=adj[cur].size(); i<size; i++) {
			int c = adj[cur].get(i);
			if(ance[c] != 0) continue;
			ance[c] = cur;
			dfs(c);
		}
	}
}
