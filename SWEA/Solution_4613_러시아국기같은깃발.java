package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution_4613_러시아국기같은깃발 {
    static int[][] map;
    static int n, m;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i=1; i<=t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            map = new int[n][m];
            int arr[] = new int[n];
            for(int j=0; j<n; j++) {
                String s = br.readLine();
                for(int k=0; k<m; k++) {
                    char c = s.charAt(k);
                    if(c=='W') map[j][k] = 1;
                    else if(c=='B') map[j][k] = 2;
                    else map[j][k] = 3;
                }
            }
            int result = Integer.MAX_VALUE;
            for(int start=1; start<n-1; start++) {
                for(int end=n-2; end>=start; end--) {
                    for(int j=0; j<start; j++) arr[j] = 1;
                    for(int j=start; j<=end; j++) arr[j] = 2;
                    for(int j=end+1; j<n; j++) arr[j] = 3;
                    int res = 0;
                    for(int j=0; j<n; j++) {
                        res += canFill(j, arr[j]);
                    }
                    if(result > res) result = res;
                }
            }
            System.out.println("#" + i + " " + result);
        }
    }
    static int canFill(int row, int color) {
        int res = 0;
        for(int i=0; i<m; i++) {
            if(map[row][i]!=color) res++;
        }
        return res;
    }
}