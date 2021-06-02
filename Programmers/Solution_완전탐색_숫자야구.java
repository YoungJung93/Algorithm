package Problem;

public class Solution_완전탐색_숫자야구 {
	static int[][] baseball;
	static int answer;
	public static void main(String[] args) {
		baseball = new int[][] {
			{123,1,1}, {356,1,0}, {327,2,0}, {489,0,1}
		};
		answer = 0;
		
		first : for(int i=111; i<=999; i++) {
			boolean f = true;
			for(int j=0,size=baseball.length; j<size; j++) {
				int[] src = go(baseball[j][0], i);
				if(src == null) continue first;
				int[] tar = {baseball[j][1], baseball[j][2]};
				boolean ff = true;
				for(int k=0; k<2; k++) {
					if(src[k]!=tar[k]) {
						ff = false; break;
					}
				}
				if(!ff) {
					f = false; break;
				}
			}
			if(f) answer++;
		}
//		System.out.println(Arrays.toString(go(324, 123)));
//		System.out.println(Arrays.toString(go(324, 356)));
//		System.out.println(Arrays.toString(go(324, 327)));
//		System.out.println(Arrays.toString(go(324, 489)));
		
		System.out.println(answer);
	}
	static int[] go(int src, int tar) {
		int strike=0, ball=0;
		int sa=src/100, sb=(src%100)/10, sc=(src%10);
		int ta=tar/100, tb=(tar%100)/10, tc=(tar%10);
		if(ta==0 || tb==0 || tc==0) return null;
		if(ta==tb || ta==tc || tb==tc) return null;
		if(sa==ta) strike++;
		else {
			if(sa==tb) ball++;
			else if(sa==tc) ball++;
		}
		if(sb==tb) strike++;
		else {
			if(sb==ta) ball++;
			else if(sb==tc) ball++;
		}
		if(sc==tc) strike++;
		else {
			if(sc==ta) ball++;
			else if(sc==tb) ball++;
		}
		return new int[] {strike, ball};
	}
}
