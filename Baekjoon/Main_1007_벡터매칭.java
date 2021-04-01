package Problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1007_벡터매칭 {
	static int N;
	static int[][] points;
	static boolean[] comb;
	static double answer;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			N = Integer.parseInt(br.readLine());
			points = new int[N][2];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				points[i][0] = Integer.parseInt(st.nextToken());
				points[i][1] = Integer.parseInt(st.nextToken());
			}
			answer = Double.MAX_VALUE;
			comb = new boolean[N];
			go(0, 0);
			System.out.printf("%.6f\n", answer);
		}
	}
	public static void go(int cnt, int index) {
		if(cnt == N/2) {
			int[] res = new int[2];
			for(int i=0; i<N; i++) {
				if(comb[i]) {
					res[0] -= points[i][0];
					res[1] -= points[i][1];
				} else {
					res[0] += points[i][0];
					res[1] += points[i][1];
				}
			}
			double leng = LengthOfVector(res[0], res[1]);
			if(answer > leng) answer = leng;
			
			return;
		}
		if(index == N) return;
		
		comb[index] = true;
		go(cnt+1, index+1);
		comb[index] = false;
		go(cnt, index+1);
	}
	public static double LengthOfVector(int x, int y) {
		double answer = 0d;
		
		long powX = (long) Math.pow(x, 2);
		long powY = (long) Math.pow(y, 2);
		
		answer = Math.sqrt((double)(powX+powY));
		
		return answer;
	}

}
