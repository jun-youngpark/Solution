package level2.sort;

import java.util.Arrays;

public class HIndex {

    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
         return answer;
    }

    public static void main(String[] args) {
        int[] priorities = {0,1,3,5,6};
        HIndex test =new HIndex();
        int result = test.solution(priorities);
        System.out.println(result);
    }


}
