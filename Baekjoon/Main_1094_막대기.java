package Problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main_1094_막대기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(br.readLine());
		
		int sum = 64;
		PriorityQueue<Integer> sticks = new PriorityQueue<>();
		sticks.offer(64);
		
		while(true) {
			if(sum == X) {
				break;
			}
			int stick = sticks.poll();
			int half = stick/2;
			if(sum-half >= X) {
				sticks.offer(half);
				sum -= half;
			} else {
				sticks.offer(half);
				sticks.offer(half);
			}
		}
		int answer = sticks.size();
		
		System.out.println(answer);
	}

}
