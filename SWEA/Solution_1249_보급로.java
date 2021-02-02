package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
 
public class Solution_1249_보급로 {
    static class pair{
        public int x, y;
        public pair(int x, int y) {
            this.x = x; this.y = y;
        }
    }
    static int n;
    static int[][] map;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
         
        for(int i=1; i<=t; i++) {
            n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            for(int j=0; j<n ;j++) {
                String str = br.readLine();
                for(int k=0; k<n; k++) {
                    map[j][k] = str.charAt(k) - '0';
                }
            }
            int[][] flag = new int[n][n];
            for(int j=0; j<n ;j++) {
                Arrays.fill(flag[j], -1);               
            }
            int res = Integer.MAX_VALUE;
            Queue<pair> que = new LinkedList<>();
            que.offer(new pair(0, 0));
            flag[0][0] = 0;
            while(!que.isEmpty()) {
                pair p = que.poll();
                if(p.x==n-1 && p.y==n-1) {
                    if(res > flag[n-1][n-1]) res = flag[n-1][n-1];
                    continue;
                }
                for(int j=0, size=dr.length; j<size; j++) {
                    int dx = p.x + dr[j];
                    int dy = p.y + dc[j];
                    if(dx<0 || dy<0 || dx>=n || dy>=n) continue;
                    if(flag[dx][dy] == -1) {
                        flag[dx][dy] = flag[p.x][p.y] + map[dx][dy];
                        que.offer(new pair(dx, dy));
                    } else {
                        if(flag[dx][dy] > flag[p.x][p.y] + map[dx][dy]) {
                            flag[dx][dy] = flag[p.x][p.y] + map[dx][dy];
                            que.offer(new pair(dx, dy));
                        }
                    }
                }
            }
            System.out.println("#" + i + " " + res);
        }
    }
}