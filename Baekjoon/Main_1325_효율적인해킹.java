package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1325_효율적인해킹 {
	static List<Integer>[] adj;
	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		adj = new List[N+1];
		for(int i=0; i<=N; i++) adj[i] = new ArrayList<Integer>();
		int[] hacking = new int[N+1];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[b].add(a);
		}
		int max = 0;
		for(int i=1; i<=N; i++) {
			boolean[] flag = new boolean[N+1];
			flag[i] = true;
			int ea = 1;
			Queue<Integer> que = new LinkedList<Integer>();
			que.offer(i);
			while(!que.isEmpty()) {
				int cur = que.poll();
				for(int j : adj[cur]) {
					if(flag[j]) continue;
					flag[j] = true;
					ea++;
					que.offer(j);
				}
			}
			if(ea > max) max = ea;
			hacking[i] = ea;
		}
		for(int i=1; i<=N; i++) {
			if(hacking[i] == max) System.out.print(i + " ");
		}
		System.out.println();
	}
}
