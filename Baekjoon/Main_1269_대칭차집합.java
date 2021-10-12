package Problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_1269_대칭차집합 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int Alen = Integer.parseInt(st.nextToken());
		int Blen = Integer.parseInt(st.nextToken());
		
		Set<Integer> set = new HashSet<>();
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<Alen; i++) {
			int a = Integer.parseInt(st.nextToken());
			set.add(a);
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<Blen; i++) {
			int a = Integer.parseInt(st.nextToken());
			if(set.contains(a)) {
				set.remove(a);
			} else {
				set.add(a);
			}
		}
		
		System.out.println(set.size());
	}

}
