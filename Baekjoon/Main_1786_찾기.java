package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main_1786_찾기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] t = br.readLine().toCharArray();
		char[] p = br.readLine().toCharArray();
		
		int tLength = t.length;
		int pLength = p.length;
		
		int[] fail = new int[pLength];
		for(int i=1, j=0; i<pLength; i++) {	
			while(j>0 && p[i]!=p[j]) j = fail[j-1];
			
			if(p[i] == p[j]) fail[i] = ++j;
		}
		
		int cnt = 0;
		List<Integer> list = new ArrayList<>();
		for(int i=0, j=0; i<tLength; i++) { 
			while(j>0 && t[i] != p[j]) j = fail[j-1];
			
			if(t[i] == p[j]) { 			
				if(j == pLength-1) {	
					list.add(i - (pLength-1) + 1);
					cnt++;				
					j = fail[j];
				} else {
					j++;
				}
			}
		}
		System.out.println(cnt);
		for(int i=0; i<list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println();
	}
}