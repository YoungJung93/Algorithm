package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution_1247_최적경로 {
	static class pair {			// pair.x : x좌표 / pair.y : y좌표
		private int x, y;
		public pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
		public int getX() {return x;}
		public int getY() {return y;}
	}
	static pair[] list;			// 고객의 좌표를 저장할 배열
	static pair comp, home;		// comp : 회사 좌표 / home : 집 좌표
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; ++i) {
			int n = Integer.parseInt(br.readLine());
			list = new pair[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			comp = new pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			home = new pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			for (int j = 0; j < n; ++j) {
				list[j] = new pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			Arrays.sort(list, new Comparator<pair>() {		// next permutation을 하기 위해 pair의 x값을 기준으로 오름차순
				public int compare(pair o1, pair o2) {
					if(o1.getX()<o2.getX()) return -1;
					else if(o1.getX()>o2.getX()) return 1;
					return 0;
				}
			});
			int min = dist();	// 처음 입력 받은 순서대로 이동했을 때의 이동거리를 초기 min 변수에 저장
			while (permu()) {	// next permutation을 수행한 결과가 true이면 dis에 list 순서대로 이동한 이동거리를 저장하고, 이 값이 min보다 작으면 min값 갱신
				int dis = dist();
				if (dis < min) min = dis;
			}
			System.out.println("#" + i + " " + min);
		}
	}

	public static boolean permu() {			// pair의 x를 오름차순 정렬했으므로 next permutation으로 순열을 하나씩 뽑음
		int i = list.length - 1;
		while (i > 0 && list[i - 1].getX() >= list[i].getX()) --i;
		if (i == 0) return false;
		int j = list.length - 1;
		while (list[i - 1].getX() >= list[j].getX()) --j;
		swap(i - 1, j);
		j = list.length - 1;
		while (i < j) swap(i++, j--);
		return true;
	}

	public static void swap(int x, int y) {
		pair tmp = list[x];
		list[x] = list[y];
		list[y] = tmp;
	}

	public static int dist() {		// 현재 리스트 순서대로 이동했을 때의 이동 거리 계산
		int dis = 0;
		for (int i = 0; i < list.length + 1; ++i) {
			if (i == 0) dis += Math.abs(comp.getX() - list[i].getX()) + Math.abs(comp.getY() - list[i].getY());
			else if (i == list.length) dis += Math.abs(list[i - 1].getX() - home.getX()) + Math.abs(list[i - 1].getY() - home.getY());
			else dis += Math.abs(list[i - 1].getX() - list[i].getX()) + Math.abs(list[i - 1].getY() - list[i].getY());
		}
		return dis;
	}
}
