package Problem;

import java.util.HashSet;
import java.util.Set;

public class Solution_방문길이 {

	public static void main(String[] args) {
		String dirs = "ULURRDLLU";
//		String dirs = "LULLLLLLU";
		
		int answer = solution(dirs);
		System.out.println(answer);
	}
	public static int solution(String dirs) {
        int answer = 0;
        
        Set<String> flag = new HashSet<>();
        int len = dirs.length();
        int r=0, c=0;
        for(int i=0; i<len; i++) {
        	char dir = dirs.charAt(i);
        	String root = "";
        	switch(dir) {
        	case 'U' :
        		if(r+1 > 5) break;
        		root = r + " " + c + " " + (r+1) + " " + c;
        		r++;
        		break;
        	case 'D' :
        		if(r-1 < -5) break;
        		root = (r-1) + " " + c + " " + r + " " + c;
        		r--;
        		break;
        	case 'R' :
        		if(c+1 > 5) break;
        		root = r + " " + c + " " + r + " " + (c+1);
        		c++;
        		break;
        	case 'L' :
        		if(c-1 < -5) break;
        		root = r + " " + (c-1) + " " + r + " " + c;
        		c--;
        		break;
        	}
        	if(!root.equals("")) flag.add(root);
        }
        answer = flag.size();
        
        return answer;
    }
}
