package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MapStream {

    public static void main(String[] args) {

        //맵(map)은 스트림 내 요소들을 하나씩 특정 값으로 변환해줍니다.
        List<String> names = Arrays.asList("son", "ryu", "kang");
        Stream<String> stream = names.stream()
                .map(String::toUpperCase);
        Arrays.asList("son", "ryu", "kang").stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);

        IntStream.range(0,3).map(i -> i*10).forEach(System.out::println);
    }
}
