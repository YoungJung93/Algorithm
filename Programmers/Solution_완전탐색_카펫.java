package Problem;

import java.util.Arrays;

public class Solution_완전탐색_카펫 {
	static int brown, red;
	static int[] answer;
	public static void main(String[] args) {
		brown = 10;
		red = 2;
		
		answer = new int[2];
		int area = brown + red;
		int garo=0, sero=0;
		for(garo=3; garo<=area/2; garo++) {
			sero = area/garo;
			if(garo*sero != area) continue;
			if(sero <= 2 || garo < sero) continue;
			if(brown==((garo*2)+(sero*2)-4) && red==((garo-2)*(sero-2))) {
				answer[0] = garo;
				answer[1] = sero;
				break;
			}
		}
		
		System.out.println(Arrays.toString(answer));
	}
}
