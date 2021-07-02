package Problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_메뉴리뉴얼 {

	public static void main(String[] args) {
		String[] orders = {
				"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"
//				"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"
//				"XYZ", "XWY", "WXA"
		};
		int[] course = {
				2,3,4
//				2,3,5
//				2,3,4
		};
		
		String[] answer = solution(orders, course);
		System.out.println(Arrays.toString(answer));
	}
	public static String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<String>();
        
        
        
        return (String[])answer.toArray();
    }
}
