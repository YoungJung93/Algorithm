package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1194_달이차오른다가자 {
	static int N, M;
	static char[][] map;
	static boolean[][][] flag;
	static int[] dr = {-1,1,0,0}, dc = {0,0,-1,1};
	static class pair {
		int r, c, keys, key, cnt;
		public pair(int r, int c, int keys, int key, int cnt) {
			this.r = r; this.c = c; this.cnt = cnt;
			this.keys = keys; this.key = key;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		pair src = null;
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				char c = s.charAt(j);
				if(c == '0') src = new pair(i,j,0,0,0);
				map[i][j] = c;
			}
		}
		flag = new boolean[64][N][M];
		Queue<pair> pq = new LinkedList<>();
		pq.offer(src);
		flag[src.key][src.r][src.c] = true;
		int result = -1;
		bfs : while(!pq.isEmpty()) {
			pair p = pq.poll();
			int key = p.key;
			int keys = p.keys;
			for(int i=0; i<4; i++) {
				int dx = p.r + dr[i];
				int dy = p.c + dc[i];
				if(dx<0 || dy<0 || dx>=N || dy>=M) continue;
				if(flag[key][dx][dy]) continue;
				if(map[dx][dy]=='#') continue;
				if(map[dx][dy]=='1') {
					result = p.cnt + 1;
					break bfs;
				} else if(map[dx][dy]>='a' && map[dx][dy]<='f') {
					int k = map[dx][dy] - 'a';
					if((key & (1<<k)) == 0) {
						flag[(key | (1<<k))][dx][dy] = true;
						pq.offer(new pair(dx, dy, keys+1, (key | (1<<k)), p.cnt+1));
					}
					else {
						flag[key][dx][dy] = true;
						pq.offer(new pair(dx, dy, keys, key, p.cnt+1));
					}
				} else if(map[dx][dy]>='A' && map[dx][dy]<='F') {
					int k = map[dx][dy] - 'A';
					if((key & (1<<k)) != 0) {
						flag[key][dx][dy] = true;
						pq.offer(new pair(dx, dy, keys, key, p.cnt+1));
					}
				} else {
					flag[key][dx][dy] = true;
					pq.offer(new pair(dx, dy, keys, key, p.cnt+1));
				}
			}
		}
		System.out.println(result);
	}
}
