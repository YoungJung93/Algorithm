package Problem;

import java.util.Scanner;

public class Solution_7985_RootedBinaryTree재구성 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] arr;
		for(int i=0; i<T; i++) {
			double K = sc.nextDouble();
			int result;
			int k = (int)Math.pow(2.0, K) - 1;
			arr = new int[k];
			for(int j=0; j<k; j++) {
				arr[j] = sc.nextInt();
			}
			int len = arr.length;
			System.out.print("#" + (i+1) + " ");
			for(int j=1; j<=K; j++) {
				for(k=1; k<=(int)Math.pow(2.0, (double)(j-1)); k++) {
					result = arr[(len / (int)Math.pow(2.0, (double)j)) + k-1 +
							((len / (int)Math.pow(2.0, (double)(j-1)) * (k-1)))];
					System.out.print(result + " ");
				}
				System.out.println();
			}
		}
	}
}
