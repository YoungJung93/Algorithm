package Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution_1873_상호의배틀필드 {
    static class tank {
        public int r, c;
        public tank(int r, int c) {
            this.r = r; this.c = c;
        }
    }
    static tank tank;
    static char[][] map;
    static int h, w;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i=1; i<=t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            map = new char[h][w];
            for(int j=0; j<h; j++) {
                map[j] = br.readLine().toCharArray();
            }
            first : for(int j=0; j<h; j++) {
                for(int k=0; k<w; k++) {
                    if(map[j][k]=='<' || map[j][k]=='>' || map[j][k]=='v' || map[j][k]=='^') {
                        tank = new tank(j, k); break first;
                    }
                }
            }
            int n = Integer.parseInt(br.readLine());
            String command = br.readLine();
            for(int j=0; j<n; j++) {
                game(command.charAt(j));
            }
            System.out.print("#" + i + " ");
            for(char[] ma : map) {
                for(char m : ma) {
                    System.out.print(m);
                }
                System.out.println();
            }
        }
    }
    static void game(char c) {
        switch(c) {
            case 'U' :
                if(tank.r>0 && map[tank.r-1][tank.c]=='.') {
                    map[tank.r][tank.c] = '.';
                    tank.r -= 1;
                }
                map[tank.r][tank.c] = '^';
                break;
            case 'D' :
                if(tank.r<h-1 && map[tank.r+1][tank.c]=='.') {
                    map[tank.r][tank.c] = '.';
                    tank.r += 1;
                }
                map[tank.r][tank.c] = 'v';
                break;
            case 'L' :
                if(tank.c>0 && map[tank.r][tank.c-1]=='.') {
                    map[tank.r][tank.c] = '.';
                    tank.c -= 1;
                }
                map[tank.r][tank.c] = '<';
                break;
            case 'R' :
                if(tank.c<w-1 && map[tank.r][tank.c+1]=='.') {
                    map[tank.r][tank.c] = '.';
                    tank.c += 1;
                }
                map[tank.r][tank.c] = '>';
                break;
            case 'S' :
                char t = map[tank.r][tank.c];
                switch(t) {
                    case '^' :
                        for(int i=tank.r-1; i>=0; i--) {
                            if(map[i][tank.c]=='.' || map[i][tank.c]=='-') continue;
                            else if(map[i][tank.c]=='*') {
                                map[i][tank.c] = '.';
                                break;
                            } else break;
                        }
                        break;
                    case 'v' :
                        for(int i=tank.r+1; i<h; i++) {
                            if(map[i][tank.c]=='.' || map[i][tank.c]=='-') continue;
                            else if(map[i][tank.c]=='*') {
                                map[i][tank.c] = '.';
                                break;
                            } else break;
                        }
                        break;
                    case '<' :
                        for(int i=tank.c-1; i>=0; i--) {
                            if(map[tank.r][i]=='.' || map[tank.r][i]=='-') continue;
                            else if(map[tank.r][i]=='*') {
                                map[tank.r][i] = '.';
                                break;
                            } else break;
                        }
                        break;
                    case '>' :
                        for(int i=tank.c+1; i<w; i++) {
                            if(map[tank.r][i]=='.' || map[tank.r][i]=='-') continue;
                            else if(map[tank.r][i]=='*') {
                                map[tank.r][i] = '.';
                                break;
                            } else break;
                        }
                }
                break;
        }
    }
}