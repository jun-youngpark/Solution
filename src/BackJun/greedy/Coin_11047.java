package BackJun.greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Coin_11047 {

    // 동전 개수 최소값 문제
    //ex: 4200 -> 1000 * 4 +
    public static void main(String[] args) {
        /*Scanner in = new Scanner(System.in);
        int personCount = in.nextInt();
        int[] array = new int[personCount];

        for(int i = 0; i < personCount; i++) {
            array[i] = in.nextInt();
        }*/
        int[] coin = new int[]{10,50,100,500,100,1000};
        int K = 4200;
        // 정렬
        Arrays.sort(coin);
        int count = 0;
        for(int i=coin.length -1 ;i>=0; i--){
            if(coin[i] <= K) {
                // 현재 가치의 동전으로 구성할 수 있는 개수를 더해준다.
                count += Math.abs(K / coin[i]);
                K = K % coin[i];
            }
        }
        System.out.println(count);

    }
}
