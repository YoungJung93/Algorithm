package Problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1072_게임 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		
		if(X == Y) {
			System.out.println(-1);
			return;
		}
		
		int base = (int)((100*(long)Y) / X);
		if(base == 99) {
			System.out.println(-1);
		} else {
			int answer = 0;
			int left = 1;
			int right = X;
			if(ratio(X+left, Y+left) > base) {
				System.out.println(left);
				return;
			}
			if(ratio(X+right, Y+right) <= base) {
				System.out.println(-1);
				return;
			}
			int mid = (left + right) / 2;
			while(left < right-1) {
				int rate = ratio(X+mid, Y+mid);
				
				if(rate > base) {
					right = mid;
				} else {
					left = mid;
				}
				mid = (left+right) / 2;
			}
			
			for(int i=left; i<=right; i++) {
				if(ratio(X+i, Y+i) > base) {
					answer = i;
					break;
				}
			}
			System.out.println(answer);
		}
	}
	public static int ratio(int X, int Y) {
		long y = 100L * Y;
		return (int)(y / X);
	}
}
