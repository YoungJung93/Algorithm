package Problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1166_선물 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		double left = 0;
		double right = 1000000000;
		double mid = (left + right) / 2;
		
		int a = 10000;
		while(a-->0) {
			mid = (left + right) / 2;
			if(((long)(L/mid)*(long)(W/mid)*(long)(H/mid)) < N) right = mid;
			else left = mid;
		}
		
		System.out.printf("%.10f", left);
	}
}
