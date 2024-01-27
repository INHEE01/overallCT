package tests;
import java.util.*;

public class escapeMaze {
    static int[] dxs = {-1, 1, 0, 0}; // dx 방향 좌표
    static int[] dys = {0, 0, -1, 1}; // dy 방향 좌표
    static int[] lever = new int[2]; // 레버 좌표 x, y

    public int solution(String[] maps) {
        String[][] map = new String[maps.length][maps[0].length()]; // nXm 크기 map 배열
        boolean[][] visited = new boolean[maps.length][maps[0].length()]; // 방문여부 확인
        int[] start = new int[2]; // 시작좌표 x, y
        // 시작좌표 찾기
        for(int x=0; x<maps.length; x++) {
            String[] s = maps[x].split(""); // maps 문자열 쪼개서 배열 s에 저장
            map[x] = s;
            // 시작좌표 S를 찾아라
            for(int y=0; y<s.length; y++) {
                if(s[y].equalsIgnoreCase("S")) {
                    start[0] = x;
                    start[1] = y;
                }
            }
        }
        // 레버까지 BFS
        int leverResult = bfs(map, visited, start, "L");
        if(leverResult == -1) {
            return -1;
        }
        // 도착지점까지 BFS
        visited = new boolean[maps.length][maps[0].length()]; // 방문여부 초기화
        int exitResult = bfs(map, visited, lever, "E");
        if(exitResult == -1) {
            return -1;
        }

        return leverResult + exitResult;
    }

    public int bfs(String[][] map, boolean[][] visited, int[] start, String target) {
        Queue<int[]> queue = new LinkedList<>(); // BFS Queue 선언
        queue.add(new int[]{start[0], start[1], 0}); // 시작좌표 x, y
        visited[start[0]][start[1]] = true; // 시작좌표 방문 확인 왜냐? 시작좌표부터 시작하는거니까

        while(!queue.isEmpty()) {
            int[] temp = queue.poll(); // 큐에서 값 하나 뽑음
            int curRow = temp[0];
            int curCol = temp[1];
            int cnt = temp[2];
            // dxs dys start
            for(int i=0; i<4; i++) {
                int row = curRow + dxs[i];
                int col = curCol + dys[i];
                if(row >= 0 && col >= 0 && row < map.length && col < map[0].length) {
                    // 도착 지점에 갔을 때
                    if(map[row][col].equals(target)) {
                        lever[0] = row;
                        lever[1] = col;
                        return cnt+1;
                    }
                    // 도착한 곳이 X가 아니면서 방문한 곳이 아니라면
                    if(!map[row][col].equals("X") && !visited[row][col]) {
                        visited[row][col] = true;
                        queue.add(new int[]{row, col, cnt+1});
                    }
                }
            }
            // dxs dys end
        }
        return -1;
    }
}
