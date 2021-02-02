package Problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
 
public class Solution_1244_최대상금 {
    static int[] card, maxVal;
    static int max;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String num = st.nextToken();
            int n = Integer.parseInt(st.nextToken());
            int size = num.length();
            card = new int[size];
            maxVal = new int[n+1];
            for (int j = size - 1, k = 0; j >= 0; --j, ++k) {
                card[k] = num.charAt(j) - '0';
            }
            max = 0;
            mix(n);
            bw.write("#" + i + " " + max + "\n");
            bw.flush();
        }
        bw.close();
    }
 
    public static void mix(int cnt) {
        int num = calculate();
        if (maxVal[cnt] < num) maxVal[cnt] = num;
        else return;
        if (cnt == 0) {
            max = maxVal[cnt];
            return;
        }
        int size = card.length;
        for (int i = 0; i < size-1; ++i) {
            for (int j = i+1; j < size; ++j) {
                if (i != j) {
                    swap(i, j);
                    mix(cnt - 1);
                    swap(i, j);
                }
            }
        }
    }
 
    public static int calculate() {
        int size = card.length, res = 0;
        for (int i = 0, w = 1; i < size; ++i, w *= 10) {
            res += card[i] * w;
        }
        return res;
    }
 
    public static void swap(int i, int j) {
        int temp = card[i];
        card[i] = card[j];
        card[j] = temp;
    }
}
