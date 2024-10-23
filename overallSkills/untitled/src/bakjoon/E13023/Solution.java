package bakjoon.E13023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    public static ArrayList<Integer>[] arr;
    public static boolean[] visited;
    public static int arrive;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int node = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        visited = new boolean[node];

        for(int i=0; i<edge; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            arr[s].add(e);
            arr[e].add(s);
        }

        arrive = 0;
        for(int i=0; i<node; i++) {
            dfs(i, 1);
            if (arrive == 1) {
                break;
            }
        }

        if(arrive == 1) {
            System.out.println(arrive);
        } else {
            System.out.print(arrive);
        }


    }

    public static void dfs(int n, int depth) {
        if(depth == 5 || arrive == 1) {
            arrive = 1;
            return;
        }
        visited[n] = true;
        for(int num : arr[n]) {
            dfs(num, depth+1);
        }

        visited[n] = false;
    }
}
