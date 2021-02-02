package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1149_RGB거리 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][3];
		int[][] cost = new int[n][3];
		StringTokenizer st;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
			cost[i][0] = arr[i][0];
			cost[i][1] = arr[i][1];
			cost[i][2] = arr[i][2];
		}
		for(int i=1; i<n; i++) {
			arr[i][0] = Math.min(arr[i-1][1], arr[i-1][2]) + cost[i][0];
			arr[i][1] = Math.min(arr[i-1][0], arr[i-1][2]) + cost[i][1];
			arr[i][2] = Math.min(arr[i-1][0], arr[i-1][1]) + cost[i][2];
		}
		int a = Math.min(arr[n-1][0], arr[n-1][1]);
		int b = Math.min(arr[n-1][1], arr[n-1][2]);
		System.out.println(Math.min(a, b));
	}
}
