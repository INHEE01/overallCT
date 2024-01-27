import tests.escapeMaze;

public class Main {
    public static void main(String[] args) {
        escapeMaze e = new escapeMaze();
        String[] map = {"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"};
        System.out.println(e.solution(map));

    }
}