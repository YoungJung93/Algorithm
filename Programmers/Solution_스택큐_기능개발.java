package Problem;

import java.util.ArrayList;
//import java.util.Arrays;
import java.util.List;

public class Solution_스택큐_기능개발 {
	static int[] progresses, speeds;
	static int[] answer;
	public static void main(String[] args) {
		progresses = new int[] {93,30,55};
		speeds = new int[] {1,30,5};

		List<Integer> list = new ArrayList<Integer>();
		int size=progresses.length;
		int[] worktime = new int[size];
		for(int i=0; i<size; i++) {
			int x = (int)Math.ceil((double)(100-progresses[i])/speeds[i]);
			worktime[i] = x;
		}
		int base = worktime[0];
		int baseInd = 0;
		for(int i=1; i<size; i++) {
			if(worktime[i] > base) {
				list.add(i-baseInd);
				baseInd = i;
				base = worktime[i];
			}
			if(i==size-1) {
				list.add(size-baseInd);
			}
		}
		answer = new int[list.size()];
		for(int i=0; i<answer.length; i++) {
			answer[i] = list.get(i);
		}
//		System.out.println(Arrays.toString(answer));
	}
}
