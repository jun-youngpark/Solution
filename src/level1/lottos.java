package level1;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.*;

public class lottos {

    //6개 =1등
    //5개 =2등
    //4개 =3등
    //3개 =4등
    //2개 =5등
    //1개or =6등
    private int getScore(int numOfMatch){
        switch (numOfMatch){
            case 6 : return 1;
            case 5 : return 2;
            case 4 : return 3;
            case 3 : return 4;
            case 2 : return 5;
            default: return 6;
        }
    }
    public int[] solution(int[] lottos, int[] win_nums) {

            int zeroCount = 0;
            int numOfMatch = 0;
            for (int lotto:lottos) {
                if(lotto == 0){
                    zeroCount++;
                }
            }

            for (int winsNumber:win_nums) {
                for (int lotto:lottos) {
                    if(lotto == winsNumber){
                        numOfMatch++;
                        continue;
                    }
                }
            }

        int[] answer = {getScore(numOfMatch+zeroCount),getScore(numOfMatch)};
        return answer;
    }


    public static void main(String[] args) {
        lottos lotto = new lottos();
        int[] lottos ={1,2,3,4,5,0};
        int[] win_nums = lotto.getLottosNumber(1 , 46);
        int[] myScore = lotto.solution(lottos,win_nums);
        System.out.println(myScore[0] + "," + myScore[1]);
        Arrays.stream(win_nums).forEach(x -> System.out.println("값:"+x) );

    }

    public int[] solutionByStream(int[] lottos, int[] winNums) {
        return LongStream.of(
                (lottos.length + 1) - Arrays.stream(lottos).filter(l -> Arrays.stream(winNums).anyMatch(w -> w == l) || l == 0).count()
                        ,(lottos.length + 1) - Arrays.stream(lottos).filter(l -> Arrays.stream(winNums).anyMatch(w -> w == l)).count()
                )
                .mapToInt(op -> (int) (op > 6 ? op - 1 : op))
                .toArray();
    }

    private int[] getLottosNumber(int min, int max){
        return new Random().ints(min, max)
                    .distinct()
                    .limit(6)
                    .sorted()
                    .toArray();
    }
}
