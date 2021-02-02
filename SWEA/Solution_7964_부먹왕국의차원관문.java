package Problem;

import java.util.Scanner;

public class Solution_7964_부먹왕국의차원관문 {
	public static int[] map;
	public static int find_one(int start, int end) {
		for(int i=end; i>start; i--) {
			if(i>=map.length) return map.length;
			else if(map[i]==1) return i;
		}
		return -1;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=1; i<=T; i++) {
			int N = sc.nextInt();
			int D = sc.nextInt();
			map = new int[N];
			for(int j=0; j<N; j++) {
				map[j] = sc.nextInt();
			}
			int ind = -1;
			int result = 0;
			int find;
			while (true) {
				find = find_one(ind, ind + D);
				if (find == -1) {
					ind += D;
					result++;
				} else if (find == map.length) {
					break;
				} else {
					ind = find;
				}
			}
			
			System.out.println("#" + i + " " + result);
		}
	}

}
