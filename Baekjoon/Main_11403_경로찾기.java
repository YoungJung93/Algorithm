package Problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_11403_경로찾기 {
	static int[][] adj;
	static int N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		adj = new int[N][N];
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				adj[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(adj[i][j]==1) continue;
				// i부터 시작해서 j까지 갈 수 있는지 확인
				Queue<Integer> que = new LinkedList<>();
				boolean[] flag = new boolean[N];
//				flag[i] = true;
				que.offer(i);
				bfs:
				while(!que.isEmpty()) {
					int cur = que.poll();
					for(int k=0; k<N; k++) {
						if(flag[k]) continue;
						if(adj[cur][k]==1) {
							if(k==j) {
								adj[i][j] = 1;
								break bfs;
							}
							flag[k] = true;
							que.offer(k);
						}
					}
				}
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(adj[i][j] + " ");
			}
			System.out.println();
		}
	}
}
