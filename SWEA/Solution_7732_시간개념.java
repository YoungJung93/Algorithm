package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_7732_시간개념 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		int[] current = new int[3];
		int[] promise = new int[3];
		int[] extra = new int[3];
		String[] result = new String[3];
		for (int i=0; i<T; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			current[0] = Integer.parseInt(st.nextToken(":"));
			current[1] = Integer.parseInt(st.nextToken(":"));
			current[2] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(in.readLine());
			promise[0] = Integer.parseInt(st.nextToken(":"));
			promise[1] = Integer.parseInt(st.nextToken(":"));
			promise[2] = Integer.parseInt(st.nextToken());
			
			if(current[0] > promise[0]) promise[0] += 24;
			if(current[1] > promise[1]) {
				promise[1] += 60;
				promise[0]--;
			}
			if(current[2] > promise[2]) {
				promise[2] += 60;
				promise[1]--;
			}
			for(int j=0; j<3; j++) {
				extra[j] = promise[j] - current[j];
			}
			if(extra[0] < 0) extra[0] += 24;
			for(int j=0; j<3; j++) {
				if(extra[j]<10) {
					result[j] = "0" + Integer.toString(extra[j]);
				}
				else {
					result[j] = Integer.toString(extra[j]);
				}
			}
			System.out.println("#" + (i+1) + " " + result[0] + ":" + result[1] + ":" + result[2]);
		}
	}

}
