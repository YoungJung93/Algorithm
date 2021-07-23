package Problem;

public class Solution_점프와순간이동 {

	public static void main(String[] args) {
		int n = 5;
//		int n = 6;
//		int n = 5000;
		
		int answer = solution(n);
		System.out.println(answer);
	}
	public static int solution(int n) {
        int answer = 0;

        while(n > 0) {
        	if(n % 2 == 1) {
        		answer++;
        		n--;
        	} else {
        		n /= 2;
        	}
        }

        return answer;
    }
}
