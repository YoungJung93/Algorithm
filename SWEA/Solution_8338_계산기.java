package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_8338_계산기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int i=1; i<=T; ++i) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int p = 0, q = 0;
			p = Integer.parseInt(st.nextToken());
			for(int j=1; j<n; ++j) {
				q = Integer.parseInt(st.nextToken());
				if(p==0 || q==0 || p==1 || q==1) 
					p += q;
				else p *= q;
			}
			System.out.println("#" + i + " " + p);
		}
	}
}