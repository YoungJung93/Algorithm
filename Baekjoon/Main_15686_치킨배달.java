package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15686_치킨배달 {
	static pair[] chicken, home, picked;
	static int[] arr, map[];
	static int lenC, lenH, n, m;
	
	static class pair{
		public int x, y;
		public pair(int x, int y) {
			this.x = x; this.y = y;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		picked = new pair[m];
		lenC=0; lenH=0;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==1) lenH++;
				else if(map[i][j]==2) lenC++;
			}
		}
		chicken = new pair[lenC];
		arr = new int[lenC];
		for(int i=0; i<m; i++) arr[i] = 1;
		Arrays.sort(arr);
		home = new pair[lenH];
		for(int i=0, c=0, h=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j]==2) chicken[c++] = new pair(i,j);
				else if(map[i][j]==1) home[h++] = new pair(i,j);
			}
		}
		int res = Integer.MAX_VALUE;
		do {
//			System.out.println(Arrays.toString(arr));
			for(int i=0, j=0; i<lenC; i++) {
				if(arr[i]==1) picked[j++] = chicken[i];
			}
//			System.out.println(Arrays.toString(picked));
			int a = gkatn();
			if(a<res) res = a;
		} while(np());
		System.out.println(res);
	}
	static int gkatn() {
		// 집들과 치킨집들과의 도시 치킨 거리 구하기
		int res = 0;
		for(int i=0; i<lenH; i++) {
			int min = Integer.MAX_VALUE;
			for(int j=0; j<m; j++) {
				int d = dist(home[i], picked[j]);
				if(d<min) min=d;
			}
			res += min;
		}
		return res;
	}
	static boolean np() {
		int i = lenC-1;
		while(i>0 && arr[i-1]>=arr[i]) --i;
		if(i==0) return false;
		int j = lenC-1;
		while(arr[i-1]>=arr[j]) --j;
		swap(i-1, j);
		j = lenC-1;
		while(i<j) swap(i++, j--);
		return true;
	}
	static void swap(int x, int y) {
		int tmp = arr[x];
		arr[x] = arr[y];
		arr[y] = tmp;
	}
	static int dist(pair p1, pair p2) {
		return Math.abs(p1.x-p2.x)+Math.abs(p1.y-p2.y);
	}
}
