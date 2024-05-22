package tests.walkingPark.problem;

public class WalkingPark {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        // 시작 위치와 장애물 x좌표와 y좌표 기준으로 체크위치 체크
        int startX=0;
        int startY=0;
        int maxX = park[0].length()-1;
        int maxY = park.length-1;
        // 가로 동선, 세로 동선
        String[] parkX = park;
        String[] parkY = new String[maxX + 1];

        for(int i=0; i<=maxY; i++) {
            String line = park[i];
            for(int j=0; j<=maxX; j++) {
                char point = line.charAt(j);
                if(point == 'S') {
                    startX = j;
                    startY = i;
                }

                if(parkY[j] == null) parkY[j] = "";
                parkY[j] += point;
            }
        }
        // 산책시작
        int moveX = startX;
        int moveY = startY;
        for(String route : routes) {
            String op = route.split(" ")[0];
            int n = Integer.valueOf(route.split(" ")[1]);
            // 동쪽으로 이동하는 경우
            if(op.equals("E")) {
                int startIdx = moveX;
                int endIdx = moveX + n;
                if(endIdx > maxX) endIdx = maxX;

                int blockIdx = parkX[moveY].substring(startIdx, (endIdx + 1)).indexOf("X");
                if(blockIdx < 0 && moveX + n <= maxX) moveX = endIdx;
            } else if(op.equals("W")){ // 서쪽으로 이동하는 경우
                int startIdx = 0;
                int endIdx = moveX;
                if(moveX > n) startIdx = moveX - n;

                int blockIdx = parkX[moveY].substring(startIdx, (endIdx + 1)).lastIndexOf("X");
                if(blockIdx < 0 && moveX - n >= 0) moveX = startIdx;
            } else if(op.equals("S")) { // 남쪽으로 이동하는 경우
                int startIdx = 0;
                int endIdx = moveY;
                if(moveY > n) startIdx = moveY - n;

                int blockIdx = parkY[moveX].substring(startIdx, (endIdx+1)).indexOf("X");
                if(blockIdx < 0 && moveY + n <= maxY) moveY = endIdx;
            } else if(op.equals("N")) {
                int startIdx = 0;
                int endIdx = moveY;
                if(moveY > n) startIdx = moveY - n;

                int blockIdx = parkY[moveX].substring(startIdx, (endIdx + 1)).lastIndexOf("X");

                if(blockIdx < 0 && moveY - n >= 0) moveY = startIdx;
            }
        }

        answer[0] = moveY;
        answer[1] = moveX;
        return answer;
    }
}
