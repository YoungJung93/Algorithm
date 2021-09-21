package Problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1105_팔 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int L = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		String left = Integer.toString(L);
		String right = Integer.toString(R);
		
		if(left.length() != right.length()) {
			System.out.println(0);
		} else {
			int len = left.length();
			int answer = 0;
			for(int i=0; i<len; i++) {
				if(left.charAt(i)=='8' && right.charAt(i)=='8') {
					answer++;
				} else if(left.charAt(i) == right.charAt(i)) {
					continue;
				} else {
					break;
				}
			}
			System.out.println(answer);
		}
	}
}
