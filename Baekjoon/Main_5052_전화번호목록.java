package Problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main_5052_전화번호목록 {
	static class Node {
		List<Node> child;
		int num;
		public Node(int num) {
			this.num = num;
			this.child = new ArrayList<>();
		}
		public boolean insert(String s) {
			Node cur = root;
			int ind = 0;
			while(true) {
				boolean f = false;	// child 중 추가할 수와 같은 수가 있으면 true
				int i=0, size=cur.child.size();
				for( ; i<size; i++) {
					if(cur.child.get(i).num == (s.charAt(ind)-'0')) {
						f = true;
						break;
					}
				}
				if(!f || cur.child.size()==0) {
					for(int j=ind; j<s.length(); j++) {
						cur.child.add(new Node(s.charAt(j)-'0'));
						cur = cur.child.get(cur.child.size()-1);
					}
					return true;
				} else {
					ind++;
					cur = cur.child.get(i);
				}
				if(ind == s.length()) break;
			}
			return false;
		}
	}
	static Node root;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			root = new Node(0);
			int n = Integer.parseInt(br.readLine());
			String[] inp = new String[n];
			for(int i=0; i<n; i++) {
				inp[i] = br.readLine();
			}
			Arrays.sort(inp, new Comparator<String>() {
				public int compare(String o1, String o2) {
					return Integer.compare(o2.length(), o1.length());
				}
			});
			String answer = "YES";
			for(int i=0; i<n ;i++) {
				if(!root.insert(inp[i])) {
					answer = "NO";
					break;
				}
			}
			System.out.println(answer);
		}
	}
}
