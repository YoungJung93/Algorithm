package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_3780_네트워크연결 {
	static int[] parent;
	static long[] cost;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int i=1; i<=t; i++) {
			n = Integer.parseInt(br.readLine());
			parent = new int[n+1];
			cost = new long[n+1];
			Arrays.fill(parent, -1);
			StringTokenizer st;
			first: while(true) {
				st = new StringTokenizer(br.readLine());
				char c = st.nextToken().charAt(0);
				switch(c) {
				case 'E' :
					int a = Integer.parseInt(st.nextToken());
					find(a);
					System.out.println(cost[a]);
					break;
				case 'I' :
					a = Integer.parseInt(st.nextToken());
					int b = Integer.parseInt(st.nextToken());
					union(a,b);
					break;
				case 'O' :
					break first;
				}
			}
		}
	}
	static int n;
	static int find(int a) {
		if(parent[a] < 0) {
			return a;
		}
		int g = find(parent[a]); 
		cost[a] += cost[parent[a]];
		return parent[a] = g;
	}
	static boolean union(int a, int b) {
		a = find(a);
		if(a==b) {
			return false;
		}
		parent[a] = b;
		cost[a] = cal(a,b);
		return true;
	}
	static int cal(int a, int b) {
		return Math.abs(a-b) % 1000;
	}
}
