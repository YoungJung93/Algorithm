package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_17394_핑거스냅 {
	static Set<Integer> list;
	static boolean[] flag;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int i=0; i<t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			prime(A, B);
			int res = -1;
			if(list.isEmpty()) res = -1;
			else if(list.contains(N)) res = 0;
			else {
				if(N>=B) flag = new boolean[2*N+1];
				else flag = new boolean[2*B+1];
				Queue<Integer> que = new LinkedList<Integer>();
				que.offer(N);
				que.offer(0);	// count 값
				flag[N] = true;
				while(!que.isEmpty()) {
					int num = que.poll();
					int cnt = que.poll();
					if(num!=0 && num>=A) { 
						if(list.contains(num/2) || list.contains(num/3) || list.contains(num-1)) {
							res = cnt+1;
							break;
						}
						if(!flag[num/2]) {
							que.offer(num/2); que.offer(cnt+1); 
							flag[num/2] = true;
						}
						if(!flag[num/3]) {
							que.offer(num/3); que.offer(cnt+1); 
							flag[num/3] = true;
						}
						if(!flag[num-1]) {
							que.offer(num-1); que.offer(cnt+1);
							flag[num-1] = true;
						}
					}
					if(num<flag.length-1) {
						if(list.contains(num+1)) {
							res = cnt+1;
							break;
						}
						if(!flag[num+1]) {
							que.offer(num+1); que.offer(cnt+1);
							flag[num+1] = true;
						}
					}
				}
			}
			System.out.println(res);
		}
	}
	static void prime(int a, int b) {
		list = new HashSet<Integer>();
		for(int i=a; i<=b; i++) {
			boolean f = true;
			if(i%2==0) f = false;
			else {
				for(int j=3; j<i; j+=2) {
					if(i%j==0) { f = false; break; }
				}
			}
			if(f) list.add(i);
		}
	}
}
