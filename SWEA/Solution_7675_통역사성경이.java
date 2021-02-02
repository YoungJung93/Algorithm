package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_7675_통역사성경이 {
	public static boolean isName(String name) {
		if(name.charAt(0)>=65 && name.charAt(0)<=90) {
			for(int i=1, size=name.length(); i<size; i++) {
				if(!((name.charAt(i)>=97 && name.charAt(i)<=122) || 
						name.charAt(i)=='?' || name.charAt(i)=='!' || name.charAt(i)=='.' )) {
					return false;
				}
			}
			return true;
		}
		return false;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int i=1; i<=T; i++) {
			int N = Integer.parseInt(br.readLine());
			int[] result = new int[N];
			String s = br.readLine();
			String[] sen = s.split("\\.|\\?|!");
			for(int j=0; j<N; j++) {
				String[] word = sen[j].trim().split(" ");
				for(int k=0, size_=word.length; k<size_; k++) {
					if(isName(word[k])) result[j]++;
				}
			}
			System.out.print("#" + i + " ");
			for(int j=0; j<N; j++) {
				System.out.print(result[j] + " ");
			}
			System.out.println();
		}
	}
}
