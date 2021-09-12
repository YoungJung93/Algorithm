package Problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1058_친구 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] fr_2 = new int[N+1];
		int[][] fr = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			String s = br.readLine();
			for(int j=1; j<=N; j++) {
				char c = s.charAt(j-1);
				if(c == 'Y') {
					fr[i][j] = 1;
				} else {
					fr[i][j] = 0;
				}
			}
		}
		
		int answer = 0;
		for(int a=1; a<=N; a++) {
			for(int b=1; b<=N; b++) {
				if(a == b) continue;
				if(fr[a][b] == 1) {
					fr_2[a]++;
				} else {
					boolean flag = false;
					for(int i=1; i<=N; i++) {
						if(i == a || i == b) continue;
						if(fr[a][i] == 1 && fr[b][i] == 1) {
							flag = true;
							break;
						}
					}
					if(flag) fr_2[a]++;
				}
			}
			if(fr_2[a] > answer) answer = fr_2[a];
		}
		
		System.out.println(answer);
	}

}
