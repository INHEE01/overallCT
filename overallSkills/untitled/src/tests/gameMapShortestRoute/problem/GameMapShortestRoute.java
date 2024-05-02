package tests.gameMapShortestRoute.problem;

import java.util.LinkedList;
import java.util.Queue;

public class GameMapShortestRoute {
    public static boolean[][] visited; // 방문 여부
    public static int n, m; // n : map 세로 m : 가로
    public static int answer = -1; // 캐릭터가 적 팀의 진영까지 이동하는 가장 빠른 길로 가면 몇 칸을 이동하는지

    static int[] dxs = {-1, 1, 0 ,0};
    static int[] dys = {0, 0, -1, 1};

    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        visited = new boolean[n][m];

        return bfs(0, 0, maps); // 0, 0부터 시작
    }
    // 시작 x좌표 : x 시작 y좌표 : y 맵 정보 : maps
    // bfs 는 Queue 를 사용
    public int bfs(int x, int y, int[][] maps) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y, 1});
        visited[0][0] = true;
        // 모두 탐색할 때까지 반복 (최단거리 계산)
        while(!q.isEmpty()) {
            int[] temp = q.poll();
            x = temp[0];
            y = temp[1];
            int count = temp[2];
            // 맵의 끝
            if(x == n-1 && y == m-1) {
                answer = count;
                break;
            }
            // 방향별로 이동할 수 있는지 없는지 체크
            for(int i=0; i<4; i++) {
                int nx = x + dxs[i];
                int ny = y + dys[i];

                if(nx < 0 || nx > n || ny < 0 || ny > m) {
                    continue;
                }

                if(maps[nx][ny] == 0) {
                    continue;
                }

                if(!visited[nx][ny] && maps[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny, count+1});
                }
            }
        }

        return answer;
    }
}
