package level1;

import java.util.Arrays;
import java.util.stream.IntStream;

public class PlusEmptyNumber {

    public int solution(int[] numbers) {
        int answer = 0;
        for(int i=1;i<10;i++){
            int finalI = i;
            if(Arrays.stream(numbers).noneMatch(num -> num == finalI)){
                answer += i;
            }
        }

        return answer;
    }

    public int solution2(int[] numbers) {
        int answer = IntStream.range(0, 10)
                        .filter(i-> Arrays.stream(numbers)
                        .noneMatch(num -> num == i))
                        .sum();


        return answer;
    }
    public static void main(String[] args) {
        PlusEmptyNumber main =new PlusEmptyNumber();
        int[] numbers={1,2,3,4,6,7,8,0};
        System.out.println(main.solution(numbers));
        System.out.println(main.solution2(numbers));
    }
}
