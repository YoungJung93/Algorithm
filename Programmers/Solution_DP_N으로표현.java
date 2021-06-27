package Problem;

import java.util.ArrayList;
import java.util.List;

public class Solution_DP_N으로표현 {
	static int N, number;
	static int answer;
	
	public static void main(String[] args) {
		N = 5;
		N = 2;
		number = 12;
		number = 11;
		answer = 0;
		
		@SuppressWarnings("unchecked")
		List<Integer>[] arr = new ArrayList[9];
		for(int i=1; i<=8; i++) arr[i] = new ArrayList<>();
		
		if(number == N) answer = 1;
		else {
			arr[1].add(N);
			arr[2].add(10*N+N); arr[3].add(100*N+10*N+N);
			arr[2].add(N+N); arr[2].add(N-N);
			arr[2].add(N/N); arr[2].add(N*N);
			arr[4].add(1000*N+100*N+10*N+N);
			arr[5].add(10000*N+1000*N+100*N+10*N+N);
			arr[6].add(100000*N+10000*N+1000*N+100*N+10*N+N);
			arr[7].add(1000000*N+100000*N+10000*N+1000*N+100*N+10*N+N);
			arr[8].add(10000000*N+1000000*N+100000*N+10000*N+1000*N+100*N+10*N+N);
			if(arr[2].contains(number)) {
				answer = 2;
			} else {
				for(int i=3; i<=8; i++) {
					for(int a=1; a<=i/2; a++) {
						int b = i-a;
						for(int c=0, cl=arr[a].size(); c<cl; c++) {
							for(int d=0, dl=arr[b].size(); d<dl; d++) {
								arr[i].add(arr[a].get(c)+arr[b].get(d));
								arr[i].add(arr[a].get(c)*arr[b].get(d));
								if(arr[a].get(c) >= arr[b].get(d)) {
									arr[i].add(arr[a].get(c)-arr[b].get(d));
									if(arr[b].get(d)!=0) arr[i].add(arr[a].get(c)/arr[b].get(d));
								} else {
									arr[i].add(arr[b].get(d)-arr[a].get(c));
									if(arr[a].get(c)!=0) arr[i].add(arr[b].get(d)/arr[a].get(c));
								}
							}
						}
					}
					if(arr[i].contains(number)) {
						answer = i;
						break;
					} else if(i==8) {
						answer = -1;
					}
				}
			}
		}
		
		System.out.println(answer);
	}
}
