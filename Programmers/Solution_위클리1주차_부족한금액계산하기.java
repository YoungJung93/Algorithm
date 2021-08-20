package Problem;

public class Solution_위클리1주차_부족한금액계산하기 {

	public static void main(String[] args) {
		int price = 3;
		int money = 20;
		int count = 4;
		
		System.out.println(solution(price, money, count));
	}
	public static long solution(int price, int money, int count) {
        long answer = money;

        for(int n=1; n<=count; n++) {
        	answer -= (n * price);
        }
        if(answer >= 0) return 0;
        
        return (answer * -1);
    }
}
