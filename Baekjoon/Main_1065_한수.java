package Problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1065_한수 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int answer = 0;
		for(int i=1; i<=N; i++) {
			if(isAP(Integer.toString(i))) answer++;
		}
		
		System.out.println(answer);
	}
	public static boolean isAP(String num) {
		int len = num.length();
		if(len <= 2) return true;
		int base = (num.charAt(1) - '0') - (num.charAt(0) - '0');
		
		for(int i=2; i<len; i++) {
			int diff = (num.charAt(i) - '0') - (num.charAt(i-1) - '0');
			if(base != diff) return false;
		}
		return true;
	}
}
