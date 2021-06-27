package Problem;

public class Solution_DP_타일장식물 {
	static int N;
	static long answer;
	public static void main(String[] args) {
		N = 5;
		N = 6;
		answer = 0;
		
		long[] arr = new long[N+2];
		
		arr[1] = 1;
		arr[2] = 1;
		for(int i=3; i<=N+1; i++) {
			arr[i] = arr[i-2] + arr[i-1];
		}
		answer = arr[N+1]*2 + arr[N]*2;
		
		System.out.println(answer);
	}
}
