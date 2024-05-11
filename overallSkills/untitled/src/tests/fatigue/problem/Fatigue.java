package tests.fatigue.problem;

public class Fatigue {
    static boolean[] visited;
    static int max = 0;

    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(k, dungeons, 0);
        return max;
    }

    public void dfs(int k, int[][] dungeons, int cnt) {
        for(int i=0; i<dungeons.length; i++) {
            int reqMin = dungeons[i][0];
            int cost = dungeons[i][1];

            if(visited[i] || k < reqMin) {
                continue;
            }

            visited[i] = true;
            dfs(k-cost, dungeons, cnt+1);
            visited[i] = false;
        }

        max = Math.max(max, cnt);
    }
}
