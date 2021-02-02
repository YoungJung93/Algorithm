package Problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_8104_조만들기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		int[] result;
		for(int i=1; i<=T; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			result = new int[k];
			int size = n*k, ind = 0;
			boolean flag = true;;
			for(int j=1; j<=size; ++j) {
				if(flag) {
					result[ind] += j;
					if(ind==k-1) flag = false;
					else ind++;
				} else {
					result[ind] += j;
					if(ind==0) flag = true;
					else ind--;
				}
			}
			bw.write("#" + i);
			for(int j : result) {
				bw.write(" " + j);
			}
			bw.write("\n");
			bw.flush();
		}
        bw.close();
	}
}