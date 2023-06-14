package myboard.test;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {

        // ArrayList => 배열. 인덱싱(숫자), 일괄처리 편함. 데이터를 탐색하기 어려움.

        // HashMap 생성
        HashMap<String, Integer> studentScores = new HashMap<>();

        // 키-값 쌍 추가
        studentScores.put("John", 90);
        studentScores.put("Emily", 85);
        studentScores.put("Michael", 92);

        HashMap<String, String> stringMap = new HashMap<>();

        stringMap.put("Michael", "hihi");

        HashMap<String, Object> objectMap = new HashMap<>();


        objectMap.put("no", 1);
        objectMap.put("title", "제목");
        //objectMap.put("reply", new ArrayList<>());

        int no = (int)objectMap.get("no");
        String title = (String)objectMap.get("title");


        stringMap.put("no", 1);
        stringMap.put("title", "제목1");



        // 값 가져오기
        int johnScore = studentScores.get("John");
        System.out.println("John's score: " + johnScore);

        // 키-값 쌍 업데이트
        studentScores.put("Emily", 88);

        // 값 삭제
        studentScores.remove("Michael");

        // 모든 키-값 쌍 출력
        for (String name : studentScores.keySet()) {
            int score = studentScores.get(name);
            System.out.println(name + ": " + score);
        }
    }
}
