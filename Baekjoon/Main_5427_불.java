package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_5427_불 {
	static class pair {
		int x, y;
		public pair(int x, int y) {
			this.x = x; this.y = y;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] dr = {-1,1,0,0}, dc = {0,0,-1,1};
		for(int t=0; t<T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int C = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			// wall : 벽의 위치를 저장하기 위한 배열
			boolean[][] wall = new boolean[R][C];
			// flag : 방문한 위치와 불이 퍼진 위치를 저장하기 위한 배열
			boolean[][] flag = new boolean[R][C];
			// user : 상근이가 이동할 위치를 탐색하기 위한 큐
			Queue<pair> user = new LinkedList<>();
			// fire : 불을 퍼뜨리기 위한 큐
			Queue<pair> fire = new LinkedList<>();
			for(int i=0; i<R; i++) {
				String s = br.readLine();
				for(int j=0; j<C; j++) {
					char ch = s.charAt(j);
					switch(ch) {
					case '.' :
						break;
					case '#' :
						wall[i][j] = true;
						break;
					case '*' :
						// 불이 난 위치이면 flag를 체크해주고 fire 큐에 위치 저장
						flag[i][j] = true;
						fire.offer(new pair(i, j));
						break;
					case '@' :
						// 상근이의 위치를 user 큐에 저장하고 flag 체크
						flag[i][j] = true;
						user.offer(new pair(i, j));
						break;
					}
				}
			}
			
			int answer = 0;
			boolean f = true;
			bfs : 
			while(true) {
				// 불이 1번 퍼지고 상근이가 1번 이동하면 1초가 증가하는 것이므로 answer를 1증가시킴
				answer++;
				int flen = fire.size();
				int ulen = user.size();
				// user 큐가 비어있다 = 상근이가 모든 위치를 탐색했음에도 빌딩을 탈출하지 못했다 이므로 IMPOSSIBLE
				if(ulen == 0) {
					f = false;
					break;
				}
				// 상근이가 이동하기 전에 fire 큐를 이용하여 불을 먼저 퍼뜨린다
				while(flen-->0) {
					pair cur = fire.poll();
					int x = cur.x;
					int y = cur.y;
					for(int i=0; i<4; i++) {
						int dx = x + dr[i];
						int dy = y + dc[i];
						if(dx<0 || dy<0 || dx>=R || dy>=C) continue;
						if(flag[dx][dy] || wall[dx][dy]) continue;
						flag[dx][dy] = true;
						fire.offer(new pair(dx, dy));
					}
				}
				// 상근이 이동하기
				while(ulen-->0) {
					pair cur = user.poll();
					int x = cur.x;
					int y = cur.y;
					for(int i=0; i<4; i++) {
						int dx = x + dr[i];
						int dy = y + dc[i];
						if(dx<0 || dy<0 || dx>=R || dy>=C) {
							break bfs;
						}
						if(flag[dx][dy] || wall[dx][dy]) continue;
						flag[dx][dy] = true;
						user.offer(new pair(dx, dy));
					}
				}
				
			}
			if(!f) System.out.println("IMPOSSIBLE");
			else System.out.println(answer);
		}
	}
}
