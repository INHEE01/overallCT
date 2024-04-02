package tests.wordConversion.problem;

public class WordConversion {
    static boolean[] visited;
    static int answer = 0;
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        dfs(begin, target, words, 0);
        return answer;
    }
    // 최단거리 : BFS
    public static void dfs(String begin, String target, String[] words, int count) {
        if(begin.equals(target)) {
            answer = count;
            return;
        }
        for(int i=0;i<words.length;i++) {
            if(visited[i]) continue;
            int len = 0;
            for(int j=0;j<begin.length();j++) {
                if(begin.charAt(j) == words[i].charAt(j)) {
                    len++;
                }
            }
            // 한 글자만 다른 경우
            if(len == begin.length()-1) {
                visited[i] = true;
                dfs(words[i], target, words, count+1);
                visited[i] = false; // 다시 탐색을 위해서 방문 처리 초기화
            }
        }
    }
}
