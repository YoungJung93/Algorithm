package Problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution_6485_삼성시의버스노선 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		HashMap<Integer, Integer> hm;
		for(int i=1; i<=T; ++i) {
			hm = new HashMap<>();
			int N = Integer.parseInt(br.readLine());
			for(int j=0; j<N; ++j) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				for(int k=a; k<=b; ++k) {
					if(hm.containsKey(k)) hm.replace(k, hm.get(k)+1);
					else hm.put(k, 1);
				}
			}
			int P = Integer.parseInt(br.readLine());
			StringBuilder res = new StringBuilder();
			for(int j=0; j<P; ++j) {
				int c = Integer.parseInt(br.readLine());
				if(hm.containsKey(c)) res.append(hm.get(c));
				else res.append(0);
				res.append(" ");
			}
			bw.write("#" + i + " " + res + "\n");
			bw.flush();
		}
		bw.close();
	}
}
