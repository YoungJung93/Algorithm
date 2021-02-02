package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2635_수이어가기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int max = 0, maxI = -1;
		for(int i=n; i>=0; i--) {
			int a = makeNum(n,i);
			if(a>=max) {
				max = a;
				maxI = i;
			}
		}
		System.out.println(max);
		System.out.printf("%d %d", n, maxI);
		while(true) {
			if(n-maxI<0) break;
			int tmp = n-maxI;
			n = maxI;
			maxI = tmp;
			System.out.print(" " + maxI);
		}
		System.out.println();
	}
	static int makeNum(int n, int m) {
		int cnt = 2;
		while(true) {
			if(n-m<0) break;
			int tmp = n-m;
			n = m;
			m = tmp;
			cnt++;
		}
		return cnt;
	}
}