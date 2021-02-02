package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_18188_다오의데이트 {
	static int H, W, res, srcx, srcy, dstx, dsty, N;
	static int[][] map;
	static int[][] move;
	static int[] dr = {-1,1,0,0}, dc = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		map = new int[H+1][W+1];
		for(int i=1; i<=H; i++) {
			String s = br.readLine();
			for(int j=1; j<=W; j++) {
				char c = s.charAt(j-1);
				if(c == '.') map[i][j] = 0;
				else if(c == 'D') {
					srcx = i; srcy = j;
					map[i][j] = 0;
				} else if(c == 'Z') {
					dstx = i; dsty = j;
					map[i][j] = 0;
				} else {
					map[i][j] = 1;
				}
			}
		}
		N = Integer.parseInt(br.readLine());
		move = new int[N+1][2];
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			char a = st.nextToken().charAt(0);
			char b = st.nextToken().charAt(0);
			move[i][0] = convertInt(a); move[i][1] = convertInt(b);
		}
		List<Character> list = new ArrayList<>();
		flag_res = false;
		result = "";
		dfs(srcx, srcy, 1, list);
		if(flag_res) {
			System.out.println("YES");
			System.out.println(result);
		} else System.out.println("NO");
	}
	static boolean flag_res;
	static String result;
	static void dfs(int r, int c, int cnt, List<Character> path) {	// cnt는 1부터
		if(flag_res) return;
		if(r == dstx && c == dsty) {
			for(int i=0, size=path.size(); i<size; i++) {
				result += path.get(i);
			}
			flag_res = true;
			return;
		} else if(cnt > N) return;
		
		for(int i=0; i<2; i++) {
			int dx = r + dr[move[cnt][i]];
			int dy = c + dc[move[cnt][i]];
			if(dx<1 || dy<1 || dx>H || dy>W) continue;
			if(map[dx][dy]==1) continue;
			path.add(convertChar(move[cnt][i]));
			dfs(dx, dy, cnt+1, path);
			path.remove(path.size()-1);
		}
	}
	static int convertInt(char c) {
		int result = 0;
		if(c == 'W') result = 0;
		else if(c == 'S') result = 1;
		else if(c == 'A') result = 2;
		else result = 3;
		return result;
	}
	static char convertChar(int a) {
		char result = 0;
		if(a == 0) result = 'W';
		else if(a == 1) result = 'S';
		else if(a == 2) result = 'A';
		else result = 'D';
		return result;
	}
}