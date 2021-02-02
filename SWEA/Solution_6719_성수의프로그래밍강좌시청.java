package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Solution_6719_성수의프로그래밍강좌시청 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i=1; i<=t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int arr[] = new int[n];
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n ;j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            int a = n-k;
            double res = 0;
            for(int j=a; j<n; j++) {
                res = (res+arr[j])/2;
            }
            System.out.print("#" + i + " ");
            System.out.printf("%.6f\n", res);
        }
    }
}   