package level1;

import java.util.ArrayList;
import java.util.Stack;

public class TakeAwayDoll {

    public int solution(int[][] board, int[] moves) {


        ArrayList<Stack<Integer>> basket = new ArrayList<Stack<Integer>>();
        for (int i = 0; i < board.length; i++) {
            Stack<Integer> stacks = new Stack<Integer>();
            for (int j = 0; j < board[i].length; j++) {
                stacks.push(board[i][j]);
            }
            basket.add(stacks);
        }
        int answer = 0;
        Stack<Integer> bag = new Stack<Integer>();
        bag.push(0);
       for(int i=0;i<moves.length;i++){
           if(basket.get(moves[i]-1).isEmpty()) continue;

           Integer currentDoll = basket.get(moves[i]-1).pop();

           if(currentDoll == 0) continue;

           if(bag.peek() == currentDoll) {
               answer+=2;
               bag.pop();
           }else {
               bag.push(currentDoll);
           }
       }

        return answer;
    }

    public static void main(String[] args) {

       int[][] board = {{0, 0, 1, 0, 0}, {0, 0, 1, 0, 0}, {0, 2, 1, 0, 0}, {0, 2, 1, 0, 0}, {0, 2, 1, 0, 0}};


       //int[][]  board = {{3,3,3,3,3},{3,3,3,3,3},{3,3,3,3,3},{3,3,3,3,3},{3,3,3,3,3}};
       int[] moves = {1, 1,1, 2, 2,2 , 1};
        //int[] moves = {1,5,3,5,1,2,1,4};
        TakeAwayDoll main = new TakeAwayDoll();
        System.out.println("result: "+main.solution(board,moves));
    }

}
