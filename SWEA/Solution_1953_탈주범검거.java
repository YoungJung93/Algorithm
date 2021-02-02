package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1953_탈주범검거 {
	static class pair {
        public int x, y, cnt;
        public pair(int x, int y, int cnt) {
            this.x = x; this.y = y; this.cnt = cnt;
        }
    }
    static int[][] map;
    static boolean[][] flag;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int n, m, l;
    static pair hole;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i=1; i<=t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            l = Integer.parseInt(st.nextToken());
            hole = new pair(r, c, 1);
            map = new int[n][m];
            flag = new boolean[n][m];
            for(int j=0; j<n; j++) {
                st = new StringTokenizer(br.readLine());
                for(int k=0; k<m; k++) {
                    map[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            bfs();
            int res = 0;
            for(boolean[] fl : flag) {
                for(boolean f : fl) {
                    if(f) res++;
                }
            }
            System.out.println("#" + i + " " + res);
        }
    }
     
    static void bfs() {
        Queue<pair> que = new LinkedList<pair>();
        que.offer(hole);
        flag[hole.x][hole.y] = true;
        while(!que.isEmpty()) {
            pair cur = que.poll();
            if(cur.cnt==l) break;
            for(int i=0; i<4; i++) {
                int dx = cur.x + dr[i];
                int dy = cur.y + dc[i];
                if(dx<0 || dy<0 || dx>=n || dy>=m) continue;
                if(!isConnection(cur, new pair(dx, dy, 0), i)) continue;
                if(flag[dx][dy]) continue;
                flag[dx][dy] = true;
                que.offer(new pair(dx, dy, cur.cnt+1));
            }
        }
    }
     
    static boolean isConnection(pair s, pair d, int dir) {
        int src = map[s.x][s.y];
        int dst = map[d.x][d.y];
        switch(src) {
        case 1:
            if(dir==0) {            // 상
                if(dst==1 || dst==2 || dst==5 || dst==6) return true;
            } else if(dir==1) {     // 하
                if(dst==1 || dst==2 || dst==4 || dst==7) return true;
            } else if(dir==2) {     //좌
                if(dst==1 || dst==3 || dst==4 || dst==5) return true;
            } else {                // 우
                if(dst==1 || dst==3 || dst==6 || dst==7) return true;
            }
            break;
        case 2:
            if(dir==0) {            // 상
                if(dst==1 || dst==2 || dst==5 || dst==6) return true;
            } else if(dir==1) {     // 하
                if(dst==1 || dst==2 || dst==4 || dst==7) return true;
            }
            break;
        case 3:
            if(dir==2) {        //좌
                if(dst==1 || dst==3 || dst==4 || dst==5) return true;
            } else if(dir==3){              // 우
                if(dst==1 || dst==3 || dst==6 || dst==7) return true;
            }
            break;
        case 4:
            if(dir==0) {            // 상
                if(dst==1 || dst==2 || dst==5 || dst==6) return true;
            } else if(dir==3) {             // 우
                if(dst==1 || dst==3 || dst==6 || dst==7) return true;
            }
            break;
        case 5:
            if(dir==1) {        // 하
                if(dst==1 || dst==2 || dst==4 || dst==7) return true;
            } else if(dir==3) {             // 우
                if(dst==1 || dst==3 || dst==6 || dst==7) return true;
            }
            break;
        case 6:
            if(dir==1) {        // 하
                if(dst==1 || dst==2 || dst==4 || dst==7) return true;
            } else if(dir==2) {     //좌
                if(dst==1 || dst==3 || dst==4 || dst==5) return true;
            }
            break;
        case 7:
            if(dir==0) {            // 상
                if(dst==1 || dst==2 || dst==5 || dst==6) return true;
            } else if(dir==2) {     //좌
                if(dst==1 || dst==3 || dst==4 || dst==5) return true;
            }
            break;
        }
        return false;
    }
}
