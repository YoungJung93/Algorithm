package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution_5607_조합 {
    static int n, r, p;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i=1; i<=t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            p = 1234567891;
            long[] fac = new long[n+1];
            fac[1] = 1;
            for(int j=2; j<=n; j++) {
                fac[j] = (fac[j-1]*j)%p;
            }
            long a = fac[n];
            long b = (fac[r]*fac[n-r])%p;
            b = power(b, p-2);
            long res = (a*b)%p;
            System.out.println("#" + i + " " + res);
        }
    }
    static long power(long x, long y) {
        long ret = 1;
        while(y>0 ) {
            if(y%2!=0) {
                ret *= x;
                ret %= p;
            }
            x *= x;
            x %= p;
            y /= 2;
        }
        return ret;
    }
}
