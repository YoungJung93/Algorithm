package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Solution_1225_암호생성기 {
    static Queue<Integer> que;
    public static void main(String[] args) throws IOException {
        StringBuilder sb;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=1; i<=10; i++) {
            br.readLine();
            que = new LinkedList<Integer>();
            sb = new StringBuilder();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<8; j++) {
                que.offer(Integer.parseInt(st.nextToken()));
            }
            First : while(true) {
                for(int j=1; j<=5; j++) {
                    int t = que.poll();
                    if(t-j <= 0) {
                        que.offer(0);
                        break First;
                    }
                    else {
                        que.offer(t-j);
                    }
                }
            }
            for(int j=0; j<8; j++) {
                sb.append(que.poll()).append(" ");
            }
            System.out.println("#" + i + " " + sb.toString());
        }
    }
 
}