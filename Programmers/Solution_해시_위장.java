package Problem;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Solution_해시_위장 {
	static String[][] clothes;
	static int answer;
	public static void main(String[] args) {
//		clothes = new String[][] {
//				{"yellow_hat","headgear"}, {"blue_sunglasses","eyewear"}
//				, {"green_turban","headgear"}
//		};
		clothes = new String[][] {
			{"crow_mask","face"}, {"blue_sunglasses","face"}
			, {"smoky_makeup","face"}
		};
		answer = 1;
		Map<String, Integer> map = new HashMap<String, Integer>();
		for(int i=0, size=clothes.length; i<size; i++) {
			String key = clothes[i][1];
			if(map.containsKey(key)) {
				map.replace(key, map.get(key)+1);
			} else {
				map.put(key, 1);
			}
		}
		Set<String> set = map.keySet();
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			int i = map.get(it.next())+1;
			answer *= i;
		}
		answer--;
		System.out.println(answer);
	}
}
