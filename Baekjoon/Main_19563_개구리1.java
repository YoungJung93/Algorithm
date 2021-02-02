package Problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_19563_개구리1 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		c -= (Math.abs(a) + Math.abs(b));
		if(c < 0) System.out.println("NO");
		else if(c % 2 == 0) System.out.println("YES");
		else System.out.println("NO");
	}
}
