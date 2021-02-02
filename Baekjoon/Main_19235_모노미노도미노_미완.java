package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_19235_모노미노도미노_미완 {
	static int[][] right, bottom;
	static int[] dr = {-1,1,0,0}, dc = {0,0,-1,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		right = new int[4][6];
		bottom = new int[6][4];
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int answer = 0;
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			// 블록 right, bottom에 옮기기
			if(t==1) {
				int rx = x, ry = 0;
				for( ; ry<6; ry++) {
					if(right[rx][ry]!=0) break;
				}
				ry--;
				right[rx][ry] = 1;
				int bx = 0, by = y;
				for( ; bx<6; bx++) {
					if(bottom[bx][by]!=0) break;
				}
				bx--;
				bottom[bx][by] = 1;
			} else if(t==2) {
				int rx1 = x, ry1 = 0;
				int rx2 = x, ry2 = 1;
				for( ; ry2<6; ry1++, ry2++) {
					if(right[rx2][ry2]!=0) break;
				}
				ry1--; ry2--;
				right[rx1][ry1] = 1;
				right[rx2][ry2] = 1;
				int bx1 = 0, by1 = y;
				int bx2 = 0, by2 = y+1;
				for( ; bx2<6; bx1++, bx2++) {
					if(bottom[bx1][by1]!=0 || bottom[bx2][by2]!=0) break;
				}
				bx1--; bx2--;
				bottom[bx1][by1] = 1;
				bottom[bx2][by2] = 1;
			} else {
				int rx1 = x, ry1 = 0;
				int rx2 = x+1, ry2 = 0;
				for( ; ry1<6; ry1++, ry2++) {
					if(right[rx1][ry1]!=0 || right[rx2][ry2]!=0) break;
				}
				ry1--; ry2--;
				right[rx1][ry1] = 1;
				right[rx2][ry2] = 1;
				int bx1 = 0, by1 = y;
				int bx2 = 1, by2 = y;
				for( ; bx2<6; bx1++, bx2++) {
					if(bottom[bx2][by2]!=0) break;
				}
				bx1--; bx2--;
				bottom[bx1][by1] = 1;
				bottom[bx2][by2] = 1;
			}
			
			int score = 0;
			// 꽉찬 행 or 열 확인 후 삭제하기, 몇 개 삭제했는지 세기(score)
			// right : 열 고정하고 행4개 확인
			while(true) {
				int ind = 10;
				for(int j=0; j<6; j++) {
					boolean f = true;
					for(int i=0; i<4; i++) {
						if(right[i][j]==0) {
							f = false;
							break;
						}
					}
					if(f) {
						ind = ind<j?ind:j;
						score++;
						for(int r=0; r<4; r++) right[r][j] = 0;
					}
				}
				if(score!=0) {
					ind--;
					for(int i=0; i<4; i++) {
						for(int j=ind; j>=0; j--) {
							right[i][j+score] = right[i][j];
							right[i][j] = 0;
						}
					}
					Queue<Integer> que = new LinkedList<Integer>();
					boolean[][] flag = new boolean[4][6];
					for(int i=0; i<4; i++) {
						if(right[i][5]==1) {
							que.offer(i);
							que.offer(5);
							flag[i][5] = true;
						}
					}
					while(!que.isEmpty()) {
						int r = que.poll();
						int c = que.poll();
						for(int i=0; i<4; i++) {
							int dx = r + dr[i];
							int dy = c + dc[i];
							if(dx<0 || dx>=4 || dy<0 || dy>=6) continue;
							if(right[dx][dy]==0) continue;
							if(flag[dx][dy]) continue;
							flag[dx][dy] = true;
							que.offer(dx);
							que.offer(dy);
						}
					}
					for(int i=0; i<4; i++) {
						for(int j=5; j>=0; j--) {
							if(right[i][j]==1 && !flag[i][j]) {
								for(int k=j+1; k<=6; k++) {
									if(k==6 || right[i][k]==1) {
										right[i][k-1] = 1;
										right[i][j] = 0;
										break;
									}
								}
							}
						}
					}
					answer += score;
					score = 0;
				} else break;
			}
			
			// bottom : 행 고정하고 열4개 확인
			while(true) {
				int ind = 10;
				for(int i=0; i<6; i++) {
					boolean f = true;
					for(int j=0; j<4; j++) {
						if(bottom[i][j]==0) {
							f = false;
							break;
						}
					}
					if(f) {
						ind = ind<i?ind:i;
						score++;
						for(int c=0; c<4; c++) bottom[i][c] = 0;
					}
				}
				if(score!=0) {
					ind--;
					for(int j=0; j<4; j++) {
						for(int i=ind; i>=0; i--) {
							bottom[i+score][j] = bottom[i][j];
							bottom[i][j] = 0;
						}
					}
					Queue<Integer> que = new LinkedList<Integer>();
					boolean[][] flag = new boolean[6][4];
					for(int j=0; j<4; j++) {
						if(bottom[5][j]==1) {
							que.offer(5);
							que.offer(j);
							flag[5][j] = true;
						}
					}
					while(!que.isEmpty()) {
						int r = que.poll();
						int c = que.poll();
						for(int i=0; i<4; i++) {
							int dx = r + dr[i];
							int dy = c + dc[i];
							if(dx<0 || dx>=6 || dy<0 || dy>=4) continue;
							if(bottom[dx][dy]==0) continue;
							if(flag[dx][dy]) continue;
							flag[dx][dy] = true;
							que.offer(dx);
							que.offer(dy);
						}
					}
					for(int j=0; j<4; j++) {
						for(int i=5; i>=0; i--) {
							if(bottom[i][j]==1 && !flag[i][j]) {
								for(int k=i+1; k<=6; k++) {
									if(k==6 || bottom[k][j]==1) {
										bottom[k-1][j] = 1;
										bottom[i][j] = 0;
										break;
									}
								}
							}
						}
					}
					answer += score;
					score = 0;
				} else break;
			}
							
			int rnum = 0;
			int bnum = 0;
			// 0, 1 행 or 열 확인, 0행(열)에 블록이 있으면 num=2, 1행(열)에 블록이 있으면 num=1, 그외 num=0
			for(int i=0; i<4; i++) {
				if(right[i][1]==1) { rnum++; break; }
			}
			for(int i=0; i<4; i++) {
				if(right[i][0]==1) { rnum++; break; }
			}
			for(int j=0; j<4; j++) {
				if(bottom[1][j]==1) { bnum++; break; }
			}
			for(int j=0; j<4; j++) {
				if(bottom[0][j]==1) { bnum++; break; }
			}
			if(rnum!=0) {
				if(rnum==1) {
					for(int c=5; c>1; c--) {
						for(int r=0; r<4; r++) {
							right[r][c] = right[r][c-1];
						}
					}
					for(int r=0; r<4; r++) right[r][1] = 0;
				} else {
					for(int c=5; c>1; c--) {
						for(int r=0; r<4; r++) {
							right[r][c] = right[r][c-2];
						}
					}
					for(int r=0; r<4; r++) { right[r][1] = 0; right[r][0] = 0; }
				}
			}
			if(bnum!=0) {
				if(bnum==1) {
					for(int r=5; r>1; r--) {
						for(int c=0; c<4; c++) {
							bottom[r][c] = bottom[r-1][c];
						}
					}
					for(int c=0; c<4; c++) bottom[1][c] = 0;
				} else {
					for(int r=5; r>1; r--) {
						for(int c=0; c<4; c++) {
							bottom[r][c] = bottom[r-2][c];
						}
					}
					for(int c=0; c<4; c++) { bottom[1][c] = 0; bottom[0][c] = 0; }
				}
			}
		}
		System.out.println(answer);
		int result = 0;
		for(int r=0; r<4; r++) {
			for(int c=0; c<6; c++) {
				if(right[r][c]==1) result++;
			}
		}
		for(int r=0; r<6; r++) {
			for(int c=0; c<4; c++) {
				if(bottom[r][c]==1) result++;
			}
		}
		System.out.println(result);
	}
}
