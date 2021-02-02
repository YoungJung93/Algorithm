package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution_4261_빠른휴대전화키패드 {
    public static void main(String[] args) throws IOException {
        String[] map = { "", " ", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i=1; i<=t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String S = st.nextToken();
            int n = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int len = S.length();
            int res = 0;
            for(int j=0; j<n; j++) {
                String str = st.nextToken();
                if(str.length() > len) continue;
                else if(str.length() < len) {
                    for(int k=0; k<len-str.length(); k++) str += " ";
                }
                boolean f = true;
                for(int k=0; k<len; k++) {
                    int a = S.charAt(k) - '0';
                    String b = str.charAt(k) + "";
                    if(!map[a].contains(b)) {
                        f = false; break;
                    }
                }
                if(f) res++;
            }
            System.out.println("#" + i + " " + res);
        }
         
    }
}