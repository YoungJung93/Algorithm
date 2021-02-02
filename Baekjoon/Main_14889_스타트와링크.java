package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14889_스타트와링크 {
	static int[] arr;
	static int n;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		for(int i=n/2; i<n; i++) {
			arr[i] = 1;
		}
		int[][] score = new int[n][n];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				score[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int min = Integer.MAX_VALUE;
		do {
			int startP = 0;
			int linkP = 0;
			int[] start = new int[n/2]; 
			int[] link = new int[n/2];
			for(int i=0,j=0,k=0; i<n; i++) {
				if(arr[i]==1) start[j++] = i;
				else link[k++] = i;
			}
			// 스타트팀 점수 구하기
			for(int i=0, size=start.length; i<size-1; i++) {
				for(int j=i+1; j<size; j++) {
					startP += score[start[i]][start[j]];
					startP += score[start[j]][start[i]];
					linkP += score[link[i]][link[j]];
					linkP += score[link[j]][link[i]];
				}
			}
			if(min > Math.abs(startP-linkP)) min = Math.abs(startP-linkP);
		} while(np());
		
		System.out.println(min);
	}
	static boolean np() {
		int i = n-1;
		while(i>0 && arr[i-1] >= arr[i]) --i;
		if(i==0) return false;
		int j = n-1;
		while(arr[i-1] >= arr[j]) --j;
		swap(i-1, j);
		j = n-1;
		while(i<j) swap(i++, j--);
		return true;
	}
	static void swap(int x, int y) {
		int tmp = arr[x];
		arr[x] = arr[y];
		arr[y] = tmp;
	}
}
