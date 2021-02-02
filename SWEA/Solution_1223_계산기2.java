package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
 
public class Solution_1223_계산기2 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> op;
        Stack<Integer> st;
        for(int i=1; i<=10; ++i) {
            int N = Integer.parseInt(br.readLine());
            String str = br.readLine();
            StringBuilder res = new StringBuilder();
            st = new Stack<>();
            op = new Stack<>();
            for(int j=0; j<N; j++) {
                char a = str.charAt(j);
                if(a=='*') {
                    if(!op.isEmpty() && op.peek()=='*') {
                        res.append(op.pop());
                    }
                    op.push(a);
                } else if(a=='+') {
                    if(!op.isEmpty()) {
                        if(op.peek()=='*') {
                            res.append(op.pop());
                        }
                        else if(op.peek()=='+') {
                            while(!op.isEmpty()) {
                                res.append(op.pop());
                            }
                        }
                    }
                    op.push(a);
                }else {
                    res.append(a);
                }
                if(j==N-1) {
                    while(!op.isEmpty()) {
                        res.append(op.pop());
                    }
                }
            }
            for(int j=0; j<N; ++j) {
                char a = res.charAt(j);
                if((a=='+' || a=='*') && !st.isEmpty()) {
                    int num2 = st.pop();
                    int num1 = st.pop();
                    if(a=='+') st.push(num1+num2);
                    else if(a=='*') st.push(num1*num2);
                }
                else st.push(a-'0');
            }
            if(!st.isEmpty()) System.out.println("#" + i + " " + st.pop());
        }
    }
 
}