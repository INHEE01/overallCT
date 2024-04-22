package tests.fineDust.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FineDust {
    public static int r, c, t;
    public static int[][] map;
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};
    public static int[] down_dir = {0, 3, 2, 1};
    public static int air_1, air_2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        map = new int[r][c];
        boolean check = false;
        for(int i=0;i<r;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<c;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == -1) {
                    map[i][j] = 0;
                    if(!check) {
                        air_1 = i;
                        check = true;
                    } else {
                        air_2 = i;
                    }
                }
            }
        }
        while(t-- > 0) {
            // 미세먼지 확산 ON
            moving();
            for(int i=0;i<r;i++) {
                for(int j=0;j<c;j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
            // 공기청정기
            air_machine();
            for(int i=0;i<r;i++) {
                for(int j=0;j<c;j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }

        int ans = 0;
        for(int i=0;i<r;i++) {
            for(int j=0;j<c;j++) {
                ans += map[i][j];
            }
        }
        System.out.println(ans);
    }
    public static void moving() {
        int[][] map_copy = new int[r][c];
        for(int i=0;i<r;i++) {
            map_copy[i] = map[i].clone();
        }
        for(int i=0;i<r;i++) {
            for(int j=0;j<c;j++) {
                int cnt = 0;
                if(map[i][j] == 0) continue;

                for(int d=0;d<4;d++) {
                    int nx = i + dx[d];
                    int ny = j + dy[d];

                    if(ny==0 && (nx==air_1 || nx == air_2)) {
                        continue;
                    }

                    if(0 <= nx && nx < r && 0 <= ny && ny < c) {
                        cnt++;
                        map_copy[nx][ny] += map[i][j] / 5;
                    }
                }
                map_copy[i][j] -= (map[i][j] / 5) * cnt;
            }
        }
        for(int i=0;i<r;i++) {
            map[i] = map_copy[i].clone();
        }

    }
    public static void air_machine() {
        // 반시계
        int temp = map[0][0];
        int x = 0;
        int y = 0;
        for(int d=0;d<4;d++) {
            while (true) {
                if(x==1 && y == 0) break;
                int nx = x + dx[d];
                int ny = y + dy[d];
                if(ny < 0 || ny >= c || nx < 0 || nx >= air_2) {
                    break;
                }
                if(!(y == 0 && (x == air_1 || x == air_2))) {
                    map[x][y] = map[nx][ny];
                }
                x = nx;
                y = ny;

            }
        }
        map[1][0] = temp;
        // 시계
        temp = map[r-1][0];
        x = r-1;
        y = 0;

        for(int d=0;d<4;d++) {
            while (true) {
                if(x==(r-2) && y==0) break;
                int nx = x + dx[down_dir[d]];
                int ny = y + dy[down_dir[d]];

                if(ny < 0 || ny >= c || nx <= air_1 || nx >= r) {
                    break;
                }

                if(!(y == 0 && (x == air_1 || x == air_2))) {
                    map[x][y] = map[nx][ny];
                }
                x = nx;
                y = ny;

            }
        }
        map[r-2][0] = temp;
    }
}
