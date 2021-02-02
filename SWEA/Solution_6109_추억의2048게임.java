package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution_6109_추억의2048게임 {
    static int[][] map, res;
    static boolean[][] flag;
    static int n;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i=1; i<=t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();
            map = new int[n][n];
            res = new int[n][n];
            flag = new boolean[n][n];
            for(int j=0; j<n; j++) {
                st = new StringTokenizer(br.readLine());
                for(int k=0; k<n; k++) {
                    map[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            switch(dir) {
            case "up" :
                for(int k=0; k<n; k++) {
                    for(int j=0; j<n; j++) {
                        if(map[j][k]==0) continue;
                        if(j==0) {
                            res[j][k] = map[j][k];
                            continue;
                        }
                        int ind=1;
                        boolean f = false;
                        while(ind<=j) {
                            if(res[j-ind][k]==0) {
                                ind++;
                            } else {
                                if(res[j-ind][k] == map[j][k] && !flag[j-ind][k]) {
                                    res[j-ind][k] *= 2;
                                    flag[j-ind][k] = true;
                                } else {
                                    res[j-ind+1][k] = map[j][k];
                                }
                                f=true;
                                break; 
                            }
                        }
                        if(!f) res[0][k] = map[j][k];
                    }
                }
                break;
            case "down" :
                for(int k=0; k<n; k++) {
                    for(int j=n-1; j>=0; j--) {
                        if(map[j][k]==0) continue;
                        if(j==n-1) {
                            res[j][k] = map[j][k];
                            continue;
                        }
                        int ind=1;
                        boolean f = false;
                        while(ind+j<n) {
                            if(res[j+ind][k]==0) {
                                ind++;
                            } else {
                                if(res[j+ind][k] == map[j][k] && !flag[j+ind][k]) {
                                    res[j+ind][k] *= 2;
                                    flag[j+ind][k] = true;
                                } else {
                                    res[j+ind-1][k] = map[j][k];
                                }
                                f=true;
                                break; 
                            }
                        }
                        if(!f) res[n-1][k] = map[j][k];
                    }
                }
                break;
            case "right" :
                for(int j=0; j<n; j++) {
                    for(int k=n-1; k>=0; k--) {
                        if(map[j][k]==0) continue;
                        if(k==n-1) {
                            res[j][k] = map[j][k];
                            continue;
                        }
                        int ind=1;
                        boolean f = false;
                        while(ind+k<n) {
                            if(res[j][k+ind]==0) {
                                ind++;
                            } else {
                                if(res[j][k+ind] == map[j][k] && !flag[j][k+ind]) {
                                    res[j][k+ind] *= 2;
                                    flag[j][k+ind] = true;
                                } else {
                                    res[j][k+ind-1] = map[j][k];
                                }
                                f=true;
                                break; 
                            }
                        }
                        if(!f) res[j][n-1] = map[j][k];
                    }
                }
                break;
            case "left" :
                for(int j=0; j<n; j++) {
                    for(int k=0; k<n; k++) {
                        if(map[j][k]==0) continue;
                        if(k==0) {
                            res[j][k] = map[j][k];
                            continue;
                        }
                        int ind=1;
                        boolean f = false;
                        while(ind<=k) {
                            if(res[j][k-ind]==0) {
                                ind++;
                            } else {
                                if(res[j][k-ind] == map[j][k] && !flag[j][k-ind]) {
                                    res[j][k-ind] *= 2;
                                    flag[j][k-ind] = true;
                                } else {
                                    res[j][k-ind+1] = map[j][k];
                                }
                                f=true;
                                break; 
                            }
                        }
                        if(!f) res[j][0] = map[j][k];
                    }
                }
                break;
            }
            System.out.println("#" + i);
            for(int[] re : res) {
                for(int r : re) {
                    System.out.print(r + " ");
                }
                System.out.println();
            }
        }
    }
}