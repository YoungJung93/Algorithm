package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_2210_숫자판점프 {
	static Set<String> set;
	static int N, map[][];
	static int[] dr = {-1,1,0,0}, dc = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = 5;
		map = new int[N][N];
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		set = new HashSet<>();
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				dfs(i, j, ""+map[i][j]);
			}
		}
		int answer = set.size();
		System.out.println(answer);
	}
	public static void dfs(int r, int c, String num) {
		if(num.length() >= 6) {
			set.add(num);
			return;
		}
		for(int i=0; i<4; i++) {
			int dx = r + dr[i];
			int dy = c + dc[i];
			if(dx<0 || dx>=N || dy<0 || dy>=N) continue;
			dfs(dx, dy, num+map[dx][dy]);
		}
	}
}
