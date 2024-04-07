package tests.roadDice.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RoadDice {
    public static int N, M, K, score;
    public static int[][] map;
    public static int currDir, currR, currC; //  현재 주사위 방향, 현재 주사위 위치 (r,c)
    public static Dice dice; // 주사위

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        StringBuffer sb = new StringBuffer();

        N = Integer.parseInt(st.nextToken()); // 행
        M = Integer.parseInt(st.nextToken()); // 열
        K = Integer.parseInt(st.nextToken()); // 이동횟수

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        } // init map

        currDir = 0;
        currR = 0;
        currC = 0;
        dice = new Dice();

        for (int i = 0; i < K; i++) {
            play();
        }

        System.out.println(score);
    }
    // dir 0,1,2,3
    static int[] dr = { 0, 1, 0, -1 }; // 우 하 좌 상
    static int[] dc = { 1, 0, -1, 0 };

    public static void play() {
        // 1. 이동방향 유지
        int nr = currR + dr[currDir];
        int nc = currC + dc[currDir];
        if (isIn(nr, nc)) {
            currR = nr;
            currC = nc;
        }
        // 범위 벗어나면, 방향 바꿈
        else {
            currDir = (currDir + 2) % 4; // 반대방향으로 바꿈
            currR += dr[currDir];
            currC += dc[currDir];
        }

        // 현재 방향으로 주사위 굴리기
        roll();

        // 2. 도착칸 점수 -> 이동방향 결정
        int B = map[currR][currC];
        if (dice.bottom > B) {
            changeDir(1); // 시계방향
        } else if (dice.bottom < B) {
            changeDir(2); // 반시계 방향
        }

        // 3. 연속해서 이동할 수 있는 칸의 개수 확인
        C = 0; // 0으로 초기화
        count(currR, currC, B, new boolean[N][M]);
        score += (B * C);
    }

    public static int C = 0; // 재귀함수에서 사용하려고 전역변수 처리함.

    // DFS - 현재 위치에서 갈 수 있는 위치 개수 계산
    public static void count(int r, int c, int num, boolean[][] visited) {
        if(map[r][c] != num) return; // 다른 숫자면 종료

        C++;
        visited[r][c] = true;

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if(isIn(nr,nc) && !visited[nr][nc])  // 영역 내에 있고, 방문하지 않은 위치에 대하여 계산
                count(nr, nc, num, visited);
        }
    }
    // 영역 내에 있는지 확인하는 함수
    public static boolean isIn(int r, int c) {
        if (r < 0 || r >= N || c < 0 || c >= M)
            return false;
        return true;
    }

    // 0: 반대 방향, 1: 시계 방향, 2: 반시계 방향
    public static void changeDir(int c) {
        if (c == 0) {
            currDir = (currDir + 2) % 4;
        } else if (c == 1) {
            currDir = (currDir + 1) % 4;
        } else if (c == 2) {
            currDir = (currDir + 3) % 4;
        }
    }
    // 네개의 방향에 따라 주사위 굴리기
    public static void roll() {
        int tmpTop = dice.top;
        int tmpBottom = dice.bottom;
        int tmpFront = dice.front;
        int tmpBack = dice.back;
        int tmpLeft = dice.left;
        int tmpRight = dice.right;

        // 오른쪽으로 굴리기
        if(currDir == 0) {
            dice.bottom = tmpRight;
            dice.top = tmpLeft;
            dice.left = tmpBottom;
            dice.right = tmpTop;
        }
        // 아래로 굴리기
        else if(currDir == 1) {
            dice.front = tmpTop;
            dice.top = tmpBack;
            dice.back = tmpBottom;
            dice.bottom = tmpFront;
        }
        // 왼쪽으로 굴리기
        else if(currDir == 2) {
            dice.bottom= tmpLeft;
            dice.top = tmpRight;
            dice.left = tmpTop;
            dice.right = tmpBottom;
        }
        // 위로 굴리기
        else if(currDir == 3) {
            dice.front = tmpBottom;
            dice.back = tmpTop;
            dice.top = tmpFront;
            dice.bottom = tmpBack;
        }

    }
    static class Dice {
        int top, bottom, left, right, front, back;

        public Dice() {
            this.top = 1;
            this.bottom = 6;
            this.left = 4;
            this.right = 3;
            this.front = 5;
            this.back = 2;
        }
    }
}
