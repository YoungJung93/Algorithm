package Problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

public class Solution_7087_문제제목붙이기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		HashSet<Integer> hs;
		for(int i=1; i<=T; ++i) {
			int N = Integer.parseInt(br.readLine());
			hs = new HashSet<>();
			for(int j=0; j<N; ++j) {
				hs.add(br.readLine().charAt(0) - 'A');
			}
			int a = 0, cnt = 0;
			while(!hs.isEmpty()) {
				if(hs.contains(a)) {
					hs.remove(a);
					cnt++; a++;
				} else break;
			}
			bw.write("#" + i + " " + cnt + "\n");
			bw.flush();
		}
		bw.close();
	}
}
