package Problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2606_바이러스 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int c = Integer.parseInt(br.readLine());
		List<Integer>[] com = new LinkedList[c+1];
		for(int i=1; i<=c; ++i) {
			com[i] = new LinkedList<Integer>();
		}
		Queue<Integer> que = new LinkedList<>();
		boolean[] flag = new boolean[c+1];
		int ea = Integer.parseInt(br.readLine());
		for(int i=0; i<ea; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			com[x].add(y);
			com[y].add(x);
		}
		int cnt=0;
		que.offer(1);
		flag[1] = true;
		while(!que.isEmpty()) {
			int vi = que.poll();
			for(int i=0, size=com[vi].size(); i<size; ++i) {
				int t = com[vi].get(i);
				if(flag[t]) continue;
				que.add(t);
				flag[t] = true;
				cnt++;
			}
		}
		bw.write(cnt + "\n");
		bw.flush();
		bw.close();
	}
}
