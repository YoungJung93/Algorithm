package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_6730_장애물경주난이도 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int i=1; i<=T; ++i) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int up=0, down=0, res=0;
			int p = Integer.parseInt(st.nextToken()), q=0;
			for(int j=1; j<n; ++j) {
				q = Integer.parseInt(st.nextToken());
				if(p>q) {
					res = p-q;
					if(res>down) down=res;
				} else if(p<q) {
					res = q-p;
					if(res>up) up=res;
				}
				p=q;
			}
			System.out.println("#" + i + " " + up + " " + down);
		}
	}
}
