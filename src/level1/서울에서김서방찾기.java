package level1;

import java.util.Arrays;
import java.util.Optional;

public class 서울에서김서방찾기 {

    public String solution(String[] seoul) {
        String answer = "";

        for(int i=0; i<seoul.length; i++) {
            if(seoul[i].equals("Kim")) {
                answer = "김서방은 " + i + "에 있다";
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        서울에서김서방찾기 main = new 서울에서김서방찾기();
        String[] seoul = {"Jane","Kim"};
        main.solution(seoul);

    }
}
