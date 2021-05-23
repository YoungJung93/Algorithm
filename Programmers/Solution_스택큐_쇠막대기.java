package Problem;

import java.util.Stack;

public class Solution_스택큐_쇠막대기 {
	static String arrangement;
	static int answer;
	public static void main(String[] args) {
		arrangement = "()(((()())(())()))(())";
		
		Stack<Character> stack = new Stack<>();
		for(int i=0, size=arrangement.length(); i<size; i++) {
			char c = arrangement.charAt(i);
			if(c == '(' && arrangement.charAt(i+1)==')') { // 레이져일 경우
				answer += stack.size();
				i++;
			} else if(c == '(') {
				stack.push('(');
				answer++;
			} else {
				stack.pop();
			}
		}
		
		System.out.println(answer);
	}
}
