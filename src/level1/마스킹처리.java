package level1;

import java.util.Arrays;

public class 마스킹처리 {

    public String solution(String phone_number) {
        String answer = "";
        char[] array = phone_number.toCharArray();
        for(int i = 0; i < array.length - 4; i ++){
            array[i] = '*';
        }

        return String.valueOf(array);
    }

    public static void main(String[] args) {
        마스킹처리 main = new 마스킹처리();
        String seoul = "01231231211";
        String a = main.solution(seoul);
        System.out.println(a);

    }
}
