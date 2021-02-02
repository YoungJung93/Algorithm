package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_8983_사냥꾼 {
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		arr = new int[m];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<m; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int res = 0;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int r = search(x, 0, m-1);
			int dis = Math.abs(r-x) + y;
			if(dis<=l) res++;
		}
		System.out.println(res);
	}
	static int search(int val, int start, int end) {
		int base = (start+end)/2;
		if(base==start) {
			int a = Math.abs(arr[start]-val);
			int b = Math.abs(arr[end]-val);
			return a<=b ? arr[start]:arr[end];
		}
		if(arr[base]>val) {
			return search(val, start, base);
		} else if(arr[base]<val) {
			return search(val, base, end);
		} else {
			return arr[base];
		}
	}
}