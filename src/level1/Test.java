package level1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test {

    static int[][] numpadPos = {
            {3,1}, //0
            {0,0}, //1
            {0,1}, //2
            {0,2}, //3
            {1,0}, //4
            {1,1}, //5
            {1,2}, //6
            {2,0}, //7
            {2,1}, //8
            {2,2}  //9
    };

    public static void main(String[] args) {
        int[] pos = {3,0};
        int num=1;
        System.out.println(pos[0]); //0
        System.out.println(numpadPos[num][0]);  //4

        int i = Math.abs(pos[0] - numpadPos[num][0]) + Math.abs(pos[1] - numpadPos[num][1]);
        System.out.println(i);
    }
}
