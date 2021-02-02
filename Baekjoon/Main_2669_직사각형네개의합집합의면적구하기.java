package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2669_직사각형네개의합집합의면적구하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[][] map = new boolean[101][101];
		for(int i=0; i<4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			for(int k=x1; k<x2; k++) {
				for(int w=y1; w<y2; w++) {
					map[k][w] = true;
				}
			}
		}
		int res = 0;
		for(boolean[] ma : map) {
			for(boolean m : ma) {
				if(m) res++;
			}
		}
		System.out.println(res);
	}
}