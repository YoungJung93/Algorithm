package Problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_2014_소수의곱 {
	static int N, K;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		Set<Integer> flag = new HashSet<>();
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<K; i++) {
			int a = Integer.parseInt(st.nextToken());
			pq.offer(a);
			flag.add(a);
		}
		
		while(pq.size() < N) {
			int a = pq.poll();
			int b = pq.poll();
			if(!flag.contains(a*a)) {
				pq.offer(a*a);
				flag.add(a*a);
			}
			if(!flag.contains(b*b)) {
				pq.offer(b*b);
				flag.add(b*b);
			}
			if(!flag.contains(a*b)) {
				pq.offer(a*b);
				flag.add(a*b);
			}
			pq.offer(a);
			pq.offer(b);
		}
		
		int answer = 0;
		for(int i=0; i<N-1; i++) pq.poll();
		answer = pq.poll();
		System.out.println(answer);
	}
}
