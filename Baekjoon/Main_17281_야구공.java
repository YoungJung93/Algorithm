package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17281_야구공 {
	static int[] arr, player, score[];
	static int n, res;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[8];		
		player = new int[10];		// player[타순] = 선수번호
		score = new int[n+1][10];		// score[이닝][선수번호] = 해당 이닝에 낼 수 있는 점수
		for(int i=0; i<8; i++) arr[i] = i+2;
		for(int i=1; i<=n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1; j<10; j++) {
				score[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// score[n][player[타순]] = 해당 이닝에 낼 수 있는 결과
		int result = 0;
		do {
			for(int i=0; i<3; i++) player[i+1] = arr[i];
			player[4] = 1;
			for(int i=4; i<9; i++) player[i+1] = arr[i-1];
			res = 0;
			game();
			if(result<res) result=res;
		} while(np());
		System.out.println(result);
	}
	static void game() {
		int xktns = 1;
		int[] ss;
		for(int i=1; i<=n; i++) {
			int out = 3;
			ss = new int[3];
			while(out>0) {
				int a = score[i][player[xktns]];
				if(a==0) out--;
				else if(a==1 || a==2 || a==3) {
					for(int j=2; j>=0; j--) {
						if (ss[j]==1) {
							if (j + a >= 3) res++;
							else ss[j + a] = 1;
							ss[j] = 0;
						}
					}
					ss[a-1] = 1;
				}
				else if(a==4) {
					for(int j=0; j<3; j++) {
						if(ss[j]==1) {
							ss[j]=0;
							res++;
						}
					}
					res++;
				}
				xktns = xktns+1>9 ? 1 : xktns+1;
			}
		}
	}
	static boolean np() {
		int i = 7;
		while(i>0 && arr[i-1] >= arr[i]) --i;
		if(i==0) return false;
		int j = 7;
		while(arr[i-1] >= arr[j]) --j;
		swap(i-1, j);
		j = 7;
		while(i<j) swap(i++, j--);
		return true;
	}
	static void swap(int x, int y) {
		int tmp = arr[x];
		arr[x] = arr[y];
		arr[y] = tmp;
	}
}
