package Problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1138_한줄로서기 {
	static int N;
	static int[] lefts;
	static Person[] persons;
	static boolean[] flag;
	static String result;
	static class Person {
		int height, left;
		public Person(int height, int left) {
			this.height = height;
			this.left = left;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		lefts = new int[N+1];
		flag = new boolean[N+1];
		for(int i=1; i<=N; i++) {
			lefts[i] = Integer.parseInt(st.nextToken());
		}
		
		result = "";
		answer = new int[N+1];
		go(1);
		
		System.out.println(result);
	}
	static int[] answer;
	public static void go(int ind) {
		if(!result.equals("")) return;
		if(ind > N) {
			for(int i=1; i<=N; i++) {
				result += answer[i];
				if(i != N) result += " ";
			}
			return;
		}
		for(int i=1; i<=N; i++) {
			if(flag[i]) continue;
			int higher = 0;
			for(int j=1; j<ind; j++) {
				if(answer[j] > i) higher++;
			}
			if(higher == lefts[i]) {
				flag[i] = true;
				answer[ind] = i;
				go(ind+1);
				flag[i] = false;
			}
		}
	}
}
