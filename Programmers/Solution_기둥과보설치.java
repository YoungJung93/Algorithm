package 카카오기출;

import java.util.Arrays;
import java.util.Comparator;

public class Solution_기둥과보설치 {
	
	public static void main(String[] args) {
		int[][] build_frame = {
//				{1,0,0,1},{1,1,1,1},{2,1,0,1},
//				{2,2,1,1},{5,0,0,1},{5,1,0,1},
//				{4,2,1,1},{3,2,1,1}
				
//				{0,0,0,1},{2,0,0,1},{4,0,0,1},{0,1,1,1},
//				{1,1,1,1},{2,1,1,1},{3,1,1,1},{2,0,0,0},
//				{1,1,1,0},{2,2,0,1}
				
				{0,0,0,1},{0,1,0,1},{0,2,0,1},{0,3,1,1},
				{3,0,0,1},{3,1,0,1},{3,2,0,1},{2,3,1,1},
				{1,3,1,1},{1,3,1,0}
		};
//		int n = 5;
		int n = 3;
		
		int[][] answer = {};
		
		int[][] bo = new int[n][n+1];
		int[][] ki = new int[n+1][n];
		int len = 0;
		for(int d=0,size=build_frame.length; d<size; d++) {
			int r = build_frame[d][0];
			int c = build_frame[d][1];
			if(build_frame[d][2] == 0) {	// 기둥
				if(build_frame[d][3] == 1) {	// 설치
					boolean f = false;
					if(c == 0) f = true;
					if(!f && (c-1>=0 && ki[r][c-1] == 1)) f = true;
					if(!f && ((r-1>=0 && bo[r-1][c]==1) || bo[r][c]==1)) f = true;
					if(f) {
						ki[r][c] = 1;
						len++;
					}
				} else if(ki[r][c] == 1) {						// 삭제
					// 
					if(c+1<=n && (r-1>=0 && bo[r-1][c+1]==bo[r][c+1])) {
						ki[r][c] = 0;
						len--;
					}
				}
			} else {						// 보
				if(build_frame[d][3] == 1) {	// 설치
					boolean f = false;
					if(c-1>=0 && (ki[r][c-1]==1 || (r+1<=n && ki[r+1][c-1]==1))) f = true;
					if(!f && (r-1>=0 && r+1<n && bo[r-1][c]==1 && bo[r+1][c]==1)) f = true;
					if(f) {
						bo[r][c] = 1;
						len++;
					}
				} else if(bo[r][c] == 1) {						// 삭제
					boolean f1 = false, f2 = false;
					if(r>0 && bo[r-1][c]==1) {
						if((r-1>=0 && c-1>=0 && ki[r-1][c-1]==1) || (c-1>=0 && ki[r][c-1]==1)) f1 = true;
					} 
					if(r+1<n && bo[r+1][c]==1) {
						if((r+1<=n && c-1>=0 && ki[r+1][c-1]==1) || (r+2<=n && c-1>=0 && ki[r+2][c-1]==1)) f2 = true;
					} 
					if((r<1 || bo[r-1][c]==0) || (r+1>=n || bo[r+1][c]==0)) {
						f1 = true;
						f2 = true;
					}
					if(f1 && f2) {
						bo[r][c] = 0;
						len--;
					}
				}
			}
		}
		answer = new int[len][3];
		int ind = 0;
		for(int i=0; i<n+1; i++) {
			for(int j=0; j<n; j++) {
				if(ki[i][j] == 1) {
					answer[ind][0] = i;
					answer[ind][1] = j;
					answer[ind][2] = 0;
					ind++;
				}
			}
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<n+1; j++) {
				if(bo[i][j] == 1) {
					answer[ind][0] = i;
					answer[ind][1] = j;
					answer[ind][2] = 1;
					ind++;
				}
			}
		}
		Arrays.sort(answer, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]) {
					if(o1[1] == o2[1]) return Integer.compare(o1[2], o2[2]);
					else return Integer.compare(o1[1], o2[1]);
				}
				return Integer.compare(o1[0], o2[0]);
			}
		});
		
		for(int i=0; i<answer.length; i++) {
			System.out.println(Arrays.toString(answer[i]));
		}
	}
}
