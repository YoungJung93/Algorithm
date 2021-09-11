package Problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1057_토너먼트 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Integer.parseInt(st.nextToken());
		int kim = Integer.parseInt(st.nextToken());
		int lim = Integer.parseInt(st.nextToken());
		
		int answer = 1;
		while(true) {
			kim = (kim + 1) / 2;
			lim = (lim + 1) / 2;
			if(kim == lim) {
				break;
			}
			answer++;
		}
		System.out.println(answer);
	}

}
