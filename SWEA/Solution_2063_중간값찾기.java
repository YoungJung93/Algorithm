package Problem;

import java.util.Scanner;

public class Solution_2063_중간값찾기 {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = sc.nextInt();
        }
        BubbleSort(arr);
        System.out.println(arr[N/2]);
    }
    public static void BubbleSort(int[] arr) {
        int N = arr.length;
        int tmp;
        for(int i=N-1; i>=0; --i) {
            for(int j=0; j<i; j++) {
                if(arr[j] > arr[j+1]) {
                    tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
    }
}