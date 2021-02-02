package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
 
public class Solution_1258_행렬찾기 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] map;
        int t = Integer.parseInt(br.readLine());
        for(int i=1; i<=t; i++) {
            int n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            for(int j=0; j<n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int k=0; k<n; k++) {
                    map[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            List<int[]> list = new ArrayList<int[]>(); 
            for(int j=0; j<n; j++) {
                for(int k=0; k<n; k++) {
                    if(map[j][k]!=0) {
                        int r=1, c=1;
                        map[j][k] = 0;
                        for(int a=1; j+a<n; a++) {
                            if(map[j+a][k]!=0) {
                                map[j+a][k] = 0;
                                r++;
                            }
                            else break;
                        }
                        for(int a=1; k+a<n; a++) {
                            if(map[j][k+a]!=0) {
                                for(int b=0; b<r; b++) {
                                    map[j+b][k+a] = 0;                                  
                                }
                                c++;
                            }
                            else break;
                        }
                        list.add(new int[] {r, c});
                    }
                }
            }
            Collections.sort(list, new Comparator<int[]>() {
                public int compare(int[] o1, int[] o2) {
                    int a = o1[0]*o1[1] - o2[0]*o2[1];
                    if(a<0) return -1;
                    else if(a>0) return 1;
                    else return o1[0]-o2[0];
                }
            });
            System.out.print("#" + i + " " + list.size());
            for(int j=0; j<list.size(); j++) {
                System.out.print(" " + list.get(j)[0] + " " + list.get(j)[1]);
            }
            System.out.println();
        }
    }
}