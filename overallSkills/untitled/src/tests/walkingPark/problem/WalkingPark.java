package tests.walkingPark.problem;

public class WalkingPark {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        int startX = 0;
        int startY = 0;
        int maxX = park[0].length() - 1;
        int maxY = park.length - 1;

        for (int i = 0; i <= maxY; i++) {
            for (int j = 0; j <= maxX; j++) {
                if (park[i].charAt(j) == 'S') {
                    startX = j;
                    startY = i;
                }
            }
        }

        int moveX = startX;
        int moveY = startY;
        for (String route : routes) {
            String[] parts = route.split(" ");
            String op = parts[0];
            int n = Integer.parseInt(parts[1]);

            switch (op) {
                case "E":
                    for (int i = 1; i <= n; i++) {
                        if (moveX + 1 > maxX || park[moveY].charAt(moveX + 1) == 'X') break;
                        moveX++;
                    }
                    break;
                case "W":
                    for (int i = 1; i <= n; i++) {
                        if (moveX - 1 < 0 || park[moveY].charAt(moveX - 1) == 'X') break;
                        moveX--;
                    }
                    break;
                case "S":
                    for (int i = 1; i <= n; i++) {
                        if (moveY + 1 > maxY || park[moveY + 1].charAt(moveX) == 'X') break;
                        moveY++;
                    }
                    break;
                case "N":
                    for (int i = 1; i <= n; i++) {
                        if (moveY - 1 < 0 || park[moveY - 1].charAt(moveX) == 'X') break;
                        moveY--;
                    }
                    break;
            }
        }

        answer[0] = moveY;
        answer[1] = moveX;
        return answer;
    }
//    public int[] solution(String[] park, String[] routes) {
//        int[] answer = new int[2];
//        int startX = 0;
//        int startY = 0;
//        int maxX = park[0].length() - 1;
//        int maxY = park.length - 1;
//
//        // 시작 위치 찾기
//        for (int i = 0; i <= maxY; i++) {
//            for (int j = 0; j <= maxX; j++) {
//                if (park[i].charAt(j) == 'S') {
//                    startX = j;
//                    startY = i;
//                }
//            }
//        }
//
//        int moveX = startX;
//        int moveY = startY;
//        for (String route : routes) {
//            String op = route.split(" ")[0];
//            int n = Integer.valueOf(route.split(" ")[1]);
//
//            switch (op) {
//                case "E": // 동쪽으로 이동
//                    for (int i = 1; i <= n; i++) {
//                        if (moveX + i > maxX || park[moveY].charAt(moveX + i) == 'X') break;
//                        moveX += i;
//                    }
//                    break;
//                case "W": // 서쪽으로 이동
//                    for (int i = 1; i <= n; i++) {
//                        if (moveX - i < 0 || park[moveY].charAt(moveX - i) == 'X') break;
//                        moveX -= i;
//                    }
//                    break;
//                case "S": // 남쪽으로 이동
//                    for (int i = 1; i <= n; i++) {
//                        if (moveY + i > maxY || park[moveY + i].charAt(moveX) == 'X') break;
//                        moveY += i;
//                    }
//                    break;
//                case "N": // 북쪽으로 이동
//                    for (int i = 1; i <= n; i++) {
//                        if (moveY - i < 0 || park[moveY - i].charAt(moveX) == 'X') break;
//                        moveY -= i;
//                    }
//                    break;
//            }
//        }
//
//        answer[0] = moveY;
//        answer[1] = moveX;
//        return answer;
//    }
}
