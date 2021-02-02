package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_11729_하노이탑이동순서 {
	public static int count = 0;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		hanoi(n, 1, 2, 3);
		System.out.print(count + "\n" + sb);
	}

	public static void hanoi(int n, int start, int extra, int end) {
		count++;
		if (n == 1) {
			sb.append(start + " " + end + "\n");
			return;
		} else {
			hanoi(n - 1, start, end, extra);
			sb.append(start + " " + end + "\n");
			hanoi(n - 1, extra, start, end);
		}
	}
}