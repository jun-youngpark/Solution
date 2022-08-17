package stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Collect {


    private static  Stream<Student> stuStream;
    public static void main(String[] args) {
            //Collect는 Stream의 데이터를 변형 등의 처리를 하고 원하는 자료형으로 변환해 줍니다.
        //MAP 으로 변환하기
        Map<String, String> collect = Arrays.asList("a", "b", "c")
                .stream()
                .collect(Collectors.toMap(Function.identity(), str -> str+"1"));
        System.out.println(collect);
        //ㄴㄷㅅ 으로 변환하기
        Set<String> collect2 = Arrays.asList("a", "b", "c")
                .stream()
                .collect(Collectors.toSet());
        System.out.println(collect2);
        //스트림의 모든 아이템들을 1개로 만들기
        Stream<String> fruits = Stream.of("banana", "apple", "mango", "kiwi", "peach", "cherry", "lemon");
        String result2 = fruits.collect(Collectors.joining("&"));
        System.out.println(result2);


        Collect collect1 = new Collect(); 
        //기본 분할(true / false) partitioningBy()에 의한 분류
        Map<Boolean, List<Student>> studentBySex = collect1.makeStudent()
                .collect(Collectors.partitioningBy(Student::isMale));
        System.out.println(studentBySex.get(true));
        System.out.println(studentBySex.get(true).stream().map(Student::getName).collect(Collectors.joining(",")));
 
        //partitioningBy()를 중첩하여 이중 분할을 할 수도 있음
        Map<Boolean, Map<Boolean, List<Student>>> failedStudentBySex = collect1.makeStudent()
                .collect(Collectors.partitioningBy(Student::isMale,
                        Collectors.partitioningBy(student -> student.getScore() <= 100)));
        List<Student> failedMaleStudents   = failedStudentBySex.get(true).get(true);
        List<Student> failedFemaleStudents = failedStudentBySex.get(false).get(true);
        System.out.println("남학생중 100점이넘은 학생 찾기");
      
        for (Student student : failedMaleStudents) {
            System.out.println(student);
        }
        System.out.println("여학생중 100점이넘은 학생 찾기");
        for (Student student : failedFemaleStudents) {
            System.out.println(student);
        }

        // toList() 생략 가능 - 기본값임
        Map<Integer, List<Student>> studentByGroupList = collect1.makeStudent()
                .collect(Collectors.groupingBy(Student::getGroup));
        //기본 타입(toList)이 아닌 경우, 반환 타입 제네릭 지정에 유의할 것
        //toCollection()은 안에 생성자 입력 필요
        Map<Integer, Set<Student>> studentByGroupSet = collect1.makeStudent()
                .collect(Collectors.groupingBy(Student::getGroup, Collectors.toSet()));
        System.out.println(studentByGroupSet);

        Map<Integer, HashSet<Student>> studentByGroupHashSet = collect1.makeStudent()
                .collect(Collectors.groupingBy(Student::getGroup, Collectors.toCollection(HashSet::new)));
        System.out.println(studentByGroupHashSet);
    }

    private Stream<Student> makeStudent() {
        return Stream.of(
                new Student("가나다", true,  1, 1, 100),
        new Student("나다라", true,  1, 2, 200),
        new Student("라마바", false, 1, 3, 300),
        new Student("사아자", false, 1, 4, 200),
        new Student("아자차", true,  1, 5, 100),
        new Student("차카타", true,  1, 6, 200),
        new Student("파하가", true,  1, 7, 150),
        new Student("나다라", false, 2, 1, 240),
        new Student("마바사", false, 2, 2, 250),
        new Student("아자차", true,  2, 3, 300),
        new Student("카타파", true,  2, 4, 200),
        new Student("하가나", true,  2, 5, 200),
        new Student("다마바", false, 2, 6, 100),
        new Student("차카타", false, 2, 7, 150)
        );
  }


    class Student {

        String name;    // 이름
        boolean isMale; // 성별
        int grade;      // 학년
        int group;      // 그룹
        int score;      // 점수

        Student(String name, boolean isMale, int grade, int group, int score) {
            this.name = name;
            this.isMale = isMale;
            this.grade = grade;
            this.group = group;
            this.score = score;
        }

        String getName() {
            return name;
        }

        boolean isMale() {
            return isMale;
        }

        int getGrade() {
            return grade;
        }

        int getGroup() {
            return group;
        }

        int getScore() {
            return score;
        }

        public String toString() {
            return String.format("[%s, %s, %d학년, %d그룹, %3d점]",
                    name, isMale ? "남" : "여", grade, group, score);
        }
    }

}
