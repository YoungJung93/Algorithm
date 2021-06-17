package Problem;

public class Solution_힙_라면공장 {
	static int stock, dates[], supplies[], k;
	static int answer;
	public static void main(String[] args) {
		stock = 4;
		dates = new int[] {4,10,15};
		supplies = new int[] {20,5,10};
		k = 30;
		answer = 0;
		
		boolean[] flag = new boolean[dates.length];
		int day = 0;
		while(day<k-1) {
			day++;
			stock--;
			if(stock==0) {
				int ind = 0, max = 0;
				for(int i=0, size=dates.length; i<size; i++) {
					if(flag[i]) continue;
					if(dates[i] > day) break;
					if(supplies[i] > max) {
						ind = i;
						max = supplies[i];
					}
				}
				flag[ind] = true;
				stock += supplies[ind];
				answer++;
			}
		}
		
		System.out.println(answer);
	}
}
