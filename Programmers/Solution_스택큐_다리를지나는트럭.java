package Problem;

import java.util.ArrayList;
import java.util.List;

public class Solution_스택큐_다리를지나는트럭 {
	static class pair {
		int ind, time;
		public pair(int ind, int time) {
			this.ind = ind; this.time = time;
		}
	}
	static int bridge_length, weight, answer;
	static int[] truck_weights;
	public static void main(String[] args) {
//		bridge_length = 2;
//		weight = 10;
//		truck_weights = new int[] {
//				7,4,5,6
//		};
//		bridge_length = 100;
//		weight = 100;
//		truck_weights = new int[] {
//				10
//		};
		bridge_length = 100;
		weight = 100;
		truck_weights = new int[] {
				10,10,10,10,10,10,10,10,10,10
		};
		answer = 1;

		int ind = 0;
		int bw = 0;
		List<pair> bridge = new ArrayList<>();
		bridge.add(new pair(ind, bridge_length));
		bw += truck_weights[ind++];
		while(true) {
			if(ind == truck_weights.length && bridge.size()==0) break;
			answer++;
			for(int i=0,size=bridge.size(); i<size; i++) {
				bridge.get(i).time--;
			}
			if(bridge.get(0).time==0) {
				bw -= truck_weights[bridge.get(0).ind];
				bridge.remove(0);
			}
			if(ind<truck_weights.length
					&& bw + truck_weights[ind] <= weight) {
				bridge.add(new pair(ind, bridge_length));
				bw += truck_weights[ind++];
			}
		}
		System.out.println(answer);
	}
}
