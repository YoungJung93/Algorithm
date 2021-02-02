package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12100_2048Easy {
	static int N;
	static int[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		res = 0;
		dfs(map, 0);
		System.out.println(res);
	}
	static int res;
	static void dfs(int[][] arr, int cnt) {
		if(cnt==5) {
			int a = max_val(arr);
			if(a > res) res = a;
			return;
		}
		dfs(up(arr), cnt+1);
		dfs(down(arr), cnt+1);
		dfs(left(arr), cnt+1);
		dfs(right(arr), cnt+1);
	}
	static int[][] up(int[][] map) {
		int[][] arr = new int[N][N];
		for(int i=0; i<N; i++) arr[i] = map[i].clone();
		for(int j=0; j<N; j++) {
			for(int i=0; i<N; i++) {
				if(arr[i][j] != 0 && i>0) {
					int r = i-1;
					while(r>=0) {
						if(arr[r][j]==0) {
							if(r==0) break;
							r--;
						}
						else { r++; break; }
					}
					int tmp = arr[i][j];
					arr[i][j] = 0;
					arr[r][j] = tmp;
				}
			}
		}
		for(int j=0; j<N; j++) {
			for(int i=0; i<N-1; i++) {
				if(arr[i][j] != 0 && arr[i][j] == arr[i+1][j]) {
					arr[i][j] *= 2;
					arr[i+1][j] = 0;
					i++;
				}
			}
		}
		for(int j=0; j<N; j++) {
			for(int i=0; i<N; i++) {
				if(arr[i][j] != 0 && i>0) {
					int r = i-1;
					while(r>=0) {
						if(arr[r][j]==0) {
							if(r==0) break;
							r--;
						}
						else { r++; break; }
					}
					int tmp = arr[i][j];
					arr[i][j] = 0;
					arr[r][j] = tmp;
				}
			}
		}
		return arr;
	}
	static int[][] down(int[][] map) {
		int[][] arr = new int[N][N];
		for(int i=0; i<N; i++) arr[i] = map[i].clone();
		for(int j=0; j<N; j++) {
			for(int i=N-1; i>=0; i--) {
				if(arr[i][j] != 0 && i<N-1) {
					int r = i+1;
					while(r<N) {
						if(arr[r][j]==0) {
							if(r==N-1) break;
							r++;
						}
						else { r--; break; }
					}
					int tmp = arr[i][j];
					arr[i][j] = 0;
					arr[r][j] = tmp;
				}
			}
		}
		for(int j=0; j<N; j++) {
			for(int i=N-1; i>0; i--) {
				if(arr[i][j] != 0 && arr[i][j] == arr[i-1][j]) {
					arr[i][j] *= 2;
					arr[i-1][j] = 0;
					i--;
				}
			}
		}
		for(int j=0; j<N; j++) {
			for(int i=N-1; i>=0; i--) {
				if(arr[i][j] != 0 && i<N-1) {
					int r = i+1;
					while(r<N) {
						if(arr[r][j]==0) {
							if(r==N-1) break;
							r++;
						}
						else { r--; break; }
					}
					int tmp = arr[i][j];
					arr[i][j] = 0;
					arr[r][j] = tmp;
				}
			}
		}
		return arr;
	}
	static int[][] left(int[][] map) {
		int[][] arr = new int[N][N];
		for(int i=0; i<N; i++) arr[i] = map[i].clone();
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(arr[i][j] != 0 && j>0) {
					int c = j-1;
					while(c>=0) {
						if(arr[i][c]==0) {
							if(c==0) break;
							c--;
						}
						else { c++; break; }
					}
					int tmp = arr[i][j];
					arr[i][j] = 0;
					arr[i][c] = tmp;
				}
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<N-1; j++) {
				if(arr[i][j] != 0 && arr[i][j] == arr[i][j+1]) {
					arr[i][j] *= 2;
					arr[i][j+1] = 0;
					j++;
				}
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(arr[i][j] != 0 && j>0) {
					int c = j-1;
					while(c>=0) {
						if(arr[i][c]==0) {
							if(c==0) break;
							c--;
						}
						else { c++; break; }
					}
					int tmp = arr[i][j];
					arr[i][j] = 0;
					arr[i][c] = tmp;
				}
			}
		}
		return arr;
	}
	static int[][] right(int[][] map) {
		int[][] arr = new int[N][N];
		for(int i=0; i<N; i++) arr[i] = map[i].clone();
		for(int i=0; i<N; i++) {
			for(int j=N-1; j>=0; j--) {
				if(arr[i][j] != 0 && j<N-1) {
					int c = j+1;
					while(c<N) {
						if(arr[i][c]==0) {
							if(c==N-1) break;
							c++;
						}
						else { c--; break; }
					}
					int tmp = arr[i][j];
					arr[i][j] = 0;
					arr[i][c] = tmp;
				}
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=N-1; j>0; j--) {
				if(arr[i][j] != 0 && arr[i][j] == arr[i][j-1]) {
					arr[i][j] *= 2;
					arr[i][j-1] = 0;
					j--;;
				}
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=N-1; j>=0; j--) {
				if(arr[i][j] != 0 && j<N-1) {
					int c = j+1;
					while(c<N) {
						if(arr[i][c]==0) {
							if(c==N-1) break;
							c++;
						}
						else { c--; break; }
					}
					int tmp = arr[i][j];
					arr[i][j] = 0;
					arr[i][c] = tmp;
				}
			}
		}
		return arr;
	}
	static int max_val(int[][] map) {
		int max = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] > max) max = map[i][j];
			}
		}
		return max;
	}
}
