package Problem;

import java.util.Arrays;
import java.util.Comparator;

public class Solution_해시_전화번호목록 {
	static String[] phone_book;
	static boolean answer;
	public static void main(String[] args) {
		answer = true;
//		phone_book = new String[] {"119", "97674223", "1195524421"};
		phone_book = new String[] {"123","456","789"};
		Arrays.sort(phone_book, new Comparator<String>() {
			public int compare(String o1, String o2) {
				return Integer.compare(o1.length(), o2.length());
			}
		});
		first : for(int i=0, size=phone_book.length; i<size; i++) {
			String base = phone_book[i];
			for(int j=i+1; j<size; j++) {
				String tar = phone_book[j];
				if(isFront(base, tar)) {
					answer = false;
					break first;
				}
			}
		}
		System.out.println(answer);
	}
	static boolean isFront(String base, String tar) {
		int len = base.length();
		tar = tar.substring(0, len);
		if(base.equals(tar)) return true;
		else return false;
	}
}
