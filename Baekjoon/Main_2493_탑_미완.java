package Problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_2493_탑 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<Integer> top = new Stack<>();
		Stack<Integer> res = new Stack<>();
		for(int i=0; i<T; ++i) {
//			top.push(Integer.parseInt(st.nextToken()));
			int N = Integer.parseInt(st.nextToken());
			if(top.isEmpty()) top.push(N);
			else {
				while(!top.isEmpty()) {
					
				}
			}
		}
		int ind = top.size()-1;
		for(int i=ind-1; i>=-1; --i) {
			if(top.isEmpty()) break;
			else if(i==-1) {
				res.push(0);
				if(!top.isEmpty()) top.pop();
				i = top.size()-1;
			} else if(top.get(i) >= top.peek()) {
				res.push(i+1);
				top.pop();
				i = top.size()-1;
			} 
		}
		for(int i=0, size=res.size(); i<size; ++i) {
			bw.write(res.pop() + " ");
		}
		bw.write("\n");
		bw.flush();
		bw.close();
	}
}
