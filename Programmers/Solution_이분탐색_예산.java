package Problem;

public class Solution_이분탐색_예산 {
	static int[] budgets;
	static int M, answer;
	public static void main(String[] args) {
		M = 485;
		budgets = new int[] {
//			120,110,140,150	
			122,110,30,50	
		};
		answer = 0;
		
		int len = budgets.length;
		int base = 0, bigger = 0, smaller = 0;
		int l = len;
		boolean[] flag = new boolean[len];
		while(true) {
			base = M / l;
			bigger = 0;
			smaller = 0;
			int max = 0;
			for(int i=0; i<len; i++) {
				if(flag[i]) continue;
				if(budgets[i] <= base) {
					flag[i] = true;
					smaller++;
					l--;
					M -= budgets[i];
					if(budgets[i] > max) max = budgets[i];
				} else {
					bigger++;
				}
			}
			if(bigger == 0) {
				answer = max;
				break;
			}
			if(smaller == 0) {
				answer = M/bigger;
				break;
			}
		}
		
		System.out.println(answer);
	}
}
