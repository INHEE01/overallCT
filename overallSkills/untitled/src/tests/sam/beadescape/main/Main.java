package tests.sam.beadescape.main;
import java.util.*;
import java.io.*;

public class Main {
    public static int N, M;
    public static char[][] map;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    
    // 빨간 구슬과 파란 구슬의 위치정보
    public static class Game {
        int[] red = new int[2];
        int[] blue = new int[2];

        public Game(int[] red, int[] blue) {
            this.red = red;
            this.blue = blue;
        }
    }

    public static int bfs(Game start) {
        Queue<Game> queue = new LinkedList<>();
        queue.add(start);
        boolean[][][][] v= new boolean[N][M][N][M]; // 노드 방문여부
        v[start.red[0]][start.red[1]][start.blue[0]][start.blue[1]] = true; // 시작노드 방문처리

        int cnt = 0;
        // 큐가 비어있지 않을 때 & 카운트가 10회 미만일 때 조건을 모두 만족할 때까지 반복
        while(!queue.isEmpty() && cnt < 10) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Game cur = queue.poll();

                for (int j = 0; j < 4; j++) {
                    int[] nRed = cur.red.clone();
                    int[] nBlue = cur.blue.clone();

                    if (move(nRed, nBlue, j)) {
                        if (map[nRed[0]][nRed[1]] == 'O') return 1; // Red 가 출구를 찾았다면 종료
                        if (v[nRed[0]][nRed[1]][nBlue[0]][nBlue[1]]) continue; // 이미 방문했던 곳 확인

                        v[nRed[0]][nRed[1]][nBlue[0]][nBlue[1]] = true; // 현재 위치 방문 완료
                        queue.add(new Game(nRed, nBlue));
                    }
                }
            }
            cnt++;
        }
        return 0;
    }
    // 
    public static boolean move(int[] red, int[] blue, int d) {
        boolean redFirst = false;
        //
        if (d == 0 && red[0] < blue[0]) redFirst = true;
        if (d == 1 && red[0] > blue[0]) redFirst = true;
        if (d == 2 && red[1] < blue[1]) redFirst = true;
        if (d == 3 && red[1] > blue[1]) redFirst = true;
        // 빨간 구슬과 파란 구슬의 이동 계산
        int nx = red[0];
        int ny = red[1];
        while(true) {
            nx += dx[d];
            ny += dy[d];

            if (map[nx][ny] == '#') break;
            red[0] = nx;
            red[1] = ny;
            if (map[nx][ny] == 'O') break;
        }

        nx = blue[0];
        ny = blue[1];
        while(true) {
            nx += dx[d];
            ny += dy[d];

            if (map[nx][ny] == '#') break;
            blue[0] = nx;
            blue[1] = ny;
            if (map[nx][ny] == 'O') break;
        }

        if (map[blue[0]][blue[1]] == 'O') return false;

        if (red[0] == blue[0] && red[1] == blue[1]) {
            switch (d) {
                case 0:
                    if (redFirst) blue[0]++;
                    else red[0]++;
                    break;
                case 1:
                    if (redFirst) blue[0]--;
                    else red[0]--;
                    break;
                case 2:
                    if (redFirst) blue[1]++;
                    else red[1]++;
                    break;
                case 3:
                    if (redFirst) blue[1]--;
                    else red[1]--;
                    break;
            }
        }
        return true;
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        int[] blue = new int[2];
        int[] red = new int[2];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'B') {
                    blue[0] = i;
                    blue[1] = j;
                }else if (map[i][j] == 'R'){
                    red[0] = i;
                    red[1] = j;
                }
            }
        }

        System.out.println(bfs(new Game(red, blue)));
    }
}
