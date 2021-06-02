package Problem;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution_완전탐색_소수찾기 {
	static String numbers;
	static int answer;
	static Set<Integer> set;
	public static void main(String[] args) {
		numbers = "17";
//		numbers = "011";
		numbers = "1234";
		answer = 0;
		
		set = new HashSet<>(); 
		
		go("", 0);
		answer = set.size();
		
		System.out.println(answer);
	}
	static char[] per;
	static void go(String s, int ind) {
		if(ind == numbers.length()) {
			if(s.length() != 0) {
				per = s.toCharArray();
				Arrays.sort(per);
				do {
					String st = "";
					for(int i=0, size=per.length; i<size; i++) st += per[i];
					int a = Integer.parseInt(st);
					if(isSosoo(a)) {
						set.add(a);
					}
				} while(np());
			}
			return;
		}
		go(s, ind+1);
		go(s+numbers.charAt(ind), ind+1);
	}
	static boolean np() {
		int i = per.length-1;
		while(i>0 && per[i-1]>=per[i]) i--;
		if(i==0) return false;
		int j = per.length-1;
		while(per[i-1] >= per[j]) j--;
		pswap(i-1, j);
		j = per.length-1;
		while(i<j) pswap(i++, j--);
		return true;
	}
	static void pswap(int x, int y) {
		char tmp = per[x];
		per[x] = per[y];
		per[y] = tmp;
	}
	static boolean isSosoo(int a) {
		boolean res = true;
		if(a==2) res = true;
		else if(a%2==0) res = false;
		else if(a<=1) res = false;
		else {
			for(int i=3; i<a/2; i+=2) {
				if(a%i==0) {
					res = false;
					break;
				}
			}
		}
		return res;
	}
}
