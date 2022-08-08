package level1;

import java.util.Arrays;
import java.util.stream.IntStream;
/*
 *
 * [프로그래머스]정렬
 * */
public class Sort {
    public int[] solution(int[] array, int[][] commands) {

        int[] answer = new int[commands.length];
        for(int i=0;i<commands.length;i++){
            int start = commands[i][0] -1;
            int end = commands[i][1] ;
            int postion = commands[i][2] -1;
            int[] newArray =  Arrays.copyOfRange(array, start, end);
            Arrays.sort(newArray);
            Arrays.stream(newArray).forEach(System.out::println);
            answer[i] = newArray[postion];
        }
        return answer;
    }

    public static void main(String[] args) {
        Sort sort = new Sort();
        int[] array ={1, 5, 2, 6, 3, 7, 4};
        int[][] commands ={{2, 5, 3}};
        sort.solution(array,commands);
    }
}
