package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1976_여행가자 {
	static int N, M;
	static int[][] adj;
	static boolean[] flag;
	static int[] arr;
	static class pair {
		int x, ind;
		public pair(int x, int ind) {
			this.x = x; this.ind = ind;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		adj = new int[N][N];
		flag = new boolean[N];
		arr = new int[M];
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				adj[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			arr[i] = Integer.parseInt(st.nextToken())-1;
		}
		String res = null;
		Queue<pair> que = new LinkedList<pair>();
		int ai = 1;
		while(true) {
			if(ai<M && arr[ai]==arr[0]) ai++;
			else break;
		}
		que.offer(new pair(arr[0], ai));
		flag[arr[0]] = true;
		fir : while(!que.isEmpty()) {
			pair cur = que.poll();
			if(cur.ind==M) {res="YES"; break;}
			for(int i=0; i<N; i++) {
				if(cur.x==i) continue;
				if(adj[cur.x][i]==1 && !flag[i]) {
					int arrInd = cur.ind;
					if(i == arr[cur.ind]) {
						arrInd++;
						while(true) {
							if(arrInd<M && arr[arrInd]==i) arrInd++;
							else break;
						}
						if(arrInd==M) {res="YES"; break fir;}
						flag = new boolean[N];
						que.clear();
						que.offer(new pair(i, arrInd));
						flag[i] = true;
						break;
					} else {
						que.offer(new pair(i, arrInd));
						flag[i] = true;
					}
				}
			}
		}
		if(res==null) res = "NO";
		System.out.println(res);
	}
}
