package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14500_테트로미노 {
	static int[][] map;
	static int N, M;
	static int[][][] tetro;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		tetro = new int[][][] {
			{{0,0}, {0,1}, {0,2}, {0,3}}, {{0,0}, {1,0}, {2,0}, {3,0}},
			{{0,0}, {0,1}, {1,0}, {1,1}}, {{0,0}, {1,0}, {2,0}, {2,1}},
			{{0,0}, {1,0}, {0,1}, {0,2}}, {{0,0}, {0,1}, {1,1}, {2,1}},
			{{0,0}, {0,1}, {0,2}, {-1,2}}, {{0,0}, {1,0}, {1,1}, {2,1}},
			{{0,0}, {0,1}, {-1,1}, {-1, 2}}, {{0,0}, {0,1}, {0,2}, {1,1}},
			{{0,0}, {1,0}, {2,0}, {1,1}}, {{0,0}, {0,1}, {0,2}, {-1,1}},
			{{0,0}, {1,0}, {2,0}, {1,-1}}, {{0,0}, {1,0}, {2,0}, {2,-1}},
			{{0,0}, {1,0}, {1,1}, {1,2}}, {{0,0}, {0,1}, {1,0}, {2,0}},
			{{0,0}, {0,1}, {0,2}, {1,2}}, {{0,0}, {1,0}, {1,-1}, {2,-1}},
			{{0,0}, {0,1}, {1,1}, {1,2}}
		};
		
		int answer = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				for(int a=0; a<19; a++) {
					int sum = 0;
					boolean f = true;
					for(int b=0; b<4; b++) {
						int dx = i + tetro[a][b][0];
						int dy = j + tetro[a][b][1];
						if(dx<0 || dy<0 || dx>=N || dy>=M) {
							f = false; break;
						}
						sum += map[dx][dy];
					}
					if(f && sum>answer) answer = sum;
				}
			}
		}
		
		System.out.println(answer);
	}
}
