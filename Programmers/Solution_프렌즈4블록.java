package Problem;

import java.util.ArrayList;
import java.util.List;

public class Solution_프렌즈4블록 {

	public static void main(String[] args) {
//		int m = 4;
//		int n = 5;
//		String[] board = {
//				"CCBDE", "AAADE", "AAABF", "CCBBF"
//		};
		
		int m = 6;
		int n = 6;
		String[] board = {
				"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"
		};
		
		int answer = solution(m, n, board);
		System.out.println(answer);
	}
	public static int solution(int m, int n, String[] board) {
        int answer = 0;
        
        int[][] map = new int[m][n];
        for(int i=0; i<m; i++) {
        	for(int j=0; j<n; j++) {
        		char c = board[i].charAt(j);
        		map[i][j] = (int)(c-'A')+1;
        	}
        }
        
        while(true) {
        	List<int[]> removeList = new ArrayList<>();
        	for(int i=0; i<m-1; i++) {
        		for(int j=0; j<n-1; j++) {
        			if(map[i][j] == 0) continue;
        			if((map[i][j] == map[i][j+1]) && (map[i+1][j] == map[i+1][j+1])
        					&& (map[i][j] == map[i+1][j])) {
        				removeList.add(new int[] {i, j});
        			}
        		}
        	}
        	if(removeList.isEmpty()) break;
        	
        	for(int i=0, size=removeList.size(); i<size; i++) {
        		int[] arr = removeList.get(i);
        		if(map[arr[0]][arr[1]] != 0) {
        			map[arr[0]][arr[1]] = 0;
        			answer++;
        		}
        		if(map[arr[0]][arr[1]+1] != 0) {
        			map[arr[0]][arr[1]+1] = 0;
        			answer++;
        		}
        		if(map[arr[0]+1][arr[1]] != 0) {
        			map[arr[0]+1][arr[1]] = 0;
        			answer++;
        		}
        		if(map[arr[0]+1][arr[1]+1] != 0) {
        			map[arr[0]+1][arr[1]+1] = 0;
        			answer++;
        		}
        	}
        	
        	for(int j=0; j<n; j++) {
        		for(int i=m-1; i>=0; i--) {
        			if(map[i][j] != 0) {
        				int r = i+1;
        				while(r < m) {
        					if(map[r][j] == 0) {
        						r++;
        					} else break;
        				}
        				if(r-1 != i) {
        					map[r-1][j] = map[i][j];
        					map[i][j] = 0;
        				}
        			}
        		}
        	}
        }
        
        return answer;
    }
}
