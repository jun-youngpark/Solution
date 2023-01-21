package level2;

/*

어떤 숫자에서 k개의 수를 제거했을 때 얻을 수 있는 가장 큰 숫자를 구하려 합니다.

예를 들어, 숫자 1924에서 수 두 개를 제거하면 [19, 12, 14, 92, 94, 24] 를 만들 수 있습니다. 이 중 가장 큰 숫자는 94 입니다.

문자열 형식으로 숫자 number와 제거할 수의 개수 k가 solution 함수의 매개변수로 주어집니다.
number에서 k 개의 수를 제거했을 때 만들 수 있는 수 중 가장 큰 숫자를 문자열 형태로 return 하도록 solution 함수를 완성하세요.
*/

public class SkillTest2_1 {

    public String solution(String number, int k) {

        StringBuilder sb = new StringBuilder();
        int index = 0;
        int next = 0;

        for (int i = 0; i < number.length() - k; i++) {
            int max = 0;

            for (int j = index; j <= i + k; j++) {
                int current = Character.getNumericValue(number.charAt(j));
                if(current  == 9){
                    max = 9;
                    next = j;
                    break;
                }
                if (max < current) {
                    max = current;
                    next = j;
                }
            }
            sb.append(max);
            index = next + 1;
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        String number = "1924";
        int k= 2;
        SkillTest2_1 skillTest2 =new SkillTest2_1();
        System.out.println(skillTest2.solution(number,k));


    }
}
