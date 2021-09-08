package Problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1049_기타줄 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int set = Integer.MAX_VALUE, each = Integer.MAX_VALUE;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(a < set) set = a;
			if(b < each) each = b;
		}
		
		int answer = 0;
		if((each*6) <= set) {
			answer = each * N;
		} else {
			int div = N / 6;
			int mod = N % 6;
			if(mod == 0) {
				answer = set * div;
			} else {
				if((each*mod) < set) {
					answer = (set * div) + (each * mod);
				} else {
					answer = set * (div + 1);
				}
			}
		}
		
		System.out.println(answer);
	}

}
