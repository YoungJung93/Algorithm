package Problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11401_이항계수3 {
	public static final int DIV = 1000000007;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int a = fac(N);
		int b = (int)(((long)fac(K) * (long)(fac(N-K))) % DIV);
		
		int answer = (int)((a * (pow(b, DIV-2))) % DIV);
		
		System.out.println(answer);
	}
	public static int fac(int n) {
		long answer = 1;
		
		for(int i=2; i<=n; i++) {
			answer *= i;
			answer = answer % DIV;
		}
		
		return (int)answer;
	}
	public static long pow(int n, int k) {
		if(k == 0) {
			return 1;
		}
		long half = pow(n, k/2) % DIV;
		if((k&1) == 0) {
			return (half * half) % DIV;
		} else {
			return (((half * half) % DIV) * n) % DIV;
		}
	}
}
