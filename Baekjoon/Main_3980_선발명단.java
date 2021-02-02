package Problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3980_선발명단 {
	static int[][] entry;
	static int answer;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int t=0; t<T; t++) {
			entry = new int[11][11];
			for(int i=0; i<11; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<11; j++) {
					entry[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			answer = 0;
			flag = new boolean[11];
			dfs(0, 0);
			System.out.println(answer);
		}
	}
	static boolean[] flag;
	static void dfs(int ind, int total) {
		if(ind == 11) {
			if(answer < total) answer = total;
			return;
		}
		for(int i=0; i<11; i++) {
			if(flag[i]) continue;
			if(entry[ind][i]==0) continue;
			flag[i] = true;
			dfs(ind+1, total+entry[ind][i]);
			flag[i] = false;
		}
	}
}
