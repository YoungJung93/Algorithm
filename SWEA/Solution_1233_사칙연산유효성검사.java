package Problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_1233_사칙연산유효성검사{
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i=1; i<=10; ++i) {
			int result = 1;
			int n = Integer.parseInt(br.readLine());
			int ind;
			char c;
			for(int j=0; j<n; ++j) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				if(st.countTokens() == 2) {
					ind = Integer.parseInt(st.nextToken());
					c = st.nextToken().charAt(0);
					if(!(c>=48 && c<=57)) {
						result = 0;
					}
				} else if(st.countTokens() == 4) {
					ind = Integer.parseInt(st.nextToken());
					c = st.nextToken().charAt(0);
					if(!(c=='+' || c=='-' || c=='*' || c=='/')) {
						result = 0;
					}
				} else {
					result = 0;
				}
			}
			bw.write("#" + i + " " + result + "\n");
			bw.flush();
		}
		bw.close();
	}
}
