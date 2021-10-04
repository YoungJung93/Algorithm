package Problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_1205_등수구하기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int score = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		if(N == 0) {
			System.out.println(1);
		} else {
			st = new StringTokenizer(br.readLine());
			Integer[] list = new Integer[N];
			for(int i=0; i<N; i++) {
				list[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(list, Comparator.reverseOrder());
			
			if(N < P) {
				int grade = 0;
				boolean flag = false;
				for(int i=0; i<N; i++) {
					if(list[i] <= score) {
						grade = i+1;
						flag = true;
						break;
					}
				}
				if(flag) {
					System.out.println(grade);
				} else {
					System.out.println(N+1);
				}
			} else {
				int grade = 0;
				boolean flag = false;
				for(int i=0; i<N; i++) {
					if(list[i] <= score) {
						grade = i+1;
						flag = true;
						break;
					}
				}
				if(flag) {
					if(score > list[N-1]) {
						System.out.println(grade);
					} else {
						System.out.println(-1);
					}
				} else {
					System.out.println(-1);
				}
			}
		}
	}

}
