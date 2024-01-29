package tests.truckOnBridge.problem;
import java.util.LinkedList;
import java.util.Queue;

public class TruckOnBridge {
    private int bridge_legnth;
    private int weight;
    private int[] truck_weights;
    public TruckOnBridge() {

    }
    public TruckOnBridge(int bridge_legnth, int weight, int[] truck_weights) {
        this.bridge_legnth = bridge_legnth;
        this.weight = weight;
        this.truck_weights = truck_weights;
    }
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> q = new LinkedList<>();
        int currentWeight = 0;
        int time = 0;

        for(int i=0; i<truck_weights.length; i++) {
            // 다리를 건너는 트럭이 있을 때와 다리를 건너는 트럭이 없을 때로 나누어서 정리
            // while 무한 루프를 통해, truck_weights[i] 트럭이 다리에 진입하는 경우 break 로 탈출한다.
            while(true) {
                // 다리를 건너고 있는 트럭이 없다면 트럭은 다리 위로 진입
                if(q.isEmpty()) {
                    q.add(truck_weights[i]);
                    currentWeight+=truck_weights[i];
                    time++;
                    break;
                } else {
                    // 다리를 건너고 있는 트럭이 있다면 경우를 몇 가지로 다시 나눔
                    // 맨 앞의 트럭이 다리를 건넜을 때, 다리를 건너고 있는 트럭의 무게와 진입하려는 트럭의 무게의 합이 다리가 견딜 수 있는 하중을 초과했을 때, 다리를 건너고 있는 트럭이 존재할 때
                    // 먼저, 맨 앞의 트럭이 다리를 건넜을 때부터 계산. 왜냐? 건넌 녀석은 다리에서 빼고 생각해야하니까.
                    if(q.size() == bridge_length) {
                        currentWeight -= q.peek();
                        q.poll();
                    } else if(currentWeight + truck_weights[i] > weight) { // 그 다음으로는 기존 무게 + 진입하려는 트럭 무게 합이 다리의 하중을 초과할 경우 큐에 0을 삽입해서 나중에 트럭이 다리를 다 건넜는지를 판별할 때 사용한다. break는 걸지 않는다. 아직 trucks_weights[i] 의 트럭은 다리를 건너지 못했으니 말이다.
                        q.add(0);
                        time++;
                    } else {
                        q.add(truck_weights[i]);
                        currentWeight+=truck_weights[i];
                        time++;
                        break;
                    }
                }
            }
        }
        int answer = time + bridge_length; // 모든 트럭이 다리를 지나는 시간은 모든 트럭이 다리 위에 오르는 시간을 의미하는 time 에서 다리의 길이를 의미하는 bridge_length 를 더해줘야한다. 그래야 마지막에 다리위에 오른 트럭이 다리를 빠져나가는 시간이 계산되기 때문
        return answer;
    }
}
