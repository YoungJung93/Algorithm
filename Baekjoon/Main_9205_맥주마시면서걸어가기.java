package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_9205_맥주마시면서걸어가기 {
	static class pair{
		public int x, y;
		public pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static final int INF = 999999;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[][] adj;
		pair[] pairs;
		for(int i=1; i<=T; i++) {
			int n = Integer.parseInt(br.readLine());
			adj = new int[n+2][n+2];
			pairs = new pair[n+2];
			StringTokenizer st = new StringTokenizer(br.readLine());
			pair start = new pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			pairs[0] = start;
			for(int j=1; j<=n; j++) {
				st = new StringTokenizer(br.readLine());
				pairs[j] = new pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			st = new StringTokenizer(br.readLine());
			pair end = new pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			pairs[n+1] = end;
			
			for(int j=0; j<n+2; j++) {
				for(int k=0; k<n+2; k++) {
					if(j==k) adj[j][k]=0;
					else if(isGo(pairs[j], pairs[k])) adj[j][k]=1;
					else adj[j][k]=INF;
				}
			}
			for (int k = 1; k < n+1; k++) {	// 경유지
				for (int a = 0; a < n+2; a++) {	// 출발지
					if(a==k) continue;			// 경유지와 출발지가 같다면 패스
					for (int j = 0; j < n+2; j++) {	// 도착지
						if(j==k || a==j) continue;	// 경유지와 도착지가 같거나 출발지와 도착지가 같다면 패스
						if(adj[a][k] + adj[k][j] < adj[a][j]) {
							adj[a][j] = adj[a][k] + adj[k][j];
						}
					}
				}
			}
			String result;
			if(adj[0][n+1]>=INF) result = "sad";
			else result = "happy";
			System.out.println(result);
		}
	}
	static boolean isGo(pair st, pair dest) {
		int a = Math.abs(st.x - dest.x);
		int b = Math.abs(st.y - dest.y);
		if(a+b <= 1000) return true;
		else return false;
	}
}
