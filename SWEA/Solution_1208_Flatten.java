package Problem;

import java.util.Scanner;

public class Solution_1208_Flatten {
    public static int findMax(int[] map) {
        int size = map.length, max=0, max_ind = 0;
        for(int i=0; i<size; ++i) {
            if(map[i] > max) {
                max = map[i];
                max_ind = i;
            }
        }
        return max_ind;
    }
    public static int findMin(int[] map) {
        int size = map.length, min=101, min_ind = 0;
        for(int i=0; i<size; ++i) {
            if(map[i] < min) {
                min = map[i];
                min_ind = i;
            }
        }
        return min_ind;
    }
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] result = new int[10];
        int[] map = new int[100];
        int dump;
        for (int i = 0; i < 10; ++i) {
            dump = sc.nextInt();
            for (int j = 0; j < 100; ++j) {
                map[j] = sc.nextInt();
            }
            for (int j = 0; j < dump; ++j) {
                map[findMax(map)]--;
                map[findMin(map)]++;
            }
            result[i] = map[findMax(map)] - map[findMin(map)];
        }
        for(int i=0; i<10; ++i) System.out.println("#" + (i+1) + " " + result[i]);
    }
 
}