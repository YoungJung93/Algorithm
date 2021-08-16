package Problem;

public class Solution_위클리2주차_상호평가 {

	public static void main(String[] args) {
		int[][] scores = {
//				{100,90,98,88,65},{50,45,99,85,77},{47,88,95,80,67},{61,57,100,80,65},{24,90,94,75,65}
//				{50,90},{50,87}
				{70,49,90},{68,50,38},{73,31,100}
		};
		
		String answer = solution(scores);
		System.out.println(answer);
	}
	static int N;
	public static String solution(int[][] scores) {
        String answer = "";
        
        N = scores.length;
        int[][] accept = new int[N][N];
        for(int r=0; r<N; r++) {
        	for(int c=0; c<N; c++) {
        		accept[r][c] = scores[c][r];
        	}
        }
        
        for(int i=0; i<N; i++) {
        	double avg = 0.0;
        	if(isDelete(i, accept[i])) {
        		int sum = 0;
        		for(int j=0; j<N; j++) {
        			if(i == j) continue;
        			sum += accept[i][j];
        		}
        		avg = (double)sum/(N-1);
        	} else {
        		int sum = 0;
        		for(int j=0; j<N; j++) {
        			sum += accept[i][j];
        		}
        		avg = (double)sum/N;
        	}
        	
        	if(avg >= 90) {
        		answer += "A";
        	} else if(avg >= 80) {
        		answer += "B";
        	} else if(avg >= 70) {
        		answer += "C";
        	} else if(avg >= 50) {
        		answer += "D";
        	} else {
        		answer += "F";
        	}
        }
        
        return answer;
    }
	public static boolean isDelete(int no, int[] scores) {
		int score = scores[no];
		boolean higher = false;
		boolean lower = false;
		for(int i=0; i<N; i++) {
			if(i == no) continue;
			if(scores[i] >= score) higher = true;
			if(scores[i] <= score) lower = true;
		}
		
		if(!higher || !lower) return true;
		else return false;
	}
}
