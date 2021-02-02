package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_1941_소문난칠공주 {
	static int[] lds, comb, arr;
	static int res;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		lds = new int[25];
		comb = new int[25];
		for(int i=0; i<5; i++) {
			String s = br.readLine();
			for(int j=0; j<5; j++) {
				switch(s.charAt(j)) {
				case 'S' :
					lds[5*i+j] = 1;
					break;
				case 'Y' :
					lds[5*i+j] = 2;
					break;
				}
			}
		}
		arr = new int[7];
		res = 0;
		combi(0,0);
		System.out.println(res);
	}
	static void combi(int idx, int cnt) {
		if(cnt==7) {
			flag = new boolean[7];
			if(bfs()) {
				res++;
			}
			return;
		}
		if(idx>=25) return;
		combi(idx+1, cnt);		// 해당 선택x
		arr[cnt] = idx;
		combi(idx+1, cnt+1);	// 해당 선택o
	}
	static int[] dr = {-5, 5, -1, 1};
	static boolean[] flag;
	static boolean bfs() {
		int a = 0;
		Queue<Integer> que = new LinkedList<Integer>();
		que.offer(arr[0]);
		flag[0] = true;
		if(lds[arr[0]]==1) a++;
		while(!que.isEmpty()) {
			int cur = que.poll();
			for(int i=0; i<4; i++) {
				int dx = cur + dr[i];
				if(dx<0 || dx>=25) continue;
				if(i==2 || i==3) {
					if(cur/5 != dx/5) continue;
				}
				for(int j=0; j<7; j++) {
					if(!flag[j] && dx==arr[j]) {
						if(lds[arr[j]]==1) a++;
						que.offer(dx);
						flag[j] = true;
					}
				}
			}
		}
		if(a<4) return false;
		for(int i=0; i<7; i++) {
			if(!flag[i]) return false;
		}
		return true;
	}
}
