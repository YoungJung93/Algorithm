package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1012_?†Í∏∞?çÎ∞∞Ï∂?{
	static int[][] map;
	static int N, M;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int i=1; i<=t; ++i) { 
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			for(int j=0; j<k; ++j) {
				st = new StringTokenizer(br.readLine());
				int c = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				map[r][c] = 1;
			}
			int bule = 0;
			for(int j=0; j<N;++j) {
				for(int a=0; a<M; ++a) {
					if(map[j][a]==1) {
						bfs(j, a);
						bule++;
					}
				}
			}
			System.out.println(bule);
		}
	}
	static void bfs(int i, int j) {
		Queue<Integer> que = new LinkedList<Integer>();
		que.offer(i);
		que.offer(j);
		while(!que.isEmpty()) {
			int x = que.poll();
			int y = que.poll();
			map[x][y] = 0;
			for(int a=0, size=dr.length; a<size; ++a) {
				int dx = x+dr[a];
				int dy = y+dc[a];
				if(dx<0 || dy<0 || dx>=N || dy>=M) continue;
				if(map[dx][dy]==1) {
					que.offer(dx);
					que.offer(dy);
					map[dx][dy] = 0;
				}
			}
		}
	}
}
