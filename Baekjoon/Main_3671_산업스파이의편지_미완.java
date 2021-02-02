package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main_3671_산업스파이의편지 {
	static Set<Integer> thtn;
	static int[] nums;
	static int[] comb, permu;
	static int n;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		Set<Integer> flag;
		getChe(9999999);
		System.out.println(thtn.size());
		for(int t=0; t<T; t++) {
			String inp = br.readLine();
			n = inp.length();
			nums = new int[n];
			for(int i=0; i<n; i++) {
				nums[i] = inp.charAt(i) - '0';
			}
			flag = new HashSet<>();
			int answer = 0;
			for(int i=1; i<=n; i++) {
				comb = new int[n];
				for(int j=0; j<i; j++) comb[j] = 1;
				Arrays.sort(comb);
				do {
					permu = new int[i];
					for(int j=0, k=0; j<n; j++) {
						if(comb[j] == 1) permu[k++] = nums[j];
					}
					Arrays.sort(permu);
					do {
						String num = "";
						for(int j=0; j<i; j++) num += permu[j];
						if(isThtn(Integer.parseInt(num))) {
							if(!flag.contains(Integer.parseInt(num))) {
								flag.add(Integer.parseInt(num));
								answer++;
							}
						}
					} while(np());
				} while(nc());
			}
			System.out.println(answer);
		}
	}
	public static boolean np() {
		int i = permu.length-1;
		while(i>0 && permu[i-1]>=permu[i]) i--;
		if(i == 0) return false;
		int j = permu.length-1;
		while(permu[i-1]>=permu[j]) j--;
		swapp(i-1, j);
		j = permu.length-1;
		while(i<j) swapp(i++, j--);
		return true;
	}
	public static void swapp(int x, int y) {
		int tmp = permu[x];
		permu[x] = permu[y];
		permu[y] = tmp;
	}
	public static boolean nc() {
		int i = n-1;
		while(i>0 && comb[i-1]>=comb[i]) i--;
		if(i == 0) return false;
		int j = n-1;
		while(comb[i-1]>=comb[j]) j--;
		swap(i-1, j);
		j = n-1;
		while(i<j) swap(i++, j--);
		return true;
	}
	public static void swap(int x, int y) {
		int tmp = comb[x];
		comb[x] = comb[y];
		comb[y] = tmp;
	}
	public static void getChe(int num) {
		int[] arr = new int[num+1];
		for(int i=2; i<=num; i++) {
			arr[i] = i;
		}
		for(int i=2; i<=num; i++) {
			if(arr[i] == 0) continue;
			for(int j=i+i; j<=num; j+=i) {
				arr[j] = 0;
			}
		}
		thtn = new HashSet<>();
		for(int i=2; i<=num; i++) {
			if(arr[i] != 0) thtn.add(i);
		}
	}
	public static boolean isThtn(int num) {
		if(thtn.contains(num)) return true;
		return false;
	}
}
