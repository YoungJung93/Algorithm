package Problem;

import java.util.*;

public class Main_11718_그대로출력하기 {
	public static void main(String[] args) {
		ArrayList<String> arr = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		int i=0;
		String str;
		while(sc.hasNextLine()) {
			str=sc.nextLine();
			if( (i>=100) || (str.startsWith(" ")) || (str.endsWith(" ")) || (str.length()>100) || (str.isEmpty()) ) break;
			arr.add(str);
			i++;
		}
		for(i=0; i<arr.size(); i++) {
			System.out.println(arr.get(i));
		}
		sc.close();
	}
}