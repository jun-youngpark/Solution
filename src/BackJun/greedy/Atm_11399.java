package BackJun.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Atm_11399 {

    //요구사항1 시간이 적게 걸리는 순 정렬
    //요구사항2 합계 하기(이전사람+다음사람)
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int personCount = in.nextInt();
        int[] arr = new int[personCount];

        for(int i = 0; i < personCount; i++) {
            arr[i] = in.nextInt();
        }
        // 정렬
        Arrays.sort(arr);

        int sum=0;
        int current=0;
        for(int person:arr){
            current = current + person;
            sum += current;
        }
        System.out.println(sum);
    }
}
