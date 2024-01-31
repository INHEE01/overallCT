package tests.makingBIggestNumber.problem;

public class MakingBiggestNumber {
    public String solution(String number, int k) {
        // 문자열number 의 길이만큼 순회
        // 앞 자리 설정하기
        int startIdx = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<number.length()-k; i++) {
            int numMax = 0;
            for(int j=startIdx; j<=i+k; j++) {
                if((int)number.charAt(j)-'0' > numMax) {
                    numMax = (int)number.charAt(j)-'0';
                    startIdx = j+1;
                }
            }
            String numtoString = Integer.toString(numMax);
            sb.append(numtoString);
        }
        String result = sb.toString();
        return result;
    }
}
