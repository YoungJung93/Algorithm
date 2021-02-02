package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2999_비밀이메일 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String email = br.readLine();
		int n = email.length();
		int r=1, c=n;
		int R=0, C=0;
		while(true) {
			if(r*c==n && r<=c && r>R) {
				R=r; C=c; c--; r=1;
			}
			if(r>=c) {
				r=1; c--;
			}
			if(c<1) break;
			r++;
		}
		char map[][] = new char[R][C];
		int eind=0;
		for(int i=0; i<C; i++) {
			for(int j=0; j<R; j++) {
				map[j][i] = email.charAt(eind++);
			}
		}
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				System.out.print(map[i][j]);
			}
		}
		System.out.println();
	}
}