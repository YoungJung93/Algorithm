package Problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_6913_동철이의프로그래밍대회 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int i=1; i<=T; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int max = 0;
			int[] arr = new int[N];
			int M = Integer.parseInt(st.nextToken());
			for(int j=0; j<N; ++j) {
				st = new StringTokenizer(br.readLine());
				int score=0;
				for(int k=0; k<M; ++k) {
					if(st.nextToken().equals("1")) {
						score++;
					}
				}
				arr[j] = score;
				if(score>max) max = score;
			}
			int one = 0;
			for(int j : arr) {
				if(j==max) one++;
			}
			bw.write("#" + i + " " + one + " " + max + "\n");
			bw.flush();
		}
		bw.close();
	}
}
