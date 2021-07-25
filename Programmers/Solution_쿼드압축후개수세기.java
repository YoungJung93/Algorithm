package Problem;

import java.util.Arrays;

public class Solution_쿼드압축후개수세기 {

	public static void main(String[] args) {
		int[][] arr = {
				{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}
//				{1,1,1,1,1,1,1,1},{0,1,1,1,1,1,1,1},{0,0,0,0,1,1,1,1},{0,1,0,0,1,1,1,1},{0,0,0,0,0,0,1,1},{0,0,0,0,0,0,0,1},{0,0,0,0,1,0,0,1},{0,0,0,0,1,1,1,1}
		};
		
		int[] answer = solution(arr);
		System.out.println(Arrays.toString(answer));
	}
	public static int[] solution(int[][] arr) {
        int[] answer = new int[2];
        
        int n = arr.length;
        int num = 1;
        int[][] flag = new int[n][n];
        for(int div = 1; div <= n; div *= 2) {
        	int subn = n/div;
        	for(int r=0; r<n; r+=subn) {
        		for(int c=0; c<n; c+=subn) {
        			if(flag[r][c] != 0) continue;
        			boolean f = true;
        			int base = arr[r][c];
        			one:
        			for(int i=r; i<r+subn; i++) {
        				for(int j=c; j<c+subn; j++) {
        					if(arr[i][j] != base) {
        						f = false;
        						break one;
        					}
        				}
        			}
        			if(f) {
        				for(int i=r; i<r+subn; i++) {
            				for(int j=c; j<c+subn; j++) {
            					flag[i][j] = num;
            				}
            			}
        				num++;
        			}
        		}
        	}
        }
        
        boolean[] check = new boolean[num];
        for(int i=0; i<n; i++) {
        	for(int j=0; j<n; j++) {
        		if(!check[flag[i][j]]) {
        			check[flag[i][j]] = true;
        			answer[arr[i][j]]++;
        		}
        	}
        }
        
        return answer;
    }
}
