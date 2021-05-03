package 카카오기출;

import java.util.*;

public class Solution_튜플 {

	public static void main(String[] args) {
		String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
//		String s = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
//		String s = "{{20,111},{111}}";
//		String s = "{{123}}";
//		String s = "{{4,2,3},{3},{2,3,4,1},{2,3}}";
		
		int[] answer = solution(s);
		System.out.println(Arrays.toString(answer));
	}
	public static int[] solution(String s) {
		
		String[] arr = s.split("\\},\\{|\\{\\{|\\}\\}");
		Arrays.sort(arr, new Comparator<String>() {
			public int compare(String s1, String s2) {
				return Integer.compare(s1.length(), s2.length());
			}
		});

		Set<String> flag = new HashSet<>();
		int[] answer = new int[arr.length-1];
		for(int i=1, len=arr.length; i<len; i++) {
			String[] subArr = arr[i].split(",");
			for(int j=0, size=subArr.length; j<size; j++) {
				if(!flag.contains(subArr[j])) {
					flag.add(subArr[j]);
					answer[i-1] = Integer.parseInt(subArr[j]);
					break;
				}
			}
		}
		
		return answer;
	}
}
