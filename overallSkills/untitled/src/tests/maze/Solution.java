package tests.maze;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    static int[] dxs = {1, -1, 0, 0};
    static int[] dys = {0, 0, 1 ,-1};
    static boolean[][] visited;
    static String[][] map;

    public int solution(String[] maps) {
        map = new String[maps.length][maps[0].length()];
        int[] start = new int[2];
        int[] middle = new int[2];
        int[] end = new int[2];

        for(int i=0; i<maps.length; i++) {
            String[] tmp = maps[i].split("");
            for(int j=0; j<tmp.length; j++) {
                map[i][j] = tmp[j];
                if(map[i][j].equals("S")) {
                    start[0] = i;
                    start[1] = j;
                }

                if(map[i][j].equals("L")) {
                    middle[0] = i;
                    middle[1] = j;
                }

                if(map[i][j].equals("E")) {
                    end[0] = i;
                    end[1] = j;
                }
            }
        }

        bfs(start);

        return 1;
    }

    public static int bfs(int[] start) {
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start[0], start[1]});
        visited = new boolean[map.length][map[0].length];
        visited[start[0]][start[1]] = true;

        while(!queue.isEmpty()) {
            int[] n = queue.poll();
            for(int i=0; i<4; i++) {
                int nx = n[0] + dxs[i];
                int ny = n[1] + dys[i];

                if(nx >= 0 && nx < map.length && ny >= 0 && ny < map[0].length && !visited[nx][ny]) {
                    if(!map[nx][ny].equals("X")) {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }

        return -1;
    }
}
