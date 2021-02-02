package Problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_7272_안경이없어 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		StringBuilder base1=new StringBuilder("CEFGHIJKLMNSTUVWXYZ");
		StringBuilder base2=new StringBuilder("ADOPQR");
		for(int i=1; i<=T; ++i) {
			String result = "";
			StringTokenizer st = new StringTokenizer(br.readLine());
			StringBuilder str1 = new StringBuilder(st.nextToken());
			int size1 = str1.length();
			StringBuilder str2 = new StringBuilder(st.nextToken());
			int size2 = str2.length();
			if(size1!=size2) result = "DIFF";
			else {
				for(int j=0; j<size1; ++j) {
					if(base1.toString().contains((str1.subSequence(j, j+1))) &&
							base1.toString().contains((str2.subSequence(j, j+1)))) {
						if(j==size1-1) {
							result="SAME";
							break;
						}
					} else if(base2.toString().contains((str1.subSequence(j, j+1))) &&
							base2.toString().contains((str2.subSequence(j, j+1)))) {
						if(j==size1-1) {
							result="SAME";
							break;
						}
					} else if(str1.charAt(j)=='B' && str2.charAt(j)=='B') {
						if(j==size1-1) {
							result="SAME";
							break;
						}
					} else {
						result = "DIFF";
						break;
					}
				}
			}
			bw.write("#" + i + " " + result + "\n");
			bw.flush();
		}
		bw.close();
	}
}