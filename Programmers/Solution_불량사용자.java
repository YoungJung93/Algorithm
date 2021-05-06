package 카카오기출;

import java.util.*;

public class Solution_불량사용자 {

	public static void main(String[] args) {
		String[] user_id = {
//				"frodo", "fradi", "crodo", "abc123", "frodoc"
//				"frodo", "fradi", "crodo", "abc123", "frodoc"
				"frodo", "fradi", "crodo", "abc123", "frodoc"
		};
		String[] banned_id = {
//				"fr*d*", "abc1**"
//				"*rodo", "*rodo", "******"
				"fr*d*", "*rodo", "******", "******"
		};
		
		int answer = solution(user_id, banned_id);
		System.out.println(answer);
	}
	static List<String>[] banList;
	static Set<String> flagSet;
	static int userLen, banLen;
	public static int solution(String[] user_id, String[] banned_id) {
		int answer = 0;
		
		userLen = user_id.length;
		banLen = banned_id.length;
		
		banList = new List[banLen];
		
		for(int i=0; i<banLen; i++) {
			banList[i] = new ArrayList<>();
			String ban = banned_id[i];
			for(int j=0; j<userLen; j++) {
				String user = user_id[j];
				boolean flag = true;
				if(ban.length() != user.length()) {
					flag = false;
				} else {
					for(int k=0, size=ban.length(); k<size; k++) {
						if(ban.charAt(k) != user.charAt(k)) {
							if(ban.charAt(k) != '*') {
								flag = false;
								break;
							}
						}
					}
				}
				if(flag) {
					banList[i].add(user);
				}
			}
		}
		
		for(int i=0; i<banLen; i++) {
			System.out.println(banList[i].toString());
		}
		
		flagSet = new HashSet<>();
		go(new ArrayList<String>(), 0);
		answer = flagSet.size();
		
		return answer;
	}
	public static void go(List<String> flag, int ind) {
		if(ind == banLen) {
			Collections.sort(flag);
			flagSet.add(flag.toString());
			return;
		}
		for(int i=0, size=banList[ind].size(); i<size; i++) {
			String ban = banList[ind].get(i);
			if(!flag.contains(ban)) {
				flag.add(ban);
				go(flag, ind+1);
				flag.remove(ban);
			}
		}
	}
}
