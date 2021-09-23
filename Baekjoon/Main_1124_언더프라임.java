package Problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_1124_언더프라임 {
	static boolean[] che;
	static Set<Integer> primeNumber;
	static List<Integer> primeNumberList;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		calculatePrimeNumber(b);
		System.out.println(primeNumber.size());
		
		int answer = 0;
		for(int i=a; i<=b; i++) {
			if(isUnderPrime(i)) answer++;
		}
		
		System.out.println(answer);
	}
	public static boolean isUnderPrime(int num) {
		int size = primeNumberList.size();
		int numOfPrime = 0;
		int n = num;
		while(n > 1) {
			int div = 1;
			for(int i=0; i<size; i++) {
				if(n % primeNumberList.get(i) == 0) {
					div = primeNumberList.get(i);
					break;
				}
			}
			n /= div;
			numOfPrime++;
		}
		return primeNumber.contains(numOfPrime);
	}
	public static void calculatePrimeNumber(int b) {
		che = new boolean[b+1];
		che[0] = true;
		che[1] = true;
		for(int i=2; i<=b/2; i++) {
			for(int j=2; ; j++) {
				if(i*j > b) break;
				che[i*j] = true;
			}
		}
		primeNumber = new HashSet<>();
		primeNumberList = new ArrayList<>();
		for(int i=2; i<=b; i++) {
			if(!che[i]) {
				primeNumber.add(i);
				primeNumberList.add(i);
			}
		}
		Collections.sort(primeNumberList);
	}
}
