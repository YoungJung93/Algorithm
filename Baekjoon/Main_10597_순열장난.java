package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10597_순열장난 {
	static String input, answer;
	static boolean[] flag;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input = br.readLine();
		if(input.length() <= 9) N = input.length();
		else {
			N = 9 + (input.length()-9)/2;
		}
		flag = new boolean[N+1];
		answer = "";
		dfs(0, "");
		System.out.println(answer);
	}
	public static void dfs(int ind, String sb) {
		if(!answer.equals("")) return;
		if(ind >= input.length()) {
			answer = sb.toString();
			return;
		}
		int a = input.charAt(ind)-'0';
		if(a <= N && !flag[a]) {
			flag[a] = true;
			dfs(ind+1, sb + a + " ");
			flag[a] = false;
		}
		if(N >= 10 && ind < input.length()-1) {
			int b = input.charAt(ind+1)-'0';
			if(a*10+b <= N && !flag[a*10+b]) {
				flag[a*10+b] = true;
				dfs(ind+2, sb + (a*10+b) + " ");
				flag[a*10+b] = false; 
			}
		}
	}
}
