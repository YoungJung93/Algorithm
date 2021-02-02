package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main_6987_월드컵 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        input = new int[4][19];
        arr = new int[19];
        for(int i=0; i<4; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=18; j++) {
                input[i][j] += Integer.parseInt(st.nextToken());
            }
        }
        result = new int[4];
        for(int i=1; i<=3; i++) {
            gkatn(1,2,i);
        }
        for(int a : result) System.out.print(a + " ");
        System.out.println();
    }
    static int[][] input;
    static int[] result, arr;
    static void gkatn(int a, int b, int res) {
        if(a==6) {
            for(int i=0; i<4; i++) {
                boolean f = true;
                for(int j=1; j<19; j++) {
                    if(input[i][j]!=arr[j]) {
                        f=false; break;
                    }
                }
                if(f) result[i] = 1;
            }
            return;
        }
         
        switch(res) {
        case 1 :
            for (int i = 1; i <= 3;i++) {
                arr[a*3-2]++;
                arr[b*3]++;
                if (b == 6) gkatn(a + 1, a + 2, i);
                else gkatn(a, b+1, i);
                arr[a*3-2]--;
                arr[b*3]--;
            }
            break;
        case 2 :
            for (int i = 1; i <= 3;i++) {
                arr[a*3-1]++;
                arr[b*3-1]++;
                if (b == 6) gkatn(a + 1, a + 2, i);
                else gkatn(a, b+1, i);
                arr[a*3-1]--;
                arr[b*3-1]--;
            }
            break;
        case 3 :
            for (int i = 1; i <= 3;i++) {
                arr[a*3]++;
                arr[b*3-2]++;
                if (b == 6) gkatn(a + 1, a + 2, i);
                else gkatn(a, b+1, i);
                arr[a*3]--;
                arr[b*3-2]--;
            }
            break;
        }
    }
}