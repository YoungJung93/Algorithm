package Problem;

import java.math.BigInteger;
import java.util.Scanner;

public class Solution_7853_오타 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		BigInteger result;
		for(int i=0; i<T; ++i) {
			result = new BigInteger("1");
			String N = sc.nextLine();
			int size = N.length();
			for(int j=0, size_=N.length(); j<size_; ++j) {
				if(j==0) result = result.multiply(BigInteger.valueOf(dif('0', N.charAt(j), N.charAt(j+1))));
				else if(j==(size_-1)) result = result.multiply(BigInteger.valueOf(dif(N.charAt(j-1), N.charAt(j), '0')));
				else result = result.multiply(BigInteger.valueOf(dif(N.charAt(j-1), N.charAt(j), N.charAt(j+1))));
			}
			result = result.mod(BigInteger.valueOf(1000000007));
			System.out.println("#" + (i+1) + " " + result);
		}
	}
	public static int dif(char before, char n, char after) { // 앞, 뒤가 모두 같을 때 1, 앞이나 뒤 중 하나와 같을 때 2, 모두 다를 때 3
		int result = 1;
		if(before == '0') {
			if(n!=after) result++;
		}
		else if(after == '0') {
			if(n!=before) result++;
		}
		else {
			if(n!=before) result++;
			if(n!=after && after!=before) result++;
		}
		return result;
	}
}
