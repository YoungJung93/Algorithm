package Problem;

import java.util.Arrays;

public class Solution_삼각달팽이 {

	public static void main(String[] args) {
//		int n = 4;
//		int n = 5;
//		int n = 6;
		int n = 1000;
		
		int[] answer = solution(n);
		System.out.println(Arrays.toString(answer));
	}
	public static int[] solution(int n) {
        int len = 0;
        for(int i=1; i<=n; i++) len += i;
		
		int[] answer = new int[len];
        
		int dir = 0; // 0 : 아래, 1 : 오른, 2 : 위
        int[][] map = new int[n+1][n+1];
        
        // 아래로 갈 때 : r + 1
        // 오른쪽으로 갈 때 : c + 1
        // 위로 갈 때 : r - 1, c - 1
        int num = 1;
        int r = 1;
        int c = 1;
        while(true) {
        	if(dir == 0) {
        		if(r+1 > n || map[r+1][c] != 0) {
        			if(c+1 > r || map[r][c+1] != 0) {
        				map[r][c] = num;
        				break;  
        			}
        			dir++;
        		} else {
        			map[r][c] = num++;
        			r++;
        		}
        	} else if(dir == 1) {
        		if(c+1 > r || map[r][c+1] != 0) {
        			if(r-1 < 1 || c-1 < 1 || map[r-1][c-1] != 0) {
        				map[r][c] = num;
        				break;
        			}
        			dir++;
        		} else {
        			map[r][c] = num++;
        			c++;
        		}
        	} else {
        		if(r-1 < 1 || c-1 < 1 || map[r-1][c-1] != 0) {
        			if(r+1 > n || map[r+1][c] != 0) {
        				map[r][c] = num;
        				break;
        			}
        			dir = 0;
        		} else {
        			map[r][c] = num++;
        			r--; c--;
        		}
        	}
        }
        
        for(int i=1, ind=0; i<=n; i++) {
        	for(int j=1; j<=n; j++) {
        		if(map[i][j] != 0) {
        			answer[ind++] = map[i][j];
        		}
        	}
        }
        
        return answer;
    }
}
