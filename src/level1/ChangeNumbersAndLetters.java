package level1;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChangeNumbersAndLetters {


    private final String arr[]={"zero","one","two","three","four","five","six","seven","eight","nine"};

    public int solution(String s) {
        for(int i=0;i<10;i++){
            s = s.replace(arr[i],Integer.toString(i));
        }
        int answer = Integer.parseInt(s);
        return answer;
    }

    public static void main(String[] args) {
        ChangeNumbersAndLetters id =new ChangeNumbersAndLetters();
        System.out.println(id.solution("one4seveneight"));
    }

}
