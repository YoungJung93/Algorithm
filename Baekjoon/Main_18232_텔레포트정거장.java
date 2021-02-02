package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_18232_텔레포트정거장 {
	static int N, M, S, E, res;
	static List<Integer>[] tel;
	static class pair {
		int pos, cnt;
		public pair(int pos, int cnt) {
			this.pos = pos; this.cnt = cnt;
		}
	}
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		tel = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			tel[i] = new ArrayList<>();
		}
		st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			tel[a].add(b);
			tel[b].add(a);
		}
		boolean[] flag = new boolean[N+1];
		Queue<pair> que = new LinkedList<>();
		que.offer(new pair(S, 0));
		flag[S] = true;
		bfs : while(!que.isEmpty()) {
			pair cur = que.poll();
			if(cur.pos-1 >= 1 && !flag[cur.pos-1]) {
				if(cur.pos-1 == E) {
					res = cur.cnt+1;
					break bfs;
				}
				flag[cur.pos-1] = true;
				que.offer(new pair(cur.pos-1, cur.cnt+1));
			}
			if(cur.pos+1 <= N && !flag[cur.pos+1]) {
				if(cur.pos+1 == E) {
					res = cur.cnt+1;
					break bfs;
				}
				flag[cur.pos+1] = true;
				que.offer(new pair(cur.pos+1, cur.cnt+1));
			}
			for(int i=0, size=tel[cur.pos].size(); i<size; i++) {
				int a = tel[cur.pos].get(i);
				if(!flag[a]) {
					if(a == E) {
						res = cur.cnt+1;
						break bfs;
					}
					flag[a] = true;
					que.offer(new pair(a, cur.cnt+1));
				}
			}
		}
		System.out.println(res);
	}
}
