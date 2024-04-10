package tests.tripPath.problem;

import java.util.PriorityQueue;
import java.util.Queue;

public class TripPath {
    public Queue<String> pq = new PriorityQueue<>(); // 우선순위 큐 (DFS는 Queue 구현하여 정의)
    public boolean[] visited; // 방문 여부

    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length]; 
        dfs(tickets, "ICN", 0, "ICN");
        String[] answer = pq.peek().split(",");
        return answer;
    }
    // DFS 정의
    public void dfs(String[][] tickets, String currentCity, int cnt, String path){
        // 탐색을 마쳤다면 여행경로 추가 후 종료
        if(cnt == tickets.length){
            pq.add(path);
            return;
        }

        for(int i=0;i<tickets.length;i++){
            if(!visited[i] && currentCity.equals(tickets[i][0])){
                visited[i] = true;
                dfs(tickets, tickets[i][1], cnt+1, path +","+ tickets[i][1]); // 다음 경로 탐색
                visited[i] = false; // 모든 배열을 순회하면 false 로 초기화
            }
        }
    }
}
