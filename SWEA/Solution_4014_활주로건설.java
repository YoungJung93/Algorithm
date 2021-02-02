package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution_4014_활주로건설 {
    static int[][] map;
    static boolean[] flag;
    static int n, x;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i=1; i<=t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            map = new int[n][n];
            int res = 0;
            for(int j=0; j<n; j++) {
                st = new StringTokenizer(br.readLine());
                for( int k=0; k<n; k++) {
                    map[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            for(int j=0; j<n; j++) {
                flag = new boolean[n];
                if(isCons(j, 0)) {
//                  System.out.println("행 : " + j);
                    res++;          
                }
                flag = new boolean[n];
                if(isCons(j, 1)) {
//                  System.out.println("열 : " + j);
                    res++;
                }
            }
            System.out.println("#" + i + " " + res);
        }
    }
    static boolean isCons(int ind, int f) { // f = 0 : 행 / 1 : 열
        int curH = 0;
        if(f==0) {  // 행 기준
            curH = map[ind][0];
            for(int i=1; i<n; i++) {
                if(map[ind][i]==curH) continue;
                else {
                    if(Math.abs(map[ind][i]-curH)!=1) return false;
                    if(map[ind][i] > curH) {
                        int c = i - x;
                        if(c<0 || c>=n) return false;
                        boolean ff = true;
                        for(int j=c; j<i; j++) {
                            if(flag[j] || map[ind][j] != curH) {
                                ff = false; break;
                            }
                        }
                        if(!ff) return false;
                        for(int j=i-1; j>=c; j--) {
                            flag[j] = true;
                        }
                        curH = map[ind][i];
                    } else {
                        int c = i + (x-1);
                        if(c<0 || c>=n) return false;
                        boolean ff = true;
                        for(int j=i; j<=c; j++) {
                            if(flag[j] || map[ind][j] != map[ind][i]) {
                                ff = false; break;
                            }
                        }
                        if(!ff) return false;
                        for(int j=i; j<=c; j++) {
                            flag[j] = true;
                        }
                        curH = map[ind][i];
                        i += (x-1);
                    }
                }
            }
        } else {    // 열 기준
            curH = map[0][ind];
            for(int i=1; i<n; i++) {
                if(map[i][ind]==curH) continue;
                else {
                    if(Math.abs(map[i][ind]-curH)!=1) return false;
                    if(map[i][ind] > curH) {
                        int r = i - x;
                        if(r<0 || r>=n) return false;
                        boolean ff = true;
                        for(int j=r; j<i; j++) {
                            if(flag[j] || map[j][ind] != curH) {
                                ff = false; break;
                            }
                        }
                        if(!ff) return false;
                        for(int j=i-1; j>=r; j--) {
                            flag[j] = true;
                        }
                        curH = map[i][ind];
                    } else {
                        int r = i + (x-1);
                        if(r<0 || r>=n) return false;
                        boolean ff = true;
                        for(int j=i; j<=r; j++) {
                            if(flag[j] || map[j][ind] != map[i][ind]) {
                                ff = false; break;
                            }
                        }
                        if(!ff) return false;
                        for(int j=i; j<=r; j++) {
                            flag[j] = true;
                        }
                        curH = map[i][ind];
                        i += (x-1);
                    }
                }
            }
        }
        return true;
    }
}
