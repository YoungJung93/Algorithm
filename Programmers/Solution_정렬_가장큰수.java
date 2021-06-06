package Problem;

import java.util.Arrays;
import java.util.Comparator;

public class Solution_정렬_가장큰수 {
	static int[] numbers;
	static String answer;
	public static void main(String[] args) {
		numbers = new int[] {
//			6,10,2
			3,30,34,5,9
		};
		answer = "";
		
		Integer[] nums = new Integer[numbers.length];
		for(int i=0,size=numbers.length; i<size; i++) nums[i] = numbers[i];
		Arrays.sort(nums, new Comparator<Integer>() {
			public int compare(Integer a, Integer b) {
				String sa = a.toString();
				String sb = b.toString();
				return (sb+sa).compareTo(sa+sb);
			}
		});

		for(int i=0, size=nums.length; i<size; i++) {
			answer += String.valueOf(nums[i]);
		}
		if(answer.charAt(0)=='0') answer = "0";
		
		System.out.println(answer);
	}
}
