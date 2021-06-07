package Problem;

import java.util.Arrays;

public class Solution_정렬_K번째수 {
	static int[] array, commands[];
	static int[] answer;
	public static void main(String[] args) {
		array = new int[] {
				1,5,2,6,3,7,4
		};
		commands = new int[][] {
			{2,5,3}, {4,4,1}, {1,7,3}
		};
		int size = commands.length;
		answer = new int[size];
		
		for(int i=0; i<size; i++) {
			int a = commands[i][0]-1;
			int b = commands[i][1]-1;
			int c = commands[i][2]-1;
			int[] arr = new int[b-a+1];
			for(int j=a; j<=b; j++) {
				arr[j-a] = array[j];
			}
			Arrays.sort(arr);
			answer[i] = arr[c];
		}
		
		System.out.println(Arrays.toString(answer));
	}
}
