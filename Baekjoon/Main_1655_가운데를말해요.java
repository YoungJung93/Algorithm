package Problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main_1655_가운데를말해요 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder answer = new StringBuilder();

		PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Comparator.reverseOrder());
		PriorityQueue<Integer> minQueue = new PriorityQueue<>();
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(maxQueue.size() == minQueue.size()) {
				maxQueue.offer(num);
			} else {
				minQueue.offer(num);
			}
			
			if(maxQueue.size() != 0 && minQueue.size() != 0) {
				if(maxQueue.peek() > minQueue.peek()) {
					int max = maxQueue.poll();
					int min = minQueue.poll();
					maxQueue.offer(min);
					minQueue.offer(max);
				}
			}
			
			if(maxQueue.size() == minQueue.size()) {
				answer.append(Math.min(maxQueue.peek(), minQueue.peek())).append("\n");
			} else {
				answer.append(maxQueue.peek()).append("\n");
			}
		}
		System.out.println(answer);
	}

}
