package tests.babyShark.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BabyShark {
    static int n;
    static int sharkY;
    static int sharkX;
    static int sharkSize = 2;
    static int eatCnt;
    // 상좌우하 dy dx
    static int[] dy = {-1, 0, 0, 1};
    static int[] dx = {0, -1, 1, 0};
    static int answer;
    static boolean[][] visited;

    static class Pos {
        int y;
        int x;
        int distance;

        Pos(int y, int x, int distance) {
            this.y = y;
            this.x = x;
            this.distance = distance;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0) {
                    if (map[i][j] == 9) {
                        sharkY = i;
                        sharkX = j;
                        map[i][j] = 0; // 처음 상어의 위치는 0으로 초기화
                    }
                }
            }
        }

        Queue<Pos> q = new PriorityQueue<>((o1, o2) -> {
            if (o1.distance == o2.distance) {
                if (o1.y == o2.y) return Integer.compare(o1.x, o2.x);
                return Integer.compare(o1.y, o2.y);
            }
            return Integer.compare(o1.distance, o2.distance);
        });
        // 상어의 처음 위치 큐에 삽입
        q.add(new Pos(sharkY, sharkX, 0));
        visited = new boolean[n][n];
        visited[sharkY][sharkX] = true;

        while (!q.isEmpty()) {
            Pos curPos = q.poll(); // 상어의 현재 위치

            for (int i = 0; i <= 3; i++) {
                int moveY = curPos.y + dy[i];
                int moveX = curPos.x + dx[i];
                if (!(moveY < n && moveX < n && moveY >= 0 && moveX >= 0)) continue;
                if (visited[moveY][moveX]) continue;
                visited[moveY][moveX] = true;

                if (map[moveY][moveX] <= sharkSize)
                    q.add(new Pos(moveY, moveX, curPos.distance + 1));
            }

            if (q.peek() != null) {
                Pos peek = q.peek();
                // 큐에 담긴 pos에 있는 물고기가 상어보다 작으면 물고기를 먹는다
                if (map[peek.y][peek.x] < sharkSize && map[peek.y][peek.x] > 0) {
                    eatCnt++;

                    if (eatCnt == sharkSize) {
                        sharkSize++;
                        eatCnt = 0;
                    }
                    map[peek.y][peek.x] = 0;
                    // 큐를 비우고 상어를 peek 위치로 이동
                    q.clear();
                    q.add(new Pos(peek.y, peek.x, 0));
                    answer += peek.distance;
                    visited = new boolean[n][n];
                    visited[peek.y][peek.x] = true;
                }
            }
        }

        System.out.println(answer);
    }
}
