package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_3124_최소스패닝트리 {
	static class gansun implements Comparable<gansun> {
		public int v1, v2, weight;
		public gansun(int v1, int v2, int weight) {
			this.v1 = v1;
			this.v2 = v2;
			this.weight = weight;
		}
		public int compareTo(gansun o) {
			int res = weight - o.weight;
			if(res>0) return 1;
			else return -1;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		gansun[] es;
		for(int i=1; i<=t; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			parents = new int[v];
			es = new gansun[e];
			long result = 0;
			makeSet();
			for(int j=0; j<e; ++j) {
				st = new StringTokenizer(br.readLine());
				es[j] = new gansun(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken()));
			}
			Arrays.sort(es);
			for(int j=0, vind=0; j<e; ++j) {
				if(union(es[j].v1, es[j].v2)) {
					result += es[j].weight;
					vind++;
				}
				if(vind==v-1) break;
			}
			System.out.println("#" + i + " " + result);
		}
	}
	static int[] parents;
	public static void makeSet() {
		Arrays.fill(parents, -1); 
	}
	public static int find(int v) {
		if(parents[v] == -1) return v;
		return parents[v] = find(parents[v]);
	}
	public static boolean union(int v1, int v2) {
		int a = find(v1), b = find(v2);
		if(a==b) return false;
		parents[b] = a;
		return true;
	}
}
