package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10163_색종이 {
	static final int MAX = 101;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[MAX][MAX];
		int no=0;
		for(int i=0; i<n; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			no++;
			for(int cntj=0,j=b; cntj<d; cntj++, j++) {
				for(int cntk=0, k=a; cntk<c; cntk++, k++) {
					map[j][k] = no;
				}
			}
		}
		int[] res=new int[n];
		for(int i=0; i<MAX; ++i) {
			for(int j=0; j<MAX; ++j) {
				if(map[i][j]!=0) {
					res[map[i][j]-1]++;
				}
			}
		}
		for(int a : res) {
			System.out.println(a);
		}
	}
}
