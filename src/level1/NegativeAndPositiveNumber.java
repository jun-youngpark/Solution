package level1;

import java.util.Arrays;

public class NegativeAndPositiveNumber {

    public int solution(int[] absolutes, boolean[] signs) {
        int answer=0;
        for(int i=0; i<absolutes.length; i++){
            if (signs[i]) {
                answer += absolutes[i];
            } else {
                answer -= absolutes[i];
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        NegativeAndPositiveNumber main =new NegativeAndPositiveNumber();
        int[] absolutes={4,7,12};
        boolean[] signs= {true,false,true};
        System.out.println(main.solution(absolutes,signs));
    }

}
