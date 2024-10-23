package bakjoon.E1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static ArrayList<Integer>[] arr;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int node = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        visited = new boolean[node+1];
        arr = new ArrayList[node+1];

        for(int i=1; i<=node; i++) {
            arr[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<edge; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            arr[s].add(e);
            arr[e].add(s);
        }

        for(int i=1; i<=node; i++) {
            Collections.sort(arr[i]);
        }

        visited = new boolean[node+1];
        dfs(start);
        System.out.println();

        visited = new boolean[node+1];
        bfs(start);
        System.out.println();
    }

    public static void bfs(int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        visited[n] = true;

        while(!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");
            for(int i : arr[node]) {
                if(!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }

    public static void dfs(int n) {
        if(visited[n]) {
            return;
        }
        System.out.print(n + " ");

        visited[n] = true;
        for(int i : arr[n]) {
            if(!visited[i]) {
                dfs(i);
            }
        }
    }
}
