package Problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_1246_온라인판매 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Integer[] arr = new Integer[M];
		for(int i=0; i<M; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr, Comparator.reverseOrder());
		
		int price = 0;
		int answer = 0;
		for(int i=0; i<N && i<M; i++) {
			int benefit = arr[i] * (i+1);
			if(benefit >= answer) {
				price = arr[i];
				answer = benefit;
			}
		}
		
		System.out.println(price + " " + answer);
	}

}
