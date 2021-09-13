package Problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1059_좋은구간 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[L];
		for(int i=0; i<L; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		int n = Integer.parseInt(br.readLine());
		
		int upperInd = 0;
		boolean isContain = false;
		for( ; upperInd<L; upperInd++) {
			if(arr[upperInd] > n) {
				break;
			} else if(arr[upperInd] == n) {
				isContain = true;
				break;
			}
		}
		if(isContain) {
			System.out.println(0);
		} else {
			int lower = 0, upper = 0;
			if(upperInd == 0) {
				upper = arr[0];
			} else {
				lower = arr[upperInd-1];
				upper = arr[upperInd];
			}
			
			int answer = ((n - lower) * (upper - n)) - 1;
			System.out.println(answer);
		}
	}

}
