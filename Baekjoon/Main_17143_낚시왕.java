package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_17143_낚시왕 {
	static int R, C, M, res;
	static List<shark>[][] map;
	static class shark {
		int s, d, z, dx, dy;
		public shark(int s, int d, int z) {
			this.s = s; this.d = d; this.z = z;
		}
	}
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new ArrayList[R][C];
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				map[i][j] = new ArrayList<>();
			}
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			map[r][c].add(new shark(s, d, z));
		}
		res = 0;
		for(int i=0; i<C; i++) {
			// 상어 잡고
			catchShark(i);
			// 상어 이동시키고
			moveShark();
			// 큰 상어가 나머지 상어 잡아먹기
			update();
		}
		System.out.println(res);
	}
	// 상어 잡기
	static void catchShark(int c) {
		// 가장 가까운 상어 잡기
		for(int i=0; i<R; i++) {
			if(!map[i][c].isEmpty()) {
				res += map[i][c].get(0).z;
				map[i][c].clear();
				return;
			}
		}
	}
	// 상어 이동시키기
	@SuppressWarnings("unchecked")
	static void moveShark() {
		List<shark>[][] imsi = new ArrayList[R][C];
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				imsi[i][j] = new ArrayList<>();
				if(!map[i][j].isEmpty()) {
					shark sh = map[i][j].get(0);
					imsi[i][j].add(new shark(sh.s, sh.d, sh.z));
				}
			}
		}
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(!imsi[i][j].isEmpty()) {
					int dx = i, dy = j;
					shark sh = imsi[i][j].get(0);
					switch (sh.d) {
					case 1:
						for(int ii=0, k=-1; ii<sh.s; ii++) {
							if((k==-1&&dx==0) || (k==1&&dx==R-1)) 
								{k *= -1; imsi[i][j].get(0).d = imsi[i][j].get(0).d==1?2:1; }
							dx += k;
						}
						break;
					case 2:
						for(int ii=0, k=1; ii<sh.s; ii++) {
							if((k==-1&&dx==0) || (k==1&&dx==R-1))
								{k *= -1; imsi[i][j].get(0).d = imsi[i][j].get(0).d==1?2:1; }
							dx += k;
						}
						break;
					case 3:
						for(int ii=0, k=1; ii<sh.s; ii++) {
							if((k==-1&&dy==0) || (k==1&&dy==C-1)) 
								{k *= -1; imsi[i][j].get(0).d = imsi[i][j].get(0).d==3?4:3; }
							dy += k;
						}
						break;
					case 4:
						for(int ii=0, k=-1; ii<sh.s; ii++) {
							if((k==-1&&dy==0) || (k==1&&dy==C-1)) 
								{k *= -1; imsi[i][j].get(0).d = imsi[i][j].get(0).d==3?4:3; }
							dy += k;
						}
						break;
					}
					imsi[i][j].get(0).dx = dx;
					imsi[i][j].get(0).dy = dy;
				}
			}
		}
		map = new ArrayList[R][C];
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				map[i][j] = new ArrayList<>();
			}
		}
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(!imsi[i][j].isEmpty()) {
					shark sh = imsi[i][j].get(0);
					map[sh.dx][sh.dy].add(new shark(sh.s, sh.d, sh.z));
				}
			}
		}
	}
	// 큰 상어가 나머지 상어 잡아먹기
	static void update() {
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j].size()>1) {
					int max=0, maxind=-1;
					for(int k=0, size=map[i][j].size(); k<size; k++) {
						shark sh = map[i][j].get(k);
						if(sh.z > max) {
							max = sh.z; maxind = k;
						}
					}
					shark sh = map[i][j].get(maxind);
//					for(int k=0, size=map[i][j].size(); k<size; k++) {
//						if(k != maxind) {
//							sh.z += map[i][j].get(k).z;
//						}
//					}
					map[i][j].clear();
					map[i][j].add(sh);
				}
			}
		}
	}
}
