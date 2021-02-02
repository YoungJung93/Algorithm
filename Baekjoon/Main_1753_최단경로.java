package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1753_최단경로 {
	static final int MAX = Integer.MAX_VALUE;
	static int V, E;
	static int[][] adj;
	static int[] dis;
	static boolean[] flag;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		adj = new int[V+1][V+1];
		dis = new int[V+1];
		flag = new boolean[V+1];
		int s = Integer.parseInt(br.readLine());
		flag[s] = true;
		
		Arrays.fill(dis, MAX);
		for(int i=1; i<=V; i++) Arrays.fill(adj[i], MAX);
		dis[s] = 0;
		for(int i=1; i<=V; i++) adj[i][i] = 0;
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			if(adj[a][b] < e) continue;
			adj[a][b] = e;
		}
		int v = s;
		while(true) {
			for(int i=1; i<=V; i++) {
				if(i == s) continue;
				dis[i] = Math.min(dis[i], dis[v]!=MAX && adj[v][i]!=MAX ? dis[v]+adj[v][i] : MAX);
			}
			v = choose();
			if(v == 0) break;
			flag[v] = true;
		}
		
		for(int i=1; i<=V; i++) {
			if(dis[i] == MAX) System.out.println("INF");
			else System.out.println(dis[i]);
		}
	}
	public static int choose() {
		int res = Integer.MAX_VALUE;
		int ind = 0;
		for(int i=1; i<=V; i++) {
			if(flag[i]) continue;
			if(dis[i] < res) {
				res = dis[i];
				ind = i;
			}
		}
		return ind;
	}

}
