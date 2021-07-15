package Problem;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution_배달 {

	public static void main(String[] args) {
		int N = 5;
//		int N = 6;
		int[][] road = {
				{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}
//				{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}	
		};
		int K = 3;
//		int K = 4;
		
		int answer = solution(N, road, K);
		System.out.println(answer);
	}
	static class Pos implements Comparable<Pos> {
		int tar, w;
		public Pos(int tar, int w) {
			this.tar = tar;
			this.w = w;
		}
		@Override
		public int compareTo(Pos o) {
			return Integer.compare(this.w, o.w);
		}
	}
	public static final int MAX = Integer.MAX_VALUE;
	public static int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        int[][] map = new int[N+1][N+1];
        for(int i=1; i<=N; i++) {
        	Arrays.fill(map[i], MAX);
        }
        for(int i=0, len=road.length; i<len; i++) {
        	map[road[i][0]][road[i][1]] = Math.min(map[road[i][0]][road[i][1]], road[i][2]);
        	map[road[i][1]][road[i][0]] = Math.min(map[road[i][1]][road[i][0]], road[i][2]);
        }
        
        int[] dis = new int[N+1];
        Arrays.fill(dis, MAX);
        dis[1] = 0;
        boolean[] flag = new boolean[N+1];
        flag[1] = true;
        PriorityQueue<Pos> pq = new PriorityQueue<>();
        for(int i=1; i<=N; i++) {
        	if(map[1][i] != MAX) {
        		dis[i] = map[1][i];
        		pq.offer(new Pos(i, map[1][i]));
        	}
        }
        
        while(!pq.isEmpty()) {
        	Pos cur = pq.poll();
        	flag[cur.tar] = true;
        	for(int i=1; i<=N; i++) {
        		if(flag[i] || map[cur.tar][i] == MAX) continue;
        		if(dis[i] > (dis[cur.tar] + map[cur.tar][i])) {
        			dis[i] = dis[cur.tar] + map[cur.tar][i];
        			pq.offer(new Pos(i, dis[i]));
        		}
        	}
        }
        
        for(int i=1; i<=N; i++) {
        	if(dis[i] <= K) answer++;
        }
        
        return answer;
    }
}
