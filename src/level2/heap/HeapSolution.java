package level2.heap;

import level2.stack_queue.Printer;

import java.util.Collections;
import java.util.PriorityQueue;

public class HeapSolution {

    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < scoville.length; i++) {
            pq.add(scoville[i]);
        }

        while (!pq.isEmpty() && pq.size() > 1){
            answer++;
            int first = pq.poll();
            int two = pq.poll();
            int mix = first + (two * 2);
            pq.add(mix);
            if(pq.peek() >= K){
                return answer;
            }
        }

        return -1;
    }


    public static void main(String[] args) {
            int[] a = {1, 2, 3, 9, 10, 12};
            int b = 7;
            HeapSolution test =new HeapSolution();
            int result = test.solution(a,b);
            System.out.println(result);
    }
}
