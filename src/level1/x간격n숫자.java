package level1;

import java.util.Arrays;

public class x간격n숫자 {

    public static void main(String[] args) {
        x간격n숫자 main =new x간격n숫자();
        main.solution(-4,2);
    }

    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        long sum = 0;
        for(int i = 0; i<n ;i++){
            sum += x;
            answer[i] = sum;
        }
        Arrays.stream(answer).forEach(value -> System.out.println(value));
        return answer;
    }
}
