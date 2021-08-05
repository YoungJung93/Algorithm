package Problem;

public class Solution_N개의최소공배수 {

	public static void main(String[] args) {
		int[] arr = {
//			2,6,8,14
			1,2,3
		};
		
		System.out.println(solution(arr));
	}
	public static int solution(int[] arr) {
        int len = arr.length;
        int lcm = arr[0];
        for(int i=1; i<len; i++) {
        	lcm = (int)(((long)lcm * arr[i]) / gcd(lcm, arr[i]));
        }
        
        return lcm;
    }
	public static int gcd(int x, int y) {
		int r = 0;
		while(y != 0) {
			r = x % y;
			x = y;
			y = r;
		}
		return x;
	}
}
