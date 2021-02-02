package Problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution_7510_상원이의연속합 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int i=1; i<=T; ++i) {
			int N = Integer.parseInt(br.readLine());
			int res, result=1;
			int start=0;
			while (true) {
				res=0;
				if(N==1 || start>N/2) break;
				++start;
				for (int j = start; j <= N; ++j) {
					if(res==N) {
						result++; break;
					} else if(res>N) {
						break;
					} else {
						res+=j;
					}
				} 
			}
			bw.write("#" + i + " " + result + "\n");
			bw.flush();
		}
		bw.close();
	}
}