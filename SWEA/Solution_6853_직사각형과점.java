package Problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_6853_직사각형과점 {
	static int x1, y1, x2, y2;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int i=1; i<=T; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			int in=0, out=0, bd=0;
			int n = Integer.parseInt(br.readLine());
			for(int j=0; j<n; ++j) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				if(judge(x,y)==0) in++;
				else if(judge(x,y)==1) out++;
				else if(judge(x,y)==2) bd++;
			}
			bw.write("#"+i+" "+in+" "+bd+" "+out+"\n");
			bw.flush();
		}
		bw.close();
	}
	static int judge(int x, int y) {
		if(x>x1 && x<x2 && y>y1 && y<y2) return 0;
		else if(((x==x1 || x==x2)&&y>=y1&&y<=y2) || 
				((y==y1 || y==y2)&&x>=x1&&x<=x2)) return 2;
		else return 1;
	}
}
