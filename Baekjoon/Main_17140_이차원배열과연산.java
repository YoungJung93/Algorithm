package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_17140_이차원배열과연산 {
	static int r, c, k;
	static int[][] arr;
	static int row = 3, col = 3;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[3][3];
		r = Integer.parseInt(st.nextToken())-1;
		c = Integer.parseInt(st.nextToken())-1;
		k = Integer.parseInt(st.nextToken());
		for(int i=0; i<3; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int t = 0;
		while(true) {
			if(t>100) {
				t=-1; break;
			}
			if(r<row && c<col) {
				if(arr[r][c]==k) break;
			}
			if(row>=col) {
				opR();
			} else {
				opC();
			}
			t++;
		}
		System.out.println(t);
	}
	static void opR() {
		int R = arr.length, C = 0;
		@SuppressWarnings("unchecked")
		ArrayList<Integer>[] list = new ArrayList[R];
		for(int i=0, size=arr[0].length; i<R; i++) {
			list[i] = new ArrayList<>();
			Arrays.sort(arr[i]);
			int base = -1;
			int a=0; // 각 숫자의 갯수
			ArrayList<int[]> list2 = new ArrayList<>();
			for(int j=0; j<size; j++) {
				if(arr[i][j]==0) continue;
				if(base==-1) base = arr[i][j];
				if(base==arr[i][j]) {
					a++;
				} else {
					list2.add(new int[] {base, a});
					base = arr[i][j];
					a = 1;
				}
				if(j==size-1) {
					list2.add(new int[] {base, a});
				}
			}
			Collections.sort(list2, new Comparator<int[]>() {
				public int compare(int[] o1, int[] o2) {
					if(o1[1] != o2[1]) return Integer.compare(o1[1], o2[1]);
					else return Integer.compare(o1[0], o2[0]);
				}
			});
			for(int j=0; j<list2.size(); j++) {
				list[i].add(list2.get(j)[0]);
				list[i].add(list2.get(j)[1]);
			}
			if(C < list[i].size()) C = list[i].size();
		}
		arr = new int[R][C];
		row = R; col = C;
		for(int i=0; i<R; i++) {
			for(int j=0, size=list[i].size()>100?100:list[i].size(); j<size; j++) {
				arr[i][j] = list[i].get(j);
			}
		}
	}
	static void opC() {
		int[][] arr2 = new int[col][row];
		for(int i=0; i<col; i++) {
			for(int j=0; j<row; j++) {
				arr2[i][j] = arr[j][i];
			}
		}
		int R = arr2.length, C = 0;
		@SuppressWarnings("unchecked")
		ArrayList<Integer>[] list = new ArrayList[R];
		for(int i=0, size=arr2[0].length; i<R; i++) {
			list[i] = new ArrayList<>();
			Arrays.sort(arr2[i]);
			int base = -1;
			int a=0; // 각 숫자의 갯수
			ArrayList<int[]> list2 = new ArrayList<>();
			for(int j=0; j<size; j++) {
				if(arr2[i][j]==0) continue;
				if(base==-1) base = arr2[i][j];
				if(base==arr2[i][j]) {
					a++;
				} else {
					list2.add(new int[] {base, a});
					base = arr2[i][j];
					a = 1;
				}
				if(j==size-1) {
					list2.add(new int[] {base, a});
				}
			}
			Collections.sort(list2, new Comparator<int[]>() {
				public int compare(int[] o1, int[] o2) {
					if(o1[1] != o2[1]) return Integer.compare(o1[1], o2[1]);
					else return Integer.compare(o1[0], o2[0]);
				}
			});
			for(int j=0; j<list2.size(); j++) {
				list[i].add(list2.get(j)[0]);
				list[i].add(list2.get(j)[1]);
			}
			if(C < list[i].size()) C = list[i].size();
		}
		arr = new int[C][R];
		row = C; col = R;
		for(int i=0; i<R; i++) {
			for(int j=0, size=list[i].size()>100?100:list[i].size(); j<size; j++) {
				arr[j][i] = list[i].get(j);
			}
		}
	}
}
