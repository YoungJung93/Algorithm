package Problem;

import java.util.Scanner;

public class Solution_5215_햄버거다이어트_미완 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int[] result = new int[t];
		int[][] arr; // [���� ���� ����][Į�θ�]
		int[] score;
		int n, l, max, scoreMax;
		for(int i=0; i<t; i++) {
			n = sc.nextInt(); // ����� ��
			l = sc.nextInt(); // ���� Į�θ�
			arr = new int[n][2];
			score = new int[n];
			max=0; scoreMax=0;
			for(int j=0; j<n; j++) {
				arr[j][0] = sc.nextInt(); // �� ����
				arr[j][1] = sc.nextInt(); // ����� Į�θ�
			}
			for(int j=0, size=arr.length; j<size; j++) {
				max = arr[j][1];
				score[j] = arr[j][0];
				
				for(int k=j+1; k<size; k++) {
					score[j] = comb(arr, k, l, max, score[j]);
				}
			}
			for(int j=0, size=score.length; j<size ;j++) {
				if(score[j] > scoreMax) scoreMax = score[j];
			}
			result[i] = scoreMax;
		}
		for(int i=0; i<t; i++) System.out.println("#" + (i+1) + " " + result[i]);
	}
	public static int comb(int[][] arr,int startInd, int l, int max, int score) {
		int score_;
		if(max > l) score = 0;
		else if(startInd < arr.length) {
			if (arr[startInd][1] + max < l) {
				max += arr[startInd][1];
				score += arr[startInd][0];
				score = comb(arr, startInd + 1, l, max, score);
			}
			else 
				score = comb(arr, startInd + 1, l, max, score);
		}
		score_ = comb(arr, startInd + 1, l, max, score);
		if(score < score_) score = score_;
		return score;
	}

}
