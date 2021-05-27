package Problem;

public class Solution_연습문제_124나라의숫자 {
	public static void main(String[] args) {
		int n = 33;
		String answer = solution(n);
		System.out.println(answer);
	}
	public static String solution(int n) {
		String answer = "";
		int num = n;
		for(int i=3; ;i*=3) {
			int mod = num % i;
			if(mod == 0) {
				answer = "4" + answer;
			} else if(mod == (i*1/3)) {
				answer = "1" + answer;
			} else {
				answer = "2" + answer;
			}
			num -= (mod==0 ? i : mod);
			if(num <= 0) break;
		}
		return answer;
	}
}
