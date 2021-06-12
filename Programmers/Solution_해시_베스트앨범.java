package Problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Solution_해시_베스트앨범 {
	static class album implements Comparable<album> {
		String genre;
		int[] no;
		int total;
		public album(String genre, int[] no, int total) {
			this.genre = genre;
			this.no = no.clone();
			this.total = total;
		}
		public int compareTo(album a) {
			return Integer.compare(a.total, this.total);
		}
	}
	static String[] genres;
	static int[] plays;
	static int[] answer;
	public static void main(String[] args) {
		genres = new String[] {
				"classic", "pop", "classic", "classic", "pop"
		};
		plays = new int[] {500, 600, 150, 800, 2500};
		
		Map<String, List<Integer>> map = new HashMap<>();
		for(int i=0, size=genres.length; i<size; i++) {
			String s = genres[i];
			if(map.containsKey(s)) {
				map.get(s).add(i);
			} else {
				List<Integer> list = new ArrayList<Integer>();
				list.add(i);
				map.put(s, list);
			}
		}
		int len = 0;
		Set<String> set = map.keySet();
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			String key = it.next();
			if(map.get(key).size()>=2) {
				len += 2;
			} else {
				len++;
			}
		}
		PriorityQueue<album> pq = new PriorityQueue<>();
		answer = new int[len];
		it = set.iterator();
		while(it.hasNext()) {
			String key = it.next();
			List<Integer> val = map.get(key);
			Collections.sort(val, new Comparator<Integer>() {
				public int compare(Integer o1, Integer o2) {
					return Integer.compare(plays[o2], plays[o1]);
				}
			});
			int total = 0;
			for(int i=0,size=val.size(); i<size; i++) {
				total += plays[val.get(i)];
			}
			int arr[];
			if(val.size()>=2) {
				arr = new int[2];
				arr[0] = val.get(0);
				arr[1] = val.get(1);
				pq.offer(new album(key, arr, total));
			} else {
				arr = new int[1];
				arr[0] = val.get(0);
				pq.offer(new album(key, arr, total));
			}
		}
		int ind = 0;
		while(!pq.isEmpty()) {
			album album = pq.poll();
			System.out.println("key : " + album.genre);
			System.out.println("total : " + album.total); 
			int[] no = album.no.clone();
			for(int i=0,size=no.length; i<size; i++) {
				answer[ind++] = no[i];
			}
		}
		System.out.println(Arrays.toString(answer));
	}
}