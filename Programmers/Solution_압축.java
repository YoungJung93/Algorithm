package Problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_압축 {

	public static void main(String[] args) {
//		String msg = "KAKAO";
//		String msg = "TOBEORNOTTOBEORTOBEORNOT";
		String msg = "ABABABABABABABAB";
		
		int[] answer = solution(msg);
		System.out.println(Arrays.toString(answer));
	}
	public static int[] solution(String msg) {
        List<Integer> result = new ArrayList<>();
        
        Map<String, Integer> dic = new HashMap<>();
        int key = 1;
        char alpha = 'A';
        for(int i=0; i<26; i++) {
        	dic.put(Character.toString((char)(alpha+i)), key++);
        }
        
        int len = msg.length();
        for(int i=0; i<len; i++) {
        	
        	int j = i+2;
        	for( ; j<=len; j++) {
        		if(!dic.containsKey(msg.substring(i, j))) {
        			break;
        		}
        	}
        	if(j>len) {
        		result.add(dic.get(msg.substring(i, len)));
        		break;
        	}
        	result.add(dic.get(msg.substring(i, j-1)));
        	dic.put(msg.substring(i, j), key++);
        	i = j - 2;
        }
        int ansLen = result.size();
        int[] answer = new int[ansLen];
        for(int i=0; i<ansLen; i++) {
        	answer[i] = result.get(i);
        }
        
        return answer;
	}
}
