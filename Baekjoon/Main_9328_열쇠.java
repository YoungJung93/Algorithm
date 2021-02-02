package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//소문자가 32 더 큼
public class Main_9328_열쇠 {
	static char[][] map;
	static int h, w;
	static int answer;
	static int[] dr = {-1,1,0,0}, dc = {0,0,-1,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			map = new char[h+2][w+2];
			for(int i=0; i<h+2; i++) Arrays.fill(map[i], '.');
			for(int i=1; i<=h; i++) {
				String s = br.readLine();
				for(int j=1; j<=w; j++) {
					map[i][j] = s.charAt(j-1);
				}
			}
			String key = br.readLine();
			if(!key.equals("0")) {
				for(int i=0, size=key.length(); i<size; i++) {
					char k = key.charAt(i);
					k = (char)(k-32);
					for(int r=0; r<h+2; r++) {
						for(int c=0; c<w+2; c++) {
							if(map[r][c]==k) {
								map[r][c] = '.';
							}
						}
					}
				}
			}
			answer = 0;
			
			boolean[][] flag = new boolean[h+2][w+2];
			Queue<Integer> que = new LinkedList<>();
			Queue<Integer>[] door = new Queue[26];
			for(int i=0; i<26; i++) door[i] = new LinkedList<>();
			que.offer(0); que.offer(0);
			flag[0][0] = true;
			while(!que.isEmpty()) {
				int r = que.poll();
				int c = que.poll();
				for(int i=0; i<4; i++) {
					int dx = r + dr[i];
					int dy = c + dc[i];
					if(dx<0 || dy<0 || dx>=h+2 || dy>=w+2) continue;
					if(flag[dx][dy]) continue;
					if(map[dx][dy] == '*') continue;
					else if(map[dx][dy]>='A' && map[dx][dy]<='Z') {
						int k = (map[dx][dy]-'A');
						door[k].offer(dx); door[k].offer(dy);
					} else if(map[dx][dy]>='a' && map[dx][dy]<='z') {
						int k = map[dx][dy] - 'a';
						while(!door[k].isEmpty()) {
							int rr = door[k].poll();
							int cc = door[k].poll();
							que.offer(rr); que.offer(cc);
						}
						char kk = (char)(map[dx][dy] - 32);
						for(int a=0; a<h+2; a++) {
							for(int b=0; b<w+2; b++) {
								if(map[a][b]==kk) {
									map[a][b] = '.';
								}
							}
						}
						que.offer(dx); que.offer(dy);
					} else if(map[dx][dy]=='$') {
						answer++;
						map[dx][dy] = '.';
						que.offer(dx);
						que.offer(dy);
					} else {
						que.offer(dx);
						que.offer(dy);
					}
					flag[dx][dy] = true;
				}
			}
			
			System.out.println(answer);
		}
	}
}
