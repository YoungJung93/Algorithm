package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main_2667_단지번호붙이기 {
	static int[][] map;
	static boolean[][] flag;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int N, danji;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		flag = new boolean[N][N];
		for(int i=0; i<N; ++i) {
			String s = br.readLine();
			for(int j=0; j<N; ++j) {
				int a = s.charAt(j)-'0';
				if(a==1) {
					flag[i][j] = true;
				}
			}
		}
		danji = 1;
		for(int i=0; i<N; ++i) {
			for(int j=0; j<N; ++j) {
				if(flag[i][j]) {
					bfs(i, j);
					++danji;
				}
			}
		}
		System.out.println(danji-1);
		int[] res = new int[danji-1];
		for(int i=0; i<N; ++i) {
			for(int j=0; j<N; ++j) {
				if(map[i][j]!=0) {
					res[map[i][j]-1]++;
				}
			}
		}
		Arrays.sort(res);
		for(int i=0; i<danji-1; ++i) {
			System.out.println(res[i]);
		}
	}
	static void bfs(int r, int c) {
		Queue<Integer> que = new LinkedList<Integer>();
		que.offer(r);
		que.offer(c);
		flag[r][c]=false;
		while(!que.isEmpty()) {
			int x = que.poll();
			int y = que.poll();
			map[x][y] = danji;
			for(int i=0, size=dr.length; i<size; ++i) {
				int dx = x+dr[i];
				int dy = y+dc[i];
				if(dx<0 || dy<0 || dx>=N || dy>=N) continue;
				if(flag[dx][dy]) {					
					que.offer(dx);
					que.offer(dy);
					flag[dx][dy] = false;
				}
			}
		}
	}
}
