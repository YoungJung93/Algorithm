package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14502_연구소 {
	static int[][] map;
	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int answer = 0;
		for(int i=0; i<N*M; i++) {
			if(map[i/M][i%M] != 0) continue;
			map[i/M][i%M] = 1;
			for(int j=i+1; j<N*M; j++) {
				if(map[j/M][j%M] != 0) continue;
				map[j/M][j%M] = 1;
				for(int k=j+1; k<N*M; k++) {
					if(map[k/M][k%M] != 0) continue;
					map[k/M][k%M] = 1;
					int a = bfs();
					answer = answer < a ? a : answer;
					map[k/M][k%M] = 0;
				}
				map[j/M][j%M] = 0;
			}
			map[i/M][i%M] = 0;
		}
		System.out.println(answer);
	}
	static int[] dr = {-1,1,0,0}, dc = {0,0,-1,1};
	static int bfs() {
		int[][] arr = new int[N][M];
		for(int i=0; i<N; i++) arr[i] = map[i].clone();
		Queue<Integer> que = new LinkedList<Integer>();
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(arr[i][j] == 2) {
					que.offer(i); que.offer(j);
				}
			}
		}
		while(!que.isEmpty()) {
			int r = que.poll();
			int c = que.poll();
			for(int i=0; i<4; i++) {
				int dx = r + dr[i];
				int dy = c + dc[i];
				if(dx<0 || dy<0 || dx>=N || dy>=M) continue;
				if(arr[dx][dy] != 0) continue;
				arr[dx][dy] = 2;
				que.offer(dx); que.offer(dy);
			}
		}
		int res = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(arr[i][j] == 0) res++;
			}
		}
		return res;
	}
}
