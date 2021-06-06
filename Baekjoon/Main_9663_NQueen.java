package Problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_9663_NQueen {
	static int[] flag;
	static int N, answer;
	static int[] dr = {-1,1,0,0,-1,-1,1,1};
	static int[] dc = {0,0,-1,1,-1,1,-1,1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		answer = 0;
		
		// 인덱스가 열, flag[i]가 그 열에 퀸이 위치한 행
		flag = new int[N];
		
		dfs(0);
		
		System.out.println(answer);
	}
	public static void dfs(int r) {
		if(r == N) {
			answer++;
			return;
		}
		for(int c=0; c<N; c++) {
			flag[r] = c;
			if(isPut(r)) {
				dfs(r+1);
			}
		}
	}
	public static boolean isPut(int c) {
		for(int i=0; i<c; i++) {
			if(flag[c] == flag[i]) return false;
			if(Math.abs(c - i) == Math.abs(flag[c] - flag[i])) return false;
		}
		return true;
	}
}
