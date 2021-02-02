package Problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_6900_주혁이의복권당첨 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] src, dst; 
		int[] rwd;
		int T = Integer.parseInt(br.readLine());
		for(int i=1; i<=T; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			src = new String[N]; rwd = new int[N];
			dst = new String[M];
			for(int j=0; j<N; ++j) {
				st = new StringTokenizer(br.readLine());
				src[j] = st.nextToken();
				rwd[j] = Integer.parseInt(st.nextToken());
			}
			for(int j=0; j<M; ++j) {
				dst[j] = br.readLine();
			}
			int result = 0;
			for(int j=0; j<N; ++j) {
				String prize = "";
				for(int k=0; k<M; ++k) {
					if(isWin(src[j], dst[k])) {
						if(prize!="" && dst[k].equals(prize))
							result += rwd[j];
						else if(prize==""){ 
							result += rwd[j];
							prize = dst[j];
						}
					}
				}
			}
			bw.write("#"+i+" "+result+"\n");
		}
		bw.flush();
		bw.close();
	}
	
	public static boolean isWin(String src, String dst) {
		if(src.length() != dst.length()) return false;
		else {
			int size = src.length();
			for(int i=0; i<size; ++i) {
				if(src.charAt(i)!='*') {
					if(src.charAt(i)!=dst.charAt(i)) return false;
				}
			}
			return true;
		}
	}
}
