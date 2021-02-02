package Problem;

import java.util.Scanner;
 
public class Solution_1210_Ladder1 {
    public static int[][] ladder = new int[100][100];
 
    public static int upLadder(int r, int c, int way) {
        if(r==0) return c;
        if(c>0 && ladder[r][c-1]==1 && way!= 2) {
            return upLadder(r,c-1,1);
        }
        else if(c<99 && ladder[r][c+1]==1 && way!=1) return upLadder(r, c+1, 2);
        else return upLadder(r-1, c, 0);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
         
        int end = -1;       // 도착지점
        for(int i=0; i<10; ++i) {
            sc.nextInt();
            sc.nextLine();
            for(int j=0; j<100; j++) {
                for(int k=0; k<100; k++) {
                    ladder[j][k] = sc.nextInt();
                }
            }
            for(int j=0; j<100; j++) {   // 도착지점 찾기
                if(ladder[99][j]==2) {
                    end=j; break;
                }
            }
            int start = upLadder(99, end, 0);
            System.out.println("#" + (i+1) + " " + start);
        }
    }
 
}