package Problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2583_영역구하기 {
	static int[] dr = {-1,1,0,0}, dc = {0,0,-1,1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			for(int j=x1; j<x2; j++) {
				for(int k=y1; k<y2; k++) {
					map[j][k] = 1;
				}
			}
		}
		boolean[][] flag = new boolean[N][M];
		List<Integer> answer = new ArrayList<>();
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]==0 && !flag[i][j]) {
					Queue<Integer> que = new LinkedList<>();
					que.offer(i); que.offer(j);
					flag[i][j] = true;
					int res = 0;
					while(!que.isEmpty()) {
						int r = que.poll();
						int c = que.poll();
						res++;
						for(int k=0; k<4; k++) {
							int dx = r + dr[k];
							int dy = c + dc[k];
							if(dx<0 || dy<0 || dx>=N || dy>=M) continue;
							if(map[dx][dy]==1 || flag[dx][dy]) continue;
							flag[dx][dy] = true;
							que.offer(dx); que.offer(dy);
						}
					}
					answer.add(res);
				}
			}
		}
		int size = answer.size();
		System.out.println(size);
		Collections.sort(answer);
		for(int i=0; i<size; i++) {
			System.out.print(answer.get(i) + " ");
		}
		System.out.println();
	}

}
