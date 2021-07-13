package Problem;

public class Solution_예상대진표 {

	public static void main(String[] args) {
		int n = 8;
		int a = 4;
		int b = 7;
		
		int answer = solution(n, a, b);
		System.out.println(answer);
	}
	public static int solution(int n, int a, int b) {
        int answer = 1;

        --a; --b;
        while(true) {
        	a /= 2;
        	b /= 2;
        	if(a == b) {
        		break;
        	}
        	answer++;
        }
        
        return answer;
    }
}
