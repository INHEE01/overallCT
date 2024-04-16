package tests.speedEnforceCamera.problem;

import java.util.Arrays;
import java.util.Comparator;

public class SpeedEnforcementCamera {
    public int solution(int[][] routes) {
        int answer = 0; // 모든 차량이 한 번은 단속용 카메라를 만나도록 하려면 몇 대의 카메라를 설치해야 하는지에 대한 값
        int min = -30000; // 차량의 진입 지점, 진출 시점은 -30000 이상 30000 이하

        Arrays.sort(routes, Comparator.comparingInt(a -> a[1]));// routes[1] 값을 기준으로 오름차순 정렬
        // 현재 자동차의 진입시간(route[i][0])이 이전 자동차의 진출시간(route[i][1])보다 뒤일 때의 경우
        for (int i = 0; i < routes.length; i++) {
            if(routes[i][0] > min) {
                min = routes[i][1];
                answer++;
            }
        }

        return answer;
    }
}
