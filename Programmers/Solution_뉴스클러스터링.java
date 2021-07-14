package Problem;

import java.util.LinkedList;
import java.util.List;

public class Solution_뉴스클러스터링 {

	public static void main(String[] args) {
//		String str1 = "FRANCE";
//		String str2 = "french";
//		String str1 = "handshake";
//		String str2 = "shake hands";
//		String str1 = "aa1+aa2";
//		String str2 = "AAAA12";
		String str1 = "E=M*C^2";
		String str2 = "e=m*c^2";
		
		int answer = solution(str1, str2);
		System.out.println(answer);
	}
	public static int solution(String str1, String str2) {
        int answer = 0;
        
        double result = 0.0f;
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        List<String> Aset = new LinkedList<>();
        List<String> Bset = new LinkedList<>();
        for(int i=0, size=str1.length(); i<size-1; i++) {
        	char one = str1.charAt(i);
        	char two = str1.charAt(i+1);
        	if(Character.isAlphabetic(one) && Character.isAlphabetic(two)) {
        		Aset.add(one + "" + two);
        	}
        }
        for(int i=0, size=str2.length(); i<size-1; i++) {
        	char one = str2.charAt(i);
        	char two = str2.charAt(i+1);
        	if(Character.isAlphabetic(one) && Character.isAlphabetic(two)) {
        		Bset.add(one + "" + two);
        	}
        }
        int AsetSize = Aset.size();
        int BsetSize = Bset.size();
        if(AsetSize==0 && BsetSize==0) {
        	result = 1;
        } else if(AsetSize==0 || BsetSize==0) {
        	result = 0;
        } else {
        	int common = 0;
        	for(int i=0; i<AsetSize; i++) {
        		String aStr = Aset.get(i);
        		int ind = Bset.indexOf(aStr);
        		if(ind != -1) {
        			Bset.remove(ind);
        			common++;
        		}
        	}
        	int union = (AsetSize + BsetSize) - common;
        	result = (double)common / (double)union;
        }
        answer = (int)(result * 65536);
        
        return answer;
    }
}
