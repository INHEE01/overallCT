package tests.gameMapShortestRoute.problem;

import java.util.LinkedList;
import java.util.Queue;

public class GameMapShortestRoute {
    public int solution(int[][] maps) {
        int answer = 0;
        int n = maps.length;
        int m = maps[0].length;
        // 이동 가능한 방향 (상,하,우,좌)
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 1}); // 시작 위치 (0, 0)에서 출발하므로 큐에 추가

        while (!queue.isEmpty()) {
            int[] currentPosition = queue.poll();
            int x = currentPosition[0];
            int y = currentPosition[1];
            int distance = currentPosition[2];
            // 목적지에 도달하면 최단 거리를 반환후 종료
            // 도착 가능한 여러 방안이 있더라도, 최단 거리 방안이 제일 먼저 도착
            if (x == n - 1 && y == m - 1) {
                answer = distance;
                break;
            }
            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                // 이동 가능한 위치이면 큐에 추가하고 해당 위치를 벽으로 표시 (방문 처리)
                if (newX >= 0 && newX < n &&
                        newY >= 0 && newY < m &&
                        maps[newX][newY] == 1) {
                    queue.offer(new int[]{newX, newY, distance + 1});
                    maps[newX][newY] = 0;
                }
            }
        }
        if (answer == 0) {
            // 목적지에 도달할 수 없는 경우 -1 반환
            return -1;
        }

        return answer;
    }
}
