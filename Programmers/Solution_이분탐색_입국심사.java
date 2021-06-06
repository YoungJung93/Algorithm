package Problem;

import java.util.Arrays;

public class Solution_이분탐색_입국심사 {
	static int n, times[];
	static long answer;
	public static void main(String[] args) {
		n = 6;
		times = new int[] {
				7,10
		};
		answer = Long.MAX_VALUE;
		
		int len = times.length;
		long[] time = new long[len];
		for(int i=0; i<len; i++) {
			time[i] = (long)times[i];
		}
		Arrays.sort(time);
		long left = 1, right = time[len-1]*n;
		long mid = 0;
		while(true) {
			if(left > right) break;
			long total = 0;
			mid = (left+right) / 2;
			for(int i=0; i<len; i++) {
				total += mid/time[i];
			}
			if(total >= n) {
				if(mid < answer) answer = mid;
				right = mid-1;
			} else {
				left = mid+1;
			}
		}
		
		System.out.println(answer);
	}
}
