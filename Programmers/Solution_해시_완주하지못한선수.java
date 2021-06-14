package Problem;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Solution_해시_완주하지못한선수 {
	static String[] participant, completion;
	static String answer;
	public static void main(String[] args) {
		answer = "";
		participant = new String[] {"leo", "kiki", "eden", "leo"};
		completion = new String[] {"kiki", "eden", "leo"};
		Map<String, Integer> map = new HashMap<String, Integer>();
		for(int i=0,size=participant.length; i<size; i++) {
			String s = participant[i];
			if(map.containsKey(s)) {
				map.replace(s, map.get(s)+1);
			} else {
				map.put(s, 1);
			}
		}
		for(int i=0, size=completion.length; i<size; i++) {
			String s = completion[i];
			if(map.containsKey(s)) {
				if(map.get(s)==1) {
					map.remove(s);
				} else {
					map.replace(s, map.get(s)-1);
				}
			}
		}
		Set<String> set = map.keySet();
		Iterator<String> it = set.iterator();
		answer = it.next();
		System.out.println(answer);
	}
}
