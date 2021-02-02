package Problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_7102_준홍이의카드놀이 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int i=1; i<=T; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int ea = Math.abs(N-M) + 1;
			int min = N <= M ? 1+N : 1+M;
			bw.write("#" + i);
			for(int j=0; j<ea; ++j) {
				bw.write(" " + min++);
			}
			bw.write("\n");
			bw.flush();
		}
		bw.close();
	}
}
