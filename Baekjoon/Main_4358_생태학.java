package Problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main_4358_생태학 {
	
	public static void main(String[] args)	throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		String s = "";
		while((s = br.readLine())!=null) {
			if(map.containsKey(s)) {
				map.replace(s, map.get(s)+1);
			} else {
				map.put(s, 1);
			}
		}
		int total = 0;
		Set<String> set = map.keySet();
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			total += map.get(it.next());
		}
		List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				return o1.getKey().compareTo(o2.getKey());
			}
		});
		for(int i=0, size=list.size(); i<size; i++) {
			System.out.printf("%s %.4f%n", list.get(i).getKey(), ((list.get(i).getValue()*100)/(float)total));
		}
	}
}
