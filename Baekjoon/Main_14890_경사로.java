package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14890_경사로 {
	static int N, l;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int answer = 0;
		for (int i = 0; i < N; i++) {
			int[] arr1 = map[i].clone();
			if (go(arr1)) {
				answer++;
			}
		}
		for (int i = 0; i < N; i++) {
			int[] arr1 = new int[N];
			for (int j = 0; j < N; j++) {
				arr1[j] = map[j][i];
			}
			if (go(arr1)) {
				answer++;
			}
		}

		System.out.println(answer);
	}

	static boolean go(int[] arr) {
		boolean[] flag = new boolean[N];
		for (int i = 1; i < N;) {
			if (arr[i - 1] == arr[i]) {
				i++;
				continue;
			}
			if (arr[i] < arr[i - 1]) {
				if (arr[i - 1] - arr[i] > 1)
					return false;
				if (flag[i])
					return false;
				flag[i] = true;
				boolean f = true;
				for (int j = i + 1; j < i + l; j++) {
					if (j >= N) {
						f = false;
						break;
					}
					if (flag[j]) {
						f = false;
						break;
					}
					if (arr[i] != arr[j]) {
						f = false;
						break;
					}
					flag[j] = true;
				}
				if (!f)
					return false;
				i += l;
			} else {
				if (arr[i] - arr[i - 1] > 1)
					return false;
				if (flag[i - 1])
					return false;
				flag[i - 1] = true;
				boolean f = true;
				for (int j = i - l; j < i - 1; j++) {
					if (j < 0) {
						f = false;
						break;
					}
					if (flag[j]) {
						f = false;
						break;
					}
					if (arr[i - 1] != arr[j]) {
						f = false;
						break;
					}
					flag[j] = true;
				}
				if (!f)
					return false;
				i++;
			}
		}
		return true;
	}
}