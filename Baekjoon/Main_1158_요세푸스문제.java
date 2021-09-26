package Problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1158_요세푸스문제 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		List<Integer> list = new ArrayList<>();
		for(int i=0; i<N; i++) {
			list.add(i+1);
		}
		
		int[] answer = new int[N];
		int ind = 0;
		for(int i=0; i<N; i++) {
			ind += (K-1);
			ind = (ind % list.size());
			answer[i] = list.remove(ind);
		}
		
		System.out.print("<");
		for(int i=0; i<N; i++) {
			System.out.print(answer[i]);
			if(i != N-1) {
				System.out.print(", ");
			}
		}
		System.out.println(">");
	}

}
