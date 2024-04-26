package tests.returnToCamp.problem;

import java.util.*;

public class ReturnToCamp {
    int[] cost;
    List<Integer>[] graph;
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        graph = new List[n + 1];
        for(int i = 0 ; i <= n; ++i)
            graph[i] = new ArrayList();

        for(int[] data : roads){
            // 양방향 연결
            graph[data[0]].add(data[1]);
            graph[data[1]].add(data[0]);
        }

        cost = new int[n + 1];
        Arrays.fill(cost, -1); // 경로가 없는 경우 -1
        search(destination);

        int[] answer = new int[sources.length];
        for(int i = 0; i < sources.length; ++i)
            answer[i] = cost[sources[i]];

        return answer;
    }
    public void search(int start){
        Queue<Integer> q = new ArrayDeque();
        q.add(start);
        cost[start] = 0;

        while(!q.isEmpty()){
            int cur = q.poll();
            int len = graph[cur].size();
            for(int i = 0; i < len; ++i){
                int next = graph[cur].get(i);
                if(cost[next] == -1){
                    cost[next] = cost[cur] + 1;
                    q.add(next);
                }
            }
        }
    }
}
