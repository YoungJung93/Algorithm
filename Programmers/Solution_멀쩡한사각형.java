package Problem;

public class Solution_멀쩡한사각형 {

	public static void main(String[] args) {
		int w = 8;
		int h = 12;
		
		long answer = solution(w, h);
		System.out.println(answer);
	}
	public static long solution(int w, int h) {
        long answer = 1;
        
        long gcd = GCD((long)w, (long)h);
        answer = (((long)w * (long)h) - (((long)w/gcd + (long)h/gcd) - 1) * gcd);
        
        return answer;
    }
	public static long GCD(long a, long b) {
		while(b > 0) {
			long tmp = a;
			a = b;
	        b = tmp % b;
		}
		return a;
	}
}
