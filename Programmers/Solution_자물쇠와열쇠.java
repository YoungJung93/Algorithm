package 카카오기출;

public class Solution_자물쇠와열쇠 {
	
	public static void main(String[] args) {
		int[][] key = {
				{0,0,0}, {1,0,0}, {0,1,1}
		};
		int[][] lock = {
				{1,1,1}, {1,1,0}, {1,0,1}
		};
		
		boolean answer = false;
		
		int n = lock.length;
		int m = key.length;
		int[][] map = new int[n+2*m-2][n+2*m-2];
		for(int i=m-1, r=0; i<n+m-1; i++, r++) {
			for(int j=m-1, c=0; j<n+m-1; j++, c++) {
				map[i][j] = lock[r][c];
			}
		}
		roof:
		for(int d=0; d<4; d++) {
			key = rotate(key);
			for(int i=0; i<n+m-1; i++) {
				for(int j=0; j<n+m-1; j++) {
					if(go(map, key, i, j)) {
						answer = true;
						break roof;
					}
				}
			}
		}
		
		System.out.println(answer);
	}
	static boolean go(int[][] map, int[][] key, int r, int c) {
		int len = map.length;
		int lenk = key.length;
		int[][] lock = new int[len][len];
		for(int i=0; i<len; i++) lock[i] = map[i].clone();
		for(int i=0; i<lenk; i++) {
			for(int j=0; j<lenk; j++) {
				lock[i+r][j+c] = lock[i+r][j+c]!=key[i][j] ? 1 : 0;
			}
		}
		int n = len-2*lenk+2;
		for(int i=lenk-1; i<n+lenk-1; i++) {
			for(int j=lenk-1; j<n+lenk-1; j++) {
				if(lock[i][j] == 0) return false;
			}
		}
		return true;
	}
	static int[][] rotate(int[][] key) {
		int len = key.length;
		int[][] copy = new int[len][len];
		for(int i=0, c=len-1; i<len; i++,c--) {
			for(int j=0, r=0; j<len; j++,r++) {
				copy[r][c] = key[i][j];
			}
		}
		return copy;
	}
}
