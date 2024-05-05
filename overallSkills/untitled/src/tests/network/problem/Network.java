package tests.network.problem;

public class Network {
    static boolean[] visited;

    public int solution(int n, int[][] computers) {
        for(int i=0; i<computers.length; i++) {
            visited[i] = false;
        }

        for(int i=0; i<computers.length; i++) {
            if(visited[i] == false) {
                answer++;
                dfs(i, visited, computers);
            }
        }
    }

    public void dfs(int n, boolean[] viisted, int[][] computers) {
        visited[n] = true;

        for(int i=0; i<computers.length; i++) {
            if(visited[i] == false && computers[n][i] == 1) {
                dfs(i, visited, computers);
            }
        }
    }
}
