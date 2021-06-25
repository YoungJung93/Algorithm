package Problem;

public class Solution_DP_정수삼각형 {
	static int[][] triangle;
	static int answer;
	public static void main(String[] args) {
		triangle = new int[][] {
			{7}, {3,8}, {8,1,0}, {2,7,4,4}, {4,5,2,6,5}
		};
		answer = 0;
		
		int len = triangle.length;
		
		for(int i=1; i<len; i++) {
			for(int j=0,size=triangle[i].length; j<size; j++) {
				int a = 0;
				if(j-1>=0 && j<triangle[i-1].length) {
					// 양 쪽이 다 가능할 때 - 둘 중 큰 수
					a = triangle[i-1][j] >= triangle[i-1][j-1] ? triangle[i-1][j] : triangle[i-1][j-1];
				} else if(j-1 < 0) {
					// 오른쪽만 가능할 때 - 오른쪽 수
					a = triangle[i-1][j];
				} else {
					// 왼쪽만 가능할 때 - 왼쪽 수
					a = triangle[i-1][j-1];
				}
				triangle[i][j] += a;
			}
		}
		
		for(int i=0; i<triangle[len-1].length; i++) {
			if(triangle[len-1][i] > answer) answer = triangle[len-1][i];
		}
		
		System.out.println(answer);
	}
}
