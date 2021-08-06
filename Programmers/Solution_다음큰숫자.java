package Problem;

public class Solution_다음큰숫자 {

	public static void main(String[] args) {
		int n = 78;
//		int n = 15;
		
		int answer = solution(n);
		System.out.println(answer);
	}
	public static int solution(int n) {
        int answer = 0;
        
        int base = Integer.bitCount(n);
        for(int i=n+1; ; i++) {
        	if(base == Integer.bitCount(i)) {
        		answer = i;
        		break;
        	}
        }
        
        return answer;
    }
}
