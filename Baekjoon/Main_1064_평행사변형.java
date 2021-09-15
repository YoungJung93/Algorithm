package Problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1064_평행사변형 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int xa = Integer.parseInt(st.nextToken());
		int ya = Integer.parseInt(st.nextToken());
		int xb = Integer.parseInt(st.nextToken());
		int yb = Integer.parseInt(st.nextToken());
		int xc = Integer.parseInt(st.nextToken());
		int yc = Integer.parseInt(st.nextToken());
		
		// 세 점이 한 평행선 위에 존재하면 평행사변형이 존재하지 않는다(-1 리턴)
		// ab와 bc의 기울기가 같으면 -1을 리턴
		int mx1 = xb - xa, my1 = yb - ya;
		int mx2 = xc - xb, my2 = yc - yb;
		if((mx1==0 && mx1==mx2) || (my1==0 && my1==my2)) {
			System.out.println(-1);
			return;
		} else {
			double g1 = (double)my1/mx1;
			double g2 = (double)my2/mx2;
			if(g1 == g2) {
				System.out.println(-1);
				return;
			}
		}
		
		double max = 0, min = Double.MAX_VALUE;
		double ab = distance(xa, ya, xb, yb);
		double bc = distance(xb, yb, xc, yc);
		double ac = distance(xa, ya, xc, yc);
		// 선분 ab와 선분 bc - ab와 cd, bc와 ad 가 서로 길이가 같아야 함
		// 이때의 둘레는 (2*ab)+(2*bc)
		double round = (2*ab)+(2*bc);
		if(round > max) max = round;
		if(round < min) min = round;
		
		// 선분 ac와 선분 bc - ac와 bd, bc와 ad 가 서로 길이가 같아야 함
		// 이때의 둘레는 (2*ac)+(2*bc)
		round = (2*ac)+(2*bc);
		if(round > max) max = round;
		if(round < min) min = round;
		
		// 선분 ac와 선분 ab - ac와 bd, ab와 cd 가 서로 길이가 같아야 함
		// 이때의 둘레는 (2*ac)+(2*ab)
		round = (2*ac)+(2*ab);
		if(round > max) max = round;
		if(round < min) min = round;
		
		System.out.println(max - min);
	}
	public static double distance(int x1, int y1, int x2, int y2) {
		double a = Math.pow(Math.abs(x1-x2), 2);
		double b = Math.pow(Math.abs(y1-y2), 2);
		
		return Math.sqrt(a+b);
	}
}
