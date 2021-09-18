package Problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1074_Z {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int startR = 0, startC = 0;
		int endR = (int)Math.pow(2, N), endC = (int)Math.pow(2, N);
		int answer = 0;
		while(N > 0) {
			int halfR = (startR + endR) / 2;
			int halfC = (startC + endC) / 2;
			int ea = (int)Math.pow(2, 2*N-2);
			if(r >= startR && r < halfR) {
				if(c >= startC && c < halfC) {
					// 1사분면
					endR = halfR;
					endC = halfC;
				} else {
					// 2사분면
					answer += ea;
					endR = halfR;
					startC = halfC;
				}
			} else {
				if(c >= startC && c < halfC) {
					// 3사분면
					answer += (ea * 2);
					startR = halfR;
					endC = halfC;
				} else {
					// 4사분면
					answer += (ea * 3);
					startR = halfR;
					startC = halfC;
				}
			}
			N--;
		}
		System.out.println(answer);
	}

}
