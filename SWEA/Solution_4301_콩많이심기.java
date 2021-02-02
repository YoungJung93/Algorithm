package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution_4301_콩많이심기 {
    static int[][] map;
    static int[] dr = {-2, 2, 0, 0};
    static int[] dc = {0, 0, -2, 2};
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            map = new int[m][n];
            for(int j=0; j<m; j++) {
                for(int k=0; k<n; k++) {
                    updateMap(j, k);
                }
            }
            int res = 0;
            for(int[] ma : map) {
                for(int m : ma) {
                    if(m==1) res++;
                }
            }
            System.out.println("#" + i + " " + res);
        }
         
    }
    static void updateMap(int r, int c) {
        if (map[r][c] == 0) {
            map[r][c] = 1;
            for (int i = 0, size = dr.length; i < size; i++) {
                int dx = r + dr[i];
                int dy = c + dc[i];
                if (dx < 0 || dy < 0 || dx >= m || dy >= n)
                    continue;
                map[dx][dy] = 2;
            }
        }
    }
}