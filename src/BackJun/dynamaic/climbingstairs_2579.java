package BackJun.dynamaic;

import java.util.Scanner;

public class climbingstairs_2579 {

    //계단은 한 번에 한 계단씩 또는 두 계단씩 오를 수 있다. 즉, 한 계단을 밟으면서 이어서 다음 계단이나, 다음 다음 계단으로 오를 수 있다.
    //연속된 세 개의 계단을 모두 밟아서는 안 된다. 단, 시작점은 계단에 포함되지 않는다.
    //마지막 도착 계단은 반드시 밟아야 한다.

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int K = in.nextInt();


        int[] step = new int[K];
        for(int i = 0; i < K; i++) {
            step[i] = in.nextInt();
        }

        int currentStep =K;
        int sum = step[K-1];
        int duple = 0;
        int stepUpCnt = 0;

        for(int i=K-1;i<=K;i--){
            if(i==1){
                sum = sum + step[i-1];
                break;
            }
            int next = step[i-1];
            int twoNext = step[i-2];
            if(next > twoNext && duple < 3){
                sum = sum + next;
                duple++;
                currentStep = currentStep-1;
            }else{
                sum = sum + twoNext;
                duple = 0;  //중복 다시초기화
                currentStep = currentStep-2;
                i--;
            }
        }
        System.out.println(sum);
    }
}
