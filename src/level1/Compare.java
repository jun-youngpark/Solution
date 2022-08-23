package level1;

public class Compare {

    public static void main(String[] args) {
        Integer x = 3;
        Integer y = 4;
        Double z = 1.0;

        System.out.println( x.compareTo(y) );  // -1    오른쪽이크면
        System.out.println( x.compareTo(3) );  //  0    같으면
        System.out.println( x.compareTo(2) );  //  1    왼쪽이크면
        System.out.println( z.compareTo(2.7) );  //  -1
        String str = "abcd";

        // 1) 비교대상에 문자열이 포함되어있을 경우
        System.out.println( str.compareTo("abcd") );  // 0 (같은 경우는 숫자나 문자나 0을 리턴)
        System.out.println( str.compareTo("ab") );  //  2
        System.out.println( str.compareTo("a") );  //  3
        System.out.println( str.compareTo("c") );  //  -2
        System.out.println( "".compareTo(str) );  //  -4
        System.out.println( "b".compareTo("c") );  //  -1
        System.out.println( "b".compareTo("b") );  //  0
        System.out.println( "b".compareTo("a") );  //  1

    }
}
