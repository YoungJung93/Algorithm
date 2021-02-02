package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2563_색종이 {
	static final int MAX = 100;
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
		int res=0;
		for(int i=0; i<MAX; ++i) {
			for(int j=0; j<MAX; ++j) {
				if(map[i][j]) res++;
			}
		}
		System.out.println(res);
	}
}
