package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_2806_NQUEEN {
	static int N, c;		// N : 입렵받을 배열의 크기 / c : 턴마다 증가시켜줄 카운트 변수
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; ++i)  {
			N = Integer.parseInt(br.readLine());
			int cnt=0;			// 최종 결과
			int[][] flag;		
			for(int j=0; j<N; ++j) {		// 맨 윗 줄에 한 번씩 퀸을 놓으면서 카운트 세기
				c=0;
				flag = new int[N][N];		// 입력받은 맵 수만큼 flag 배열 생성 / 0 : 다음 퀸을 놓을 수 있음, 1 : 다음 퀸을 놓을 수 없음
				jagui(update(flag, 0, j), 1);	// 맨 윗 줄을 제외하고 index 1부터 시작
				cnt+=c;
			}
			System.out.println("#"+i+" "+cnt);
		}
	}
	public static void jagui(int[][] flag, int ind) {	
		if(ind==N) {		//	ind가 N까지 진행되었으면 모든 줄에 1개의 퀸이 존재한다는 뜻이므로 카운트 변수인 c를 1 증가시키고 리턴
			c++; return;
		} else if(isFull(flag, ind)) return;	// ind가 N까지 진행되지 않았는데 더 이상 퀸을 놓을 수 있는 자리가 없다면 그냥 리턴
		for(int i=0; i<N; ++i) {				// 그 줄에 퀸을 놓을 수 있는 자리를 탐색한 후, 재귀 돌림
			if(flag[ind][i]==0) {
				jagui(update(flag, ind, i), ind+1);
			}
		}
	}
	public static boolean isFull(int[][] flag, int ind) {	// ind 행에 퀸을 놓을 자리가 있는지 확인 / true : 놓을 자리 없음, false : 놓을 자리 있음
		for(int i=0; i<N; ++i) {
			if(flag[ind][i]==0) return false;
		}
		return true;
	}
	public static int[][] update(int[][] flag, int r, int c) {	// r행 c열에 퀸이 놓였을 때 flag배열을 갱신
		int[][] arr = new int[N][];
		for(int i=0; i<N; ++i) {
			arr[i] = flag[i].clone();
		}
		for(int i=0; i<N; ++i) {
			arr[r][i]=1;
			arr[i][c]=1;
		}
		int i=1;
		while(true) {
			if(r-i>=0 && c-i>=0) arr[r-i][c-i]=1;
			if(r-i>=0 && c+i<N) arr[r-i][c+i]=1;
			if(r+i<N && c-i>=0) arr[r+i][c-i]=1;
			if(r+i<N && c+i<N) arr[r+i][c+i]=1;
			i++;
			if( (r-i<0 && c-i<0) && (r-i<0 && c+i>=N) && (r+i>=N && c-i<0) && (r+i>=N && c+i>=N) )
				break;
		}
		return arr;
	}
}
