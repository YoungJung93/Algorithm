package Problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1052_물병 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		String bit = Integer.toBinaryString(N);
		
		int answer = 0;
		
		while(howOne(bit) > K) {
			int ind = bit.lastIndexOf("1");
			int plus = (int)Math.pow(2, bit.length()-ind-1);
			answer += plus;
			N += plus;
			bit = Integer.toBinaryString(N);
		}
		
		System.out.println(answer);
	}
	public static int howOne(String bit) {
		int len = bit.length();
		int answer = 0;
		for(int i=0; i<len; i++) {
			if(bit.charAt(i) == '1') answer++;
		}
		return answer;
	}
}
