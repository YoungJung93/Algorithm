package Problem;

public class Solution_n진수게임 {

	public static void main(String[] args) {
//		int n = 2;
//		int t = 4;
//		int m = 2;
//		int p = 1;
//		int n = 16;
//		int t = 16;
//		int m = 2;
//		int p = 1;
		int n = 16;
		int t = 16;
		int m = 2;
		int p = 2;
		
		System.out.println(solution(n, t, m, p));
	}
	public static String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        
        StringBuilder sb = new StringBuilder();
        
        int num = 0;
        while(sb.length() < m*t) {
        	sb.append(convert(num, n));
        	num++;
        }
        
        for(int i=p-1, j=0; j<t*m; j+=m) {
        	answer.append(sb.charAt(i+j));
        }
        
        return answer.toString();
    }
	public static String convert(int num, int n) {
		StringBuilder answer = new StringBuilder();
		
		int mod = 0;
		while(true) {
			mod = num % n;
			num = num / n;
			if(mod >= 10) {
				answer.insert(0, (char)('A' + (mod-10)));
			} else {
				answer.insert(0, mod);
			}
			if(num == 0) break;
		}
		
		return answer.toString();
	}
}
