package Problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1002_터렛 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			
			if(x1==x2 && y1==y2 && r1==r2) {
				System.out.println(-1);
			} else if(x1==x2 && y1==y2) {
				System.out.println(0);
			} else {
				double d = distance(x1, y1, x2, y2);
				if(d == (r1+r2) || d == (Math.max(r1, r2) - Math.min(r1, r2))) {
					System.out.println(1);
				} else if(d < (Math.max(r1, r2) - Math.min(r1, r2)) || d > (r1+r2)) {
					System.out.println(0);
				} else {
					System.out.println(2);
				}
			}
		}
	}
	public static double distance(int x1, int y1, int x2, int y2) {
		double a = Math.pow((x2-x1), 2);
		double b = Math.pow((y2-y1), 2);
		return Math.sqrt(a+b);
	}
}
