package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_6603_로또 {
	static int[] arr;
	static int k;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while(true) {
			st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			if(k==0) break;
			arr = new int[k];
			for(int i=0; i<k; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			dfs(0, 0, "");
			System.out.println();
		}
	}
	static void dfs(int ind, int cnt, String res) {
		if(ind==k) {
			if(cnt==6) {
				System.out.println(res);
			}
			return;
		}
		if((k-ind)+cnt < 6) return;
		dfs(ind+1, cnt+1, res+arr[ind]+" ");
		dfs(ind+1, cnt, res);
	}
}
