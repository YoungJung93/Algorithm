package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
 
public class Solution_4366_정식이의은행업무 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i=1; i<=t; i++) {
            String a = br.readLine();
            String b = br.readLine();
            String bi = null;
            String ai = null;
            for(int j=0, size=a.length(); j<size; j++) {
                if(a.charAt(j)=='0') ai=a.substring(0, j) + "1" + a.substring(j+1, size);
                else  ai=a.substring(0, j) + "0" + a.substring(j+1, size);
                bi = to3(from2(ai));
                if(comp(bi, b)==1) break;
            }
            System.out.println("#" + i + " " + from2(ai));
        }
    }
    static int comp(String a, String b) {
        int res=0;
//      if(a.length()!=b.length()) return -1;
        if(a.length()<b.length()) {
            while(a.length()!=b.length()) {
                a = "0" + a;
            }
        }else if(a.length()>b.length()) {
            while(a.length()!=b.length()) {
                b = "0" + b;
            }
        }
        for(int i=0, size=a.length(); i<size; i++) {
            if(res>1) break;
            if(a.charAt(i) != b.charAt(i)) res++;
        }
        return res;
    }
    static BigInteger from2(String s) {
        BigInteger res = new BigInteger("0");
        for(int i=s.length()-1, j=1; i>=0; i--, j*=2) {
            res = res.add(BigInteger.valueOf((s.charAt(i)-'0')*j));
        }
        return res;
    }
    static String to3(BigInteger s) {
        String res = "";
        while(s.compareTo(BigInteger.valueOf(3))==1) {
            res = s.mod(BigInteger.valueOf(3)) + res;
            s = s.divide(BigInteger.valueOf(3));
        }
        res=s+res;
        return res;
    }
    static BigInteger from3(String s) {
        BigInteger res = new BigInteger("0");
        for(int i=s.length()-1, j=1; i>=0; i--, j*=3) {
            res = res.add(BigInteger.valueOf((s.charAt(i)-'0')*j));
        }
        return res;
    }
}