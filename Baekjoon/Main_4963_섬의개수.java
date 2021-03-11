package Problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_4963_섬의개수 {
	static int[] dr = {-1,-1,-1,0,0,1,1,1};
	static int[] dc = {-1,0,1,-1,1,-1,0,1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int C = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			if(R==0 && C==0) break;
			int[][] map = new int[R][C];
			boolean[][] flag = new boolean[R][C];
			for(int i=0; i<R; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<C; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int answer = 0;
			for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) {
					if(map[i][j] == 1 && !flag[i][j]) {
						answer++;
						Queue<Integer> que = new LinkedList<>();
						que.offer(i); que.offer(j);
						flag[i][j] = true;
						while(!que.isEmpty()) {
							int r = que.poll();
							int c = que.poll();
							for(int k=0; k<8; k++) {
								int dx = r + dr[k];
								int dy = c + dc[k];
								if(dx<0 || dy<0 || dx>=R || dy>=C) continue;
								if(map[dx][dy]==0 || flag[dx][dy]) continue;
								flag[dx][dy] = true;
								que.offer(dx); que.offer(dy);
							}
						}
					}
				}
			}
			System.out.println(answer);
		}
	}

}
