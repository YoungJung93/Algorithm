package Problem;

public class Solution_괄호변환 {
	public static void main(String[] args) {
//		String p = "(()())()";
//		String p = ")(";
		String p = "()(())()";
		
		String answer = solution(p);
		System.out.println(answer);
	}
	public static String solution(String p) {
		String answer = "";
		
		if(isRight(p)) {
			return p;
		}
		res = "";
		go(p);
		answer = res;
		
		return answer;
	}
	public static String res;
	public static void go(String w) {
		int wLen = w.length();
		if(wLen == 0) return;
		int wInd = 0;
		String u = "";
		String v = "";
		int i=0;
		for(i=2; i+wInd<=wLen; i+=2) {
			u = w.substring(wInd, wInd+i);
			if(isBalance(u)) {
				v = w.substring(wInd+i, wLen);
				break;
			}
		}
		if(isRight(u)) {
			res += u;
			go(v);
		} else {
			res += "(";
			go(v);
			res += ")";
			for(int j=1, len=u.length(); j<len-1; j++) {
				char c = u.charAt(j);
				if(c == '(') {
					res += ")";
				} else {
					res += "(";
				}
			}
		}
	}
	
	public static boolean isBalance(String str) {
		int len = str.length();
		int open = 0, close = 0;
		for(int i=0; i<len; i++) {
			char c = str.charAt(i);
			if(c == '(') open++;
			else close++;
		}
		return open == close;
	}
	public static boolean isRight(String str) {
		int len = str.length();
		int open = 0;
		for(int i=0; i<len; i++) {
			char c = str.charAt(i);
			if(c == '(') {
				open++;
			} else {
				if(open == 0) return false;
				open--;
			}
		}
		return open == 0;
	}
}
