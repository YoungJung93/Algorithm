package Problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Solution_7193_승현이의수학공부 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int i=1; i<=T; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			StringBuilder sb = new StringBuilder(st.nextToken());
			long res = 0;
			for(int j=0, size = sb.length(); j<size; ++j) {
				res += sb.charAt(j)-'0';
			}
			res %= (n-1);
			bw.write("#" + i + " " + res + "\n");
			bw.flush();
		}
		bw.close();
	}
}
