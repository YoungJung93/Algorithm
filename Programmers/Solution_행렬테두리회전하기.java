package Problem;

import java.util.Arrays;

public class Solution_행렬테두리회전하기 {

	public static void main(String[] args) {
//		int rows = 6;
//		int columns = 6;
//		int rows = 3;
//		int columns = 3;
		int rows = 100;
		int columns = 97;
		int[][] queries = {
//				{2,2,5,4},{3,3,6,6},{5,1,6,3}
//				{1,1,2,2},{1,2,2,3},{2,1,3,2},{2,2,3,3}
				{1,1,100,97}
		};
		
		int[] answer = solution(rows, columns, queries);
		System.out.println(Arrays.toString(answer));
	}
	public static int[] solution(int rows, int columns, int[][] queries) {
		int ansLen = queries.length;
        int[] answer = new int[ansLen];

        int[][] map = new int[rows][columns];
        for(int i=0, num=1; i<rows; i++) {
        	for(int j=0; j<columns; j++) {
        		map[i][j] = num++;
        	}
        }
        
        for(int t=0; t<ansLen; t++) {
        	int x1 = queries[t][0]-1;
        	int y1 = queries[t][1]-1;
        	int x2 = queries[t][2]-1;
        	int y2 = queries[t][3]-1;
        	
        	int tmp = map[x1][y1];
        	int min = tmp;
        	
        	for(int x=x1+1; x<=x2; x++) {
        		map[x-1][y1] = map[x][y1];
        		if(map[x-1][y1] < min) min = map[x-1][y1];
        	}
        	for(int y=y1+1; y<=y2; y++) {
        		map[x2][y-1] = map[x2][y];
        		if(map[x2][y-1] < min) min = map[x2][y-1];
        	}
        	for(int x=x2-1; x>=x1; x--) {
        		map[x+1][y2] = map[x][y2];
        		if(map[x+1][y2] < min) min = map[x+1][y2];
        	}
        	for(int y=y2-1; y>y1; y--) {
        		map[x1][y+1] = map[x1][y];
        		if(map[x1][y+1] < min) min = map[x1][y+1];
        	}
        	map[x1][y1+1] = tmp;
        	if(map[x1][y1+1] < min) min = map[x1][y1+1];
        	
        	answer[t] = min;
        }
        
        return answer;
    }
}
