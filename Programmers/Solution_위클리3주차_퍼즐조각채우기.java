package Problem;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution_위클리3주차_퍼즐조각채우기 {

	public static void main(String[] args) {
		int[][] game_board = {
//				{1,1,0,0,1,0},{0,0,1,0,1,0},{0,1,1,0,0,1},{1,1,0,1,1,1},{1,0,0,0,1,0},{0,1,1,1,0,0}
				{0,0,0},{1,1,0},{1,1,1}
		};
		int[][] table = {
//				{1,0,0,1,1,0},{1,0,1,0,1,0},{0,1,1,0,1,1},{0,0,1,0,0,0},{1,1,0,1,1,0},{0,1,0,0,0,0}
				{1,1,1},{1,0,0},{0,0,0}	
		};
		
		System.out.println(solution(game_board, table));
	}
	public static int solution(int[][] game_board, int[][] table) {
        int answer = 0;
        
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        
        int N = table.length;
        List<boolean[][]> puzzles = new LinkedList<>();
        List<boolean[][]> spaces = new LinkedList<>();
        for(int i=0; i<N; i++) {
        	for(int j=0; j<N; j++) {
        		if(table[i][j] == 0) continue;
        		boolean[][] flag = new boolean[N][N];
        		Queue<Integer> que = new LinkedList<>();
        		flag[i][j] = true;
        		table[i][j] = 0;
        		que.offer(i); que.offer(j);
        		while(!que.isEmpty()) {
        			int r = que.poll();
        			int c = que.poll();
        			for(int k=0; k<4; k++) {
        				int dx = r + dr[k];
        				int dy = c + dc[k];
        				if(dx<0 || dy<0 || dx>=N || dy>=N) continue;
        				if(table[dx][dy] == 0 || flag[dx][dy]) continue;
        				table[dx][dy] = 0;
        				flag[dx][dy] = true;
        				que.offer(dx); que.offer(dy);
        			}
        		}
        		int x1=Integer.MAX_VALUE, y1=Integer.MAX_VALUE;
        		int x2=Integer.MIN_VALUE, y2=Integer.MIN_VALUE;
        		for(int r=0; r<N; r++) {
        			for(int c=0; c<N; c++) {
        				if(flag[r][c]) {
        					if(r < x1) x1 = r;
        					if(r > x2) x2 = r;
        					if(c < y1) y1 = c;
        					if(c > y2) y2 = c;
        				}
        			}
        		}
        		boolean[][] puzzle = new boolean[x2-x1+1][y2-y1+1];
        		for(int r=x1; r<=x2; r++) {
        			for(int c=y1; c<=y2; c++) {
        				puzzle[r-x1][c-y1] = flag[r][c];
        			}
        		}
        		puzzles.add(puzzle);
        	}
        }
        
        for(int i=0; i<N; i++) {
        	for(int j=0; j<N; j++) {
        		if(game_board[i][j] == 1) continue;
        		boolean[][] flag = new boolean[N][N];
        		Queue<Integer> que = new LinkedList<>();
        		flag[i][j] = true;
        		game_board[i][j] = 1;
        		que.offer(i); que.offer(j);
        		while(!que.isEmpty()) {
        			int r = que.poll();
        			int c = que.poll();
        			for(int k=0; k<4; k++) {
        				int dx = r + dr[k];
        				int dy = c + dc[k];
        				if(dx<0 || dy<0 || dx>=N || dy>=N) continue;
        				if(game_board[dx][dy] == 1 || flag[dx][dy]) continue;
        				game_board[dx][dy] = 1;
        				flag[dx][dy] = true;
        				que.offer(dx); que.offer(dy);
        			}
        		}
        		int x1=Integer.MAX_VALUE, y1=Integer.MAX_VALUE;
        		int x2=Integer.MIN_VALUE, y2=Integer.MIN_VALUE;
        		for(int r=0; r<N; r++) {
        			for(int c=0; c<N; c++) {
        				if(flag[r][c]) {
        					if(r < x1) x1 = r;
        					if(r > x2) x2 = r;
        					if(c < y1) y1 = c;
        					if(c > y2) y2 = c;
        				}
        			}
        		}
        		boolean[][] space = new boolean[x2-x1+1][y2-y1+1];
        		for(int r=x1; r<=x2; r++) {
        			for(int c=y1; c<=y2; c++) {
        				space[r-x1][c-y1] = flag[r][c];
        			}
        		}
        		spaces.add(space);
        	}
        }
        
        int puzzleLen = puzzles.size();
        for(int i=0; i<puzzleLen; i++) {
        	boolean[][] puzzle = puzzles.get(i);
        	int spaceLen = spaces.size();
        	space:
        	for(int j=0; j<spaceLen; j++) {
        		boolean[][] space = spaces.get(j);
        		for(int k=0; k<4; k++) {
        			space = rotate(space);
        			if(isMatch(space, puzzle)) {
        				for(int r=0, R=space.length, C=space[0].length; r<R; r++) {
        					for(int c=0; c<C; c++) {
        						if(space[r][c]) answer++;
        					}
        				}
        				spaces.remove(j);
        				break space;
        			}
        		}
        	}
        }
        
        return answer;
    }
	public static boolean isMatch(boolean[][] space, boolean[][] puzzle) {
		if(space.length != puzzle.length) return false;
		if(space[0].length != puzzle[0].length) return false;
		
		int R = space.length;
		int C = space[0].length;
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(space[i][j] != puzzle[i][j]) return false;
			}
		}
		return true;
	}
	public static boolean[][] rotate(boolean[][] arr) {
		int R = arr.length;
		int C = arr[0].length;
		boolean[][] tmp = new boolean[C][R];
		for(int i=0, c=R-1; i<R; i++, c--) {
			for(int j=0, r=0; j<C; j++, r++) {
				tmp[r][c] = arr[i][j];
			}
		}
		return tmp;
	}
}
