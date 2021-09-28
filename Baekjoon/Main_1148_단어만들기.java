package Problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main_1148_단어만들기 {
	static int[] puzzle;
	static int[] numOfWord;
	static List<int[]> dics;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		dics = new ArrayList<>();
		while(true) {
			String input = br.readLine();
			if(input.equals("-")) break;
			int[] dic = new int[26];
			int len = input.length();
			for(int i=0; i<len; i++) {
				char c = input.charAt(i);
				dic[c-'A']++;
			}
			dics.add(dic);
		}
		int size = dics.size();
		while(true) {
			String input = br.readLine();
			if(input.equals("#")) break;
			numOfWord = new int[26];
			puzzle = new int[26];
			for(int i=0; i<9; i++) {
				char c = input.charAt(i);
				puzzle[c-'A']++;
			}
			for(int i=0; i<size; i++) {
				int[] dic = dics.get(i);
				boolean flag = true;
				for(int j=0; j<26; j++) {
					if(dic[j] == 0) continue;
					if(puzzle[j] < dic[j]) {
						flag = false;
					}
				}
				if(flag) {
					for(int j=0; j<26; j++) {
						if(dic[j] > 0) {
							numOfWord[j]++;
						}
					}
				}
			}
			
			int min = Integer.MAX_VALUE, max = 0;
			for(int i=0; i<26; i++) {
				if(puzzle[i] <= 0) continue;
				if(numOfWord[i] > max) max = numOfWord[i];
				if(numOfWord[i] < min) min = numOfWord[i];
			}
			String worst = "", best = "";
			for(int i=0; i<26; i++) {
				if(puzzle[i] <= 0) continue;
				if(numOfWord[i] == min) {
					worst += (char)('A'+i);
				}
				if(numOfWord[i] == max) {
					best += (char)('A'+i);
				}
			}
			System.out.println(worst + " " + min + " " + best + " " + max);
		}
	}
}
