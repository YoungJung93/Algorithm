package Problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_16639_괄호추가하기3 {
	static long answer;
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		String exp = br.readLine();
		
		long[] nums = new long[N/2+1];
		char[] ops = new char[N/2];
		
		for(int i=0; i<N; i++) {
			char c = exp.charAt(i);
			if((i & 1) == 0) {
				nums[i/2] = c-'0';
			} else {
				ops[i/2] = c;
			}
		}
		
		answer = Integer.MIN_VALUE;
		calculate(nums, ops);
		
		System.out.println(answer);
	}
	public static void calculate(long[] nums, char[] ops) {
		int len = ops.length;
		if(len == 0) {
			long num = nums[0];
			if(num > answer) answer = num;
			return;
		}
		for(int i=0; i<len; i++) {
			long res = nums[i];
			char op = ops[i];
			if(op == '+') {
				res += nums[i+1];
			} else if(op == '-') {
				res -= nums[i+1];
			} else {
				res *= nums[i+1];
			}
			
			long[] nums_ = new long[len];
			char[] ops_ = new char[len-1];
			for(int j=0, k=0; j<=len; j++) {
				if(j==i) {
					nums_[k++] = res;
				} else if(j==i+1) {
					continue;
				} else {
					nums_[k++] = nums[j];
				}
			}
			for(int j=0, k=0; j<len; j++) {
				if(j==i) continue;
				ops_[k++] = ops[j];
			}
			calculate(nums_, ops_);
		}
	}
}
