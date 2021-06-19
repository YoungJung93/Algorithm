package Problem;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_DFS_BFS_네트워크 {
	static int n;
	static int[][] computers;
	static int answer;
	
	static boolean[][] flag;
	static boolean[] flag_com;
	public static void main(String[] args) {
		n = 3;
		computers = new int[][] {
//			{1,1,0}, {1,1,0}, {0,0,1}
			{1,1,0}, {1,1,1}, {0,1,1}
		};
		answer = 0;
		
		flag = new boolean[n][n];
		flag_com = new boolean[n];
		
		for(int i=0; i<n; i++) {
			if(flag_com[i]) continue;
			answer++;
			Queue<Integer> que = new LinkedList<Integer>();
			que.offer(i);
			flag_com[i] = true;
			while(!que.isEmpty()) {
				int cur = que.poll();
				for(int j=0; j<n; j++) {
					if(cur == j) continue;
					if(flag[cur][j]) continue;
					if(computers[cur][j] == 0) continue;
					flag[cur][j] = true;
					flag_com[j] = true;
					que.offer(j);
				}
			}
		}
		
		System.out.println(answer);
	}
}
