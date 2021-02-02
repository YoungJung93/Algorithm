package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
 
public class Solution_4013_특이한자석 {
    static int[][] wktjr;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i=1; i<=t; i++) {
            int n = Integer.parseInt(br.readLine());
            wktjr = new int[4][8];
            for(int j=0; j<4; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int k=0; k<8; k++) {
                    wktjr[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            int result = 0;
            for(int j=0; j<n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken())-1;
                int f = Integer.parseInt(st.nextToken());
                List<Integer> left = new ArrayList<>();
                List<Integer> right = new ArrayList<>();
                 
                int r1 = r, r2 = r-1;
                while(r2>=0) {
                    if(wktjr[r1][6] != wktjr[r2][2]) {
                        left.add(r2);
                        r1--; r2--;
                    } else break;
                }
                r1 = r; r2 = r+1;
                while(r2<4) {
                    if(wktjr[r1][2] != wktjr[r2][6]) {
                        right.add(r2);
                        r1++; r2++;;
                    } else break;
                }
                rotate(r, f);
                int ff = f;
                for(int ii=0, size=left.size(); ii<size; ii++) {
                    int e = left.get(ii);
                    ff *= -1;
                    rotate(e, ff);
                }
                ff = f;
                for(int ii=0, size=right.size(); ii<size; ii++) {
                    int e = right.get(ii);
                    ff *= -1;
                    rotate(e, ff);
                }
            }
            int a = 1;
            for(int j=0; j<4; j++) {
                if(wktjr[j][0]==1) result += a;
                a*=2;
            }
            System.out.println("#" + i + " " + result);
        }
    }
    static void rotate(int r, int f) {
        if(f==1) { // 시계방향
            int tmp = wktjr[r][7];
            for(int i=7; i>0; i--) {
                wktjr[r][i] = wktjr[r][i-1];
            }
            wktjr[r][0]=tmp;
        } else {    // 반시계방향
            int tmp = wktjr[r][0];
            for(int i=0; i<7; i++) {
                wktjr[r][i] = wktjr[r][i+1];
            }
            wktjr[r][7]=tmp;
        }
    }
}