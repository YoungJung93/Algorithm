package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17244_아맞다우산 {
	static int N, M, th, res, sx, sy;
	static pair dst;
	static int[][] map;
	static Map<Integer, int[]> key;
	static int[] dr = {-1,1,0,0}, dc = {0,0,-1,1}, permu;
	static class pair {
		int x, y, time;
		public pair(int x, int y, int time) {
			this.x = x; this.y = y; this.time = time;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		key = new HashMap<Integer, int[]>();
		dst = null;
		th = 0;
		for(int i=0, k=1; i<M; i++) {
			String s = br.readLine();
			for(int j=0; j<N; j++) {
				char c = s.charAt(j);
				switch (c) {
				case '#':
					map[i][j] = -1;	break;
				case '.':
					map[i][j] = 0; break;
				case 'S':
					map[i][j] = 0; sx = i; sy = j; break;
				case 'E':
					map[i][j] = 0; dst = new pair(i, j, 0); break;
				case 'X':
					th++; map[i][j] = k; 
					key.put(k++, new int[] {i, j}); break;
				}
			}
		}
		permu = new int[th];
		for(int i=0; i<th; i++) {
			permu[i] = i+1;
		}
		res = Integer.MAX_VALUE;
		if(th==0) {
			res = bfs(sx, sy, dst.x, dst.y);
		} else {
			do {
				int total = bfs(sx, sy, key.get(permu[0])[0], key.get(permu[0])[1]);
				for(int i=1; i<th; i++) {
					total += bfs(key.get(permu[i-1])[0], key.get(permu[i-1])[1], 
							key.get(permu[i])[0], key.get(permu[i])[1]);
				}
				total += bfs(key.get(permu[th-1])[0], key.get(permu[th-1])[1], dst.x, dst.y);
				if(total < res) res = total;
			} while(np());
		}
		System.out.println(res);
	}
	static int bfs(int sr, int sc, int dsr, int dsc) {
		boolean[][] flag = new boolean[M][N];
		Queue<pair> que = new LinkedList<>();
		que.offer(new pair(sr, sc, 0));
		flag[sr][sc] = true;
		while(!que.isEmpty()) {
			pair cur = que.poll();
			for(int i=0; i<4; i++) {
				int dx = cur.x + dr[i];
				int dy = cur.y + dc[i];
				if(dx<0 || dy<0 || dx>=M || dy>=N) continue;
				if(dx==dsr && dy==dsc) return cur.time+1;
				if(map[dx][dy]==-1) continue;
				if(flag[dx][dy]) continue;
				flag[dx][dy] = true;
				que.offer(new pair(dx, dy, cur.time+1));
			}
		}
		return -1;
	}
	static boolean np() {
		int i = th - 1;
		while(i>0 && permu[i-1] >= permu[i]) i--;
		if(i==0) return false;
		int j = th - 1;
		while(permu[i-1] >= permu[j]) j--;
		swap(i-1, j);
		j = th - 1;
		while(i < j) swap(i++, j--);
		return true;
	}
	static void swap(int x, int y) {
		int tmp = permu[x];
		permu[x] = permu[y];
		permu[y] = tmp;
	}
}
