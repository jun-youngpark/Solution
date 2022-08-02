package level1;

import java.util.Arrays;

public class PressKeyPad {


    private int[] leftButton={1,4,7};
    private int[] rightButton={3,6,9};
    public String solution(int[] numbers, String hand) {
        StringBuilder sb =new StringBuilder();
        int currentLeftFinger = 10;
        int currentRightFinger = 12;

        for (int i = 0; i<numbers.length; i++){
            int tmp = numbers[i];
            int finalTmp = tmp;

            if(Arrays.stream(leftButton)
                    .anyMatch(value -> value == finalTmp)){
                sb.append("L");
                currentLeftFinger = numbers[i];
            }else {
                if(Arrays.stream(rightButton)
                        .anyMatch(value -> value == finalTmp)){
                    sb.append("R");
                    currentRightFinger = numbers[i];
                }else{
                    if(tmp==0){
                        tmp=11;
                    }
                    int leftdist = Math.abs(tmp-currentLeftFinger)/3+Math.abs(tmp-currentLeftFinger)%3;
                    int rightdist = Math.abs(tmp-currentRightFinger)/3+Math.abs(tmp-currentRightFinger)%3;

                    if(leftdist<rightdist){
                        sb.append("L");
                        currentLeftFinger = tmp;
                    }else if(leftdist>rightdist){
                        sb.append("R");
                        currentRightFinger = tmp;
                    }else{
                        if(hand.equals("left")){
                            sb.append("L");
                            currentLeftFinger = tmp;
                        }else{
                            sb.append("R");
                            currentRightFinger = tmp;
                        }
                    }
                }
            }

        }
        String answer =sb.toString();
        return answer;
    }

    public static void main(String[] args) {
        PressKeyPad id =new PressKeyPad();
        int[] numbers={1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand ="right";
        System.out.println(id.solution(numbers,hand));
    }

}
