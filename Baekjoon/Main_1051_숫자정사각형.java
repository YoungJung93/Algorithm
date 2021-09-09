package Problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1051_숫자정사각형 {
	static int[][] map;
	static int N, M;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				int a = s.charAt(j) - '0';
				map[i][j] = a;
			}
		}
		
		int answer = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				int maxSize = Math.min(N - i, M - j);
				if(maxSize <= answer) continue;
				for(int k=maxSize; k>answer; k--) {
					if(check(i, j, k)) {
						answer = k;
						break;
					}
				}
			}
		}
		
		System.out.println(answer * answer);
	}
	public static boolean check(int r, int c, int size) {
		int base = map[r][c];
		int dr = r + size - 1, dc = c + size - 1;
		if(dr >= N || dc >= M) return false;
		if(map[r][dc] != base) return false;
		if(map[dr][c] != base) return false;
		if(map[dr][dc] != base) return false;
		return true;
	}
}
