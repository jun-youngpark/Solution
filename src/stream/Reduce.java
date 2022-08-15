package stream;

import java.util.Optional;
import java.util.stream.Stream;

public class Reduce {


    public static void main(String[] args) {
        // Reduce 예제 1 ~10 까지 합 출력 reduce()는 스트림의 원소들을 하나씩 소모해가며, 누적 계산을 수행하고 결과값을 리턴하는 메서드다.
        Optional<Integer> sum = Stream.of(1,2,3,4,5,6,7,8,9,10).reduce((x, y) -> x + y);
        Optional<Integer> max = Stream.of(1,2,3,4,5,6,7,8,9,10).reduce(Integer::max);
        Optional<Integer> min = Stream.of(1,2,3,4,5,6,7,8,9,10).reduce(Integer::min);
        sum.ifPresent(s -> System.out.println("sum: " + s));
        max.ifPresent(s -> System.out.println("max: " + s));
        min.ifPresent(s -> System.out.println("min: " + s));

    }
}
