package Problem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution_후보키 {
	public static void main(String[] args) {
		String[][] relation = {
				{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}	
		};
				
		int answer = solution(relation);
		System.out.println(answer);
	}
	public static int keyLen, row;
	public static List<Integer> keyBitList;
	public static int solution(String[][] relation) {
        int answer = 0;
        
        row = relation.length;
        keyLen = relation[0].length;
        keyBitList = new ArrayList<>();
        
        for(int i=1; i<=keyLen; i++) {
        	makeKey(relation, 0, i, "");
        }
        answer = keyBitList.size();
        return answer;
    }
	public static void makeKey(String[][] relation, int ind, int len, String key) {
		int keyBit = makeBit(key);
		if(keyBit != 0 && key.split(" ").length == len) {
			boolean isContain = false;
			for(int i=0, size=keyBitList.size(); i<size; i++) {
				int get = keyBitList.get(i);
				if((get | keyBit) == keyBit) {
					isContain = true;
					break;
				}
			}
			if(!isContain && isCandidateKey(relation, key)) {
				keyBitList.add(keyBit);
			}
			return;
		}
		if(ind >= keyLen) return;
		StringBuilder sb = new StringBuilder().append(key).append(key.length()==0?"":" ").append(Integer.toString(ind));
		makeKey(relation, ind+1, len, sb.toString());
		makeKey(relation, ind+1, len, key);
	}
	public static int makeBit(String key) {
		if(key.length() == 0) return 0;
		int answer = 0;
		String[] str = key.split(" ");
		for(int i=0, size=str.length; i<size; i++) {
			int num = Integer.parseInt(str[i]);
			answer |= (1 << num);
		}
		return answer;
	}
	public static boolean isCandidateKey(String[][] relation, String key) {
		if(key.length() == 0) return false;
		
		Set<String> flag = new HashSet<>();
		for(int i=0; i<row; i++) {
			StringBuilder str = new StringBuilder();
			String[] strArr = key.split(" ");
			int len = strArr.length;
			int[] arr = new int[len];
			for(int j=0; j<len; j++) {
				arr[j] = Integer.parseInt(strArr[j]);
			}
			for(int j=0; j<len; j++) {
				str.append(relation[i][arr[j]]);
				if(j != len) str.append(" ");
			}
			if(flag.contains(str.toString())) return false;
			flag.add(str.toString());
		}
		
		return true;
	}
}
