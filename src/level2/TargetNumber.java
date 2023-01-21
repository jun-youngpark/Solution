package level2;

/*
* 프로그래머스 타겟넘버 문제
* DFS 문제
* 한쪽은 계속해서 더하기
* 한쪽은 계속해서 빼기
*
* */
public class TargetNumber {

    int answer = 0;
    public int solution(int[] numbers, int target) {

        dfs(numbers,target,0,0);
        System.out.println(answer);
        return answer;

    }

    public void dfs(int[] numbers,int target,int depth,int result){
        if(numbers.length == depth){
            if(result==target){
                answer++;
            }
            return;
        }
        int add = result + numbers[depth];
        int minus = result - numbers[depth];

        dfs(numbers,target,depth+1,add);
        dfs(numbers,target,depth+1,minus);

    }

    public static void main(String[] args) {
        TargetNumber tn = new TargetNumber();
        int[] numbers={1, 1, 1, 1, 1};
        int target=3;
        tn.solution(numbers,target);

    }
}

