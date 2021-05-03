package 카카오기출;

import java.util.Stack;

public class Solution_크레인인형뽑기게임 {

	public static void main(String[] args) {
		int[][] board = {
			{0,0,0,0,0},
			{0,0,1,0,3},
			{0,2,5,0,1},
			{4,2,4,4,2},
			{3,5,1,3,1}
		};
		int[] moves = {
			1,5,3,5,1,2,1,4
		};
		
		int answer = solution(board, moves);
		System.out.println(answer);
	}
	public static int solution(int[][] board, int[] moves) {
		int answer = 0;
		
		Stack<Integer> dolls = new Stack<>();
		int n = board.length;
		
		for(int i=0, size=moves.length; i<size; i++) {
			int pickC = moves[i] - 1;
			int pickR = -1;
			for(int r=0 ; r<n; r++) {
				if(board[r][pickC] != 0) {
					pickR = r;
					break;
				}
			}
			if(pickR != -1) {
				if(!dolls.isEmpty() && (dolls.peek()==board[pickR][pickC])) {
					answer += 2;
					dolls.pop();
				} else {
					dolls.push(board[pickR][pickC]);
				}
				board[pickR][pickC] = 0;
			}
		}
		
		return answer;
	}
}
