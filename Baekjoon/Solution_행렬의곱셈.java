package Problem;

import java.util.Arrays;

public class Solution_행렬의곱셈 {

	public static void main(String[] args) {
		int[][] arr1 = {
//				{1,4},{3,2},{4,1}
				{2,3,2},{4,2,4},{3,1,4}
		};
		int[][] arr2 = {
//				{3,3},{3,3}
				{5,4,3},{2,4,1},{3,1,1}
		};
		
		int[][] answer = solution(arr1, arr2);
		for(int i=0, size=answer.length; i<size; i++) {
			System.out.println(Arrays.toString(answer[i]));
		}
	}
	public static int[][] solution(int[][] arr1, int[][] arr2) {
        int R = arr1.length;
        int C = arr2.length;
        int C2 = arr2[0].length;
        
        int[][] answer = new int[R][C2];
        for(int i=0; i<R; i++) {
        	for(int j=0; j<C2; j++) {
        		int res = 0;
        		for(int c=0; c<C; c++) {
        			res += (arr1[i][c]*arr2[c][j]);
        		}
        		answer[i][j] = res;
        	}
        }
        
        return answer;
    }
}
