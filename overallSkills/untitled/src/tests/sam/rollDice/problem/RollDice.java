package tests.sam.rollDice.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RollDice {
    // Process
    // NxM 크기의 지도 위에서 움직임, (r, c)는 지도 위에서의 좌표
    // r은 북쪽으로부터 떨어진 칸의 개수, c는 서쪼긍로부터 떨어진 칸의 개수
    // 최초의 주사위의 상태는 윗면에 1이 와있으며, 3이 동쪽을 바라보고 있으며, 좌표는 (x, y)에 위치.
    // 주사위 굴려서 이동한 칸에 있는 수가 0이면, 주사위의 바닥면에 쓰여있는 칸의 수가 칸에 들어감. 0이 아니면 칸의 수가 주사위의 바닥면에 들어감.
    // 지도 바깥으로 주사위가 나갈 수 없음. 나가려고 시도할 시 해당 명령 무시

    // Method Requirements
    // 첫 째줄 입력 : n, m, x, y, k 입력 (지도의 크기, 주사위의 최초 좌표, 명령 개수)
    // 둘 째줄 입력 : 지도 칸마다 숫자 입력
    // 셋 째줄(세 번째) 입력 : 이동하는 명령 (동 : 1, 서 : 2, 남 : 3, 북 : 4)
    static int n, m, x, y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 첫째 줄 입력 : n, m, x, y, k
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());


    }
}