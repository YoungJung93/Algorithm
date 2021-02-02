package Problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution_1240_단순2진암호코드 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		HashMap<String, Integer> hm = new HashMap<>();
		hm.put("0001101", 0); 	hm.put("0011001", 1);
		hm.put("0010011", 2);	hm.put("0111101", 3);
		hm.put("0100011", 4);	hm.put("0110001", 5);
		hm.put("0101111", 6);	hm.put("0111011", 7);
		hm.put("0110111", 8);	hm.put("0001011", 9);
		int T = Integer.parseInt(br.readLine());
		int[][] code;
		for(int i=1; i<=T; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			code = new int[N][8];
			int result;
			int res, col=0, ind=0;
			for(int j=0; j<N; ++j) {
				String in = br.readLine();
				if(ind==7) col++;
				ind=0;
				for(int k=0; k<M-6; k++) {
					String s = in.substring(k, k+7);
					if(hm.containsKey(s)) {
						code[col][ind++] = hm.get(s);
						k+=6;
					} else {
						k++;
					}
				}
			}
//			for(int j=0; j<N; j++) {
//				System.out.println(Arrays.toString(code[j]));
//			}
//			boolean flag = true;
//			first : for(int j=0; j<8; ++j) {
//				for(int k=0; k<N; ++k) {
//					if(code[k][j]==code[k+1][j]) continue;
//					else {
//						flag = false;
//						break first;
//					}
//				}
//			}
//			if(!flag) {
//				result = 0;
//			} else {
				int even=0, odd=0, jg=0;
				for(int k=0; k<8; ++k) {
					if(k==7) jg = code[0][k];
					else if(k%2==1) odd+=code[0][k];
					else if(k%2==0) even+=code[0][k];
				}
				res = odd*3 + even + jg;
				if(res%10==0) {
					result = odd + even + jg;
				} else {
					result = 0;
				}
//			}
			bw.write("#" + i + " " + result + "\n");
			bw.flush();
		}
		bw.close();
	}
	
}
