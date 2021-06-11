package Problem;

import java.util.Arrays;

public class Solution_탐욕법_저울 {
	static int[] weight;
	static int answer;
	public static void main(String[] args) {
		weight = new int[] {
			1,1,3	
		};
		answer = 0;
		
		Arrays.sort(weight);
		if(weight[0] != 1) {
			answer = 1;
		} else {
			int sum = weight[0];
			for(int i=1, size=weight.length; i<size; i++) {
				if(sum < weight[i] && sum+1 != weight[i]) {
					answer = sum+1;
					break;
				}
				sum += weight[i];
				if(i==size-1) {
					answer = sum+1;
				}
			}
		}
		
		System.out.println(answer);
	}
}
