package tests.dragonCurve.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class DragonCurve {
    // 크기는 100 x 100, x와 y의 범위는 0<=x<=100, 0<=y<=100
    private static boolean[][] map = new boolean[101][101];
    private static int x1 = 100, x2 = 0, y1 = 100, y2 = 0;
    private static int[] dx = {0, -1, 0, 1};
    private static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Node[] list = new Node[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            int gen = Integer.parseInt(st.nextToken()); // 세대

            setRange(y, x);
            list[i] = new Node(y, x, dir, gen);
        }

        for (int i = 0; i < n; i++) {
            fill(list[i]);
        }
        int answer = countSquare();
        System.out.println(answer);
    }

    private static void fill(Node node) {
        int gen = node.gen;
        ArrayList<Integer> list = new ArrayList<>();
        map[node.x][node.y] = true;
        map[node.x + dx[node.dir]][node.y + dy[node.dir]] = true;
        list.add(node.dir);

        int x = node.x + dx[node.dir];
        int y = node.y + dy[node.dir];
        setRange(x, y);

        int ndir;
        while (gen-- > 0) {
            for (int i = list.size() - 1; i >= 0; i--) {
                ndir = (list.get(i) + 1) % 4;
                x = x + dx[ndir];
                y = y + dy[ndir];
                setRange(x, y);

                map[x][y] = true;
                list.add(ndir);
            }
        }
    }

    private static void setRange(int x, int y) {
        if (x < x1) x1 = x;
        if (x > x2) x2 = x;
        if (y < y1) y1 = y;
        if (y > y2) y2 = y;
    }

    private static int countSquare() { // 네모 몇개 있는지 count
        int count = 0;
        for (int i = x1; i < x2; i++) {
            for (int j = y1; j < y2; j++) {
                if (!map[i][j]) continue;
                if (map[i][j] && map[i + 1][j] && map[i][j + 1] && map[i + 1][j + 1]) count++;
            }
        }
        return count;
    }
}
// Class : Node 정의
class Node {
    int x, y;
    int dir;
    int gen;

    public Node(int x, int y, int dir, int gen) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.gen = gen;
    }

}
