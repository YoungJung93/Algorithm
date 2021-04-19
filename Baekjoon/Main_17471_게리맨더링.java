package Problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17471_게리맨더링 {
	static int[] comb, population;
	static int N;
	static List<Integer>[] adj;
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		population = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) population[i] = Integer.parseInt(st.nextToken());
		
		adj = new List[N];
		for(int i=0; i<N; i++) adj[i] = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int size = Integer.parseInt(st.nextToken());
			for(int j=0; j<size; j++) {
				int tar = Integer.parseInt(st.nextToken())-1;
				adj[i].add(tar);
				adj[tar].add(i);
			}
		}
		
		int[] flag = new int[N];
		int no = 0;
		for(int i=0; i<N; i++) {
			if(flag[i] != 0) continue;
			no++;
			if(no > 2) break;
			Queue<Integer> que = new LinkedList<>();
			que.offer(i);
			flag[i] = no;
			while(!que.isEmpty()) {
				int cur = que.poll();
				for(int j=0, size=adj[cur].size(); j<size; j++) {
					int tar = adj[cur].get(j);
					if(flag[tar] != 0) continue;
					flag[tar] = no;
					que.offer(tar);
				}
			}
		}
		
		if(no > 2) {
			System.out.println(-1);
		} else {
			if(no == 1) {
				int answer = Integer.MAX_VALUE;
				for(int i=1; i<N; i++) {
					comb = new int[N];
					// i는 1번 선거구의 구역 수
					for(int j=0; j<i; j++) {
						comb[j] = 1;
					}
					Arrays.sort(comb);
					do {
						boolean[] visit = new boolean[N];
						Queue<Integer> que = new LinkedList<>();
						for(int j=0; j<N; j++) {
							if(comb[j] == 0) {
								que.offer(j);
								visit[j] = true;
								break;
							}
						}
						while(!que.isEmpty()) {
							int cur = que.poll();
							for(int j=0, size=adj[cur].size(); j<size; j++) {
								int tar = adj[cur].get(j);
								if(visit[tar] || comb[tar]==1) continue;
								visit[tar] = true;
								que.offer(tar);
							}
						}
						que = new LinkedList<>();
						for(int j=0; j<N; j++) {
							if(comb[j] == 1) {
								que.offer(j);
								visit[j] = true;
								break;
							}
						}
						while(!que.isEmpty()) {
							int cur = que.poll();
							for(int j=0, size=adj[cur].size(); j<size; j++) {
								int tar = adj[cur].get(j);
								if(visit[tar] || comb[tar]==0) continue;
								visit[tar] = true;
								que.offer(tar);
							}
						}
						boolean f = true;
						for(int j=0; j<N; j++) {
							if(!visit[j]) {
								f = false;
								break;
							}
						}
						if(f) {
							int no1 = 0;
							int no2 = 0;
							for(int c=0; c<N; c++) {
								if(comb[c] == 0) no1 += population[c];
							}
							for(int c=0; c<N; c++) {
								if(comb[c] == 1) no2 += population[c];
							}
							if(answer > Math.abs(no1 - no2)) {
								answer = Math.abs(no1 - no2);
							}
						}
					} while(np());
				}
				System.out.println(answer);
			} else {
				int no1 = 0;
				int no2 = 0;
				for(int i=0; i<N; i++) {
					if(flag[i] == 1) no1 += population[i];
				}
				for(int i=0; i<N; i++) {
					if(flag[i] == 2) no2 += population[i];
				}
				System.out.println(Math.abs(no1-no2));
			}
		}
		
	}
	public static boolean np() {
		int i=N-1;
		while(i>0 && comb[i-1] >= comb[i]) i--;
		if(i == 0) return false;
		int j = N-1;
		while(comb[i-1] >= comb[j]) j--;
		swap(i-1, j);
		j = N-1;
		while(i < j) swap(i++, j--);
		return true;
	}
	public static void swap(int x, int y) {
		int tmp = comb[x];
		comb[x] = comb[y];
		comb[y] = tmp;
	}
}
