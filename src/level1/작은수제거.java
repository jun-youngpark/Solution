package level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.OptionalInt;

public class 작은수제거 {

    public static void main(String[] args) {
        작은수제거 main = new 작은수제거();
        int[] arr={4,3,2,1};
        int[] result = main.solution(arr);
        Arrays.stream(result).forEach(System.out::println);

    }

    public int[] solution(int[] arr) {
        //if (arr.length <= 1) return new int[]{ -1 };
        //  int min = Arrays.stream(arr).min().getAsInt();
       // return Arrays.stream(arr).filter(i -> i != min).toArray();
        if (arr.length <= 1) return new int[]{ -1 };
        int[] answer = {};
        ArrayList<Integer> list = new ArrayList<Integer>();
        OptionalInt min = Arrays.stream(arr).min();
        if(min.isPresent()){
            for(int i=0;i<arr.length;i++){
                if(min.getAsInt() == arr[i]) {
                    arr[i] = -1;
                }else{
                    list.add(arr[i]);
                }
            }
        }
        answer = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }
        return answer;
    }

}
