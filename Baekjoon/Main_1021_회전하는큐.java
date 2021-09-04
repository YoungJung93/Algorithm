package Problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1021_회전하는큐 {
	static int N, M;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int answer = 0;
		
		st = new StringTokenizer(br.readLine());
		boolean[] flag = new boolean[N+1];
		int point = 1;
		for(int i=0; i<M; i++) {
			int a = Integer.parseInt(st.nextToken());
			if(a != point) {
				int right = 0, left = 0;
				for(int j=point; ; j++) {
					if(j > N) j = 1;
					if(j == a) break;
					if(!flag[j]) right++;
				}
				for(int j=point; ; j--) {
					if(j == 0) j = N;
					if(j == a) break;
					if(!flag[j]) left++;
				}
				answer += Math.min(right, left);
			}
			flag[a] = true;
			if(i != M-1) {
				point = a+1;
				if(point > N) point = 1;
				while(flag[point]) {
					point++;
					if(point > N) point = 1;
				}
			}
		}
		
		System.out.println(answer);
	}
}
