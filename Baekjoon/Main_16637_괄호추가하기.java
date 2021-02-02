package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main_16637_괄호추가하기 {
	static String exp;
	static int N;
	static int[] comb;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		exp = br.readLine();
		
		int answer = calc(exp);
		
		comb = new int[N/2];
		for(int i=1; i<=(N/2+1)/2; i++) {
			for(int j=0; j<i; j++) comb[j] = 1;
			Arrays.sort(comb);
			np: do {
				for(int j=1; j<N/2-1; j++) {
					if(comb[j] == 1 && (comb[j-1]==1 || comb[j+1]==1)) continue np;
				}
				String infix = exp.substring(0);
				for(int j=0, ind=0; ; j++) {
					if(ind >= N/2 || j>=infix.length()) break;
					if(infix.charAt(j)>='0' && infix.charAt(j)<='9') {
						if(comb[ind] == 1) {
							infix = infix.substring(0, j) + "(" +
									infix.substring(j, j+3) + ")" +
									infix.substring(j+3, infix.length());
							ind++;
							j += 5;
						}
						ind++;
					}
				}
				int res = calc(infix);
				if(res > answer) answer = res;
			} while(np());
		}
		System.out.println(answer);
	}
	static boolean np() {
		int i = N/2 - 1;
		while(i>0 && comb[i-1] >= comb[i]) i--;
		if(i == 0) return false;
		int j = N/2 - 1;
		while(comb[i-1] >= comb[j]) j--;
		swap(i-1, j);
		j = N/2 - 1;
		while(j>i) swap(i++, j--);
		return true;
	}
	static void swap(int x, int y) {
		int tmp = comb[x];
		comb[x] = comb[y];
		comb[y] = tmp; 
	}
	static int calc(String infix) {
		// 중위 표기식을 후위 표기식으로 바꾸기
		Stack<Character> st = new Stack<>();
		int len = infix.length();
		String postfix = "";
		for(int i=0; i<len; i++) {
			char c = infix.charAt(i);
			if(c >= '0' && c <= '9') {
				postfix += c;
			} else if(c == '(') {
				st.push(c);
			} else if(c == ')') {
				char p;
				while(!st.isEmpty()) {
					p = st.pop();
					if(p == '(') {
						break;
					} else {
						postfix += p;
					}
				}
			} else {
//				if(c == '+' || c == '-') {
					while(!st.isEmpty()) {
						if(st.peek() == '(') {
							break;
						} else {
							postfix += st.pop();
						}
					}
					st.push(c);
//				} else {
//					while(!st.isEmpty()) {
//						if(st.peek() == '*' || st.peek() == '/') {
//							postfix += st.pop();
//						} else break;
//					}
//					st.push(c);
//				}
			}
		}
		while(!st.isEmpty()) {
			postfix += st.pop();
		}
		
		Stack<Integer> num = new Stack<>();
		for(int i=0, size=postfix.length(); i<size; i++) {
			char c = postfix.charAt(i);
			if(c>='0' && c<='9') {
				num.push(c - '0');
			} else {
				int b = num.pop();
				int a = num.pop();
				int calc = 0;
				switch(c) {
				case '+' :
					calc = a + b;
					break;
				case '-' :
					calc = a - b;
					break;
				case '*' :
					calc = a * b;
					break;
				case '/' :
					calc = a / b;
					break;
				}
				num.push(calc);
			}
		}
		
		return num.pop();
	}
}
