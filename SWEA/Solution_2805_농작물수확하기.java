package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_2805_농작물수확하기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		String[] farm;
		for(int i=1; i<=T; ++i) {
			int N = Integer.parseInt(br.readLine());
			farm = new String[N];
			int result=0;
			int mid = N/2;
			for(int j=0; j<N; ++j) {
				farm[j] = br.readLine();
				if(j<=mid) {
					for(int k=mid-j; k<=mid+j; ++k) {
						result += farm[j].charAt(k) - '0';
					}
				} else {
					for(int k=j-mid; k<=mid+(N-j-1); ++k) {
						result += farm[j].charAt(k) - '0';
					}
				}
			}
			System.out.println("#" + i + " " + result);
		}
	}
}