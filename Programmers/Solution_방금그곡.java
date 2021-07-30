package Problem;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution_방금그곡 {

	public static void main(String[] args) {
//		String m = "ABCDEFG"; 
//		String m = "CC#BCC#BCC#BCC#B"; 
		String m = "ABC"; 
		String[] musicinfos = {
//				"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"
//				"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"
				"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"
		};
		
		String answer = solution(m, musicinfos);
		System.out.println(answer);
	}
	static class Result implements Comparable<Result>{
		int ind;
		String name;
		int runtime;
		public Result(int ind, String name, int runtime) {
			this.ind = ind;
			this.name = name;
			this.runtime = runtime;
		}
		public int compareTo(Result o) {
			if(this.runtime == o.runtime) {
				return Integer.compare(this.ind, o.ind);
			}
			return Integer.compare(o.runtime, this.runtime);
		}
	}
	public static String solution(String m, String[] musicinfos) {
        String answer = "";
        
        StringBuilder music = new StringBuilder();
        int mlen = m.length();
        for(int i=0; i<mlen; i++) {
        	char c = m.charAt(i);
        	music.append(c);
        	if(i != mlen-1 && m.charAt(i+1) == '#') {
        		music.append("#");
        		i++;
        	}
        	music.append(" ");
        }
        m = music.toString();
        
        int infoLen = musicinfos.length;
        PriorityQueue<Result> res = new PriorityQueue<>();
        
        for(int i=0; i<infoLen; i++) {
        	String[] info = musicinfos[i].split(",");
        	int start = Integer.parseInt(info[0].split(":")[0]) * 60;
        	start += Integer.parseInt(info[0].split(":")[1]);
        	int end = Integer.parseInt(info[1].split(":")[0]) * 60;
        	end += Integer.parseInt(info[1].split(":")[1]);
        	int runtime = end - start;
        	
        	int len = info[3].length();
        	List<String> melodys = new ArrayList<>();
        	for(int j=0; j<len; j++) {
        		char c = info[3].charAt(j);
        		String melody = Character.toString(c);
        		if(j != len-1 && info[3].charAt(j+1) == '#') {
        			melody += '#';
        			j++;
        		}
        		melodys.add(melody);
        	}
        	len = melodys.size();
        	
        	StringBuilder melody = new StringBuilder();
        	for(int j=0; j<runtime; j++) {
        		melody.append(melodys.get(j % len));
        		melody.append(" ");
        	}
        	
        	if(melody.indexOf(m) != -1) {
        		res.offer(new Result(i, info[2], runtime));
        	}
        }
        if(res.isEmpty()) answer = "(None)";
        else {
        	answer = res.poll().name;
        }
        
        return answer;
    }
}
