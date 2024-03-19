package tests.sam.manipulateLadder.main;

import java.io.*;

public class Main {
    static int n,m,h;
    static int map[][];
    static int min = 4;
    static boolean end = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] t = br.readLine().split(" ");
        n = Integer.parseInt(t[0]);
        m = Integer.parseInt(t[1]);
        h = Integer.parseInt(t[2]);

        map = new int[h+2][n+2];

        for(int i=0; i<m; i++) {
            String [] tt = br.readLine().split(" ");
            int a = Integer.parseInt(tt[0]);
            int b = Integer.parseInt(tt[1]);
            map[a][b]=1;
        }
        for(int i=0; i<=3; i++) {
            dfs(0,i,1);
        }
        System.out.println(-1);
    }
    public static void dfs(int level, int num, int col) {
        if(level>num || level >min) {
            return ;
        }
        if(isPossible()) {
            min = Math.min(min,level);
            System.out.println(min);
            System.exit(0);
            return ;
        }
        for(int i=col; i<=h; i++) {
            for(int j=1; j<=n; j++) {
                if(map[i][j]==0 && map[i][j-1]==0 && map[i][j+1]==0) {
                    map[i][j]=1;
                    dfs(level+1,num,i);
                    map[i][j]=0;
                }
            }
        }
    }
    public static boolean isPossible() {
        for(int i=1; i<=n; i++) {
            int line = i;
            int col = 1;
            while(true) {
                if(col == h+1) {
                    break;
                }
                if(map[col][line]==1) { // 옆칸에 연결 돼 있는거
                    line+=1;
                }
                else if(map[col][line-1] ==1) {
                    line -=1;
                }
                col++;
            }

            if(line != i) {
                return false;
            }
        }
        return true;
    }
}