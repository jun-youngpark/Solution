package level1;

import java.util.Locale;

public class 문자열P와Y개수 {


    boolean solution(String n) {
        boolean answer = false;
        n = n.toUpperCase();
        int nCount = Math.toIntExact((n.chars().filter(s -> s == 'P').count()));
        int yCount = Math.toIntExact((n.chars().filter(s -> s == 'Y').count()));

        if(nCount == 0 && yCount ==0 ){
            return true;
        }
        if(nCount == yCount) answer = true;
        return answer;
    }

    public static void main(String[] args) {
        문자열P와Y개수 main = new 문자열P와Y개수();
        main.solution("pPoooyY");


    }
}
