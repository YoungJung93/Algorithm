package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_7728_다양성측정 {
	public static int[] index;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int i=0; i<T; i++) {
			index = new int[10];
			int result=0;
			int n = Integer.parseInt(in.readLine());
			variety(n);
			for(int j=0; j<10; j++) {
				if(index[j] != 0) result++;
			}
			System.out.println("#" + (i+1) + " " + result);
		}
	}
	public static void variety(int n) {
		if(n==0) return;
		index[n%10]++;
		variety(n/10);
	}
}
