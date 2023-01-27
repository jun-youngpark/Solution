package level2;

import java.util.PriorityQueue;
import java.util.Queue;

public class FunctionDevelopment {

    public static void main(String[] args) {
        FunctionDevelopment main = new FunctionDevelopment();
        int[]  progresses ={93,30,55};
        int[] speeds ={1,30,5};
        main.solution(progresses,speeds);
        // 7 4 9
    }

    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        int result=0;

        Queue<Integer> queue = new PriorityQueue();


        for(int i=0;i<progresses.length;i++){
            int count=0;
            result = progresses[i];
            while(result >=100){
                count++;
                result = result + speeds[i];
                break;
            }
            queue.add(count);
        }

        int tmp = 0;
        int value = 0;
        while(queue.isEmpty()){
             if(value <= queue.peek()){
                 tmp++;
             }
        }


        return answer;
    }


}
