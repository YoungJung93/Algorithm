package Problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_5569_출근경로_미완 {
	static int cnt=0, w, h;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		root(1, 1, 0, false);
		root(2, 0, 1, false);
		cnt = cnt % 100000;
//		System.out.println(cnt % 100000);
		bw.write(cnt + "\n");
		bw.flush();
		bw.close();
	}
	public static void root(int f, int x, int y, boolean flag) {
		if(x==w-1 && y==h-1) {
			cnt++; return;
		} else if(x==w-1) {
			if(flag && f==1) return;
			else if(f==1) root(2, x, y+1, true);
			else root(2, x, y+1, false);
		} else if(y==h-1) {
			if(flag && f==2) return;
			else if(f==2) root(1, x+1, y, true);
			else root(1, x+1, y, false);
		} else {
			if(flag) {
				if(f==1) root(1, x+1, y, false);
				else root(2, x, y+1, false);
			} else {
				if(f==1) {
					root(1, x+1, y, false);
					root(2, x, y+1, true);
				} else {
					root(1, x+1, y, true);
					root(2, x, y+1, false);
				}
			}
		}
	}
}
