package Problem;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_게임맵최단거리 {
	public static void main(String[] args) {
		int[][] maps = {
//				{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}
				{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}
		};
		
		int answer = solution(maps);
		System.out.println(answer);
	}
	static class pos {
		int r, c, cnt;
		public pos(int r, int c, int cnt) {
			this.r = r; this.c = c; this.cnt = cnt;
		}
	}
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	public static int solution(int[][] maps) {
        int answer = -1;
        
        int n = maps.length;
        int m = maps[0].length;
        
        Queue<pos> que = new LinkedList<>();
        que.offer(new pos(0, 0, 1));
        boolean[][] flag = new boolean[n][m];
        flag[0][0] = true;
        bfs: 
        while(!que.isEmpty()) {
        	pos cur = que.poll();
        	for(int i=0; i<4; i++) {
        		int dx = cur.r + dr[i];
        		int dy = cur.c + dc[i];
        		if(dx<0 || dy<0 || dx>=n || dy>=m) continue;
        		if(flag[dx][dy] || maps[dx][dy]==0) continue;
        		if(dx == n-1 && dy == m-1) {
        			answer = cur.cnt + 1;
        			break bfs;
        		}
        		flag[dx][dy] = true;
        		que.offer(new pos(dx, dy, cur.cnt+1));
        	}
        }
        
        return answer;
    }
}
