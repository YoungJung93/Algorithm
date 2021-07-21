package Problem;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution_영어끝말잇기 {

	public static void main(String[] args) {
		int n = 3;
//		int n = 5;
//		int n = 2;
		String[] words = {
				"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"
//				"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"
//				"hello", "one", "even", "never", "now", "world", "draw"
		};
		
		int[] answer = solution(n, words);
		System.out.println(Arrays.toString(answer));
	}
	public static int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        Set<String> flag = new HashSet<>();
        int len = words.length;
        char start = 0;
        for(int i=0; i<len; i++) {
        	String word = words[i];
        	if((i == 0 || word.charAt(0) == start) && (!flag.contains(word))) {
        		start = word.charAt(word.length()-1);
        		flag.add(word);
        	} else {
        		answer[0] = (i % n) + 1;
        		answer[1] = (i / n) + 1;
        		break;
        	}
        }
        
        return answer;
    }
}
