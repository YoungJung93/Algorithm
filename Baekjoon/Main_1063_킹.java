package Problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1063_킹 {
	static int[] dr = {0,0,1,-1,-1,-1,1,1};
	static int[] dc = {1,-1,0,0,1,-1,1,-1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String king = st.nextToken();
		int kingR = 8 - (int)(king.charAt(1) - '0');
		int kingC = (int)(king.charAt(0) - 'A');
		String stone = st.nextToken();
		int stoneR = 8 - (int)(stone.charAt(1) - '0');
		int stoneC = (int)(stone.charAt(0) - 'A');
		int N = Integer.parseInt(st.nextToken());
		for(int i=0; i<N; i++) {
			String com = br.readLine();
			int dir = 0;
			switch(com) {
			case "R" :
				dir = 0;
				break;
			case "L" :
				dir = 1;
				break;
			case "B" :
				dir = 2;
				break;
			case "T" :
				dir = 3;
				break;
			case "RT" :
				dir = 4;
				break;
			case "LT" :
				dir = 5;
				break;
			case "RB" :
				dir = 6;
				break;
			case "LB" :
				dir = 7;
				break;
			}
			int dx = kingR + dr[dir];
			int dy = kingC + dc[dir];
			if(dx<0 || dy<0 || dx>=8 || dy>=8) continue;
			if(stoneR == dx && stoneC == dy) {
				int sx = stoneR + dr[dir];
				int sy = stoneC + dc[dir];
				if(sx<0 || sy<0 || sx>=8 || sy>=8) continue;
				stoneR = sx;
				stoneC = sy;
			}
			kingR = dx;
			kingC = dy;
		}
		king = (char)(kingC + 'A') + Integer.toString(8-kingR);
		stone = (char)(stoneC + 'A') + Integer.toString(8-stoneR);
		
		System.out.println(king);
		System.out.println(stone);
	}

}
