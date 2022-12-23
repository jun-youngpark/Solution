package level1;

import java.util.Stack;

public class StackTest {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<Character>();

        if(s.charAt(0) == ')')
            return false;

        for(int i=0; i<s.length(); i++){
            if(!stack.isEmpty() && s.charAt(i) == ')'){
                stack.pop();
            }
            else{
                stack.push(s.charAt(i));
            }
        }
        // 스택이 비어있으면 모든 괄호가 짝지어 졌으므로 true, 아닐경우 false
        answer = (stack.isEmpty()) ? true : false;
        return answer;
    }

    public static void main(String[] args) {
        StackTest main = new StackTest();
        main.solution("");
    }
}
