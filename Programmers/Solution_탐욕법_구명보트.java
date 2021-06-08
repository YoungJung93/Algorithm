package Problem;

import java.util.Arrays;
import java.util.Comparator;

public class Solution_탐욕법_구명보트 {
	static int[] people;
	static int limit;
	static int answer;
	public static void main(String[] args) {
		people = new int[] {
//				70,50,80,50
				70,80,50
		};
		limit = 100;
		
		answer = 0;
		int len = people.length;
		Integer[] arr = new Integer[len];
		for(int i=0; i<len; i++) {
			arr[i] = people[i];
		}
		Arrays.sort(arr, new Comparator<Integer>() {
			public int compare(Integer arg0, Integer arg1) {
				return Integer.compare(arg1, arg0);
			}
		});
		int head=0, tail=len-1;
		while(head <= tail) {
			if(head == tail) {
				answer++;
				head++;
			} else {
				if(arr[head] + arr[tail] <= limit) {
					head++; tail--;
					answer++;
				} else {
					answer++;
					head++;
				}
			}
		}
		
		System.out.println(answer);
	}
}
