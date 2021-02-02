package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14499_주사위굴리기 {
	static int[][] map;
	static int[] dice, result;
	static int[] east = {0,4,2,1,6,5,3};
	static int[] west = {0,3,2,6,1,5,4};
	static int[] south = {0,2,6,3,4,1,5};
	static int[] north = {0,5,1,3,4,6,2};
	static int N, M, x, y, k;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		dice = new int[7];
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		result = new int[k];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dice[6] = map[x][y];
		map[x][y] = 0;
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<k; i++) {
			int a = Integer.parseInt(st.nextToken());
			int[] arr = dice.clone();
			switch (a) {
			case 1:
				if(y+1<M) {
					y++;
					for(int j=1; j<7; j++) {
						dice[j] = arr[east[j]];
					}
					if(map[x][y]==0) {
						map[x][y] = dice[6];
					} else {
						dice[6] = map[x][y];
						map[x][y] = 0;
					}
					result[i] = dice[1];
				} else result[i] = -1;
				break;
			case 2:
				if(y-1>=0) {
					y--;
					for(int j=1; j<7; j++) {
						dice[j] = arr[west[j]];
					}
					if(map[x][y]==0) {
						map[x][y] = dice[6];
					} else {
						dice[6] = map[x][y];
						map[x][y] = 0;
					}
					result[i] = dice[1];
				} else result[i] = -1;
				break;
			case 3:
				if(x-1>=0) {
					x--;
					for(int j=1; j<7; j++) {
						dice[j] = arr[north[j]];
					}
					if(map[x][y]==0) {
						map[x][y] = dice[6];
					} else {
						dice[6] = map[x][y];
						map[x][y] = 0;
					}
					result[i] = dice[1];
				} else result[i] = -1;
				break;
			case 4:
				if(x+1<N) {
					x++;
					for(int j=1; j<7; j++) {
						dice[j] = arr[south[j]];
					}
					if(map[x][y]==0) {
						map[x][y] = dice[6];
					} else {
						dice[6] = map[x][y];
						map[x][y] = 0;
					}
					result[i] = dice[1];
				} else result[i] = -1;
				break;
			default:
				break;
			}
		}
		for(int i=0; i<k; i++) {
			if(result[i]==-1) continue;
			System.out.println(result[i]);
		}
	}
}
