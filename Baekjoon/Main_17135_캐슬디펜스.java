package Problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17135_캐슬디펜스 {
	static int[] comb;
	static int N, M, D;
	static int[][] map, saveMap;
	static int[] dr = {0, -1, 1, 0};
	static int[] dc = {-1, 0, 0, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map = new int[N+1][M];
		saveMap = new int[N+1][M];
		comb = new int[M];
		for(int i=0; i<3; i++) comb[i] = 1;
		Arrays.sort(comb);
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				saveMap[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int answer = 0;
		do {
			for(int i=0; i<=N; i++) map[i] = saveMap[i].clone();
			int res = 0;
			while(true) {
				if(isEnd()) break;
				// 가까운 적 처치
				List<int[]> killList = new ArrayList<>();
				for(int i=0; i<M; i++) {
					if(comb[i] == 1) {
						Queue<Integer> que = new LinkedList<>();
						que.offer(N); que.offer(i);
						boolean[][] flag = new boolean[N+1][M];
						flag[N][i] = true;
						int d = 0;
						bfs:while(!que.isEmpty()) {
							if(d >= D) break;
							int size = que.size()/2;
							for(int s=0; s<size; s++) {
								int r = que.poll();
								int c = que.poll();
								for(int j=0; j<4; j++) {
									int dx = r + dr[j];
									int dy = c + dc[j];
									if(dx<0 || dy<0 || dx>N || dy>=M) continue;
									if(flag[dx][dy]) continue;
									if(map[dx][dy] == 0) {
										que.offer(dx); que.offer(dy);
										flag[dx][dy] = true;
									} else {
										killList.add(new int[] {dx, dy});
										break bfs;
									}
								}
							}
							d++;
						}
					}
				}
				for(int k=0, size=killList.size(); k<size; k++) {
					int[] tmp = killList.get(k);
					if(map[tmp[0]][tmp[1]] == 1) {
						map[tmp[0]][tmp[1]] = 0;
						res++;
					}
				}
				
				// 적 한칸 아래로
				for(int i=0; i<M; i++) map[N-1][i] = 0;
				for(int i=N; i>0; i--) {
					for(int j=0; j<M; j++) {
						map[i][j] = map[i-1][j];
					}
				}
				for(int i=0; i<M; i++) map[0][i] = 0;
			}
			if(res > answer) answer = res;
		} while(np());
		
		System.out.println(answer);
	}
	public static boolean isEnd() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 1) return false;
			}
		}
		return true;
	}
	public static boolean np() {
		int i = M - 1;
		while(i > 0 && comb[i-1] >= comb[i]) i--;
		if(i == 0) return false;
		int j = M - 1;
		while(comb[i-1] >= comb[j]) j--;
		swap(i-1, j);
		j = M - 1;
		while(i < j) swap(i++, j--);
		return true;
	}
	public static void swap(int x, int y) {
		int tmp = comb[x];
		comb[x] = comb[y];
		comb[y] = tmp;
	}
}
