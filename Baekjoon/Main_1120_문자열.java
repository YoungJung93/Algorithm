package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1120_문자열 {
	static String A, B;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = st.nextToken();
		B = st.nextToken();
		int answer = Integer.MAX_VALUE;
		if(A.length() == B.length()) {
			answer = strDiff(A, B);
		} else {
			int Alen = A.length(), Blen = B.length();
			for(int i=0; i<=(Blen-Alen); i++) {
				String subB = B.substring(i, i+Alen);
				int diff = strDiff(A, subB);
				if(diff < answer) answer = diff;
			}
		}
		System.out.println(answer);
	}
	static int strDiff(String s1, String s2) {
		int result = 0;
		for(int i=0, size=s1.length(); i<size; i++) {
			if(s1.charAt(i)!=s2.charAt(i)) result++;
		}
		return result;
	}
}
