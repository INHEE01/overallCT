package tests.exercisingUniform.problem;
import java.util.Arrays;

public class ExercisingUniform {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] uniformCount = new int[n+2]; // 체육복을 가지고 있는 상태를 나타내는 배열. -1 이면 체육복 없음, 0 이면 체육복 있음, 1이면 여분의 체육복 있음
        // 람다식을 이용하여 배열 초기화. 여분의 체육복이 있었는데 잃어버리는 경우도 있기에 if else 사용 x
        // 람다식을 이용할 때, (s -> s==num) 에서 parameter num 자리에 변수(여기서 기준은 idx)가 오면 에러가 발생하며, parameter 값은 반드시 정적인 값이어야 한다. Variable used in lambda expression should be final or effectively final 참고.
        for(int idx=1; idx<=n; idx++) {
            int num = idx;
            if(Arrays.stream(lost).anyMatch(s -> s==num)) {
                uniformCount[idx] -= 1;
            }
            if (Arrays.stream(reserve).anyMatch(s -> s==num)) {
                uniformCount[idx] += 1;
            }
        }
        // 첫 번째 번호부터 체육복 소지 상태 점검. 만약 체육복을 잃어버렸다면, 앞에 있는 친구가 체육복이 있는지 확인 후에 뒤에 있는 친구 확인
        // 앞에 친구한테 빌렸으면 다음 번호 학생의 상태 점검. 체육복은 한 번 빌려주면 다른 친구에게 빌려줄 수 없음
        for(int idx=1; idx<=n; idx++) {
            if(uniformCount[idx] == -1) {
                if(uniformCount[idx-1] == 1) {
                    uniformCount[idx-1] -= 1;
                    uniformCount[idx] += 1;
                    continue;
                }
                if(uniformCount[idx+1] == 1) {
                    uniformCount[idx+1] -= 1;
                    uniformCount[idx] += 1;
                }
            }
        }
        // 체육복을 소지하고 있는 친구는 체육 수업에 참여할 수 없다.
        int result = 0;
        for(int count : uniformCount) {
            if(count != -1) {
                result++;
            }
        }
        // 배열을 생성할 때 번호 0번, 그리고 번호 n+1 번 학생이 체육복을 소지중으다 라고(배열의 해당 인덱스 값이 0) 만들어놨기 때문에 이 두명 분을 빼줘야 한다.
        return result-2;
    }
}
