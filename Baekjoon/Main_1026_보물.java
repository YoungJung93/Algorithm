package Problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_1026_보물 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		int[] B = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(A);
		
		Map<Integer, Integer> map = new HashMap<>();
		boolean[] flag = new boolean[N];
		for(int i=0; i<N; i++) {
			int order = 0;
			for(int j=0; j<N; j++) {
				if(i == j) continue;
				if(B[i] < B[j]) order++;
				else if(B[i] == B[j]) {
					if(flag[j]) order++;
				}
			}
			map.put(order, B[i]);
			flag[i] = true;
		}
		
		int answer = 0;
		for(int i=0; i<N; i++) {
			answer += (A[i] * map.get(i));
		}
		System.out.println(answer);
	}

}
