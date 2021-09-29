package Problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main_1174_줄어드는숫자 {
	static List<Long> nums;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		if(N > 1023) {
			System.out.println(-1);
			return;
		} else if(N <= 11) {
			System.out.println(N-1);
			return;
		}
		
		nums = new ArrayList<>();
		
		for(int i=1; i<=10; i++) {
			go(9, i, "");
		}
		
		Collections.sort(nums);
		
		System.out.println(nums.get(N-1));
	}
	public static void go(int ind, int select, String num) {
		if(num.length() == select) {
			nums.add(Long.parseLong(num));
			return;
		}
		if(ind < 0) return;
		go(ind-1, select, num+ind);
		go(ind-1, select, num);
	}
}
