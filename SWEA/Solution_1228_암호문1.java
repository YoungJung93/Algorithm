package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_1228_암호문1 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> res;
        for(int i=1; i<=10; ++i) {
        	res = new LinkedList<String>();
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<10; j++) {
                res.add(st.nextToken());
            }
            
            int cn = Integer.parseInt(br.readLine());
            String[] com = br.readLine().substring(2).split("I");
            for(int j=0; j<cn; j++) {
            	String tmp = com[j].trim();
                int ind = Integer.parseInt(tmp.split(" ")[0]);
                if(ind >= 10) continue;
                int indea = Integer.parseInt(tmp.split(" ")[1]);
                for(int k=2; k<2+indea; k++,ind++) {
                	res.add(ind, tmp.split(" ")[k]);
                }
                res = res.subList(0, 10);
            }
            System.out.print("#" + i + " ");
            for(int j=0; j<10; j++) {
            	System.out.print(res.get(j) + " ");
            }
            System.out.println();
        }
    }
}