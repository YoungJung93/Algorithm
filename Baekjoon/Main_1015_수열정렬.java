package Problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main_1015_수열정렬 {
	static int N;
	static class Index implements Comparable<Index> {
		int ind, num;
		public Index(int ind, int num) {
			this.ind = ind;
			this.num = num;
		}
		public int compareTo(Index i) {
			if(this.num == i.num) {
				return Integer.compare(this.ind, i.ind);
			}
			return Integer.compare(this.num, i.num);
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		PriorityQueue<Index> pq = new PriorityQueue<>();
		for(int i=0; i<N; i++) {
			int a = Integer.parseInt(st.nextToken());
			pq.offer(new Index(i, a));
		}
		
		String[] answer = new String[N];
		for(int i=0; i<N; i++) {
			Index cur = pq.poll();
			answer[cur.ind] = Integer.toString(i);
		}
		
		System.out.println(Arrays.stream(answer).collect(Collectors.joining(" ")));
	}

}
