package bakjoon.E11724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    public static boolean[] visited;
    public static ArrayList<Integer>[] arrList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int node = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        arrList = new ArrayList[node+1];
        visited = new boolean[node+1];

        for(int i=1; i<=edge; i++) {
            arrList[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<node; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arrList[s].add(e);
            arrList[e].add(s);
        }

        int count = 0;
        for(int i=1; i<node+1; i++) {
            if(!visited[i]) {
                count++;
                dfs(i);
            }
        }

        System.out.println(count);
    }

    public static void dfs(int v) {
        if(visited[v]) {
            return;
        }

        for(int i : arrList[v]) {
            if(!visited[i]) {
                dfs(i);
            }
        }
    }
}
