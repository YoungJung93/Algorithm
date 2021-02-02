package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_8911_거북이 {
	static int maxX, maxY, minX, minY;
	static int[] dr = {1,0,-1,0}, dc = {0,1,0,-1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int i=0; i<t; i++) {
			maxX = 0; maxY = 0;
			minX = 0; minY = 0;
			int dir = 0; 	// 처음 방향 북쪽
			int x = 0, y = 0;
			String s = br.readLine();
			for(int j=0, size=s.length(); j<size; j++) {
				char c = s.charAt(j);
				switch(c) {
				case 'F' :
					x = x + dr[dir];
					y = y + dc[dir];
					if(x > maxX) maxX = x;
					if(x < minX) minX = x;
					if(y > maxY) maxY = y;
					if(y < minY) minY = y;
					break;
				case 'B' :
					x = x - dr[dir];
					y = y - dc[dir];
					if(x > maxX) maxX = x;
					if(x < minX) minX = x;
					if(y > maxY) maxY = y;
					if(y < minY) minY = y;
					break;
				case 'L' :
					dir = rotate(1, dir);
					break;
				case 'R' :
					dir = rotate(2, dir);
					break;
				}
			}
			System.out.println(Math.abs(maxX-minX)*Math.abs(maxY-minY));
		}
	}
	static int rotate(int a, int dir) {
		if(a==1) {	// 왼쪽으로 회전
			dir--;
			if(dir == -1) dir = 3;
		} else {	// 오른쪽으로 회전
			dir++;
			if(dir == 4) dir = 0;
		}
		return dir;
	}
}
