package Problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution_6718_희성이의원근법 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int i=1; i<=T; ++i) {
			int n = Integer.parseInt(br.readLine());
			int res=0;
			if(n<100) res=0;
			else if(n<1000) res=1;
			else if(n<10000) res=2;
			else if(n<100000) res=3;
			else if(n<1000000) res=4;
			else if(n>1000000) res=5;
			
			bw.write("#" + i + " " + res + "\n");
			bw.flush();
		}
		bw.close();
	}
}
