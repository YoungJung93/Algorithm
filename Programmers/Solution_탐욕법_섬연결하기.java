package Problem;

import java.util.Arrays;
import java.util.Comparator;

public class Solution_탐욕법_섬연결하기 {
	static int n, costs[][];
	static int answer;
	public static void main(String[] args) {
		n = 4;
		costs = new int[][] {
			{0,1,1}, {0,2,2}, {1,2,5}, {1,3,1}, {2,3,8}
		};
		
		answer = 0;
		
		Arrays.sort(costs, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[2], o2[2]);
			}
		});
		boolean[] flag = new boolean[n];
		boolean[] flag_cost = new boolean[costs.length];
		flag[0] = true;
		while (!isEnd(flag)) {
			for (int i = 0; i < costs.length; i++) {
				if (flag_cost[i]) continue;
				if(!flag[costs[i][0]] && flag[costs[i][1]]) {
					flag[costs[i][0]] = true;
					flag_cost[i] = true;
					answer += costs[i][2];
					break;
				} else if(flag[costs[i][0]] && !flag[costs[i][1]]) {
					flag[costs[i][1]] = true;
					flag_cost[i] = true;
					answer += costs[i][2];
					break;
				}
			}
		}
		
		System.out.println(answer);
	}
	static boolean isEnd(boolean[] flag) {
		for(int i=0, size=flag.length; i<size; i++) {
			if(!flag[i]) return false;
		}
		return true;
	}
}
