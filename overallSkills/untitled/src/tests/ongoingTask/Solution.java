package tests.ongoingTask;

import java.util.*;

class Solution {
    // 진행해야 하는 과제 정의
    public static class Task {
        String name;
        int start;
        int playtime;

        Task(String name, int start, int playtime) {
            this.name = name;
            this.start = start;
            this.playtime = playtime;
        }
    }

    public String[] solution(String[][] plans) {
        // 과제를 끝낸 순서대로 result 배열에 담기.
        // 과제를 수행하던 도중 새로운 과제를 수행해야 하면 기존에 하던 과제를 마치고 새로운 과제 수행
        // 시작 시간 기준으로 정렬
        String[] answer = {};
        List<Task> tasks = new ArrayList<>();

        for(String[] plan : plans) {
            String name = plan[0];
            int start = timeToMin(plan[1]);
            int playtime = Integer.parseInt(plan[2]);
            tasks.add(new Task(name, start, playtime));
        }
        // 시작 시간(start)을 기준으로 정렬
        tasks.sort(Comparator.comparingInt(task -> task.start));

        List<String> result = new ArrayList<>();
        Stack<Task> stack = new Stack<>();
        int currentTime = 0;

        for (Task task : tasks) {
            while (!stack.isEmpty() && currentTime + stack.peek().playtime <= task.start) {
                Task currentTask = stack.pop();
                currentTime += currentTask.playtime;
                result.add(currentTask.name);
            }

            if (!stack.isEmpty()) {
                Task currentTask = stack.pop();
                currentTask.playtime -= (task.start - currentTime);
                stack.push(currentTask);
            }

            stack.push(task);
            currentTime = task.start;
        }

        while (!stack.isEmpty()) {
            Task currentTask = stack.pop();
            currentTime += currentTask.playtime;
            result.add(currentTask.name);
        }

        answer = result.toArray(new String[result.size()]);
        return answer;
    }
    // 시간을 분으로 계산하기
    public int timeToMin(String time) {
        String[] hourTime = time.split(":");
        return Integer.parseInt(hourTime[0])*60 + Integer.parseInt(hourTime[1]);
    }
}