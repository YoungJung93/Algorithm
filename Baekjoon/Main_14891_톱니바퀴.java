package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_14891_톱니바퀴 {
	static int[][] top;
	public static void main(String[] args) throws IOException {
		top = new int[5][8];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=1; i<=4; i++) {
			String s = br.readLine();
			for(int j=0; j<8; j++) {
				top[i][j] = s.charAt(j) - '0';
			}
		}
		int k = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			List<int[]> list = new ArrayList<int[]>();
			list.add(new int[] {t, d});
			int tt = t, lt = t-1, ld = d*-1;
			while(lt>0) {
				if(top[tt][6] != top[lt][2]) {
					list.add(new int[] {lt, ld});
					ld *= -1;
					tt = lt;
					lt--;
				} else break;
			}
			tt = t;
			int rt = t+1, rd = d*-1;
			while(rt<5) {
				if(top[tt][2] != top[rt][6]) {
					list.add(new int[] {rt, rd});
					rd *= -1;
					tt = rt;
					rt++;
				} else break;
			}
			for(int j=0,size=list.size(); j<size; j++) {
				rotate(list.get(j)[0], list.get(j)[1]);
			}
		}
		int answer = 0;
		if(top[1][0] == 1) answer += 1;
		if(top[2][0] == 1) answer += 2;
		if(top[3][0] == 1) answer += 4;
		if(top[4][0] == 1) answer += 8;
		System.out.println(answer);
	}
	static void rotate(int t, int d) {
		if(d==1) {
			int tmp = top[t][7];
			for(int i=7; i>=1; i--) {
				top[t][i] = top[t][i-1];
			}
			top[t][0] = tmp;
		} else {
			int tmp = top[t][0];
			for(int i=0; i<7; i++) {
				top[t][i] = top[t][i+1];
			}
			top[t][7] = tmp;
		}
	}
}
