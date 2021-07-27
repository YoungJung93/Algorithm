package Problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution_메뉴리뉴얼 {

	public static void main(String[] args) {
		String[] orders = {
//				"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"
//				"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"
				"XYZ", "XWY", "WXA"
		};
		int[] course = {
//				2,3,4
//				2,3,5
				2,3,4
		};
		
		String[] answer = solution(orders, course);
		System.out.println(Arrays.toString(answer));
	}
	static int[] comb;
	public static String[] solution(String[] orders, int[] course) {
        List<String> result = new ArrayList<>();
        
        int ordersLen = orders.length;
        int courseLen = course.length;
        Map<String, Integer> map = new HashMap<>();
        for(int o=0; o<ordersLen; o++) {
        	char[] arr = orders[o].toCharArray();
        	Arrays.sort(arr);
        	String order = String.valueOf(arr);
        	int orderLen = order.length();
        	comb = new int[orderLen];
        	for(int c=0; c<courseLen; c++) {
        		if(course[c] > orderLen) break;
        		for(int i=0; i<course[c]; i++) {
        			comb[i] = 1;
        		}
        		Arrays.sort(comb);
        		do {
        			StringBuilder sb = new StringBuilder();
        			for(int i=0; i<orderLen; i++) {
        				if(comb[i] == 1) {
        					sb.append(order.charAt(i));
        				}
        			}
        			String s = sb.toString();
        			if(map.containsKey(s)) {
        				map.replace(s, map.get(s)+1);
        			} else {
        				map.put(s, 1);
        			}
        		} while(np());
        	}
        }
        int[] maxOrder = new int[11];
        Set<String> set = map.keySet();
        Iterator<String> it = set.iterator();
        while(it.hasNext()) {
        	String key = it.next();
        	int len = key.length();
        	int val = map.get(key);
        	if(val > maxOrder[len]) {
        		maxOrder[len] = val;
        	}
        }
        
        it = set.iterator();
        while(it.hasNext()) {
        	String key = it.next();
        	int len = key.length();
        	int val = map.get(key);
        	if(val >= 2 && val == maxOrder[len]) {
        		result.add(key);
        	}
        }
        Collections.sort(result);
        int ansLen = result.size();
        
        String[] answer = new String[ansLen];
        for(int i=0; i<ansLen; i++) {
        	answer[i] = result.get(i);
        }
        
        return answer;
    }
	public static boolean np() {
		int len = comb.length;
		int i = len - 1;
		while(i > 0 && comb[i-1] >= comb[i]) i--;
		if(i == 0) return false;
		int j = len - 1;
		while(comb[i-1] >= comb[j]) j--;
		swap(i-1, j);
		j = len - 1;
		while(i < j) swap(i++, j--);
		return true;
	}
	public static void swap(int x, int y) {
		int tmp = comb[x];
		comb[x] = comb[y];
		comb[y] = tmp;
	}
}
