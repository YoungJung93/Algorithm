package Problem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution_가장먼노드 {

	public static void main(String[] args) {
		int n = 6;
		int[][] vertex = {
				{3,6},{4,3},{3,2},{1,3},{1,2},{2,4},{5,2}	
		};
		
		int answer = solution(n, vertex);
		System.out.println(answer);
	}
	public static int solution(int n, int[][] edge) {
        int answer = 0;
        
        @SuppressWarnings("unchecked")
		List<Integer>[] adj = new List[n+1];
        for(int i=1; i<=n; i++) adj[i] = new ArrayList<>();
        
        for(int i=0, size=edge.length; i<size; i++) {
        	adj[edge[i][0]].add(edge[i][1]);
        	adj[edge[i][1]].add(edge[i][0]);
        }
        
        List<List<Integer>> result = new ArrayList<>();
        Queue<Integer> que = new LinkedList<>();
        boolean[] flag = new boolean[n+1];
        que.offer(1);
        flag[1] = true;
        result.add(new ArrayList<>());
        result.get(0).add(1);
        int cnt = 0;
        while(!que.isEmpty()) {
        	int size = que.size();
        	cnt++;
        	result.add(new ArrayList<>());
        	for(int i=0; i<size; i++) {
        		int cur = que.poll();
        		for(int node : adj[cur]) {
        			if(flag[node]) continue;
        			flag[node] = true;
        			que.offer(node);
        			result.get(cnt).add(node);
        		}
        	}
        }
        
        answer = result.get(result.size()-2).size();
        
        return answer;
    }
}
