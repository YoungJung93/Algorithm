package Problem;

import java.util.*;

public class Main_17144_미세먼지안녕 {
	static int[][] arr;
	static int[][] tmp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r=sc.nextInt();
		int c=sc.nextInt();
		int t=sc.nextInt();
		int i,j,k;
		int a=0, b=0;
		int result=0;
		sc.nextLine();
		arr=new int[r][c];
		tmp=new int[r][c];
		for(i=0; i<r; i++) {
			for(j=0; j<c; j++) {
				arr[i][j] = sc.nextInt();
				tmp[i][j] = 0;
				if(arr[i][j]==-1) {
					if(a==0) a=i;
					else b=i;
				}
			}
		}
		for(i=0; i<t; i++) {
			extend(r,c,a,b);
			for(j=0; j<r; j++) {
				for(k=0; k<c; k++) {
					arr[j][k]=0;
				}
			}
			airCleaner(r,c,a,b);
		}
		for(i=0; i<r; i++) {
			for(j=0; j<c; j++) {
				result += arr[i][j];
			}
		}
		
		result += 2;
		System.out.println(result);
		sc.close();
	}
	static void extend(int r, int c, int a, int b) {
		int i,j;
		for(i=0; i<r; i++) {
			for(j=0; j<c; j++) {
				tmp[i][j]=0;
			}
		}
		for(i=0; i<r; i++) {
			for(j=0; j<c; j++) {
				if(arr[i][j]!=0 && arr[i][j]!=-1) {
					if(i==0 && j==0) { 
						tmp[i+1][j] += (arr[i][j]/5); 
						tmp[i][j+1] += (arr[i][j]/5);
						tmp[i][j] += (arr[i][j] - ((arr[i][j]/5) * 2));
					}
					else if(i==0 && j==(c-1)) {
						tmp[i+1][j] += (arr[i][j]/5);
						tmp[i][j-1] += (arr[i][j]/5);
						tmp[i][j] += (arr[i][j] - ((arr[i][j]/5) * 2));
					}
					else if(i==(r-1) && j==0) {
						tmp[i-1][j] += (arr[i][j]/5);
						tmp[i][j+1] += (arr[i][j]/5);
						tmp[i][j] += (arr[i][j] - ((arr[i][j]/5) * 2));
					}
					else if(i==(r-1) && j==(c-1)) {
						tmp[i-1][j] += (arr[i][j]/5);
						tmp[i][j-1] += (arr[i][j]/5);
						tmp[i][j] += (arr[i][j] - ((arr[i][j]/5) * 2));
					}
					else if(j==0) {
						if(i==(a-1)) {
							tmp[i-1][j] += (arr[i][j]/5);
							tmp[i][j+1] += (arr[i][j]/5);
							tmp[i][j] += (arr[i][j] - ((arr[i][j]/5) * 2));
						}
						else if(i==(b+1)) {
							tmp[i+1][j] += (arr[i][j]/5);
							tmp[i][j+1] += (arr[i][j]/5);
							tmp[i][j] += (arr[i][j] - ((arr[i][j]/5) * 2));
						}
						else {
							tmp[i-1][j] += (arr[i][j]/5);
							tmp[i+1][j] += (arr[i][j]/5);
							tmp[i][j+1] += (arr[i][j]/5);
							tmp[i][j] += (arr[i][j] - ((arr[i][j]/5) * 3));
						}
					}
					else if(j==(c-1)) {
						tmp[i-1][j] += (arr[i][j]/5);
						tmp[i+1][j] += (arr[i][j]/5);
						tmp[i][j-1] += (arr[i][j]/5);
						tmp[i][j] += (arr[i][j] - ((arr[i][j]/5) *3));
					}
					else if(i==0) {
						tmp[i][j-1] += (arr[i][j]/5);
						tmp[i][j+1] += (arr[i][j]/5);
						tmp[i+1][j] += (arr[i][j]/5);
						tmp[i][j] += (arr[i][j] - ((arr[i][j]/5) *3));
					}
					else if(i==(r-1)) {
						tmp[i][j-1] += (arr[i][j]/5);
						tmp[i][j+1] += (arr[i][j]/5);
						tmp[i-1][j] += (arr[i][j]/5);
						tmp[i][j] += (arr[i][j] - ((arr[i][j]/5) *3));
					}
					else {
						if((i==a || i==b) && j==1) {
							tmp[i][j+1] += (arr[i][j]/5);
							tmp[i-1][j] += (arr[i][j]/5);
							tmp[i+1][j] += (arr[i][j]/5);
							tmp[i][j] += (arr[i][j] - ((arr[i][j]/5) * 3));
						}
						else {
							tmp[i][j-1] += (arr[i][j]/5);
							tmp[i][j+1] += (arr[i][j]/5);
							tmp[i-1][j] += (arr[i][j]/5);
							tmp[i+1][j] += (arr[i][j]/5);
							tmp[i][j] += (arr[i][j] - ((arr[i][j]/5) *4));
						}
					}
					tmp[a][0]=-1;
					tmp[b][0]=-1;
				}
			}
		}
		
	}
	static void airCleaner(int r, int c, int a, int b) {
		int i,j;
		
		for(i=0; i<r; i++) {
			for(j=0; j<c; j++) {
				arr[i][j]=tmp[i][j];
			}
		}
		for(i=0,j=0; i<a; i++) arr[i+1][j]=tmp[i][j]; // 0행 ~ a-1행, 0열 행+1
		for(i=0,j=1; j<c; j++) arr[i][j-1]=tmp[i][j]; // 0행, 1열 ~ c-1열 열-1
		for(i=1,j=c-1; i<=a; i++) arr[i-1][j]=tmp[i][j]; // 1행 ~ a행, c-1열 행-1
		for(i=a,j=1; j<(c-1); j++) arr[i][j+1]=tmp[i][j]; // a행, 1열 ~ c-2열 열+1
		
		for(i=b+1,j=0; i<r; i++) arr[i-1][j]=tmp[i][j]; // b+1행 ~ r-1행, 0열 행-1
		for(i=r-1,j=1; j<c; j++) arr[i][j-1]=tmp[i][j]; // r-1행, 1열 ~ c-1열 열-1
		for(i=b,j=c-1; i<(r-1); i++) arr[i+1][j]=tmp[i][j]; // b행 ~ r-2행, c-1열 행+1
		for(i=b,j=1; j<(c-1); j++) arr[i][j+1]=tmp[i][j]; // b행, 1열 ~ c-2열 열+1
		
		arr[a][1]=0; arr[b][1]=0;
		arr[a][0]=-1; arr[b][0]=-1;
	}
}
