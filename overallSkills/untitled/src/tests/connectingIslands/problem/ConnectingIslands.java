package tests.connectingIslands.problem;

import java.util.Arrays;

public class ConnectingIslands {
    public static int[] parent; // 각 노드의 부모
    public static int finalCost; // 최소 연결 비용

    public int solution(int n, int[][] costs) {
        // make Set
        parent = new int[n];
        for(int i=0; i<n; i++) {
            parent[i]=i;
        }
        // 간선 비용 순으로 costs 배열 정렬
        Arrays.sort(costs, (o1, o2) -> (o1[2] - o2[2]));
        // Kruscal Algorithm
        for(int i=0; i<costs.length; i++) {
            // 사이클이 존재하지 않는 경우에만 간선을 선택
            if(find(costs[i][0]) != find(costs[i][1])) {
                union(costs[i][0], costs[i][1]);
                finalCost+=costs[i][2];
            }
        }
        return finalCost;
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a>b) {
            parent[a] = b;
        } else {
            parent[b] = a;
        }
    }

    public static int find(int x) {
        if(parent[x] == x) {
            return x;
        } else {
            return find(parent[x]);
        }
    }
}
