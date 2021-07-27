package Problem;

import java.util.Stack;

public class Solution_짝지어제거하기 {

	public static void main(String[] args) {
		String s = "baabaa";
//		String s = "cdcd";
		
		int answer = solution(s);
		System.out.println(answer);
	}
	public static int solution(String s)
    {
		if(s.length() % 2 == 1) return 0;
		
		Stack<Character> stack = new Stack<>();
		int sLen = s.length();
		for(int i=0; i<sLen; i++) {
			char c = s.charAt(i);
			if(!stack.isEmpty() && stack.peek() == c) {
				stack.pop();
			} else {
				stack.push(c);
			}
		}
		
		if(stack.isEmpty()) return 1;
		else return 0;
    }
}
