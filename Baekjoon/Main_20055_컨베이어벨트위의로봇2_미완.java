package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_20055_컨베이어벨트위의로봇2_미완 {
	static int N, K, first, num;
	static stat[] con;
	static class stat {
		boolean robot;
		int dur, no;
		public stat(boolean robot, int dur, int no) {
			this.robot = robot;
			this.dur = dur;
			this.no = no;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		con = new stat[2*N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<2*N; i++) {
			int a = Integer.parseInt(st.nextToken());
			con[i] = new stat(false, a, 0);
		}
		first = -1;
		num = 1;
		
		int answer = 0;
		while(true) {
			answer++;
			rotate();
			move();
			if(!con[0].robot) {
				con[0].robot = true;
				con[0].no = num++;
				con[0].dur--;
				if(first == -1) first = 0;
			}
			if(canEnd() >= K) {
				break;
			}
			System.out.println(answer);
		}
		
		System.out.println(answer);
	}
	public static void rotate() {
		stat[] tmp = new stat[2*N];
		tmp[0] = new stat(con[2*N-1].robot, 0, con[2*N-1].no);
		for(int i=0; i<2*N-1; i++) {
			tmp[i+1] = new stat(con[i].robot, 0, con[i].no);
		}
		for(int i=0; i<2*N; i++) {
			tmp[i].dur = con[i].dur;
		}
		con = tmp.clone();
		if(first!=-1) first = first+1>=2*N ? 0 : first+1;
	}
	public static void move() {
		if(first == -1) return;
		for(int i=first, j=0, n=1; j==0 || i!=first; j++) {
			int tar = i+1>=2*N ? 0 : i+1;
			if(con[i].robot && con[i].no == n) {
				if(!con[tar].robot && con[tar].dur >= 1) {
					con[tar].robot = true;
					con[tar].dur--;
					con[tar].no = n;
					con[i].no = 0;
					con[i].robot = false;
				}
				n++;
			}
			i = tar;
		}
	}
	public static int canEnd() {
		int res = 0;
		for(int i=0; i<2*N; i++) {
			if(con[i].dur == 0) res++; 
		}
		return res;
	}
}
