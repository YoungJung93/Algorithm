package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
 
public class Solution_5432_쇠막대기자르기 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int result;
        Stack<Character> sticks;
        for(int i=1; i<=T; ++i) {
            result = 0;
            sticks = new Stack<>();
            String stick = br.readLine();
            for(int j=0, size=stick.length(); j<size; ++j) {
                if(stick.charAt(j)=='(') {
                    if(j!=size-1 && stick.charAt(j+1)==')') {
                        result += sticks.size();
                        ++j;
                    }
                    else {
                        sticks.push(stick.charAt(j));
                        result++;
                    }
                } else if(stick.charAt(j)==')') {
                    if(!sticks.isEmpty()) sticks.pop();
                }
            }
            System.out.println("#" + i + " " + result);
        }
    }
}