package Problem;

public class Solution_DFS_BFS_타겟넘버 {
	static int[] numbers;
	static int target;
	static int answer;
	
	static int res;
	public static void main(String[] args) {
		numbers = new int[] {
			1,1,1,1,1	
		};
		target = 3;
		answer = 0;
		
		res = 0;
		dfs(numbers, 0, 0, target);
		answer = res;
		
		System.out.println(answer);
	}
	static void dfs(int[] number, int ind, int sum, int tar) {
		if(ind == number.length) {
			if(sum == tar) res++;
			return;
		}
		dfs(number, ind+1, sum+number[ind], tar);
		dfs(number, ind+1, sum-number[ind], tar);
	}
}
