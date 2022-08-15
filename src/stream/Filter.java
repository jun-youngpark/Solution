package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Filter {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("Apple","Banana","Melon","Grape","Strawberry","AppleMint"));
        String a = list.stream()
                .filter(h -> h.startsWith("Apple"))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException());
        System.out.println(a);  //apple
        list.stream().filter(t->t.length()>5).forEach(System.out::println);
        System.out.println(list.stream().sorted().collect(Collectors.toList()));    //정렬 a->z
        System.out.println(list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));    //정렬 z->a
        list.stream().map(s -> s.toUpperCase()).forEach(System.out::println);   //대문자로 변환


    }

}
