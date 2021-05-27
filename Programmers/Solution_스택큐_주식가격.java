package Problem;

import java.util.Arrays;

public class Solution_스택큐_주식가격 {
	static int[] prices, answer;
	public static void main(String[] args) {
		prices = new int[] {1,2,3,2,3};
		
		int len = prices.length;
		answer = new int[len];
		
		for(int i=0; i<len; i++) {
			for(int j=i+1, a=0; j<len; j++) {
				a++;
				if(prices[j] < prices[i]) {
					answer[i] = a;
					break;
				}
				if(j==len-1) {
					answer[i] = a;
				}
			}
		}
		
		System.out.println(Arrays.toString(answer));
	}
}
