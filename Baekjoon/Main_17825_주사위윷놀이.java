package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_17825_주사위윷놀이 {
	static class pair {
		int r, c, score;
		public pair(int r, int c, int score) {
			this.r = r; this.c = c;
			this.score = score;
		}
	}
	static int[][] map;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[][] {
			{0,2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38,40,-1},
			{10,13,16,19,25,30,35,40,-1},
			{20,22,24,25,30,35,40,-1},
			{30,28,27,26,25,30,35,40,-1}
		};
		arr = new int[10];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<10; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		answer = 0;
		dfs(0, 4, new ArrayList<pair>());
		
		System.out.println(answer);
	}
	static int answer;
	static void dfs(int seq, int rest, List<pair> mal) {
		if(seq >= 10) {
			int sum = 0;
			for(int i=0, size=mal.size(); i<size; i++) {
				sum += mal.get(i).score;
			}
			if(sum > answer) {
				answer = sum;
			}
			return;
		}
		if(rest > 0) {
			List<pair> list = new ArrayList<>();
			for(int i=0, size=mal.size(); i<size; i++) {
				pair p = mal.get(i);
				list.add(new pair(p.r, p.c, p.score));
			}
			pair p = null;
			if(arr[seq] == 5) p = new pair(1,0,map[1][0]);
			else p = new pair(0,arr[seq],map[0][arr[seq]]);
			if(canInsert(p.r, p.c, list)) {
				list.add(p);
				dfs(seq+1, rest-1, list);
			}
		}
		for(int i=0, size=mal.size(); i<size; i++) {
			List<pair> list = new ArrayList<>();
			for(int j=0; j<size; j++) {
				pair p = mal.get(j);
				list.add(new pair(p.r, p.c, p.score));
			}
			pair cur = new pair(list.get(i).r, list.get(i).c, list.get(i).score);
			list.remove(i);
			if((cur.r==0 && cur.c==21) || (cur.r==1 && cur.c==8) || 
					(cur.r==2 && cur.c==7) || (cur.r==3 && cur.c==8)) continue;
			pair ins = null;
			int r=0, c=0;
			if(cur.r == 0) {
				if(cur.c+arr[seq]==5) {
					r = 1; c = 0;
					if(!canInsert(r, c, list)) continue;
					ins = new pair(r, c, cur.score+map[r][c]);
				} else if(cur.c+arr[seq]==10) {
					r = 2; c = 0;
					if(!canInsert(r, c, list)) continue;
					ins = new pair(r, c, cur.score+map[r][c]);
				} else if(cur.c+arr[seq]==15) {
					r = 3; c = 0;
					if(!canInsert(r, c, list)) continue;
					ins = new pair(r, c, cur.score+map[r][c]);
				} else {
					r = 0; c = cur.c + arr[seq];
					if(!canInsert(r, c, list)) continue;
					if(c<21) ins = new pair(r, c, cur.score+map[r][c]);
					else ins = new pair(r, 21, cur.score);
				}
			} else if(cur.r == 1) {
				r = 1; c = cur.c+arr[seq];
				if(!canInsert(r, c, list)) continue;
				if(c<8) ins = new pair(r, c, cur.score+map[r][c]);
				else ins = new pair(r, 8, cur.score);
			} else if(cur.r == 2) {
				r = 2; c = cur.c + arr[seq];
				if(!canInsert(r, c, list)) continue;
				if(c<7) ins = new pair(r, c, cur.score+map[r][c]);
				else ins = new pair(r, 7, cur.score);
			} else {
				r = 3; c = cur.c + arr[seq];
				if(!canInsert(r, c, list)) continue;
				if(c<8) ins = new pair(r, c, cur.score+map[r][c]);
				else ins = new pair(r, 8, cur.score);
			}
			list.add(i, ins);
			dfs(seq+1, rest, list);
		}
	}
	static boolean canInsert(int r, int c, List<pair> list) {
		if((r==0 && c>=21) || (r==1 && c>=8) || 
				(r==2 && c>=7) || (r==3 && c>=8)) {
			return true;
		}
		for(int i=0, size=list.size(); i<size; i++) {
			pair p = list.get(i);
			if(p.r == r && p.c == c) return false;
			if((r==1&&c==4) || (r==2&&c==3) || (r==3&&c==4)) {
				if((p.r==1&&p.c==4) || (p.r==2&&p.c==3) || (p.r==3&&p.c==4)) 
					return false;
			}
			if((r==0&&c==20) || (r==1&&c==7) || (r==2&&c==6) || (r==3&&c==7)) {
				if((p.r==0&&p.c==20) || (p.r==1&&p.c==7) || (p.r==2&&p.c==6) || (p.r==3&&p.c==7))
					return false;
			}
			if((r==1&&c==5) || (r==2&&c==4) || (r==3&&c==5)) {
				if((p.r==1&&p.c==5) || (p.r==2&&p.c==4) || (p.r==3&&p.c==5))
					return false;
			}
			if((r==1&&c==6) || (r==2&&c==5) || (r==3&&c==6)) {
				if((p.r==1&&p.c==6) || (p.r==2&&p.c==5) || (p.r==3&&p.c==6))
					return false;
			}
		}
		return true;
	}
}
