package tests.truckOnBridge.main;

import tests.truckOnBridge.problem.TruckOnBridge;

public class Main {
    public static void main(String[] args) {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7,4,5,6};
        TruckOnBridge t = new TruckOnBridge();
        System.out.println(t.solution(bridge_length, weight, truck_weights));
    }
}
