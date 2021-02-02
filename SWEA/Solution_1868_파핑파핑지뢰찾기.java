package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
 
public class Solution_1868_파핑파핑지뢰찾기 {
    static class pair{
        public int x, y;
        public pair(int x, int y) {
            this.x = x; this.y = y;
        }
    }
    static int[][] map;
    static int n;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i=1; i<=t; i++) {
            n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            for(int j=0; j<n; j++) {
                String str = br.readLine();
                for(int k=0; k<n; k++) {
                    char c = str.charAt(k);
                    map[j][k] = c=='.' ? -1 : -2;
                }
            }
            update();
            int result = 0;
            for(int j=0; j<n; j++) {
                for(int k=0; k<n; k++) {
                    if(map[j][k] == 0) {
                        bfs(j, k);
                        result++;
                    }
                }
            }
            for(int j=0; j<n ;j++) {
                for(int k=0; k<n; k++) {
                    if(map[j][k] != -1 && map[j][k] != -2) {
                        map[j][k] = -1;
                        result++;
                    }
                }
            }
            System.out.println("#" + i + " " +result);
        }
    }
    static int[] dr = {-1,-1,-1,0,0,1,1,1};
    static int[] dc = {-1,0,1,-1,1,-1,0,1};
    static void bfs(int r, int c) {
        Queue<pair> que = new LinkedList<>();
        que.offer(new pair(r, c));
        while(!que.isEmpty()) {
            pair p = que.poll();
            if(map[p.x][p.y]==0) {
                for(int i=0, size=dr.length; i<size; i++) {
                    int dx = p.x + dr[i];
                    int dy = p.y + dc[i];
                    if(dx<0 || dy<0 || dx>=n || dy>=n) continue;
                    if(map[dx][dy] != -1 && map[dx][dy] != -2) {
                        que.offer(new pair(dx, dy));
                    }
                }
            }
            map[p.x][p.y]=-1; 
        }
    }
    static void update() {
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                int cnt=0;
                if(map[i][j]==-1) {
                    for(int k=0, size=dr.length; k<size; k++) {
                        int dx = i+dr[k];
                        int dy = j+dc[k];
                        if(dx<0 || dy<0 || dx>=n || dy>=n) continue;
                        if(map[dx][dy]==-2) cnt++;
                    }
                    map[i][j] = cnt;
                }
            }
        }
    }
}