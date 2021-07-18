package Problem;

import java.util.Stack;

public class Solution_괄호회전하기 {

	public static void main(String[] args) {
//		String s = "[](){}";
//		String s = "}]()[{";
//		String s = "[)(]";
		String s = "}}}";
		
		int answer = solution(s);
		System.out.println(answer);
	}
	public static int solution(String s) {
        int answer = 0;
        
        int len = s.length();
        
        for(int i=0; i<len; i++) {
        	String sub = s.substring(i, len) + s.substring(0, i);
        	if(isRight(sub)) answer++;
        }
        
        return answer;
    }
	public static boolean isRight(String s) {
		int len = s.length();
		if(len % 2 == 1) return false;
		Stack<Character> stack = new Stack<>();
		for(int i=0; i<len; i++) {
			char c = s.charAt(i);
			switch(c) {
			case '{' :
				stack.push(c);
				break;
			case '[' :
				stack.push(c);
				break;
			case '(' :
				stack.push(c);
				break;
			case '}' :
				if(stack.isEmpty()) return false;
				if(stack.peek() != '{') return false;
				stack.pop();
				break;
			case ']' :
				if(stack.isEmpty()) return false;
				if(stack.peek() != '[') return false;
				stack.pop();
				break;
			case ')' :
				if(stack.isEmpty()) return false;
				if(stack.peek() != '(') return false;
				stack.pop();
				break;
			}
		}
		return true;
	}
}
