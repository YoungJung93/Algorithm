package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2503_숫자야구 {
	static int N;
	static String[] nums;
	static int[][] score;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		nums = new String[N];
		score = new int[N][2];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			nums[i] = st.nextToken();
			score[i][0] = Integer.parseInt(st.nextToken());
			score[i][1] = Integer.parseInt(st.nextToken());
		}
		int answer = 0;
		for(int a=1; a<10; a++) {
			for(int b=1; b<10; b++) {
				if(a==b) continue;
				for(int c=1; c<10; c++) {
					if(a==c || b==c) continue;
					String src = a+""+b+""+c;
					boolean f = true;
					for(int i=0; i<N; i++) {
						int[] arr = compare(src, nums[i]);
						if(arr[0]!=score[i][0] || arr[1]!=score[i][1]) {
							f = false; break;
						}
					}
					if(f) {
						answer++;
					}
				}
			}
		}
		System.out.println(answer);
	}
	static int[] compare(String src, String tar) {
		int strike = 0, ball = 0;
		int len = src.length();
		boolean[] flagJ = new boolean[len];
		boolean[] flagI = new boolean[len];
		for(int i=0; i<len; i++) {
			if(src.charAt(i) == tar.charAt(i)) {
				strike++;
				flagI[i] = true;
			}
		}
		for(int i=0; i<len; i++) {
			if(flagI[i]) continue;
			char c = tar.charAt(i);
			for(int j=0; j<len; j++) {
				if(flagJ[j]) continue;
				if(src.charAt(j) == c) {
					ball++;
					flagJ[j] = true;
					flagI[i] = true;
					break;
				}
			}
		}
		return new int[] {strike, ball};
	}
}
