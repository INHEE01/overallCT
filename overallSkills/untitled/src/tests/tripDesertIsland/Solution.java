package tests.tripDesertIsland;

import java.util.*;

class Solution {
    static char[][] map; // 무인도를 나타내는 지도
    static boolean[][] visited; // 방문 여부
    static int[] dx = {-1, 1, 0, 0}; // x 좌표계
    static int[] dy = {0, 0, -1, 1}; // y 좌표계

    public static List<Integer> solution(String[] maps){
        List<Integer> answer = new ArrayList<>();
        map = new char[maps.length][maps[0].length()];
        visited = new boolean[map.length][map[0].length];
        // 맵 순회하면서 char로 형변환. map은 자료형이 char[][] 이었음.
        for(int i=0;i<maps.length;i++){
            map[i] = maps[i].toCharArray();
        }
        // map을 순회하면서 해당 위치가 X가 아니라면, List answer에 bfs(i, j) 의 값을 add 한다.
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[i].length;j++){
                if(!visited[i][j] && map[i][j] != 'X'){
                    answer.add(bfs(i, j));
                }
            }
        }

        if(answer.size() == 0){
            answer.add(-1);
        }

        Collections.sort(answer);

        return answer;
    }

    public static int bfs(int x, int y){
        int sum = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            sum += map[cx][cy]-'0';
            // 상, 하, 좌, 우 순회
            for(int i=0;i<4;i++){
                int nx = cx+dx[i];
                int ny = cy+dy[i];
                // 좌표의 범위가 맵의 범위가 아니라면 처음부터
                if(nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length)
                    continue;
                // 방문하지 않았으면서 동시에 X가 아닌 위치라면 true로 변경 후 큐에 삽입
                if(!visited[nx][ny] && map[nx][ny] != 'X'){
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
        
        return sum;
    }
}