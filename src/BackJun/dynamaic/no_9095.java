package BackJun.dynamaic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
* 정수 4를 1, 2, 3의 합으로 나타내는 방법은 총 7가지가 있다. 합을 나타낼 때는 수를 1개 이상 사용해야 한다.

1+1+1+1
1+1+2
1+2+1
2+1+1
2+2
1+3
3+1
정수 n이 주어졌을 때, n을 1, 2, 3의 합으로 나타내는 방법의 수를 구하는 프로그램을 작성하시오.
* */
public class no_9095 {

    public static void main(String[] args) {

       // 1로만 더하는방법 111 ,12,21
        // 1로만 더하다가 맨 마지막 2
        // 1로 더하고
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();
        int max = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            int input = s.nextInt();
            list.add(input);
            if (input > max)
                max = input;
        }
        int dp[] = new int[max + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= max; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        for (Integer integer : list) {
            System.out.println(dp[integer]);
        }
    }

}
