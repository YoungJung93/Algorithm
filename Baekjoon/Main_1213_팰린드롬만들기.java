package Problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1213_팰린드롬만들기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int[] arr = new int[26];
		int len = input.length();
		
		for(int i=0; i<len; i++) {
			char c = input.charAt(i);
			arr[c-'A']++;
		}
		boolean isPalindrome = true;
		boolean isOdd = false;
		int oddInd = 0;
		for(int i=0; i<26; i++) {
			if((arr[i]&1)==1) {
				if(isOdd) {
					isPalindrome = false;
					break;
				}
				isOdd = true;
				oddInd = i;
			}
		}
		if(!isPalindrome) {
			System.out.println("I'm Sorry Hansoo");
		} else if((len&1)==1) {
			// 길이가 홀수일 때
			String answer = "";
			for(int i=0; i<26; i++) {
				char c = (char)(i+'A');
				for(int j=0; j<arr[i]/2; j++) {
					answer += c;
				}
			}
			if(isOdd) {
				answer += (char)(oddInd+'A');
			}
			for(int i=25; i>=0; i--) {
				char c = (char)(i+'A');
				for(int j=0; j<arr[i]/2; j++) {
					answer += c;
				}
			}
			System.out.println(answer);
		} else {
			// 길이가 짝수일 때
			String answer = "";
			for(int i=0; i<26; i++) {
				char c = (char)(i+'A');
				for(int j=0; j<arr[i]/2; j++) {
					answer += c;
				}
			}
			for(int i=25; i>=0; i--) {
				char c = (char)(i+'A');
				for(int j=0; j<arr[i]/2; j++) {
					answer += c;
				}
			}
			System.out.println(answer);
		}
	}

}
