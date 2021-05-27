package Problem;

import java.util.Arrays;

public class Solution_스택큐_탑 {
	static int[] heights;
	static int[] answer;
	public static void main(String[] args) {
		heights = new int[] {
//				6,9,5,7,4
//				3,9,9,3,5,7,2
				1,5,3,6,7,6,5
		};
		int len = heights.length;
		answer = new int[len];
		for(int i=len-1; i>=0; i--) {
			int base = heights[i];
			int res = 0;
			for(int j=i-1; j>=0; j--) {
				int tar = heights[j];
				if(base < tar) {
					res = j+1;
					break;
				}
			}
			answer[i] = res;
		}
		System.out.println(Arrays.toString(answer));
	}
}
