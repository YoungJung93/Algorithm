package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_11967_불켜기 {
	static class pair {
		boolean bulb;
		List<Integer> list;
		public pair(boolean bulb) {
			this.bulb = bulb;
			list = new ArrayList<Integer>();
		}
		public void setList(int r, int c) {
			list.add(r); list.add(c);
		}
	}
	static pair[][] map;
	static boolean[][] flag;
	static int N, M;
	static int[] dr = {-1,1,0,0}, dc = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new pair[N+1][N+1];
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				map[i][j] = new pair(false);
			}
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]
					.setList(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		int answer = 0;
		map[1][1].bulb = true;
		flag = new boolean[N+1][N+1];
		for(int i=0,size=map[1][1].list.size(); i<size; i+=2) {
			map[map[1][1].list.get(i)][map[1][1].list.get(i+1)].bulb = true;
		}
		flag[1][1] = true;
		Queue<Integer> que = new LinkedList<>();
		que.offer(1); que.offer(1);
		while(!que.isEmpty()) {
			int r = que.poll();
			int c = que.poll();
			for(int i=0; i<4; i++) {
				int dx = r + dr[i];
				int dy = c + dc[i];
				if(dx<1 || dy<1 || dx>N || dy>N) continue;
				if(flag[dx][dy]) continue;
				if(!map[dx][dy].bulb) continue;
				flag[dx][dy] = true;
				que.offer(dx); que.offer(dy);
				
				Queue<Integer> imsi = new LinkedList<>();
				imsi.offer(dx); imsi.offer(dy);
				while(!imsi.isEmpty()) {
					int imr = imsi.poll();
					int imc = imsi.poll();
					for(int j=0, size=map[imr][imc].list.size(); j<size; j+=2) {
						int lr = map[imr][imc].list.get(j);
						int lc = map[imr][imc].list.get(j+1);
						map[lr][lc].bulb = true;
						if(flag[lr][lc]) continue;
						for(int k=0; k<4; k++) {
							int ddx = lr + dr[k];
							int ddy = lc + dc[k];
							if(ddx<1 || ddy<1 || ddx>N || ddy>N) continue;
							if(flag[ddx][ddy]) {
								flag[lr][lc] = true;
								que.offer(lr); que.offer(lc);
								imsi.offer(lr); imsi.offer(lc);
								break;
							}
						}
					}
				}
			}
		}
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(map[i][j].bulb) answer++;
			}
		}
		System.out.println(answer);
	}
}
