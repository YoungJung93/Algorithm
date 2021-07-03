package Problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_오픈채팅방 {

	public static void main(String[] args) {
		String[] record = {
				"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234",
				"Enter uid1234 Prodo","Change uid4567 Ryan"
		};
		
		String[] answer = solution(record);
		System.out.println(Arrays.toString(answer));
	}
	public static String[] solution(String[] record) {
        int recordLen = record.length;
        Map<String, String> userName = new HashMap<>();
        List<String[]> list = new ArrayList<>();
        for(int i=0; i<recordLen; i++) {
        	String[] command = record[i].split(" ");
        	switch(command[0]) {
        	case "Enter" :
        		list.add(new String[] {command[0], command[1]});
        		userName.put(command[1], command[2]);
        		break;
        	case "Leave" :
        		list.add(new String[] {command[0], command[1]});
        		break;
        	case "Change" :
        		userName.put(command[1], command[2]);
        		break;
        	}
        }
        int listLen = list.size();
        String[] answer = new String[listLen];
        for(int i=0; i<listLen; i++) {
        	String[] arr = list.get(i);
        	answer[i] = userName.get(arr[1]);
        	if(arr[0].equals("Enter")) {
        		answer[i] += "님이 들어왔습니다.";
        	} else {
        		answer[i] += "님이 나갔습니다.";
        	}
        }
        
        return answer;
    }
}
