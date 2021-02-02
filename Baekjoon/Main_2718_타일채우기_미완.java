package Problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2718_타일채우기 {
	static int N, res;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			N = Integer.parseInt(br.readLine());
			res = 0;
			dfs(0, 0);
			System.out.println(res);
		}
	}
	static void dfs(int ind, int flag) {
		if(ind == N-1) {
			if(flag==0 || flag==3 || flag==9 || flag==12 || flag==15) {
				res++;
			}
			return;
		}
		switch(flag) {
		case 0 :
			dfs(ind+1, 0); dfs(ind+1, 3);
			dfs(ind+1, 9); dfs(ind+1, 12); dfs(ind+1, 15);
			break;
		case 1 :
			dfs(ind+1, 2); dfs(ind+1, 8); dfs(ind+1, 14);
			break;
		case 2 :
			dfs(ind+1, 1); dfs(ind+1, 13);
			break;
		case 3 :
			dfs(ind+1, 0); dfs(ind+1, 12);
			break;
		case 4 :
			dfs(ind+1, 8); dfs(ind+1, 11); 
			break;
		case 5 :
			dfs(ind+1, 10); 
			break;
		case 6 :
			dfs(ind+1, 9); 
			break;
		case 7 :
			dfs(ind+1, 8); 
			break;
		case 8 :
			dfs(ind+1, 1); dfs(ind+1, 4); dfs(ind+1, 7); 
			break;
		case 9 :
			dfs(ind+1, 0); dfs(ind+1, 6); 
			break;
		case 10 :
			dfs(ind+1, 5); 
			break;
		case 11 :
			dfs(ind+1, 4); 
			break;
		case 12 :
			dfs(ind+1, 0); dfs(ind+1, 3);  
			break;
		case 13 :
			dfs(ind+1, 2); 
			break;
		case 14 :
			dfs(ind+1, 1); 
			break;
		case 15 :
			dfs(ind+1, 0); 
			break;
		}
		
	}
}
