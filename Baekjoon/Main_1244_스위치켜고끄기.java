package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1244_스위치켜고끄기 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        bulb = new boolean[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++) {
            int a = Integer.parseInt(st.nextToken());
            if(a==1) bulb[i] = true;
            else bulb[i] = false;
        }
        int k = Integer.parseInt(br.readLine());
        for(int i=0; i<k ; i++) {
            st = new StringTokenizer(br.readLine());
            int gen = Integer.parseInt(st.nextToken());
            int ind = Integer.parseInt(st.nextToken());
            if(gen==1) nam(ind);
            else yeo(ind);
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=n; i++) {
            if(bulb[i]) sb.append("1 ");
            else sb.append("0 ");
            if(i%20==0) sb.append("\n");
        }
        System.out.println(sb);
    }
    static boolean[] bulb;
    static void nam(int ind) {
        for(int i=ind, size=bulb.length; i<size; i+=ind) {
            bulb[i] = !bulb[i];
        }
    }
    static void yeo(int ind) {
        int size = bulb.length,i,j;
        int min=0, max=0;
        for(i=ind-1, j=ind+1; i>0 && j<size; i--,j++) {
            if(bulb[i]==bulb[j]) continue;
            break;
        }
        min = i+1; max = j-1;
        for(int k=min; k<=max; k++) {
            bulb[k] = !bulb[k];
        }
    }  
}