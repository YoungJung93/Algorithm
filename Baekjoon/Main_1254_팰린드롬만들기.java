package Problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1254_팰린드롬만들기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder str = new StringBuilder(br.readLine());
		
		if(isPal(str.toString())) {
			System.out.println(str.length());
			return;
		}
		
		StringBuilder add = new StringBuilder();
		int len = str.length();
		
		int answer = 0;
		for(int i=0; i<len; i++) {
			String c = str.charAt(i)+"";
			StringBuilder sb = new StringBuilder(c);
			add = sb.append(add);
			if(isPal(str.toString() + add.toString())) {
				answer = len + add.length();
				break;
			}
		}
		
		System.out.println(answer);
	}
	public static boolean isPal(String str) {
		int len = str.length();
		if((len&1)==1) {
			StringBuilder sb1 = new StringBuilder(str.substring(0, len/2));
			StringBuilder sb2 = new StringBuilder(str.substring(len/2+1, len));
			sb2 = sb2.reverse();
			return sb1.toString().equals(sb2.toString());
		} else {
			StringBuilder sb1 = new StringBuilder(str.substring(0, len/2));
			StringBuilder sb2 = new StringBuilder(str.substring(len/2, len));
			sb2 = sb2.reverse();
			return sb1.toString().equals(sb2.toString());
		}
	}
}
