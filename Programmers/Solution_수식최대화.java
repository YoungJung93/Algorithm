package Problem;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution_수식최대화 {
	
	public static void main(String[] args) {
		String expression = "100-200*300-500+20";
		
		long answer = solution(expression);
		System.out.println(answer);
	}
	public static char[] operation;
	public static long solution(String expression) {
        long answer = 0;
        
        operation = new char[] {'+', '-', '*'};
        Arrays.sort(operation);
        
        do {
        	 List<String> nums = new LinkedList<>();
             List<Character> ops = new LinkedList<>();
             String num = "";
             for(int i=0, len=expression.length(); i<len; i++) {
             	char c = expression.charAt(i);
             	if(c=='+' || c=='-' || c=='*') {
             		nums.add(num);
             		num = "";
             		ops.add(c);
             	} else if(i==len-1) {
             		num += c;
             		nums.add(num);
             	} else {
             		num += c;
             	}
             }
        	long result = calculation(nums, ops);
        	result = Math.abs(result);
        	if(result > answer) answer = result;
        } while(np());
        
        return answer;
    }
	public static long calculation(List<String> nums, List<Character> ops) {
		for(int i=0; i<3; i++) {
			for(int j=0; j<ops.size(); j++) {
				if(ops.get(j) == operation[i]) {
					String one = nums.remove(j);
					String two = nums.remove(j);
					long res = 0;
					switch(operation[i]) {
					case '+' :
						res = Long.parseLong(one) + Long.parseLong(two);
						break;
					case '-' :
						res = Long.parseLong(one) - Long.parseLong(two);
						break;
					case '*' :
						res = Long.parseLong(one) * Long.parseLong(two);
						break;
					}
					nums.add(j, Long.toString(res));
					ops.remove(j);
					--j;
				}
			}
		}
		return Long.parseLong(nums.get(0));
	}
	public static boolean np() {
		int i = 2;
		while(i>0 && operation[i-1]>=operation[i]) i--;
		if(i==0) return false;
		int j = 2;
		while(operation[i-1]>=operation[j]) j--;
		swap(i-1, j);
		j = 2;
		while(j>i) swap(i++, j--);
		return true;
	}
	public static void swap(int x, int y) {
		char tmp = operation[x];
		operation[x] = operation[y];
		operation[y] = tmp;
	}
}
