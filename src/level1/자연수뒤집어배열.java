package level1;

import java.util.Arrays;
import java.util.Collections;

public class 자연수뒤집어배열 {
    public static void main(String[] args) {
        자연수뒤집어배열 main =new 자연수뒤집어배열();
        long n =12345;
         main.solution(n);
    }

    public int[] solution(long n) {
        String a = "" + n;
        int[] answer = new int[a.length()];
        int cnt=0;

        while(n>0) {
            answer[cnt]=(int)(n%10);
            n/=10;
            System.out.println(n);
            cnt++;
        }
        return answer;
    }
}
