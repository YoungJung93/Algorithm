package Problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution_DFS_BFS_여행경로 {
	static String[][] tickets;
	static String[] answer;
	
	static List<String> list;
	static boolean[] flag;
	public static void main(String[] args) {
		tickets = new String[][] {
			{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}
//			{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}
		};
		
		list = new ArrayList<String>();
		flag = new boolean[tickets.length];
		dfs(tickets, "ICN", "ICN", 0);
		Collections.sort(list);
		answer = list.get(0).split(" ");
		
		System.out.println(Arrays.toString(answer));
	}
	static void dfs(String[][] tic, String last, String path, int cnt) {
		if(cnt == tic.length) {
			list.add(path);
			return;
		}
		for(int i=0, size=tic.length; i<size; i++) {
			if(!flag[i] && last.equals(tic[i][0])) {
				flag[i] = true;
				dfs(tic, tic[i][1], path+" "+tic[i][1], cnt+1);
				flag[i] = false;
			}
		}
	}
}
