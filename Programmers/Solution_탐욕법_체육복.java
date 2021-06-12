package Problem;

public class Solution_탐욕법_체육복 {
	static int n, lost[], reserve[];
	static int answer;
	public static void main(String[] args) {
		lost = new int[] {
				2,4,3
//				2,4
//				3
		};
		reserve = new int[] {
				1,3,5
//				3
//				1
		};
		n = 5;
//		n = 5;
//		n = 3;
		
		answer = n-lost.length;
		
		boolean[] flag = new boolean[n+1];
		for(int i=0,size=reserve.length; i<size; i++) {
			boolean f = false;
			for(int j=0,size_=lost.length; j<size_; j++) {
				if(reserve[i] == lost[j]) {
					lost[j] = -1;
					f = true; break;
				}
			}
			if(!f) flag[reserve[i]] = true;
		}
		for(int i=0,size=lost.length; i<size; i++) {
			int a = lost[i];
			if(a == -1) {
				answer++;
				continue;
			}
			if(a>1 && flag[a-1]) {
				flag[a-1] = false;
				answer++;
			} else if(a<n && flag[a+1]) {
				flag[a+1] = false;
				answer++;
			}
		}
		
		System.out.println(answer);
	}
}
