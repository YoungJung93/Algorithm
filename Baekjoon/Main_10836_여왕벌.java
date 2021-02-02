package Problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_10836_여왕벌 {
	static int[] left, top;
	static int N, M;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		left = new int[M];
		top = new int[M-1];
		Arrays.fill(left, 1);
		Arrays.fill(top, 1);
		for(int n=0; n<N; n++) {
			int[] com = new int[2*M-1];
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			int ind = 0;
			for(int i=0; i<a; i++) com[ind++] = 0;
			for(int i=0; i<b; i++) com[ind++] = 1;
			for(int i=0; i<c; i++) com[ind++] = 2;
			
			for(ind=0; ind<M; ind++) {
				left[ind] += com[ind];
			}
			int in = 0;
			for(ind=M; ind<2*M-1; ind++) {
				top[in++] += com[ind];
			}
		}
		for(int i=M-1; i>=0; i--) {
			System.out.print(left[i] + " ");
			for(int j=0; j<M-1; j++) {
				System.out.print(top[j] + " ");
			}
			System.out.println();
		}
	}
}
