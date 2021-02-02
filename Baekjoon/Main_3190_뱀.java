package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_3190_뱀 {
	static int[][] map, dir;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		map = new int[n+1][n+1];
		dir = new int[n+1][n+1];
		for(int i=0; i<=n; i++)	{			
			Arrays.fill(dir[i], -1);
		}
		StringTokenizer st;
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
		}
		int l = Integer.parseInt(br.readLine());
		int headx=1, heady=1, tailx=1, taily=1;
		map[headx][heady] = 2;
		dir[headx][heady] = 1;
		Map<Integer, Character> hm = new HashMap<Integer, Character>();
		for(int i=0; i<l; i++) {
			st = new StringTokenizer(br.readLine());
			hm.put(Integer.parseInt(st.nextToken()), st.nextToken().charAt(0));
		}
		int time = 0;
		while(true) {
			++time;
			int d = dir[headx][heady];
			switch(dir[headx][heady]) {
			case 0 :
				headx--; break;
			case 1 :
				heady++; break;
			case 2 : 
				headx++; break;
			case 3 :
				heady--; break;
			}
			if(headx<1 || heady<1 || headx>n || heady>n) break;
			if(map[headx][heady]==2) break;
			// 범위 검사
			if(map[headx][heady] != 1) {
				map[tailx][taily] = 0;
				switch(dir[tailx][taily]) {
				case 0 :
					tailx--; break;
				case 1 :
					taily++; break;
				case 2 : 
					tailx++; break;
				case 3 :
					taily--; break;
				}
			}
			map[headx][heady] = 2;
			if(hm.containsKey(time)) {
				char c = hm.get(time);
				if(c=='D') dir[headx][heady] = (d+1)%4;
				else {
					if(d==0) dir[headx][heady] = 3;
					else dir[headx][heady] = d-1;
				}
			} else dir[headx][heady] = d;
		}
		System.out.println(time);
	}
}
