package level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class SkillTestLv1 {

    //정수 n을 입력받아 n의 약수를 모두 더한 값을 리턴하는 함수, solution을 완성해주세요.
    public int solution(int n) {
        int answer = 0;
        for(int i = 1; i <= n; i++){
            if(n % i == 0){
                answer += i;
            }
        }
        return answer;
    }

    //문자열로 구성된 리스트 strings와, 정수 n이 주어졌을 때, 각 문자열의 인덱스 n번째 글자를 기준으로 오름차순 정렬하려 합니다.
    // 예를 들어 strings가 ["sun", "bed", "car"]이고 n이 1이면 각 단어의 인덱스 1의 문자 "u", "e", "a"로 strings를 정렬합니다.

        public String[] solution(String[] strings, int n) {
            String[] answer = {};
            ArrayList<String> arr = new ArrayList<>();
            for (int i = 0; i < strings.length; i++) {

                arr.add("" + strings[i].charAt(n) + strings[i]);
            }

            Collections.sort(arr);
            answer = new String[arr.size()];
            for (int i = 0; i < arr.size(); i++) {
                answer[i] = arr.get(i).substring(1, arr.get(i).length());
            }
            return answer;
        }

    public static void main(String[] args) {
        SkillTestLv1 skill = new SkillTestLv1();
        System.out.println(skill.solution(12));

        String[] strings={"sun", "bed", "car"};
        Arrays.stream(skill.solution(strings, 1)).forEach(System.out::println);

    }
}
