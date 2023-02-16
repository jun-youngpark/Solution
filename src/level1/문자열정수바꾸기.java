package level1;

public class 문자열정수바꾸기 {
    public static void main(String[] args) {
        문자열정수바꾸기 main =new 문자열정수바꾸기();
        String n ="-12345";
        main.solution(n);
    }

    public int solution(String s) {
        int answer = Integer.parseInt(s);


        System.out.println(answer);
        return answer;
    }
}
