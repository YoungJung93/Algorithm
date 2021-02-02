package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution_1861_정사각형방 {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] map;
    static int n;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i=1; i<=t; i++) {
            n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            for(int j=0; j<n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int k=0; k<n; k++) {
                    map[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            int max = Integer.MIN_VALUE;
            int minR=-1, minC=-1;
            for(int j=0; j<n ;j++) {
                for(int k=0; k<n; k++) {
                    cnt = 1;
                    hamsu(j, k);
                    if(max<=cnt) {
                        if(max==cnt && map[j][k]<map[minR][minC]) {
                            minR=j; minC=k;
                        } else if(max<cnt) {
                            minR=j; minC=k;
                        }
                        max = cnt;
                    }
                }
            }
            System.out.println("#" + i + " " + map[minR][minC] + " " + max);
        }
    }
    static int cnt;
    static void hamsu(int r, int c) {
        int base = map[r][c];
        int rr = 0, cc = 0;
        for(int i=0; i<4; i++) {
            rr = r + dr[i];
            cc = c + dc[i];
            if(rr<0 || cc<0 || rr>=n || cc>=n) continue;
            if(map[rr][cc] == base+1) {
                cnt++;
                hamsu(rr, cc);
            }
        }
    }
}