package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17779_게리맨더링2 {
	static int[][] map;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int answer = Integer.MAX_VALUE;
		for(int i=0; i<N-2; i++) {
			for(int j=1; j<N-1; j++) {
				// 기준점 i,j
				for(int d1=1; d1<N; d1++) {
					for(int d2=1; d2<N; d2++) {
						if(i+d1+d2 >= N || j-d2<0 || j+d2>=N || j-d1+d2>=N || j-d1+d2<0 || 
								j+d2-d1>=N || j+d2-d1<0 || i+d1>=N || j-d1<0 || i+d2>=N || j+d2>=N) break;
						int[][] div = new int[N][N];
						for(int a=0; a<=d1; a++) div[i+a][j-a] = 5;
						for(int a=0; a<=d2; a++) div[i+a][j+a] = 5;
						for(int a=0; a<=d2; a++) div[i+d1+a][j-d1+a] = 5;
						for(int a=0; a<=d1; a++) div[i+d2+a][j+d2-a] = 5;
						
						for(int a=0; a<i+d1; a++) {
							for(int b=0; b<=j; b++) {
								if(div[a][b] == 5) break;
								div[a][b] = 1;
							}
						}
						
						for(int a=0; a<=i+d2; a++) {
							for(int b=N-1; b>j; b--) {
								if(div[a][b] == 5) break;
								div[a][b] = 2;
							}
						}
						
						for(int a=i+d1; a<N; a++) {
							for(int b=0; b<j-d1+d2; b++) {
								if(div[a][b] == 5) break;
								div[a][b] = 3;
							}
						}
						
						for(int a=i+d2+1; a<N; a++) {
							for(int b=N-1; b>=j-d1+d2; b--) {
								if(div[a][b] == 5) break;
								div[a][b] = 4;
							}
						}
						
						for(int a=0; a<N; a++) {
							for(int b=0; b<N; b++) {
								if(div[a][b] == 0) div[a][b] = 5;
							}
						}
						int max = 0, min = Integer.MAX_VALUE;
						int[] arr = new int[6];
						for(int a=0; a<N; a++) {
							for(int b=0; b<N; b++) {
								arr[div[a][b]] += map[a][b];
							}
						}
						for(int a=1; a<=5; a++) {
							if(arr[a] > max) max = arr[a];
							if(arr[a] < min) min = arr[a];
						}
						if(answer > max-min) answer = max-min;
					}
				}
			}
		}
		System.out.println(answer);
	}
}
