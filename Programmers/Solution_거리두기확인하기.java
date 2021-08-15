package Problem;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_거리두기확인하기 {

	public static void main(String[] args) {
		String[][] places = {
				{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
		};
		
		int[] answer = solution(places);
		System.out.println(Arrays.toString(answer));
	}
	static class Pos {
		int r, c, cnt;
		public Pos(int r, int c, int cnt) {
			this.r = r; this.c = c;
			this.cnt = cnt;
		}
	}
	public static int[] solution(String[][] places) {
        int T = places.length;
        int[] answer = new int[T];
        int N = places[0].length;
        
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        for(int t=0; t<T; t++) {
        	char[][] map = new char[N][N];
        	for(int i=0; i<N; i++) {
        		map[i] = places[t][i].toCharArray();
        	}
        	
        	boolean flag = true;
        	main:
        	for(int i=0; i<N; i++) {
        		for(int j=0; j<N; j++) {
        			if(map[i][j] != 'P') continue;
        			Queue<Pos> que = new LinkedList<>();
        			que.offer(new Pos(i, j, 0));
        			boolean[][] visit = new boolean[N][N];
        			visit[i][j] = true;
        			while(!que.isEmpty()) {
        				Pos cur = que.poll();
        				if(cur.cnt >= 2) continue;
        				for(int k=0; k<4; k++) {
        					int dx = cur.r + dr[k];
        					int dy = cur.c + dc[k];
        					if(dx<0 || dy<0 || dx>=N || dy>=N) continue;
        					if(visit[dx][dy]) continue;
        					if(map[dx][dy] == 'P') {
        						flag = false;
        						break main;
        					}
        					if(map[dx][dy] == 'X') continue;
        					visit[dx][dy] = true;
        					que.offer(new Pos(dx, dy, cur.cnt+1));
        				}
        			}
        		}
        	}
        	if(flag) answer[t] = 1;
        	else answer[t] = 0;
        }
        
        return answer;
    }
}
