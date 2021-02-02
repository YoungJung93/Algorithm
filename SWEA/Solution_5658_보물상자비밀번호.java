package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
 
public class Solution_5658_보물상자비밀번호 {
    static class pw implements Comparable<pw>{
        public String num;
        public int unit;
        public pw(String num, int unit) {
            this.num = num;
            this.unit = unit;
        }
        public int cal() {
            int res=0;
            for(int i=unit-1, j=1; i>=0; i--, j*=16) {
                char c = num.charAt(i);
                if(c>='0' && c<='9') {
                    res += (c-'0')*j;
                } else {
                    res += (10 + (c-'A')) * j;
                }
            }
            return res;
        }
        public int compareTo(pw o) {
            return Integer.compare(this.cal(), o.cal()) * -1;
        }
        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("pw [num=").append(num).append(", unit=").append(unit).append("]");
            return builder.toString();
        }
         
    }
    static char[] arr;
    static int n, k, u;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i=1; i<=t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            arr = br.readLine().toCharArray();
            u = n/4;
            int un = n/4;
            PriorityQueue<pw> que = new PriorityQueue<>();
            HashSet<String> set = new HashSet<>();
            do {
                String s = "";
                for(int j=0, k=u; j<=n; j++,k--) {
                    if(k==0) {
                        if(!set.contains(s)) {
                            que.offer(new pw(s, u));
                            set.add(s);
                        }
                        s = "";
                        k=u;
                    }
                    if(j!=n) s += arr[j];
                }
                rotate();
            } while(--un>0);
            for(int j=0; j<k-1; j++) {
                que.poll();
            }
            String r = que.poll().num;
            System.out.println("#" + i + " " + toDec(r));
//          while(!que.isEmpty()) {
//              System.out.println(que.poll());
//          }
//          System.out.println();
        }
    }
    static int toDec(String num) {
        int len = num.length();
        int res=0;
        for(int i=len-1, w=1; i>=0; i--, w*=16) {
            char c = num.charAt(i);
            if(c>='0' && c<='9') {
                res += (c-'0')*w;
            } else {
                res += (10 + (c-'A')) * w;
            }
        }
        return res;
    }
    static void rotate() {
        char tmp = arr[n-1];
        for(int i=n-2; i>=0; i--) {
            arr[i+1] = arr[i];
        }
        arr[0] = tmp;
    }
}
