package Problem;

import java.util.Arrays;
import java.util.Comparator;

public class Solution_정렬_HIndex {
	static int[] citations;
	static int answer;
	public static void main(String[] args) {
		citations = new int[] {
				3,0,6,1,5
		};
		answer = 0;
		
		int n = citations.length;
		Integer[] arr = new Integer[n];
		for(int i=0; i<n; i++) arr[i] = citations[i];
		Arrays.sort(arr, Comparator.reverseOrder());
		
		int h = n;
		if(arr[n-1] >= h) answer = h;
		else {
			for(int i=(n-2); i>=(n-1)/2; i--) {
				h = i+1;
				if(arr[i+1] <= h && arr[i] >= h) {
					answer = h;
					break;
				}
			}
		}
		
		System.out.println(answer);
	}
}
