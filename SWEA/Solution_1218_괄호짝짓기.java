package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
 
public class Solution_1218_괄호짝짓기 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> st1;
        for(int i=1; i<=10; ++i) {
            int result;
            int N = Integer.parseInt(br.readLine());
            String str = br.readLine();
            st1 = new Stack<>(); 
            First : for(int j=0, size=str.length(); j<size; j++) {
                char a = str.charAt(j);
                switch(a) {
                case '(' :
                    st1.push('(');
                    break;
                case ')' :
                    if(st1.peek()=='(') {
                        if(!st1.isEmpty()) st1.pop();
                    } else break First;
                    break;
                case '[' :
                    st1.push('[');
                    break;
                case ']' :
                    if(st1.peek()=='[') {
                        if(!st1.isEmpty()) st1.pop();
                    } else break First;
                    break;
                case '{' :
                    st1.push('{');
                    break;
                case '}' :
                    if(st1.peek()=='{') {
                        if(!st1.isEmpty()) st1.pop();
                    } else break First;
                    break;
                case '<' :
                    st1.push('<');
                    break;
                case '>' :
                    if(st1.peek()=='<') {
                        if(!st1.isEmpty()) st1.pop();
                    } else break First;
                    break;
                }
            }
            if(st1.isEmpty()) result = 1;
            else result=0;
            System.out.println("#" + i + " " + result);
        }
    }
}