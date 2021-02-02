package Problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_6808_규영이와인영이의카드게임 {
	static int[] kyu;
	static int[] in;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int i=1; i<=T; ++i) {
			kyu = new int[9];
			in = new int[9];
			res_win=0;
			res_lose=0;
			int imsi[] = new int[18];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<9; ++j) {
				kyu[j] = Integer.parseInt(st.nextToken());
			}
			for(int j=0; j<9; ++j) {
				imsi[kyu[j]-1] = -1;
			}
			int ind=0;
			for(int j=0; j<18; ++j) {
				if(imsi[j]!=-1) in[ind++] = j+1;
			}
			game(0);
			bw.write("#" + i + " " + res_win + " " + res_lose + "\n");
			bw.flush();
		}
		bw.close();
	}
	static int res_win, res_lose;
	static void game(int index) {
		if(index == 9) {
			int iny=0, kyy=0;
			for(int i=0; i<9; ++i) {
				if(kyu[i] > in[i]) kyy+=kyu[i]+in[i];
				else if(kyu[i] < in[i]) iny+=kyu[i]+in[i];
			}
			if(kyy>iny) res_win++;
			else if(kyy<iny) res_lose++;
			return;
		}
		for(int i=index; i<9; ++i) {
			swap(index, i);
			game(index+1);
			swap(i, index);
		}
	}
	static void swap(int x, int y) {
		int tmp = in[x];
		in[x] = in[y];
		in[y] = tmp;
	}
}
