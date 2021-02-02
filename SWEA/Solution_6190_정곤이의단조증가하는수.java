package Problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_6190_정곤이의단조증가하는수 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		int[] arr;
		for(int i=1; i<=T; ++i) {
			int n = Integer.parseInt(br.readLine());
			arr = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; ++j) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			int max=0;
			for(int j=0; j<n-1; ++j) {
				for(int k=j+1; k<n; ++k) {
					int u = arr[j]*arr[k];
					if(isInc(u)) {
						if(u>max) max=u;
					}
				}
			}
			if(max==0) max=-1;
			bw.write("#" + i + " " + max + "\n");
			bw.flush();
		}
		bw.close();
	}
	static boolean isInc(int num) {
		int a = num%10, b=0;
		num /= 10;
		if(num==0) return false;
		while(num!=0) {
			b = num%10;
			if(a<b) return false;
			a = b;
			num /= 10;
		}
		return true;
	}
}
