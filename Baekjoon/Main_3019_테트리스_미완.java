package Problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3019_테트리스 {
	static boolean[][][][] blocks = {
			{}, // 0번은 비어있게 놔둠
			{ 	// 1번 블록
				{{true},{true},{true},{true}},
				{{true,true,true,true}}
			},
			{ 	// 2번 블록
				{{true,true},{true,true}}
			},
			{	// 3번 블록
				{{false,true,true},{true,true,false}}, {{true,false},{true,true},{false,true}}
			},
			{	// 4번 블록
				{{true,true,false},{false,true,true}}, {{false,true},{true,true},{true,false}}
			},	
			{	// 5번 블록
				{{false,true,false},{true,true,true}}, {{true,true,true},{false,true,false}},
				{{false,true},{true,true},{false,true}}, {{true,false},{true,true},{true,false}}
			},
			{	// 6번 블록
				{{false,false,true},{true,true,true}}, {{true,true},{false,true},{false,true}},
				{{true,true,true},{true,false,false}}, {{true,false},{true,false},{true,true}}
			},
			{	// 7번 블록
				{{true,false,false},{true,true,true}}, {{false,true},{false,true},{true,true}},
				{{true,true,true},{false,false,true}}, {{true,true},{true,false},{true,false}}
			}
	};
	static boolean[][] map;
	static int C, P;
	static final int MAX = 105;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		map = new boolean[MAX][C];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<C; i++) {
			int c = Integer.parseInt(st.nextToken());
			for(int j=MAX-1; j>MAX-1-c; j--) {
				map[j][i] = true;
			}
		}
		int answer = 0;
		for(int i=0; i<blocks[P].length; i++) {
			int len = blocks[P][i][0].length;
			if(len > C) continue;
			for(int j=0; j<=C-len; j++) {
				if(go(blocks[P][i], j)) answer++;
			}
		}
		System.out.println(answer);
	}
	// block을 map에 몇 개까지 놓을 수 있는지
	static boolean go(boolean[][] block, int c) {
		boolean[][] arr = new boolean[MAX][C];
		for(int i=0; i<MAX; i++) arr[i] = map[i].clone();
		int h = block.length;
		int w = block[0].length;
		int r = h-1;
		for( ; r<MAX; r++) {
			boolean f = true;
			fir:for(int j=0; j<w; j++) {
				for(int k=0; k<h; k++) {
					if(arr[r][c+j] && block[k][j]) {
						f = false;
						break fir;
					}
				}
			}
			if(!f) {
				r--;
				break;
			}
			if(r==MAX-1) break;
		}
		for(int i=0; i<h; i++) {
			for(int j=0; j<w; j++) {
				arr[r-i][c+j] = arr[r-i][c+j] || block[h-1-i][j];
			}
		}
		if(verify(arr)) {
			System.out.println(c);
			return true;
		}
		return false;
	}
	static boolean verify(boolean[][] arr) {
		for(int j=0; j<arr[0].length; j++) {
			boolean f = arr[arr.length-1][j];
			for(int i=arr.length-2; i>=0; i--) {
				if(!f && arr[i][j]) return false;
				f = arr[i][j];
			}
		}
		return true;
	}
}
