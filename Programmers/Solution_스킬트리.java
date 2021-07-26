package Problem;

import java.util.Arrays;

public class Solution_스킬트리 {

	public static void main(String[] args) {
		String skill = "CBD";
		String[] skill_trees = {
				"BACDE", "CBADF", "AECB", "BDA"
		};
		
		int answer = solution(skill, skill_trees);
		System.out.println(answer);
	}
	public static int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        // 현재 스킬을 배울 수 있는지 확인할 boolean 배열
        boolean[] canSkill = new boolean[26];
        
        // 이 스킬을 배웠을 때 그 다음 어떤 스킬을 배울 수 있는지 저장할 배열
        int[] nextSkill = new int[26];
        
        int skillLen = skill.length();
        int treeLen = skill_trees.length;
        
        for(int i=0; i<treeLen; i++) {
        	String tree = skill_trees[i];
        	Arrays.fill(canSkill, true);
        	Arrays.fill(nextSkill, -1);
        	for(int j=1; j<skillLen; j++) {
            	char c = skill.charAt(j);
            	canSkill[c-'A'] = false;
            	nextSkill[skill.charAt(j-1)-'A'] = c-'A';
            }
        	boolean res = true;
        	for(int j=0, len=tree.length(); j<len; j++) {
        		int sk = tree.charAt(j) - 'A';
        		if(!canSkill[sk]) {
        			res = false;
        			break;
        		}
        		if(nextSkill[sk] != -1) canSkill[nextSkill[sk]] = true;
        	}
        	if(res) answer++;
        }
        
        return answer;
    }
}
