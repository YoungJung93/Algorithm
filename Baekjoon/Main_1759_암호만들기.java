package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_1759_암호만들기 {
	static int n, m;
	static int[] comb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		comb = new int[n];
		char[] keys = new char[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) keys[i] = st.nextToken().charAt(0);
		
		Arrays.sort(keys);
		
		Set<Character> ahdmaemf = new HashSet<>();
		ahdmaemf.add('a'); ahdmaemf.add('e'); ahdmaemf.add('i');
		ahdmaemf.add('o'); ahdmaemf.add('u');
		
		List<String> answer = new ArrayList<>();

		for(int i=0; i<m; i++) comb[i] = 1;
		Arrays.sort(comb);
		do {
			int ahdma = 0, wkdma = 0;
			String str = "";
			for(int i=0; i<n; i++) {
				if(comb[i] == 1) {
					if(ahdmaemf.contains(keys[i])) {
						ahdma++;
					} else wkdma++;
					str += keys[i];
				}
			}
			if(ahdma >= 1 && wkdma >= 2) answer.add(str);
		} while(np());
		
		answer.sort((o1, o2) -> o1.compareTo(o2));
		
		for(int i=0, size=answer.size(); i<size; i++) {
			System.out.println(answer.get(i));
		}
	}
	public static boolean np() {
		int i = n-1;
		while(i>0 && comb[i-1] >= comb[i]) i--;
		if(i == 0) return false;
		int j = n-1;
		while(comb[i-1] >= comb[j]) j--;
		swap(i-1, j);
		j = n-1;
		while(j > i) swap(i++, j--);
		return true;
	}
	public static void swap(int x, int y) {
		int tmp = comb[x];
		comb[x] = comb[y];
		comb[y] = tmp;
	}
}
