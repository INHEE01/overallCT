package bakjoon.E23291;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static int N, K;
    public static int[][] map;
    public static int[] dxs = {1, -1, 0, 0};
    public static int[] dys = {0, 0, 1, -1};
    // 구현 메소드 : 물고기 수 가장 적은 어항에 물고기 1마리 추가,


    public static void main(String[] args) throws IOException {
        // 입력 부분
        // 어항 회전 프로세스
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            map[N][i] = Integer.parseInt(st.nextToken());
        }


    }

}
