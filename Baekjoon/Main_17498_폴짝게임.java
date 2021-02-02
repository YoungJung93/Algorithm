package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_17498_폴짝게임 {
	static int[][] map;
	static long[][] maxArr;
	static int N, M, D;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		maxArr = new long[N][M];
		for(int i=0; i<N; i++) {
			Arrays.fill(maxArr[i], 0);
		}
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=1; i<N; i++) {
			for(int j=0; j<M; j++) {
				long max = Long.MIN_VALUE;
				int base = map[i][j];
				for(int ii=1; ii<=D; ii++) {
					if(i-ii<0) continue;
					for(int jj=j-(D-ii); jj<=j+(D-ii); jj++) {
						if(jj<0 || jj>=M) continue;
						int tar = map[i-ii][jj];
						long p = maxArr[i-ii][jj];
						if(base*tar+p > max) {
							max = base*tar+p;
						}
					}
				}
				maxArr[i][j] = max;
			}
		}
		long result = Long.MIN_VALUE;
		for(int i=0; i<M; i++) {
			if(result < maxArr[N-1][i]) result = maxArr[N-1][i];
		}
		System.out.println(result);
	}
}
