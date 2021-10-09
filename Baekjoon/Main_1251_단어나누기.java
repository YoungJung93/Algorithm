package Problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main_1251_단어나누기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		int len = str.length();
		
		List<String> list = new ArrayList<>();
		for(int one=1; one<len-1; one++) {
			for(int two=1; two<(len-one); two++) {
				StringBuilder sb1 = new StringBuilder(str.substring(0, one));
				StringBuilder sb2 = new StringBuilder(str.substring(one, one+two));
				StringBuilder sb3 = new StringBuilder(str.substring(one+two, len));
				
				sb1 = sb1.reverse();
				sb2 = sb2.reverse();
				sb3 = sb3.reverse();
				
				sb1.append(sb2).append(sb3);
				
				list.add(sb1.toString());
			}
		}
		Collections.sort(list);
		
		System.out.println(list.get(0));
	}

}
