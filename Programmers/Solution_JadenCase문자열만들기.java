package Problem;

public class Solution_JadenCase문자열만들기 {

	public static void main(String[] args) {
//		String s = "3people unFollowed me";
		String s = "for the last  week ";
//		String s = "     ";
		
		String answer = solution(s);
		System.out.println(answer);
	}
	public static String solution(String s) {
        StringBuilder answer = new StringBuilder();
        
        s = s.toLowerCase();
        
        int sLen = s.length();
        boolean isFirstAlpha = true;
        for(int i=0; i<sLen; i++) {
        	char c = s.charAt(i);
        	if(c == ' ') {
        		answer.append(c);
        		isFirstAlpha = true;
        	} else if(Character.isAlphabetic(c)) {
        		if(isFirstAlpha) {
        			answer.append(Character.toUpperCase(c));
        		} else {
        			answer.append(c);
        		}
        		isFirstAlpha = false;
        	} else {
        		answer.append(c);
        		isFirstAlpha = false;
        	}
        }
        
        return answer.toString();
    }
}
