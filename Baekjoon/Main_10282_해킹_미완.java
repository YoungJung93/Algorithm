package Problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_10282_해킹_미완 {
	static int n, d, c;
	static List<int[]>[] adj;
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			adj = new List[n+1];
			for(int i=1; i<=n; i++) adj[i] = new ArrayList<int[]>();
			for(int i=0; i<d; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				adj[b].add(new int[] {a, s});
			}
			PriorityQueue<int[]> que = new PriorityQueue<>(new Comparator<int[]>() {
				public int compare(int[] o1, int[] o2) {
					return Integer.compare(o1[1], o2[1]);
				}
			});
//			Queue<int[]> que = new LinkedList<>();
			que.offer(new int[] {c, 0});
			int answer = 1;
			int time = 0;
			
			boolean[] verify = new boolean[n+1];
			verify[c] = true;
			while(!que.isEmpty()) {
				int[] cur = que.poll();
				if(!verify[cur[0]]) {
					if(time < cur[1]) {
						time = cur[1];
					}
					verify[cur[0]] = true;
					answer++;
					// que에서 cur[0]을 지워줌
					PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
						public int compare(int[] o1, int[] o2) {
							return Integer.compare(o1[1], o2[1]);
						}
					});
					while(!que.isEmpty()) {
						int[] arr = que.poll();
						if(arr[0] != cur[0]) {
							q.offer(arr);
						}
					}
//					while(!q.isEmpty()) {
//						que.offer(q.poll());
//					}
					que = q;
				}
				for(int i=0, size=adj[cur[0]].size(); i<size; i++) {
					int tar = adj[cur[0]].get(i)[0];
					if(verify[tar]) continue;
					que.offer(new int[] {tar, cur[1] + adj[cur[0]].get(i)[1]});
				}
			}
			System.out.println(answer + " " + time);
		}
	}
}
