package Problem;

import java.util.Scanner;

public class Solution_5431_민석이의과제체크하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int N, K, a;
        int[] student;
        for(int i=0; i<T; ++i) {
            N = sc.nextInt();
            student = new int[N];
            K = sc.nextInt();
            for(int j=0; j<K; ++j) {
                a = sc.nextInt();
                student[a-1] = 1;
            }
            System.out.print("#" + (i+1) + " ");
            for(int j=0; j<N; ++j) {
                if(student[j] != 1) System.out.print(j+1 + " ");
            }
            System.out.println();
        }
    }
 
}