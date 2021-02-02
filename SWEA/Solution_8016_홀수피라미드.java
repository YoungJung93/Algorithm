package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Solution_8016_홀수피라미드 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		BigInteger left, right;
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(in.readLine());
			left = new BigInteger("1");
			right = new BigInteger("1");
			if(!BigInteger.valueOf(N).equals(1)) {
				left = BigInteger.valueOf(N).subtract(BigInteger.valueOf(2));
				left = left.multiply(BigInteger.valueOf(2)).multiply(BigInteger.valueOf(N));
				left = left.add(BigInteger.valueOf(3));
				right = BigInteger.valueOf(N).multiply(BigInteger.valueOf(2));
				right = right.multiply(BigInteger.valueOf(N));
				right = right.subtract(BigInteger.valueOf(1));
			}
			System.out.printf("#%d %d %d\n", i + 1, left, right);
		}
	}
}