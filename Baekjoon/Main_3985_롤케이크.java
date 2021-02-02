package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3985_롤케이크 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int l = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		int gidae_max = 0, gidae = 0;
		int[] saram = new int[l+1];
		for(int i=1; i<=n; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(b-a > gidae_max) {
				gidae_max = b-a;
				gidae = i;
			}
			for(int j=a; j<=b; j++) {
				if(saram[j]==0) saram[j] = i;
			}
		}
		int[] flag = new int[l+1];
		int max = 0, max_saram=0;
		for(int i=1; i<=l; i++) {
			flag[saram[i]]++;
		}
		for(int i=1; i<=l; i++) {
			if(flag[i] > max) {
				max = flag[i];
				max_saram = i;
			}
		}
		System.out.println(gidae);
		System.out.println(max_saram);
	}
}