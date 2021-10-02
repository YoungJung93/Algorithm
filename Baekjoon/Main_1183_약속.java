package Problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1183_약속 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		int[] diff = new int[N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			diff[i] = a-b;
		}
		
		Arrays.sort(diff);
		if((N&1)==1) {
			System.out.println(1);
		} else {
			int answer = diff[N/2] - diff[N/2-1] + 1;
			System.out.println(answer);
		}
	}

}
