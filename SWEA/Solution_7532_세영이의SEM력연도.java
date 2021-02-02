package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_7532_세영이의SEM력연도 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int i=1; i<=T; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int result=0;
			if(s==e && e==m) result = s;
			else {
				int base = 365-s, be=5-base, bm=17-base;
				while(be<0) be+=24;
				while(bm<0) bm+=29;
				int res=be, re=bm;
				int cnt=0;
				while(res!=e || re!=m) {
					res += 5;
					re += 17;
					++cnt;
					if(res>24) res-=24;
					if(re>29) re-=29;
				}
				result = 365*cnt + s;
			}
			System.out.println("#" + i + " " + result);
			
		}
	}
}