package Problem;

public class Solution_탐욕법_큰수만들기 {
	static String number;
	static int k;
	static String answer;
	
	public static void main(String[] args) {
		number = "1924";
//		number = "1231234";
//		number = "4177252841";
		number = "000010000";
		
		k=2;
//		k=3;
//		k=4;
		k=5;
		
		answer = "";
		
		while (true) {
			if(isSame(number)) {
				number = number.substring(k);
				break;
			}
			int ind = max(number.substring(0,k+1));
			if(ind == 0) {
				answer += number.charAt(0);
				number = number.substring(1);
			} else {
				answer += number.charAt(ind);
				number = number.substring(ind+1);
				k -= ind;
			}
			if(k==0) break;
		}
		answer += number;
		
		System.out.println(answer);
	}
	static boolean isSame(String s) {
		boolean f = true;
		char c = s.charAt(0);
		for(int i=1, size=s.length(); i<size; i++) {
			if(c != s.charAt(i)) {
				f = false; break;
			}
		}
		return f;
	}
	static int max(String s) {
		int max = -1, maxInd=-1;
		for(int i=0, size=s.length(); i<size; i++) {
			int a = s.charAt(i) - '0';
			if(max < a) {
				max = a;
				maxInd = i;
			}
		}
		return maxInd;
	}
}
