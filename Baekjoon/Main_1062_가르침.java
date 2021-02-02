package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_1062_가르침 {
	static int N, K;
	static String[] inp;
	static Set<Character> set;
	static int[] comb;
	static int[] alpha = {1,3,4,5,6,7,9,10,11,12,14,15,16,17,18,20,21,22,23,24,25};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		inp = new String[N];
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			int len = s.length();
			s = s.substring(4, len-4);
			inp[i] = s;
		}
		if(K<5) System.out.println(0);
		else {
			int answer = 0;
			comb = new int[21];
			for(int i=0; i<K-5; i++) comb[i] = 1;
			Arrays.sort(comb);
			do {
				set = new HashSet<>();
				set.add('a'); set.add('n'); set.add('t');
				set.add('i'); set.add('c');
				for(int i=0; i<21; i++) {
					if(comb[i]==1) {
						set.add((char)('a'+alpha[i]));
					}
				}
				int res = 0;
				for(int i=0; i<N; i++) {
					String s = inp[i];
					boolean f = true;
					for(int j=0, size=s.length(); j<size; j++) {
						if(!set.contains(s.charAt(j))) {
							f = false; break;
						}
					}
					if(f) {
						res++;
					}
				}
				if(res > answer) answer = res;
			} while(np());
			System.out.println(answer);
		}
	}
	static boolean np() {
		int i = 20;
		while(i>0 && comb[i-1] >= comb[i]) i--;
		if(i==0) return false;
		int j = 20;
		while(comb[i-1] >= comb[j]) j--;
		swap(i-1, j);
		j = 20;
		while(j > i) swap(i++, j--);
		return true;
	}
	static void swap(int x, int y) {
		int tmp = comb[x];
		comb[x] = comb[y];
		comb[y] = tmp;
	}
}
