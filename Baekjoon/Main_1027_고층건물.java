package Problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1027_고층건물 {
	static int N;
	static int[] heights;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		heights = new int[N];
		for(int i=0; i<N; i++) heights[i] = Integer.parseInt(st.nextToken());
		
		int answer = 0;
		for(int base=0; base<N; base++) {
			int res = 0;
			// 왼쪽으로
			for(int left=base-1; left>=0; left--) {
				int rateX = base - left;
				int rateY = heights[base] - heights[left];
				boolean flag = true;
				for(int chk=left+1; chk<base; chk++) {
					if(!isSee(rateX, rateY, base, heights[base], chk, heights[chk])) {
						flag = false;
						break;
					}
				}
				if(flag) {
					res++;
				}
			}
			// 오른쪽으로
			for(int right=base+1; right<N; right++) {
				int rateX = right - base;
				int rateY = heights[right] - heights[base];
				boolean flag = true;
				for(int chk=base+1; chk<right; chk++) {
					if(!isSee(rateX, rateY, base, heights[base], chk, heights[chk])) {
						flag = false;
						break;
					}
				}
				if(flag) {
					res++;
				}
			}
			if(res > answer) {
				answer = res;
			}
		}
		
		System.out.println(answer);
	}
	// rateX : x의 변화율, rateY : y의 변화울
	// x : 기준 x의 값, y : 기준 y의 값
	// chkX, chkY : 중간에 체크할 x, y값
	public static boolean isSee(int rateX, int rateY, int x, int y, int chkX, int chkY) {
		double a = y - (((double)rateY / (double)rateX) * x);
		double inc = (double)rateY / (double)rateX;
		
		double exp = inc * chkX + a;
		
		if(chkY < exp) return true;
		else return false;
	}
}
