package Problem;

public class Solution_DP_도둑질 {
	static int[] money;
	static int answer;
	
	public static void main(String[] args) {
		money = new int[] {
			1,2,3,1	
		};
		answer = 0;
		
		int len = money.length;
		int arr1[] = new int[len-1];
		int arr2[] = new int[len-1];
		arr1[0] = money[1];
		arr1[1] = 0;
		arr1[2] = arr1[0] + money[3];
		arr2[0] = money[0];
		arr2[1] = money[1];
		arr2[2] = arr2[0] + money[2];
		for(int i=3; i<len-1; i++) {
			arr1[i] = Math.max(arr1[i-2], arr1[i-3]) + money[i+1];
			arr2[i] = Math.max(arr2[i-2], arr2[i-3]) + money[i];
		}
		
		int a = Math.max(arr1[len-3], arr1[len-2]);
		int b = Math.max(arr2[len-3], arr2[len-2]);
		answer = Math.max(a, b);
		
		System.out.println(answer);
	}
}
