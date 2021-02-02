package Problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_7227_사랑의카운슬러_미완 {
	static int[][] cdn;
	static int res, min;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		
		int result=0;
		for(int i=1; i<=T; ++i) {
			int N = Integer.parseInt(br.readLine());
			cdn = new int[N][2];
			boolean[] flag = new boolean[N];
			for(int j=0; j<N; ++j) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				cdn[j][0] = Integer.parseInt(st.nextToken());
				cdn[j][1] = Integer.parseInt(st.nextToken());
			}
			min=2111111111;
			res = 0;
			for(int j=0; j<N-1; ++j) {
//				res = pair(0, -1, j, res, 1, min);
			}
		}
	}
//	public static int pair(int flag, int exind, int ind, int res, int cnt, int min) {
//		int size = cdn.length;
//		if(flag == (1<<size)-1) return res+cdn[exind][0]-cdn[ind][0]+cdn[exind][1]-cdn[ind][1];
//		for(int i=0; i<size; ++i) {
//			if((flag&(1<<i)) == 0) {
//				if(cnt%2==0) res += cdn[exind][0]-cdn[ind][0]+cdn[exind][1]-cdn[ind][1];
//				return pair(flag|(1<<i), ind, i, res, cnt+1, min);
//			}
//		}
//	}
}
