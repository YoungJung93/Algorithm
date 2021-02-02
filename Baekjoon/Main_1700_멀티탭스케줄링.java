package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_1700_멀티탭스케줄링 {
	static List<Integer> hole;
	static int[] inp;
	static int N, K;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		hole = new ArrayList<Integer>();
		inp = new int[K];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<K; i++) {
			inp[i] = Integer.parseInt(st.nextToken());
		}
		int i=0, result = 0;
		if(N==1) {			// 멀티탭 구멍이 1개면 
			int h = inp[0];
			for(int j=1; j<K; j++) {
				if(h == inp[j]) continue;
				else {
					result++;
					h = inp[j];
				}
			}
		} else {
			for(i=0; i<K; i++) {			// 멀티탭 구멍만큼 처음에 꽂아주기
				if(hole.size()>=N) break;
				if(hole.contains(inp[i])) continue;
				hole.add(inp[i]);
			}
			if(i!=K) {						// 처음에 멀티탭에 꽂은 후 더 꽂아야할 플러그가 남았으면
				for( ; i<K; i++) {			// 처음 꽂은 다음번 인덱스부터 시작하기
					if(hole.contains(inp[i])) continue;		// 이미 꽂혀있으면 넘어가기
					else {
						// 플러그가 안끼워져 있을 때, 뒷 부분을 본다 -> hole에 있는 것들 중 1개 빼고 모두 나올 때까지 돌리기
						// 만약 끝까지 돌았는데 2개 이상 안나온다면 그 중 아무거나 빼기 
						Set<Integer> set = new HashSet<>();	
						for(int j=i+1; j<K; j++) {			// 그 다음번부터 돌면서 꽂혀있는 플러그 저장 
							if(hole.contains(inp[j])) set.add(inp[j]);
							if(set.size()==N-1) break;
						}
						for(int j=0; j<N; j++) {
							if(!set.contains(hole.get(j))) {
								hole.remove(j);
								hole.add(inp[i]);
								result++;
								break;
							}
						}
					}
				}
			}
		}
		System.out.println(result);
	}
	
}
