package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_18233_러버덕을사랑하는모임2_미완 {
	static int[][] arr;
	static int[] comb, pick[];
	static int N, P, E;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		arr = new int[N][2];
		comb = new int[N];
		pick = new int[P][2];
		for(int i=0; i<P; i++) {
			comb[i] = 1;
		}
		Arrays.sort(comb);
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		boolean flag = false;
		do {
			for(int i=0, j=0; i<N; i++) {
				if(comb[i]==1) {
					pick[j][0] = arr[i][0];
					pick[j][1] = arr[i][1];
					j++;
				}
			}
			int min=0, max=0;
			for(int i=0; i<P; i++) {
				min += pick[i][0];
				max += pick[i][1];
			}
			if(min <= E && max >= E) {
				flag = true;
				break;
			}
		} while(np());
		if(!flag) {
			System.out.println(-1);
		} else {
			int[] result = new int[N];
			int e = E;
			for(int i=0, j=0; i<N; i++) {
				if(comb[i]==0) continue;
				result[i] = pick[j][0];
				e -= pick[j][0];
				j++;
			}
			for(int i=0,j=0; i<N; i++) {
				if(comb[i]==0) continue;
				int a = pick[j][1] - pick[j][0];
				if(a >= e) {
					result[i] += e;
					break;
				} else {
					result[i] += a;
					e -= a;
				}
				j++;
			}
			for(int i=0; i<N; i++) {
				System.out.print(result[i] + " ");
			}
		}
		
	}
	static boolean np() {
		int i=N-1;
		while(i>0 && comb[i-1]>=comb[i]) i--;
		if(i==0) return false;
		int j=N-1;
		while(comb[i-1]>=comb[j]) j--;
		swap(i-1, j);
		j=N-1;
		while(i<j) swap(i++, j--);
		return true;
	}
	static void swap(int x, int y) {
		int tmp = comb[x];
		comb[x] = comb[y];
		comb[y] = tmp;
	}
}
