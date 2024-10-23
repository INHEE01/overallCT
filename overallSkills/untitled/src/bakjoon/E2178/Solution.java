package bakjoon.E2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    public static int n, m;
    public static boolean[][] visited;
    public static int[][] arr;
    public static int[][] maze;
    public static int[] dxs = {1, -1, 0, 0};
    public static int[] dys = {0, 0, 1, -1};
    // 전역 변수 선언
    // bfs, 유효한 범위 확인 & 방문하지 않은 곳 체크 필요.
    // dx dy 설정
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        maze = new int[n][m];
        visited = new boolean[n][m];
        arr = new int[n][m];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for(int j=0; j<m; j++) {
                maze[i][j] = Integer.parseInt(s.substring(j, j+1));
            }
        }

        bfs(0,0);
        System.out.println(arr[n-1][m-1]+1);
    }

    public static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while(!queue.isEmpty()) {
            int[] xy = queue.poll();

            for(int i=0; i<4; i++) {
                int nowX = xy[0] + dxs[i];
                int nowY = xy[1] + dys[i];
                if(isRange(nowX, nowY, n, m)) {
                    if(notVisited(nowX, nowY)) {
                        visited[nowX][nowY] = true;
                        arr[nowX][nowY] = arr[xy[0]][xy[1]]+1;
                        queue.add(new int[]{nowX, nowY});
                    }
                }
            }
        }
    }

    public static boolean isRange(int x, int y, int n, int m) {
        return x >= 0 && y >= 0 && x < n && y < m;
    }

    public static boolean notVisited(int x, int y) {
        return maze[x][y] != 0 && !visited[x][y];
    }
}
