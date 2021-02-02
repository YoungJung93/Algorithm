package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_6692_다솔이의월급상자 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int i=1; i<=T; ++i) {
			int n = Integer.parseInt(br.readLine());
			double res = 0;
			for(int j=0; j<n; ++j) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				double p = (Double.parseDouble(st.nextToken()));
				int x = Integer.parseInt(st.nextToken());
				res += p*x;
			}
			System.out.printf("#%d %.6f\n", i, res);
		}
	}
}
