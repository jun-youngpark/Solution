package level1;

import java.util.*;

public class 올바른괄호 {

    public boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new PriorityQueue<>();
        char[] list = s.toCharArray();

        for(int i=0;i<list.length;i++) {
            queue.add(list[i]);
        }

        while(!queue.isEmpty()) {
            if(queue.peek() == ')') {
                queue.poll();
                if(stack.pop() != '('){
                    answer = false;
                }
            }else{
                stack.push(queue.poll());
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        올바른괄호 main = new 올바른괄호();
        String s = 	"(()("	;
        boolean a = main.solution(s);
        System.out.println("result : "+a);

    }
}
