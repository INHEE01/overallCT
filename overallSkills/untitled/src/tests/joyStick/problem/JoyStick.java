package tests.joyStick.problem;

public class JoyStick {
    public int solution(String name) {
        int preIdx=0, count=0, move=0;
        // 순회
        for(int i=0; i<name.length(); i++) {
            // 가까운 쪽으로 상하로 조이스틱을 움직인다.
            count += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i)+1);
            // 인덱스 한 칸 앞으로 전진
            preIdx = i+1;
            // 인덱스가 name의 범위 안에 있거나 name 문자열에서 인덱스의 위치하는 문자가 A일 경우 뛰어넘기. 고칠 필요가 없음.
            while(preIdx < name.length() && name.charAt(preIdx) == 'A') {
                preIdx++;
            }
            // 좌우로 조이스틱이 움직이는 것을 계산.
            move = Math.min(preIdx - i, name.length() - preIdx);
        }
        return count+move;
    }
}
