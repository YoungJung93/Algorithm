package Problem;

public class Solution_탐욕법_조이스틱 {
	static String name;
	static int answer;
	public static void main(String[] args) {
		name = "JEROEN";
		name = "JAN";
		name = "JAAA";
		name = "AAAA";
		name = "AABABABAB";
		name = "BBAAAAAB";
		
		answer = 0;
		
		int[] move = {
			0,1,2,3,4,5,6,7,8,9,10,11,12,13,
			12,11,10,9,8,7,6,5,4,3,2,1
		};
		int len = name.length();
		int ind = 0, right=0, left=0;
		int ea = 0;
		boolean[] flag = new boolean[len];
		for(int i=0; i<len; i++) {
			if(name.charAt(i) != 'A') {
				ea++;
				flag[i] = true;
			}
		}
		
		if(ea==0 || (ea==1 && name.charAt(0)!='A')) {
			// 맨 앞을 제외한 나머지가 전부 A일 때 -> 맨 앞만 바꾸면 됨
			int a = name.charAt(0) - 'A';
			answer = move[a];
		} else {
			while(true) {
				// ind 자리의 수 변경
				char c = name.charAt(ind);
				if(name.charAt(ind) != 'A') {
					answer += move[c-'A'];
					ea--;
					flag[ind] = false;
				}
				if(ea == 0) break;
				// ind를 왼쪽으로 옮길지 오른쪽으로 옮길지 확인
				right = ind+1<len ? ind+1 : 0;
				int rightInd = 1, leftInd = 1;
				left = ind-1>=0 ? ind-1 : len-1;
				while(true) {
					if(flag[right]) break;
					else {
						right = right+1<len ? right+1 : 0;
						rightInd++;
					}
				}
				while(true) {
					if(flag[left]) break;
					else {
						left = left-1>=0 ? left-1 : len-1;
						leftInd++;
					}
				}
				// ind 옮기기
				if(rightInd <= leftInd) {
					answer += rightInd;
					ind = right;
				} else {
					answer += leftInd;
					ind = left;
				}
				
			}
		}
		
		System.out.println(answer);
	}
}
