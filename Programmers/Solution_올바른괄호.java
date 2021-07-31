package Problem;

import java.util.Stack;

public class Solution_올바른괄호 {

	public static void main(String[] args) {
//		String s = "()()";
//		String s = "(())()";
//		String s = ")()(";
		String s = "(()(";
		
		boolean answer = solution(s);
		
		System.out.println(answer);
	}
	static boolean solution(String s) {
        int len = s.length();
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<len; i++) {
        	char c = s.charAt(i);
        	if(c == '(') {
        		stack.push(c);
        	} else {
        		if(stack.isEmpty()) return false;
        		stack.pop();
        	}
        }

        return stack.isEmpty();
    }
}
