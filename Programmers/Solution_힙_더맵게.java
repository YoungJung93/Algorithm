package Problem;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution_힙_더맵게 {
	static int K, scoville[];
	static int answer;
	public static void main(String[] args) {
		K = 7;
		scoville = new int[] {
			1,2,3,9,10,12	
		};
		
		PriorityQueue<Long> pq = new PriorityQueue<>(new Comparator<Long>() {
			public int compare(Long o1, Long o2) {
				return Long.compare(o1, o2);
			}
		});
		for(int i=0,size=scoville.length; i<size; i++) {
			pq.offer((long)scoville[i]);
		}
		answer = 0;
		while(pq.size()>1) {
			Long a = pq.poll();
			if(a>=K) break;
			Long b = pq.poll();
			Long c = a + 2*b;
			pq.offer(c);
			answer++;
		}
		if(pq.size()==1 && pq.peek()<K) {
			answer = -1;
		}
		
		System.out.println(answer);
	}
}
