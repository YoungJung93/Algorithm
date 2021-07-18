package Problem;

import java.util.LinkedList;
import java.util.List;

public class Solution_캐시 {

	public static void main(String[] args) {
//		int cacheSize = 3;
//		int cacheSize = 3;
//		int cacheSize = 2;
//		int cacheSize = 5;
//		int cacheSize = 2;
		int cacheSize = 0;
		String[] cities = {
//				"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"
//				"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"
//				"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"
//				"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"
//				"Jeju", "Pangyo", "NewYork", "newyork"
				"Jeju", "Pangyo", "Seoul", "NewYork", "LA"
		};
		
		int answer = solution(cacheSize, cities);
		
		System.out.println(answer);		
	}
	public static int solution(int cacheSize, String[] cities) {
        int answer = 0;
        int len = cities.length;
        
        if(cacheSize == 0) {
        	return 5 * len;
        }
        
        List<String> cache = new LinkedList<>();
        for(int i=0; i<len; i++) {
        	String city = cities[i];
        	city = city.toLowerCase();
        	int ind = cache.indexOf(city);
        	if(ind == -1) {
        		answer += 5;
        		if(cache.size() == cacheSize) {cache.remove(0);}
        		cache.add(city);
        	} else {
        		answer++;
        		String rem = cache.remove(ind);
        		cache.add(rem);
        	}
        }
        
        
        return answer;
    }
}