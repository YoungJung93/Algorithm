package Problem;

import java.util.Arrays;

public class Solution_완전탐색_모의고사 {
	static int[] answers;
	static int[] answer;
	public static void main(String[] args) {
		int[] one = {
			1,2,3,4,5
		};
		int[] two = {
			2,1,2,3,2,4,2,5
		};
		int[] three = {
			3,3,1,1,2,2,4,4,5,5
		};
		answers = new int[] {
			1,2,3,4,5
//			1,3,2,4,2
		};
		
		int a=0, aind=0, b=0, bind=0, c=0, cind=0;
		int len = answers.length;
		
		for(int i=0; i<len; i++) {
			if(one[aind]==answers[i]) a++;
			if(two[bind]==answers[i]) b++;
			if(three[cind]==answers[i]) c++;
			aind++; bind++; cind++;
			if(aind >= one.length) aind = 0;
			if(bind >= two.length) bind = 0;
			if(cind >= three.length) cind = 0;
		}
		int size = 0;
		if(a>=b && a>=c) size++;
		if(b>=a && b>=c) size++;
		if(c>=a && c>=b) size++;
		answer = new int[size];
		int ind = 0;
		if(a>=b && a>=c) answer[ind++] = 1;
		if(b>=a && b>=c) answer[ind++] = 2;
		if(c>=a && c>=b) answer[ind++] = 3;
		
		System.out.println(Arrays.toString(answer));
	}
}
