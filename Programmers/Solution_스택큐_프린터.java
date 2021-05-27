package Problem;

import java.util.ArrayList;
import java.util.List;

public class Solution_스택큐_프린터 {
	static class docu {
		int name;
		int weight;
		public docu(int name, int weight) {
			this.name = name; this.weight = weight;
		}
	}
	static int location, priorities[];
	static int answer;
	public static void main(String[] args) {
		priorities = new int[] {
//				2,1,3,2
				1,1,9,1,1,1
		};
		location = 2;
		location = 0;
		answer = 1;
		
		List<docu> list = new ArrayList<docu>();
		for(int i=0,size=priorities.length; i<size; i++) {
			list.add(new docu(i, priorities[i]));
		}
		while(!list.isEmpty()) {
			docu cur = list.remove(0);
			boolean f = true;
			for(int i=0, size=list.size(); i<size; i++) {
				if(cur.weight < list.get(i).weight) {
					f = false; break;
				}
			}
			if(!f) {
				list.add(cur);
			} else {
				if(location == cur.name) {
					break;
				} else {
					answer++;
				}
			}
		}
		System.out.println(answer);
	}
}
