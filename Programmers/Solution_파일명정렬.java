package Problem;

import java.util.Arrays;

public class Solution_파일명정렬 {

	public static void main(String[] args) {
		String[] files = {
//				"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"
				"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"
		};
		
		String[] answer = solution(files);
		System.out.println(Arrays.toString(answer));
	}
	static class File implements Comparable<File> {
		int no;
		String head, num, tail;
		int number;
		
		public File(int no, String head, String num, String tail) {
			this.no = no; this.head = head; this.tail = tail;
			this.num = num;
			this.number = Integer.parseInt(num);
		}
		public String toString() {
			return head + num + tail;
		}
		
		public int compareTo(File o) {
			if(this.head.toLowerCase().equals(o.head.toLowerCase())) {
				if(this.number == o.number) {
					return Integer.compare(this.no, o.no);
				}
				return Integer.compare(this.number, o.number);
			}
			return this.head.toLowerCase().compareTo(o.head.toLowerCase());
		}
	}
	public static String[] solution(String[] files) {
        int filesLen = files.length;
        File[] fileArr = new File[filesLen];
        for(int i=0; i<filesLen; i++) {
        	String file = files[i];
        	int len = file.length();
        	StringBuilder head = new StringBuilder();
        	StringBuilder num = new StringBuilder();
        	StringBuilder tail = new StringBuilder();
        	int flag = 0;
        	for(int j=0; j<len; j++) {
        		char c = file.charAt(j);
        		if(flag == 0) {
        			if(!Character.isDigit(c)) {
        				head.append(c);
        			} else {
        				num.append(c);
        				flag++;
        			}
        		} else if(flag == 1) {
        			if(Character.isDigit(c)) {
        				num.append(c);
        			} else {
        				tail.append(c);
        				flag++;
        			}
        		} else {
        			tail.append(c);
        		}
        	}
        	fileArr[i] = new File(i, head.toString(), num.toString(), tail.toString());
        }
        Arrays.sort(fileArr);
        
        String[] answer = new String[filesLen];
        for(int i=0; i<filesLen; i++) {
        	answer[i] = fileArr[i].toString();
        }
        
        return answer;
    }
}
