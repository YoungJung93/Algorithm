package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_15685_드래곤커브 {
	static List<int[]> list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		StringTokenizer st;
		list = new ArrayList<>();
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			go(x, y, d, g);
		}
		boolean[][] map = new boolean[101][101];
		for(int i=0,size=list.size(); i<size; i++) {
			map[list.get(i)[0]][list.get(i)[1]] = true;
		}
		int answer = 0;
		for(int i=0; i<=99; i++) {
			for(int j=0; j<=99; j++) {
				if(map[i][j] && map[i+1][j] &&
						map[i][j+1] && map[i+1][j+1]) answer++;
			}
		}
		System.out.println(answer);
	}
	static void go(int x, int y, int d, int g) {
		List<int[]> li = new ArrayList<>();
		li.add(new int[] {0, 0});
		if(d==0) li.add(new int[] {1, 0});
		else if(d==1) li.add(new int[] {0, -1});
		else if(d==2) li.add(new int[] {-1, 0});
		else li.add(new int[] {0, 1});
		for(int i=0; i<g; i++) {
			List<int[]> imsi = new ArrayList<>();
			int size=li.size();
			for(int j=0; j<size; j++) {
				imsi.add(new int[] {
					li.get(j)[1] * (-1), li.get(j)[0]	
				});
			}
			int dx = li.get(size-1)[0] - imsi.get(size-1)[0];
			int dy = li.get(size-1)[1] - imsi.get(size-1)[1];
			for(int j=size-2; j>=0; j--) {
				li.add(new int[] {
					imsi.get(j)[0] + dx, imsi.get(j)[1] + dy
				});
			}
		}
		for(int i=0,size=li.size(); i<size; i++) {
			list.add(new int[] {
				li.get(i)[0] + x, li.get(i)[1] + y	
			});
		}
	}
}
