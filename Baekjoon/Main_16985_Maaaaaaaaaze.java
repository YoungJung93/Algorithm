package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16985_Maaaaaaaaaze {
	static class pair {
		int x,y,z,cnt;
		public pair(int x, int y, int z, int cnt) {
			this.x = x; this.y = y; this.z = z; this.cnt = cnt;
		}
	}
	static int[] seq;
	static int[][][] arr, maze;
	static boolean[][][] flag;
	static final int SIZE = 5;
	static int[] dz = {-1,1,0,0,0,0};
	static int[] dr = {0,0,-1,1,0,0};
	static int[] dc = {0,0,0,0,-1,1};
	static int result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		seq = new int[SIZE];					// 판의 순서 저장 배열
		arr = new int[SIZE][SIZE][SIZE];		// 전체 정육면체(입력)
		maze = new int[SIZE][SIZE][SIZE];		// 전체 정육면체
		StringTokenizer st;
		for(int i=0; i<SIZE; i++) {
			seq[i] = i;
		}
		for (int k = 0; k < SIZE; k++) {
			for (int i = 0; i < SIZE; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < SIZE; j++) {
					arr[k][i][j] = Integer.parseInt(st.nextToken());
				}
			} 
		}
		result = Integer.MAX_VALUE;
		do {
			makeMaze();	// seq 배열대로 maze 배열 만들어주기
			// maze 배열의 5개 판 각각 돌려가며 bfs 돌리기
			for(int a=0; a<4; a++) {
				rotate(0);
				for(int b=0; b<4; b++) {
					rotate(1);
					for(int c=0; c<4; c++) {
						rotate(2);
						for(int d=0; d<4; d++) {
							rotate(3);
							for(int e=0; e<4; e++) {
								rotate(4);
								int bfs = bfs();
								if(bfs==12) bfs();
								if(bfs!=-1 && bfs<result) result = bfs;
							}
						}
					}
				}
			}
			// bfs 돌릴 때마다 최솟값 갱신
		} while(np());
		if(result==Integer.MAX_VALUE) result = -1;
		System.out.println(result);
	}
	static int bfs() {
		if(maze[0][0][0]==0) return -1;
		flag = new boolean[SIZE][SIZE][SIZE];
		Queue<pair> que = new LinkedList<pair>();
		que.offer(new pair(0,0,0,0));
		flag[0][0][0] = true;
		while(!que.isEmpty()) {
			pair cur = que.poll();
			if(cur.cnt >= result) continue;
			for(int i=0; i<6; i++) {
				int dx = cur.x + dz[i];
				int dy = cur.y + dr[i];
				int dz = cur.z + dc[i];
				if(dx<0 || dy<0 || dz<0 || dx>=SIZE || dy>=SIZE || dz>=SIZE) continue;
				if(flag[dx][dy][dz]) continue;
				if(maze[dx][dy][dz]==1) {
					if (dx == 4 && dy == 4 && dz == 4) return cur.cnt + 1;
					que.offer(new pair(dx, dy, dz, cur.cnt + 1));
					flag[dx][dy][dz] = true;
				}
			}
		}
		return -1;
	}
	static void makeMaze() {
		for(int i=0; i<SIZE; i++) {
			maze[i] = arr[seq[i]].clone();
		}
	}
	static void rotate(int a) {		// 판 1개 시계 방향으로 돌리기
		int[][] tmp = new int[SIZE][SIZE];
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE; j++) {
				tmp[j][SIZE-1-i] = maze[a][i][j];
			}
		}
		maze[a] = tmp.clone();
	}
	static boolean np() {
		int i = SIZE-1;
		while(i>0 && seq[i] <= seq[i-1]) i--;
		if(i==0) return false;
		int j = SIZE-1;
		while(seq[j] <= seq[i-1]) j--;
		swap(i-1, j);
		j = SIZE-1;
		while(j>i) swap(i++,j--);
		return true;
	}
	static void swap(int i, int j) {
		int tmp = seq[i];
		seq[i] = seq[j];
		seq[j] = tmp;
	}
}
