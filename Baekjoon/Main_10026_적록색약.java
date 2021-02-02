package Problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_10026_적록색약 {
	static int N;
	static char[][] map;
	static boolean[][] flag;
	static int[] dr = {-1,1,0,0}, dc = {0,0,-1,1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int answer1 = 0, answer2 = 0;
		map = new char[N][N];
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<N; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		// 적록색약이 아닌 사람이 봤을 때
		flag = new boolean[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(flag[i][j]) continue;
				Queue<Integer> que = new LinkedList<Integer>();
				que.offer(i); que.offer(j);
				flag[i][j] = true;
				while(!que.isEmpty()) {
					int r = que.poll();
					int c = que.poll();
					for(int k=0; k<4; k++) {
						int dx = r + dr[k];
						int dy = c + dc[k];
						if(dx<0 || dy<0 || dx>=N || dy>=N) continue;
						if(flag[dx][dy]) continue;
						if(map[dx][dy] != map[i][j]) continue;
						flag[dx][dy] = true;
						que.offer(dx); que.offer(dy);
					}
				}
				answer1++;
			}
		}
		// 적록색약인 사람이 봤을 때
		flag = new boolean[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == 'G') map[i][j] = 'R';
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(flag[i][j]) continue;
				Queue<Integer> que = new LinkedList<Integer>();
				que.offer(i); que.offer(j);
				flag[i][j] = true;
				while(!que.isEmpty()) {
					int r = que.poll();
					int c = que.poll();
					for(int k=0; k<4; k++) {
						int dx = r + dr[k];
						int dy = c + dc[k];
						if(dx<0 || dy<0 || dx>=N || dy>=N) continue;
						if(flag[dx][dy]) continue;
						if(map[dx][dy] != map[i][j]) continue;
						flag[dx][dy] = true;
						que.offer(dx); que.offer(dy);
					}
				}
				answer2++;
			}
		}
		System.out.println(answer1 + " " + answer2);
	}
}
