package Problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1010_다리놓기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int n = Math.max(a, b);
			int m = Math.min(a, b);
			int[] son, mom;
			if(m > n-m) {
				son = new int[n-m];
				mom = new int[n-m];
				for(int i=0; i<n-m; i++) {
					son[i] = m+1+i;
					mom[i] = i+1;
				}
			} else {
				son = new int[n-(n-m)];
				mom = new int[m];
				for(int i=0; i<n-(n-m); i++) {
					son[i] = (n-m)+1+i;
				}
				for(int i=0; i<m; i++) {
					mom[i] = i+1;
				}
			}
			
			int momLen = mom.length;
			int sonLen = son.length;
			for(int i=0; i<momLen; i++) {
				for(int j=0; j<sonLen; j++) {
					if(mom[i] == 1) break;
					int gcd = GCD(mom[i], son[j]);
					if(gcd == 1) continue;
					mom[i] = mom[i] / gcd;
					son[j] = son[j] / gcd;
				}
			}
			int answer = 1;
			for(int i=0; i<sonLen; i++) {
				answer *= son[i];
			}
			System.out.println(answer);
		}
	}
	public static int GCD(int x, int y) {
		int r=0;
		while(y != 0) {
			r = x % y;
			x = y;
			y = r;
		}
		return x;
	}
}
