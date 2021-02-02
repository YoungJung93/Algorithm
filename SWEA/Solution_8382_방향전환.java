package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_8382_방향전환 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int i=1; i<=t; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int x = Math.abs(x2-x1);
			int y = Math.abs(y2-y1);
			int res = 0, base=0;
			if(x==y) {
				res = x+y;
			} else if(x>y) {
				res = 2*y;
				base = x-y;
			} else {
				res = 2*x;
				base = y-x;
			}
			if(base%2==0) {
				res += base*2;
			} else {
				res += base*2-1;
			}
			System.out.println("#" + i + " " + res);
		}
	}
}
