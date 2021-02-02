package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1592_영식이와친구들 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		int ind = 0;
		int cnt = 0;
		arr[ind]++;
		if(arr[ind]%2==1) ind+=l;
		else ind-=l;
		while(true) {
			if(ind<0) ind = n+ind;
			if(ind>=n) ind = ind-n;
			arr[ind]++;
			cnt++;
			if(arr[ind]==m) break;
			if(arr[ind]%2==1) ind+=l;
			else ind-=l;
		}
		System.out.println(cnt);
	}
}