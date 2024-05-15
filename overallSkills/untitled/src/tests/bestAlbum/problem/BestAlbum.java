package tests.bestAlbum.problem;

import java.util.*;

public class BestAlbum {
    public int[] solution(String[] genres, int[] plays) {
        // HashMap 선언 후 노래 장르와 장르 누적 재생 횟수를 map에 put.
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }
        // 정렬하기 위해 ArrayList 선언
        ArrayList<String> genre = new ArrayList<>();
        for(String key : map.keySet()) {
            genre.add(key);
        }
        // 재생 횟수 내림차순 정렬
        Collections.sort(genre, (o1, o2) -> map.get(o2) - map.get(o1));

        ArrayList<Integer> list = new ArrayList<>();
        // 속한 노래가 많이 재생된 장르 먼저 수록 > 장르 내에서 많이 재생된 노래를 먼저 수록 > 장르 내에서 재생 횟수가 같은 노래 중에는 고유 번호가 낮은 노래를 먼저 수록
        // 장르별 노래는 두 곡씩만 모은다
        for(int i = 0; i < genre.size(); i++) {
            String g = genre.get(i);
            int max = 0;
            int firstIdx = -1;
            for(int j = 0; j < genres.length; j++) {
                if(g.equals(genres[j]) && max < plays[j]) {
                    max = plays[j];
                    firstIdx = j;
                }
            }

            max = 0;
            int secondIdx = -1;
            for(int j = 0; j < genres.length; j++) {
                if(g.equals(genres[j]) && max < plays[j] && j != firstIdx) {
                    max = plays[j];
                    secondIdx = j;
                }
            }
            list.add(firstIdx);
            if(secondIdx >= 0) list.add(secondIdx);
        }

        int[] result = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
