package Problem;

import java.util.Scanner;

public class Solution_3307_최장증가부분수열 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int[] result = new int[t];
		int n, len;
		int[] arr;
		int a;
		for(int i=0; i<t; i++) {
			n = sc.nextInt();
			arr = new int[n];
			for(int j=0; j<n; j++) {
				arr[j] = sc.nextInt();
			}
			for(int j=0, size=arr.length; j<size; j++) {
				len=1;
				a = arr[j];
				for(int k=j+1; k<size; k++) {
					if(a < arr[k]) {
						len++;
						a = arr[k];
					}
				}
				if(result[i] < len) result[i] = len;
			}
		}
		for(int i=0; i<t; i++) {
			System.out.println("#" + (i+1) + " " + result[i]);
		}
		sc.close();
	}
}
