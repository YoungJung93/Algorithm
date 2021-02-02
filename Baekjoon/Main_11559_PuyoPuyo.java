package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_11559_PuyoPuyo {
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[12][6];
        for(int i=0; i<12; i++) {
            String s = br.readLine();
            for(int j=0; j<6; j++) {
                char c = s.charAt(j);
                switch(c) {
                case '.':
                    map[i][j] = 0;
                    break;
                case 'R':
                    map[i][j] = 1;
                    break;
                case 'G':
                    map[i][j] = 2;
                    break;
                case 'B':
                    map[i][j] = 3;
                    break;
                case 'P':
                    map[i][j] = 4;
                    break;
                case 'Y':
                    map[i][j] = 5;
                    break;
                }
            }
        }
        int result = 0;
        while(go()) {
        	result++;
        }
        System.out.println(result);
    }
    static boolean[][] flag;
    static int[] dr = {0,0,-1,1};    // 좌우상하
    static int[] dc = {-1,1,0,0};
    static boolean go() {
    	boolean ff = false;
        flag = new boolean[12][6];
        for(int i=0; i<12; i++) {
            for(int j=0; j<6; j++) {
                // 4개 이상 뭉쳐있는지 확인
                if(map[i][j]!=0 && isPuyo(i, j)) {
                	ff = true;
                    // 뭉쳐있으면 0으로 바꿈
                	puyo(i,j);
                }
            }
        }
        // 0인 부분 내리기
        for(int j=0; j<6; j++) {
        	boolean f = false;
        	for(int i=11; i>=0; i--) {
        		if(map[i][j]==0) f = true;
        		else if(f) {
        			f=false;
        			while(true) {
        				if(i+1>11) break;
        				if(map[i+1][j]!=0) break;
        				map[i+1][j] = map[i][j];
        				map[i][j] = 0;
        				i++;
        			}
        		}
        	}
        }
        return ff;
    }
    static void puyo(int r, int c) {
    	int a = map[r][c];
        Queue<Integer> que = new LinkedList<Integer>();
        que.offer(r); que.offer(c);
        map[r][c] = 0;
        while(!que.isEmpty()) {
            int x = que.poll();
            int y = que.poll();
            for(int i=0; i<4; i++) {
                int dx = x + dr[i];
                int dy = y + dc[i];
                if(dx<0 || dx>=12 || dy<0 || dy>=6) continue;
                if(map[dx][dy]==a) {
                    que.offer(dx); que.offer(dy);
                    map[dx][dy] = 0;
                }
            }
        }
    }
    static boolean isPuyo(int r, int c) {
        int ea = 1;
        int a = map[r][c];
        Queue<Integer> que = new LinkedList<Integer>();
        que.offer(r); que.offer(c);
        flag[r][c] = true;
        while(!que.isEmpty()) {
            int x = que.poll();
            int y = que.poll();
            for(int i=0; i<4; i++) {
                int dx = x + dr[i];
                int dy = y + dc[i];
                if(dx<0 || dx>=12 || dy<0 || dy>=6) continue;
                if(flag[dx][dy]) continue;
                if(map[dx][dy]==a) {
                    ea++;
                    que.offer(dx); que.offer(dy);
                    flag[dx][dy] = true;
                }
                if(ea>=4) return true;
            }
        }
        return false;
    }
}