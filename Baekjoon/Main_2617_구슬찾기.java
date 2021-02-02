package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2617_구슬찾기 {
	static List<Integer>[] big;
	static List<Integer>[] small;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		big = new ArrayList[N+1];
		small = new ArrayList[N+1];
		for(int i=0; i<M; ++i) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(small[a]==null) small[a] = new ArrayList<>();
			if(big[b]==null) big[b] = new ArrayList<>();
			small[a].add(b);
			big[b].add(a);
		}
		int cnt=0;
		for(int i=1; i<=N; ++i) {
			if(hamsu(i) > (N/2)) cnt++;
		}
		System.out.println(cnt);
	}
	static int hamsu(int tar) {
		boolean[] flag = new boolean[big.length];
		int b=0, s=0;
		Queue<Integer> que = new LinkedList<>();
		que.offer(tar);
		flag[tar] = true;
		while(!que.isEmpty()) {
			int a = que.poll();
			if(big[a]==null) continue;
			for(int i=0; i<big[a].size(); ++i) {
				int tmp = big[a].get(i);
				if(!flag[tmp]) {
					que.offer(tmp);
					b++;
					flag[tmp] = true;
				}
			}
		}
		flag = new boolean[small.length];
		que = new LinkedList<>();
		que.offer(tar);
		flag[tar] = true;
		while(!que.isEmpty()) {
			int a = que.poll();
			if(small[a]==null) continue;
			for(int i=0; i<small[a].size(); ++i) {
				int tmp = small[a].get(i);
				if(!flag[tmp]) {
					que.offer(tmp);
					s++;
					flag[tmp] = true;
				}
			}
		}
		return b>s ? b : s;
	}
}
