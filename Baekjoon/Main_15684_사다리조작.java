package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15684_사다리조작 {
	static int N, M, H;
	static int[][] map;
	static int[] comb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H+1][N+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = 1;
			map[a][b+1] = -1;
		}
		int answer = -1;
		if(go()) {
			answer = 0;
		} else {
			comb = new int[N*H];
			first : for(int i=1; i<=3; i++) {
				for(int j=0; j<i; j++) {
					comb[j] = 1;
				}
				Arrays.sort(comb);
				do {
					boolean f = true;
					for(int j=0, len=comb.length; j<len; j++) {
						if(comb[j]==1) {
							if(j%N == N-1) {
								f = false;
								break;
							}
							if(j-1>=0 && j-1/N==j/N && comb[j-1]==1) {
								f = false;
								break;
							}
							if(j+1<len && j+1/N==j/N && comb[j+1]==1) {
								f = false;
								break;
							}
						}
					}
					if(!f) continue;
					for(int j=0, len=comb.length; j<len; j++) {
						if(comb[j]==1) {
							int r = j/N + 1;
							int c = j%N + 1;
							if(map[r][c] != 0 || map[r][c+1] != 0) {
								f = false;
								break;
							}
						}
					}
					if(!f) continue;
					for(int j=0, len=comb.length; j<len; j++) {
						if(comb[j]==1) {
							int r = j/N + 1;
							int c = j%N + 1;
							map[r][c] = 1;
							map[r][c+1] = -1;
						}
					}
					if(go()) {
						answer = i;
						break first;
					}
					for(int j=0, len=comb.length; j<len; j++) {
						if(comb[j]==1) {
							int r = j/N + 1;
							int c = j%N + 1;
							map[r][c] = 0;
							map[r][c+1] = 0;
						}
					}
				} while(np());
			}
		}
		System.out.println(answer);
	}
	static boolean np() {
		int i = comb.length - 1;
		while(i > 0 && comb[i-1] >= comb[i]) i--;
		if(i==0) return false;
		int j = comb.length - 1;
		while(comb[i-1] >= comb[j]) j--;
		swap(i-1, j);
		j = comb.length - 1;
		while(i < j) swap(i++, j--);
		return true;
	}
	static void swap(int x, int y) {
		int tmp = comb[x];
		comb[x] = comb[y];
		comb[y] = tmp;
	}
	static boolean go() {
		for(int i=1; i<=N; i++) {
			int r = 1, c = i;
			while(true) {
				if(map[r][c]==0) r++;
				else if(map[r][c]==1) { c++; r++; }
				else { c--; r++; }
				if(r>H) break;
			}
			if(c != i) return false;
		}
		return true;
	}
}
