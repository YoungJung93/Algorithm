package Problem;

public class Solution_숫자의표현 {

	public static void main(String[] args) {
		int n = 15;
		
		System.out.println(solution(n));
	}
	static int answer;
	public static int solution(int n) {
        answer = 1;
        
        for(int i=1; i<=n/2; i++) {
        	go(n, i, i);
        }
        
        return answer;
    }
	public static void go(int n, int num, int sum) {
		if(sum > n) {
			return;
		} else if(sum == n) {
			System.out.println(num);
			answer++;
			return;
		}
		go(n, num+1, sum+num+1);
	}
}
