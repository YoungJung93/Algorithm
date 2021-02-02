package Problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_1075_나누기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int F = Integer.parseInt(br.readLine());
		int res = (N % 100) + (F - (N % F));
		while(true) {
			if(res-F >= 0) res = res - F;
			else break;
		}
		if(res < 10) bw.write("0" + res + "\n");
		else bw.write(res + "\n");
		bw.flush();
		bw.close();
	}
}
