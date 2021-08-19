package Problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution_순위검색 {

	public static void main(String[] args) {
		String[] info = {
				"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"
		};
		String[] query = {
				"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"
		};
		
		int[] answer = solution(info, query);
		System.out.println(Arrays.toString(answer));
	}
	static List<Integer>[][][][] infos;
	@SuppressWarnings("unchecked")
	public static int[] solution(String[] info, String[] query) {
        int[] answer = {};
        
        int infoLen = info.length;
        int queryLen = query.length;
        answer = new int[queryLen];
        
        infos = new List[3][2][2][2];
        for(int a=0; a<3; a++) {
        	for(int b=0; b<2; b++) {
        		for(int c=0; c<2; c++) {
        			for(int d=0; d<2; d++) {
        				infos[a][b][c][d] = new ArrayList<>();
        			}
        		}
        	}
        }
        
        for(int i=0; i<infoLen; i++) {
        	String[] arr = info[i].split(" ");
        	int a=0, b=0, c=0, d=0;
        	int score = Integer.parseInt(arr[4]);
        	
        	if(arr[0].equals("cpp")) a = 0;
        	else if(arr[0].equals("java")) a = 1;
        	else a = 2;
        	
        	if(arr[1].equals("backend")) b = 0;
        	else b = 1;
        	
        	if(arr[2].equals("junior")) c = 0;
        	else c = 1;
        	
        	if(arr[3].equals("chicken")) d = 0;
        	else d = 1;
        	
        	infos[a][b][c][d].add(score);
        }
        
        for(int a=0; a<3; a++) {
        	for(int b=0; b<2; b++) {
        		for(int c=0; c<2; c++) {
        			for(int d=0; d<2; d++) {
        				Collections.sort(infos[a][b][c][d]);
        			}
        		}
        	}
        }
        
        for(int i=0; i<queryLen; i++) {
        	String[] arr = query[i].split(" ");
        	int[] as = new int[3], bs = new int[2], cs = new int[2], ds = new int[2];
        	Arrays.fill(as, -1); Arrays.fill(bs, -1);
        	Arrays.fill(cs, -1); Arrays.fill(ds, -1);
        	if(arr[0].equals("cpp")) as[0] = 0;
        	else if(arr[0].equals("java")) as[0] = 1;
        	else if(arr[0].equals("python")) as[0] = 2;
        	else { as[0] = 0; as[1] = 1; as[2] = 2; }
        	
        	if(arr[2].equals("backend")) bs[0] = 0;
        	else if(arr[2].equals("frontend")) bs[0] = 1;
        	else { bs[0] = 0; bs[1] = 1; }
        	
        	if(arr[4].equals("junior")) cs[0] = 0;
        	else if(arr[4].equals("senior")) cs[0] = 1;
        	else { cs[0] = 0; cs[1] = 1; }
        	
        	if(arr[6].equals("chicken")) ds[0] = 0;
        	else if(arr[6].equals("pizza")) ds[0] = 1;
        	else { ds[0] = 0; ds[1] = 1; }
        	
        	int score = Integer.parseInt(arr[7]);
        	
        	for(int a=0; a<3; a++) {
            	for(int b=0; b<2; b++) {
            		for(int c=0; c<2; c++) {
            			for(int d=0; d<2; d++) {
            				answer[i] += find(as[a], bs[b], cs[c], ds[d], score);
            			}
            		}
            	}
            }
        }
        
        return answer;
    }
	public static int find(int a, int b, int c, int d, int score) {
		if(a==-1 || b==-1 || c==-1 || d==-1) return 0;
		int answer = 0;
		int ind = Collections.binarySearch(infos[a][b][c][d], score);
		if(ind >= 0) {
			while(ind > 0) {
				if(infos[a][b][c][d].get(ind-1) == score) ind--;
				else break;
			}
		} else {
			ind = (-1*ind)-1;
			if(ind >= infos[a][b][c][d].size()) return 0;
			int base = infos[a][b][c][d].get(ind);
			while(ind > 0) {
				if(infos[a][b][c][d].get(ind-1) == base) ind--;
				else break;
			}
		}
		answer = infos[a][b][c][d].size() - ind;
		
		return answer;
	}
}
