package tests.network.problem;

public class Network {
    int[][] connect; // 연결에 대한 정보
    static boolean[] check; // 방문 여부
    int n; // 컴퓨터의 개수
    // x는 시작점
    public boolean[] dfs(int x){
        check[x] = true;
        // 컴퓨터의 개수만큼 탐색, 연결되어 있다면(한 네트워크라면) dfs 진행 (if문에서 구현하기)
        for (int i = 0; i < n; i++) {
            if (i != x && connect[x][i] == 1 && !check[i]) {
                check = dfs(i);
            }
        }
        return check;
    }

    public int solution(int temp, int[][] computers) {
        int answer = 0; // 네트워크의 개수
        n = temp;
        check = new boolean[n];
        connect = computers;
        // 네트워크 개수 찾기 : check[i] 가 false일 때마다 dfs 호출(방문 처리 x) -> 네트워크 개수를 count 한다  
        for (int i = 0; i < n; i++) {
            if (!check[i]) {
                dfs(i);
                answer++;
            }
        }

        return answer;
    }
}
