package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17837_새로운게임2 {
	// 오른, 왼, 위, 아래
	static int[] dr = {0,0,-1,1}, dc = {1,-1,0,0};
	// 흰색 : 0, 빨강 : 1, 파랑 : 2
	static int[][] map;
	static String[][][] arr;
	static int N, K;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		arr = new String[N][N][2];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				arr[i][j][0] = "";
				arr[i][j][1] = "";
			}
		}
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			int d = Integer.parseInt(st.nextToken())-1;
			arr[r][c][0] = Integer.toString(i);
			arr[r][c][1] = Integer.toString(d);
		}
		int answer = -1;
		main : for(int i=1; i<=1000; i++) {
			for(int j=0; j<K; j++) {
				int r = 0, c = 0;
				f : for(r=0 ; r<N; r++) {
					for(c=0 ; c<N; c++) {
						if(arr[r][c][0].contains(Integer.toString(j))) break f;
					}
				}
				String cs = String.copyValueOf(arr[r][c][0].toCharArray());
				String dir = String.copyValueOf(arr[r][c][1].toCharArray());
				int ind = 0;
				for(int size=cs.length(); ind<size; ind++) {
					if(cs.charAt(ind)-'0' == j) break;
				}
				int d = dir.charAt(ind) - '0';
				int dx = r + dr[d];
				int dy = c + dc[d];
				if(dx<0 || dy<0 || dx>=N || dy>=N || map[dx][dy]==2) {
					if(d==0) d=1;
					else if(d==1) d=0;
					else if(d==2) d=3;
					else d=2;
					dx = r + dr[d];
					dy = c + dc[d];
					dir = dir.substring(0, ind) + Integer.toString(d) + dir.substring(ind+1, cs.length());
					if(dx<0 || dy<0 || dx>=N || dy>=N || map[dx][dy]==2) {
						arr[r][c][1] = dir;
						continue;
					} else {
						if(map[dx][dy]==0) {
							arr[r][c][0] = cs.substring(0, ind);
							arr[r][c][1] = dir.substring(0, ind);
							arr[dx][dy][0] += cs.substring(ind, cs.length());
							arr[dx][dy][1] += dir.substring(ind, dir.length());
						} else if(map[dx][dy]==1) {
							arr[r][c][0] = cs.substring(0, ind);
							arr[r][c][1] = dir.substring(0, ind);
							arr[dx][dy][0] += reverse(cs.substring(ind, cs.length()));
							arr[dx][dy][1] += reverse(dir.substring(ind, dir.length()));
						}
					}
				} else if(map[dx][dy]==0) {
					arr[r][c][0] = cs.substring(0, ind);
					arr[r][c][1] = dir.substring(0, ind);
					arr[dx][dy][0] += cs.substring(ind, cs.length());
					arr[dx][dy][1] += dir.substring(ind, dir.length());
				} else if(map[dx][dy]==1) {
					arr[r][c][0] = cs.substring(0, ind);
					arr[r][c][1] = dir.substring(0, ind);
					arr[dx][dy][0] += reverse(cs.substring(ind, cs.length()));
					arr[dx][dy][1] += reverse(dir.substring(ind, dir.length()));
				}
				if(arr[dx][dy][0].length() >= 4) {
					answer = i;
					break main;
				}
			}
		}
		
		System.out.println(answer);
	}
	static String reverse(String s) {
		String res = "";
		int size = s.length();
		for(int i=size-1; i>=0; i--) {
			res += s.charAt(i);
		}
		return res;
	}
}
