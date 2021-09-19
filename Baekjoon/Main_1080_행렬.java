package Problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1080_행렬 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] A = new int[N][M];
		int[][] B = new int[N][M];
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				A[i][j] = s.charAt(j) - '0';
			}
		}
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				B[i][j] = s.charAt(j) - '0';
			}
		}
		int answer = 0;
		for(int i=0; i<=N-3; i++) {
			for(int j=0; j<=M-3; j++) {
				if(A[i][j] != B[i][j]) {
					answer++;
					for(int r=i; r<i+3; r++) {
						for(int c=j; c<j+3; c++) {
							if(A[r][c] == 0) A[r][c] = 1;
							else A[r][c] = 0;
						}
					}
				}
			}
		}
		
		boolean isSame = true;
		first :
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(A[i][j] != B[i][j]) {
					isSame = false;
					break first;
				}
			}
		}
		
		if(isSame) {
			System.out.println(answer);
		} else {
			System.out.println(-1);
		}
	}
}
