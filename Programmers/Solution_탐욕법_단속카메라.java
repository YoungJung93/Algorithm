package Problem;

import java.util.Arrays;
import java.util.Comparator;

public class Solution_탐욕법_단속카메라 {
	static int[][] routes;
	static int answer;
	public static void main(String[] args) {
		routes = new int[][] {
			{-20,15}, {-14,-5}, {-18,-13}, {-5,-3}
		};
		answer = 0;
		
		Arrays.sort(routes, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[0], o2[0]);
			}
		});
		
		answer = 1;
		int len = routes.length;
		int base = routes[0][1];
		for(int i=1; i<len; i++) {
			if(routes[i][0] > base) {
				answer++;
				base = routes[i][1];
			} else {
				base = routes[i][1]<base ? routes[i][1] : base;
			}
		}
		
		System.out.println(answer);
	}
}
