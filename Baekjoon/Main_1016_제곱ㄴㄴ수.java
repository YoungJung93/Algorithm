package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1016_제곱ㄴㄴ수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long min = Long.parseLong(st.nextToken());
		long max = Long.parseLong(st.nextToken());
		boolean[] flag = new boolean[(int)(max-min)+1];
		
		for(long i=2; ; i++) {
			long divNum = i*i;
			if(divNum > max) break;
			for(long j=(divNum*(min/divNum)); j<=max; j+=divNum) {
				if(j < min) continue;
				flag[(int)(j-min)] = true;
			}
		}
		
		int answer = 0;
		for(int i=0; i<=max-min; i++) {
			if(!flag[i]) answer++;
		}
		
		System.out.println(answer);
	}

}
