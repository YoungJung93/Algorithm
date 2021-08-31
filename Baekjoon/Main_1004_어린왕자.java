package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1004_어린왕자 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(br.readLine());
			int answer = 0;
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				int cx = Integer.parseInt(st.nextToken());
				int cy = Integer.parseInt(st.nextToken());
				int cr = Integer.parseInt(st.nextToken());
				int d1 = (int)(Math.pow(cx-x1, 2) + Math.pow(cy-y1, 2));
				int d2 = (int)(Math.pow(cx-x2, 2) + Math.pow(cy-y2, 2));
				boolean in1 = false, in2 = false;
				if(d1 < cr*cr) in1 = true;
				if(d2 < cr*cr) in2 = true;
				if(in1 ^ in2) answer++;
			}
			System.out.println(answer);
		}
	}

}
