package Problem;

import java.util.Scanner;

public class Solution_1204_최빈수구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] result = new int[T];
        int[] score, student;
        int freq, freq_score;
        for(int i=0; i<T; i++) {
            score = new int[1000];
            student = new int[101];
            freq = 0; freq_score = 0;
            sc.nextInt();
            for(int j=0; j<1000; j++) {
                score[j] = sc.nextInt();
            }
            for(int j=0; j<1000; j++) {
                student[score[j]] += 1;
            }
            for(int j=0; j<101; j++) {
                if(student[j] > freq) {
                    freq = student[j];
                    freq_score = j;
                }
                else if(student[j] == freq) {
                    if(j > freq_score) {
                        freq_score = j;
                    }
                }
            }
            result[i] = freq_score;
        }
        for(int i=0; i<T; i++)
            System.out.println("#" + (i+1) + " " + result[i]);
         
    }
 
}