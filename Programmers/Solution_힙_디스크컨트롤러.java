package Problem;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution_힙_디스크컨트롤러 {
	static int[][] jobs;
	static int answer;
	static class work implements Comparable<work> {
		int working, input;
		public work(int input, int working) {
			this.input = input; this.working = working;
		}
		public int compareTo(work o) {
			return Integer.compare(this.working, o.working);
		}
	}
	public static void main(String[] args) {
		jobs = new int[][] {
//			{0,3}, {1,9}, {2,6}
			{0,3}, {4,4}, {5,3}, {4,1}
		};
		answer = 0;
		
		Arrays.sort(jobs, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				if(o1[0]==o2[0]) return Integer.compare(o1[1], o2[1]);
				else return Integer.compare(o1[0], o2[0]);
			}
		});
		PriorityQueue<work> pq = new PriorityQueue<>();
		
		int curTime = jobs[0][0];
		int ind = 1;
		work cur = new work(jobs[0][0], jobs[0][1]);
		while(true) {
			if(ind >= jobs.length && pq.isEmpty()) break;
			while(ind<jobs.length && jobs[ind][0] == curTime) {
				pq.offer(new work(jobs[ind][0], jobs[ind][1]));
				ind++;
			}
			if(cur == null) {
				if(!pq.isEmpty()) cur = pq.poll();
				else curTime++;
			} else if(cur.working==0) {
				answer += curTime - cur.input;
				if(pq.isEmpty()) cur = null;
				else cur = pq.poll();
			} else {
				cur.working--;
				curTime++;
			}
		}
		curTime += cur.working;
		answer += (curTime-cur.input);
		answer /= jobs.length;
		
		System.out.println(answer);
	}
}
