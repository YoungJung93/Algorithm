package Problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main_1235_학생번호 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] arr = new String[N];
		for(int i=0; i<N; i++) {
			arr[i] = br.readLine();
		}
		
		int len = arr[0].length();
		for(int i=1; i<=len; i++) {
			Set<String> set = new HashSet<>();
			boolean flag = true;
			for(int j=0; j<N; j++) {
				String sub = arr[j].substring(len-i, len);
				if(set.contains(sub)) {
					flag = false;
					break;
				} else {
					set.add(sub);
				}
			}
			if(flag) {
				System.out.println(i);
				break;
			}
		}
	}
}
