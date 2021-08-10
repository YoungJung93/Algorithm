package Problem;

import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_최댓값과최솟값 {

	public static void main(String[] args) {
//		String s = "1 2 3 4";
//		String s = "-1 -2 -3 -4";
		String s = "-1 -1";
		
		System.out.println(solution(s));
	}
	public static String solution(String s) {
        String answer = "";
        
        StringTokenizer st = new StringTokenizer(s, " ");
        int len = st.countTokens();
        int[] arr = new int[len];
        for(int i=0; i<len; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        
        answer = Integer.toString(arr[0]) + " " + Integer.toString(arr[len-1]);
        
        return answer;
    }
}
