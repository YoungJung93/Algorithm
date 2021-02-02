package Problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_15566_개구리1 {
	static class frog {
		int[] topic;
		int no;
		public frog(int no, int c, int h, int f, int p) {
			this.no = no;
			this.topic = new int[] {0, c, h, f, p};
		}
	}
	static int N, M;
	// 개구리 정보 저장
	static frog[] frogs;
	// flower[연꽃번호] - 그 연꽃에 있을 수 있는 개구리 번호
	static List<Integer>[] flowers;
	// 통나무 정보
	static int[][] adj;
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		frogs = new frog[N+1];
		flowers = new ArrayList[N+1];
		adj = new int[N+1][N+1];
		for(int i=1; i<=N; i++) flowers[i] = new ArrayList<>();
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			frogs[i] = new frog(i, Integer.parseInt(st.nextToken()), 
					Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())
					,Integer.parseInt(st.nextToken()));
		}
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(a==b) {
				flowers[a].add(i);
			} else {
				flowers[a].add(i);
				flowers[b].add(i);
			}
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			adj[a][b] = c;
		}
		flag = new boolean[N+1];
		answer = "";
		go(1, new int[N+1]);
		if(answer.equals("")) {
			System.out.println("NO");
		} else {
			System.out.println("YES");
			System.out.println(answer);
		}
	}
	static boolean[] flag;
	static String answer;
	static void go(int cnt, int[] arr) {
		if(answer.length() > 0) return;
		if(cnt == N+1) {
			if(canPut(arr)) {
				for(int i=1; i<=N; i++) {
					answer += (arr[i] + " ");
				}
			}
			return;
		}
		for(int i=0, size=flowers[cnt].size(); i<size; i++) {
			int a = flowers[cnt].get(i);
			if(!flag[a]) {
				arr[cnt] = a;
				flag[a] = true;
				go(cnt+1, arr);
				flag[a] = false;
			}
		}
	}
	static boolean canPut(int[] arr) {
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(adj[i][j]==0) continue;
				int base = adj[i][j];
				if(frogs[arr[i]].topic[base] != frogs[arr[j]].topic[base]) {
					return false;
				}
			}
		}
		return true;
	}
}
