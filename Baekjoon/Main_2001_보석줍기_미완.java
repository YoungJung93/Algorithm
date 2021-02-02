package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_2001_보석줍기 {
	static int n, m, k, res;
	static int[][] adj;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		adj = new int[n+1][n+1];
		boolean[] flag = new boolean[n+1];
		Set<Integer> set = new HashSet<>();
		for(int i=0; i<k; i++) {
			set.add(Integer.parseInt(br.readLine()));
		}
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			adj[a][b] = c;
			adj[b][a] = c;
		}
		res = 0;
		int jewc = 0;
		if(set.contains(1)) {
			jewc++;
			set.remove(1);
		}
		flag[1] = true;
		for(int i=2; i<=n; i++) {
			if(adj[1][i]==0) continue;
			dfs(1, i, jewc, set, flag);
		}
		System.out.println(res);
	}
	static void dfs(int src, int dst, int jewc, Set<Integer> jew, boolean[] f) {
		for(int i=1; i<=n; i++) {
			if(i==dst) continue;
			
			if(jew.contains(dst)) {
				
			} else {
				
			}
		}
		for(int i=1; i<=n; i++) {
			if(i==dst) continue;
			if(f[i]) continue;
			if(adj[dst][i]==0) continue;
			if(adj[dst][i] < jewc) continue;
			if(i==1) {
				if(res < jewc) res = jewc;
				continue;
			}
			if(jew.contains(i)) {
				Set<Integer> li = new HashSet<>();
				Iterator<Integer> it = jew.iterator();
				while(it.hasNext()) {
					li.add(it.next());
				}
				boolean[] ff = new boolean[n+1];
				ff[i] = true;
				dfs(dst, i, jewc, li, ff);
				li.remove(i);
				dfs(dst, i, jewc+1, li, ff);
			} else {
				f[i] = true;
				dfs(dst, i, jewc, jew, f);
				f[i] = false;
			}
		}
	}
}
