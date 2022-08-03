package level1;

import java.util.stream.IntStream;

public class DotProduct {

    public int solution(int[] a, int[] b) {
     /*
        int answer = 0;
        for(int i=0;i<a.length;i++){
            answer += a[i] * b[i];
        }
        return answer;
        */
        return IntStream.range(0, a.length).map(index -> a[index] * b[index]).sum();
    }

    public static void main(String[] args) {
        DotProduct main =new DotProduct();
        int[] a = {1,2,3,4};
        int[] b = {-3,-1,0,2};
        System.out.println(main.solution(a,b));
    }
}
