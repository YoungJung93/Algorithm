package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2567_색종이2 {
	static final int MAX = 100;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		boolean[][] map = new boolean[MAX][MAX];
		for(int i=0; i<n; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			for(int cntj=0,j=MAX-b-1; cntj<10; cntj++, j--) {
				for(int cntk=0, k=a; cntk<10; cntk++, k++) {
					map[j][k] = true;
				}
			}
		}
		int result=0;
		for(int i=0; i<MAX; i++) {
			for(int j=0; j<MAX; j++) {
				if(map[i][j]) {
					int res = 4;
					for(int k=0, size=dr.length; k<size; k++) {
						int dx=i+dr[k];
						int dy=j+dc[k];
						if(dx<0 || dy<0 || dx>=MAX || dy>=MAX) continue;
						if(map[dx][dy]) res--;
					}
					result+=res;
				}
			}
		}
		System.out.println(result);
	}
}
