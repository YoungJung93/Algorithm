package Problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17406_배열돌리기4 {
	static int[][] map, saveMap, commands;
	static int N, M, K;
	static int[] comb;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		saveMap = new int[N][M];
		map = new int[N][M];
		commands = new int[K][3];
		comb = new int[K];
		for(int i=0; i<K; i++) comb[i] = i;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				saveMap[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			commands[i][0] = Integer.parseInt(st.nextToken())-1;
			commands[i][1] = Integer.parseInt(st.nextToken())-1;
			commands[i][2] = Integer.parseInt(st.nextToken());
		}
		
		int answer = Integer.MAX_VALUE;
		
		do {
			for(int i=0; i<N; i++) map[i] = saveMap[i].clone();
			for(int i=0; i<K; i++) {
				rotate(commands[comb[i]][0], commands[comb[i]][1], commands[comb[i]][2]);
			}
			int res = valueOfArray();
			if(res < answer) answer = res;
		} while(np());
		
		System.out.println(answer);
	}
	public static boolean np() {
		int i = K - 1;
		while(i > 0 && comb[i-1] >= comb[i]) i--;
		if(i == 0) return false;
		int j = K - 1;
		while(comb[i-1] >= comb[j]) j--;
		swap(i-1, j);
		j = K - 1;
		while(i < j) swap(i++, j--);
		return true;
	}
	public static void swap(int x, int y) {
		int tmp = comb[x];
		comb[x] = comb[y];
		comb[y] = tmp;
	}
	public static int valueOfArray() {
		int res = Integer.MAX_VALUE;
		for(int i=0; i<N; i++) {
			int sum = 0;
			for(int j=0; j<M; j++) {
				sum += map[i][j];
			}
			if(sum < res) res = sum;
		}
		return res;
	}
	public static void rotate(int r, int c, int s) {
		for(int i=s; i>0; i--) {
			// 왼쪽 위 : (r-i, c-i), 오른쪽 아래 : (r+i, c+i)
			int tmp = map[r-i][c-i];
			for(int rr = r-i+1; rr <= r+i; rr++) {
				map[rr-1][c-i] = map[rr][c-i];
			}
			for(int cc = c-i+1; cc <= c+i; cc++) {
				map[r+i][cc-1] = map[r+i][cc];
			}
			for(int rr = r+i-1; rr >= r-i; rr--) {
				map[rr+1][c+i] = map[rr][c+i];
			}
			for(int cc = c+i-1; cc > c-i; cc--) {
				map[r-i][cc+1] = map[r-i][cc];
			}
			map[r-i][c-i+1] = tmp;
		}
	}
}
