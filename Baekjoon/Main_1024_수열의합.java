package Problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1024_수열의합 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		// i가 홀수(홀수 개로 나뉨)일 때는 가운데에 있는 수가 N%i==0 && N/i 여야 한다
		
		// i가 짝수(짝수 개로 나뉨)일 때는 가운데의 2개의 수의 합이 N%(가운데 두 수의 합)==0 && N/(가운데 두 수의 합)==2 여야 한다.
		
		int[] answer = {};
		boolean flag = false;
		for(int i=L; i<=100; i++) {
			if((i&1) == 1) {
				if(N % i == 0) {
					int center = N / i;
					answer = new int[i];
					answer[i/2] = center;
					for(int j=i/2-1; j>=0; j--) {
						answer[j] = answer[j+1] - 1;
					}
					for(int j=i/2+1; j<i; j++) {
						answer[j] = answer[j-1] + 1;
					}
					if(answer[0] < 0) continue;
					flag = true;
					break;
				}
			} else {
				if(N % (i/2) == 0) {
					int sum = N / (i/2);
					if(sum % 2 == 1) {
						int one = sum / 2;
						int two = sum / 2 + 1;
						answer = new int[i];
						answer[i/2-1] = one;
						answer[i/2] = two;
						for(int j=i/2-1; j>=0; j--) {
							answer[j] = answer[j+1] - 1;
						}
						for(int j=i/2+1; j<i; j++) {
							answer[j] = answer[j-1] + 1;
						}
						if(answer[0] < 0) continue;
						flag = true;
						break;
					}
				}
			}
		}
		if(!flag) {
			System.out.println(-1);
		} else {
			for(int i=0, len=answer.length; i<len; i++) {
				System.out.print(answer[i]);
				if(i != len-1) System.out.print(" ");
			}
			System.out.println();
		}
	}

}
