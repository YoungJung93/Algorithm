package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16234_인구이동 {
	static int N, L, R;
	static int[][] map;
	static int[] dr = {-1,1,0,0}, dc = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int answer = 0;
		while(true) {
			boolean[][] flag = new boolean[N][N];
			boolean f = true;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(flag[i][j]) continue;
					Queue<Integer> yh = new LinkedList<>();
					yh.offer(i); yh.offer(j);
					int sum = map[i][j];
					Queue<Integer> que = new LinkedList<Integer>();
					que.offer(i); que.offer(j);
					flag[i][j] = true;
					while(!que.isEmpty()) {
						int x = que.poll();
						int y = que.poll();
						for(int k=0; k<4; k++) {
							int dx = x + dr[k];
							int dy = y + dc[k];
							if(dx<0 || dy<0 || dx>=N || dy>=N) continue;
							int a = Math.abs(map[x][y]-map[dx][dy]);
							if(a < L || a > R) continue;
							if(flag[dx][dy]) continue;
							flag[dx][dy] = true;
							sum += map[dx][dy];
							que.offer(dx); que.offer(dy);
							yh.offer(dx); yh.offer(dy);
						}
					}
					if(yh.size() == 2) continue;
					f = false;
					int ea = yh.size()/2;
					int re = sum/ea;
					for(int k=0; k<ea; k++) {
						int x = yh.poll();
						int y = yh.poll();
						map[x][y] = re;
					}
				}
			}
			
			if(f) break;
			answer++;
		}
		System.out.println(answer);
	}
}
