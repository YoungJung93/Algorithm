package Problem;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_카카오프렌즈컬러링북 {

	public static void main(String[] args) {
		int m = 6;
		int n = 4;
		int[][] picture = {
				{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1},
				{0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}	
		};
		
		int[] answer = solution(m, n, picture);
		System.out.println(Arrays.toString(answer));
	}
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	public static int[] solution(int m, int n, int[][] picture) {
		int area = 0;
		int max_area = 0;
		
		boolean[][] flag = new boolean[m][n];
		for(int r=0; r<m; r++) {
			for(int c=0; c<n; c++) {
				if(picture[r][c] == 0 || flag[r][c]) continue;
				area++;
				Queue<Integer> que = new LinkedList<>();
				que.offer(r); que.offer(c);
				int color = picture[r][c];
				flag[r][c] = true;
				int vol_area = 1;
				while(!que.isEmpty()) {
					int curR = que.poll();
					int curC = que.poll();
					for(int i=0; i<4; i++) {
						int dx = curR + dr[i];
						int dy = curC + dc[i];
						if(dx<0 || dy<0 || dx>=m || dy>=n) continue;
						if(picture[dx][dy] != color) continue;
						if(flag[dx][dy]) continue;
						flag[dx][dy] = true;
						que.offer(dx); que.offer(dy);
						vol_area++;
					}
				}
				if(vol_area > max_area) max_area = vol_area;
			}
		}
		
		return new int[] {area, max_area};
	}
}
