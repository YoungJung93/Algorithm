package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main_16235_나무재테크 {
	static int[][] map, A;
	static int n, m, k;
	static ArrayList<Integer>[][] age;
	static int[] dr = {-1,-1,-1,0,0,1,1,1};
	static int[] dc = {-1,0,1,-1,1,-1,0,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new int[n+1][n+1];
		A = new int[n+1][n+1];
		age = new ArrayList[n+1][n+1];
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				age[i][j] = new ArrayList<>();
			}
		}
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=n; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=1; i<=n; i++) {
			Arrays.fill(map[i], 5);
		}
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			age[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
		}
		for(int i=0; i<k; i++) {
			List<int[]> samang = new ArrayList<>();
			// 봄
			for(int a=1; a<=n; a++) {
				for(int b=1; b<=n; b++) {
					Collections.sort(age[a][b], new Comparator<Integer>() {
						public int compare(Integer o1, Integer o2) {
							return Integer.compare(o1, o2);
						}
					});
					for(int c=0; c<age[a][b].size(); c++) {
						if(age[a][b].get(c) <= map[a][b]) {
							map[a][b] -= age[a][b].get(c);
							age[a][b].set(c, age[a][b].get(c)+1);
						} else {
							samang.add(new int[] {a, b, age[a][b].get(c), c});
							age[a][b].remove(c--);
						}
					}
				}
			}
			// 여름
			for(int a=0; a<samang.size(); a++) {
				int[] rem = samang.get(a);
				map[rem[0]][rem[1]] += (rem[2]/2);
			}
			// 가을
			for(int a=1; a<=n; a++) {
				for(int b=1; b<=n; b++) {
					ArrayList<Integer> ll = age[a][b];
					for(int c=0, size=ll.size(); c<size; c++) {
						if(ll.get(c) % 5 == 0) {
							for(int d=0; d<dr.length; d++) {
								int dx = a + dr[d];
								int dy = b + dc[d];
								if(dx<1 || dy<1 || dx>n || dy>n) continue;
								age[dx][dy].add(1);
							}
						}
					}
				}
			}
			// 겨울
			for(int a=1; a<=n; a++) {
				for(int b=1; b<=n; b++) {
					map[a][b] += A[a][b];
				}
			}
		}
		int res = 0;
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				res+=age[i][j].size();
			}
		}
		System.out.println(res);
	}
}
