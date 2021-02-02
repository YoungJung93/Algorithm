package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_1938_통나무옮기기 {
	static int N;
	static int[][] map;
	static boolean[][][] flag;
	static tnm src, dest;
	static class tnm {
		int prex, prey, cenx, ceny, nextx, nexty, cnt, dir;	// dir : 0(가로), 1(세로)
		public tnm() {
			this.prex = 0; this.prey = 0;
			this.cenx = 0; this.ceny = 0;
			this.nextx = 0; this.nexty = 0;
			this.cnt = 0;
		}
		public tnm(int prex, int prey, int cenx, int ceny, int nextx, int nexty, int cnt, int dir) {
			this.prex = prex; this.prey = prey;
			this.cenx = cenx; this.ceny = ceny;
			this.nextx = nextx; this.nexty = nexty;
			this.cnt = cnt; this.dir = dir;
		}
	}
	static int[] dr = {-1,1,0,0}, dc = {0,0,-1,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		flag = new boolean[N][N][2];
		src = new tnm(); dest = new tnm();
		int sr = 0, de = 0;
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<N; j++) {
				char c = s.charAt(j);
				switch(c) {
				case 'B' :
					map[i][j] = 1;
					if(sr==0) { src.prex=i; src.prey=j; sr++; }
					else if(sr==1) { src.cenx=i; src.ceny=j; sr++; }
					else { src.nextx=i; src.nexty=j; sr++; }
					break;
				case 'E' :
					map[i][j] = 2; 
					if(de==0) { dest.prex=i; dest.prey=j; de++; }
					else if(de==1) { dest.cenx=i; dest.ceny=j; de++; }
					else { dest.nextx=i; dest.nexty=j; de++; }
					break;
				case '0' :
					map[i][j] = 0; break;
				case '1' :
					map[i][j] = -1; break;
				}
			}
		}
		if(src.prex==src.cenx) src.dir = 0;
		else src.dir=1;
		if(dest.prex==dest.cenx) dest.dir = 0;
		else dest.dir=1;
		Queue<tnm> que = new LinkedList<tnm>();
		que.offer(src);
		flag[src.cenx][src.ceny][src.dir] = true;
		int res = 0;
		all : while(!que.isEmpty()) {
			tnm cur = que.poll();
			for(int i=0; i<4; i++) {
				int dpx = cur.prex + dr[i];
				int dpy = cur.prey + dc[i];
				int dcx = cur.cenx + dr[i];
				int dcy = cur.ceny + dc[i];
				int dnx = cur.nextx + dr[i];
				int dny = cur.nexty + dc[i];
				if(dpx<0 || dpx>=N || dpy<0 || dpy>=N) continue;
				if(dcx<0 || dcx>=N || dcy<0 || dcy>=N) continue;
				if(dnx<0 || dnx>=N || dny<0 || dny>=N) continue;
				if(flag[dcx][dcy][cur.dir]) continue;
				if(map[dpx][dpy]==-1 || map[dcx][dcy]==-1 || map[dnx][dny]==-1) continue;
				if(cur.dir==dest.dir && dcx==dest.cenx && dcy==dest.ceny) {
					res = cur.cnt + 1;
					break all;
				}
				que.offer(new tnm(dpx,dpy,dcx,dcy,dnx,dny, cur.cnt+1,cur.dir));
				flag[dcx][dcy][cur.dir] = true;
			}
			if(cur.dir==0) {	// 가로 -> 세로
				if(cur.prex==0 || cur.prex==N-1) continue;
				if(map[cur.prex-1][cur.prey]==-1 || map[cur.prex+1][cur.prey]==-1) continue;
				if(map[cur.cenx-1][cur.ceny]==-1 || map[cur.cenx+1][cur.ceny]==-1) continue;
				if(map[cur.nextx-1][cur.nexty]==-1 || map[cur.nextx+1][cur.nexty]==-1) continue;
				int dpx = cur.cenx-1, dpy = cur.ceny;
				int dcx = cur.cenx, dcy = cur.ceny;
				int dnx = cur.cenx+1, dny = cur.ceny;
				if(dpx<0 || dpx>=N || dpy<0 || dpy>=N) continue;
				if(dcx<0 || dcx>=N || dcy<0 || dcy>=N) continue;
				if(dnx<0 || dnx>=N || dny<0 || dny>=N) continue;
				if(flag[dcx][dcy][1]) continue;
				if(map[dpx][dpy]==-1 || map[dcx][dcy]==-1 || map[dnx][dny]==-1) continue;
				if(dest.dir==1 && dcx==dest.cenx && dcy==dest.ceny) {
					res = cur.cnt + 1;
					break all;
				}
				que.offer(new tnm(dpx,dpy,dcx,dcy,dnx,dny,cur.cnt+1,1));
				flag[dcx][dcy][1] = true;
			} else {			// 세로 -> 가로
				if(cur.prey==0 || cur.prey==N-1) continue;
				if(map[cur.prex][cur.prey-1]==-1 || map[cur.prex][cur.prey+1]==-1) continue;
				if(map[cur.cenx][cur.ceny-1]==-1 || map[cur.cenx][cur.ceny+1]==-1) continue;
				if(map[cur.nextx][cur.nexty-1]==-1 || map[cur.nextx][cur.nexty+1]==-1) continue;
				int dpx = cur.cenx, dpy = cur.ceny-1;
				int dcx = cur.cenx, dcy = cur.ceny;
				int dnx = cur.cenx, dny = cur.ceny+1;
				if(dpx<0 || dpx>=N || dpy<0 || dpy>=N) continue;
				if(dcx<0 || dcx>=N || dcy<0 || dcy>=N) continue;
				if(dnx<0 || dnx>=N || dny<0 || dny>=N) continue;
				if(flag[dcx][dcy][0]) continue;
				if(map[dpx][dpy]==-1 || map[dcx][dcy]==-1 || map[dnx][dny]==-1) continue;
				if(dest.dir==0 && dcx==dest.cenx && dcy==dest.ceny) {
					res = cur.cnt + 1;
					break all;
				}
				que.offer(new tnm(dpx,dpy,dcx,dcy,dnx,dny,cur.cnt+1,0));
				flag[dcx][dcy][0] = true;
			}
		}
		System.out.println(res);
	}
}
