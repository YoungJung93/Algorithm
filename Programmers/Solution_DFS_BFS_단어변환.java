package Problem;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_DFS_BFS_단어변환 {
	static String begin, target, words[];
	static int answer;
	static class pair {
		String word;
		int cnt;
		public pair(String word, int cnt) {
			this.word = word; this.cnt = cnt;
		}
	}
	public static void main(String[] args) {
		begin = "hit";
		target = "cog";
		words = new String[] {
//			"hot", "dot", "dog", "lot", "log", "cog"
//			"hot", "dot", "ddg", "ddd", "ccc", "cog"
			"hot", "dot", "dog", "lot", "log"
		};
		answer = 0;
		
		int len = words.length;
		boolean flag = false;
		for(int i=0; i<len; i++) {
			if(words[i].equals(target)) {
				flag=true;
				break;
			}
		}
		if(!flag) answer = 0;
		else {
			boolean[] flag_word = new boolean[len];
			Queue<pair> que = new LinkedList<pair>();
			que.offer(new pair(begin, 0));
			bfs : while(!que.isEmpty()) {
				pair cur = que.poll();
				for(int i=0; i<len; i++) {
					if(flag_word[i]) continue;
					if(difStr(cur.word, words[i]) == 1) {
						if(words[i].equals(target)) {
							answer = cur.cnt+1;
							break bfs;
						}
						flag_word[i] = true;
						que.offer(new pair(words[i], cur.cnt+1));
					}
				}
			}
		}
		
		System.out.println(answer);
	}
	static int difStr(String src, String tar) {
		int len = src.length();
		int a = 0;
		for(int i=0; i<len; i++) {
			if(src.charAt(i) != tar.charAt(i)) a++;
		}
		return a;
	}
}
