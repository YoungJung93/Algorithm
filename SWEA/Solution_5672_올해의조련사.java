package Problem;

import java.util.Scanner;

public class Solution_5672_올해의조련사 {
    static char[] input, result;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=1; i<=t; i++) {
            int n = sc.nextInt();
            input = new char[n];
            result = new char[n];
            for(int j=0; j<n; j++) {
                input[j] = sc.next().charAt(0);
            }
            int head=0, tail=n-1, ind=0;
            while(head<=tail) {
                if(input[head] < input[tail]) {
                    result[ind++] = input[head++];
                } else if(input[head] > input[tail]) {
                    result[ind++] = input[tail--];
                } else {
                    int a = isDir(head, tail);
                    if(a==-1) {
                        result[ind++] = input[head++];
                    } else if(a==1) {
                        result[ind++] = input[tail--];
                    } else {
                        result[ind++] = input[head++];
                    }
                }
            }
            System.out.print("#" + i + " ");
            for(char c : result) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
    private static int isDir(int head, int tail) {
        while(++head<=--tail) {
            if(input[head] < input[tail]) return -1;
            else if(input[head] > input[tail]) return 1;
        }
        return 0;
    }
}