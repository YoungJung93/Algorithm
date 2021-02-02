package Problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2468_안전영역 {
	static int[][] map;
	static boolean[][] flag;
	static int N;
	public static void main(String[] args)	throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		int min = 101, max = 0;
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				int h = Integer.parseInt(st.nextToken());
				if(min > h) min = h;
				if(max < h) max = h;
				map[i][j] = h;
			}
		}
		int answer = 1;
		for(int h=min; h<=max; h++) {
			flag = new boolean[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j] <= h) flag[i][j] = true;
				}
			}
			int res = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(!flag[i][j]) {
						res++;
						bfs(i, j);
					}
				}
			}
			if(res > answer) answer = res;
		}
		System.out.println(answer);
	}
	static int[] dr = {-1,1,0,0}, dc = {0,0,-1,1};
	static void bfs(int r, int c) {
		Queue<Integer> que = new LinkedList<>();
		que.offer(r); que.offer(c);
		flag[r][c] = true;
		while(!que.isEmpty()) {
			int x = que.poll();
			int y = que.poll();
			for(int i=0; i<4; i++) {
				int dx = x + dr[i];
				int dy = y + dc[i];
				if(dx<0 || dy<0 || dx>=N || dy>=N) continue;
				if(flag[dx][dy]) continue;
				flag[dx][dy] = true;
				que.offer(dx); que.offer(dy);
			}
		}
	}
}
