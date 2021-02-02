package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_7584_자가복제문자열 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int i=1; i<=T; i++) {
			long n = Long.parseLong(br.readLine());
			long len=1;
			while(true) {
				len = len*2+1;
				if(n <= len) break;
			}
			int result = dup(n, 1, len, 0);
			System.out.println("#" + i + " " + result);
		}
	}
	// flag == 0: 가운데, 1: 왼쪽, 2: 오른쪽
	public static int dup(long n, long start, long end, int flag) {
		long mid = (start+end)/2;
		if(end-start == 2 ) {
			if(n < mid) return 0;
			else if(n > mid) return 1;
			else if(n == mid) {
				if(flag==0) return 0;
				else if(flag==1) return 0;
				else if(flag==2) return 1;
			}
		} else {
			if(n < mid) return dup(n, start, mid-1, 1);
			else if(n > mid) return dup(n, mid+1, end, 2);
			else if(n == mid) {
				if(flag==0) return 0;
				else if(flag==1) return 0;
				else if(flag==2) return 1;
			}
		}
		return -1;
	}
}