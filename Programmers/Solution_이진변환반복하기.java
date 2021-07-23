package Problem;

import java.util.Arrays;

public class Solution_이진변환반복하기 {

	public static void main(String[] args) {
//		String s = "110010101001";
//		String s = "01110";
		String s = "1111111";
		
		int[] answer = solution(s);
		System.out.println(Arrays.toString(answer));
	}
	public static int[] solution(String s) {
        int[] answer = new int[2];
        
        int a = 0;
        int b = 0;
        while(true) {
        	a++;
        	// s의 모든 0을 제거
        	String after = s.replaceAll("0", "");
        	b += (s.length() - after.length());
        	s = after;
        	// s를 s의 길이로
        	s = Integer.toBinaryString(s.length());
        	// s가 1이면 종료
        	if(s.equals("1")) break;
        }
        answer[0] = a;
        answer[1] = b;
        
        return answer;
    }
}
