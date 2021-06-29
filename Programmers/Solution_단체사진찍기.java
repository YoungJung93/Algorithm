package Problem;

public class Solution_단체사진찍기 {

	public static void main(String[] args) {
		int n = 2;
		String[] data = {
//				"N~F=0", "R~T>2"
				"M~C<2", "C~M>1"
		};
		
		int answer = solution(n, data);
		
		System.out.println(answer);
	}
	static int N;
	static char[] comb;
	public static int solution(int n, String[] data) {
		int answer = 0;
		
		N = n;
		comb = new char[] {
				'A','C','F','J','M','N','R','T'
		};
		
		do {
			if(isCondition(data)) 
				answer++;
		} while(np());
		
		return answer;
	}
	public static boolean isCondition(String[] data) {
		for(int i=0; i<N; i++) {
			String condition = data[i];
			char src = condition.charAt(0);
			char dst = condition.charAt(2);
			int srcInd = 0;
			int dstInd = 0;
			for(; srcInd<8; srcInd++) {
				if(comb[srcInd] == src) break;
			}
			for(; dstInd<8; dstInd++) {
				if(comb[dstInd] == dst) break;
			}
			int interval = condition.charAt(4) - '0';
			switch(condition.charAt(3)) {
			case '=' :
				if(Math.abs(srcInd-dstInd)-1 != interval) {
					return false;
				}
				break;
			case '<' :
				if(Math.abs(srcInd-dstInd)-1 >= interval) {
					return false;
				}
				break;
			case '>' :
				if(Math.abs(srcInd-dstInd)-1 <= interval) {
					return false;
				}
				break;
			}
		}
		return true;
	}
	public static boolean np() {
		int i = 7;
		while(i>0 && comb[i-1] >= comb[i]) i--;
		if(i==0) return false;
		int j = 7;
		while(comb[i-1] >= comb[j]) j--;
		swap(i-1, j);
		j = 7;
		while(j>i) swap(i++, j--);
		return true;
	}
	public static void swap(int x, int y) {
		char tmp = comb[x];
		comb[x] = comb[y];
		comb[y] = tmp;
	}
}
