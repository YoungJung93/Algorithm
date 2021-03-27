package Problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2749_피보나치수3 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(br.readLine());
		int answer = 0;
		
		int mod = 1000000;
		int period = 15 * (mod/10);
		
		int[] mods = new int[period];
		mods[0] = 0;
		mods[1] = 1;
		for(int i=2; i<period; i++) {
			mods[i] = (mods[i-1] + mods[i-2]) % mod;
		}
		
		answer = mods[(int)(n % period)];
		
		System.out.println(answer);
	}
}
