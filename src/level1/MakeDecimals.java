package level1;


/*
문제 설명
        주어진 숫자 중 3개의 수를 더했을 때 소수가 되는 경우의 개수를 구하려고 합니다.
        숫자들이 들어있는 배열 nums가 매개변수로 주어질 때, nums에 있는 숫자들 중 서로 다른 3개를 골라 더했을 때
        소수가 되는 경우의 개수를 return 하도록 solution 함수를 완성해주세요.
        제한사항
        nums에 들어있는 숫자의 개수는 3개 이상 50개 이하입니다.
        nums의 각 원소는 1 이상 1,000 이하의 자연수이며, 중복된 숫자가 들어있지 않습니다.
*/

// (x * y * z % 2) == ㅈ
public class MakeDecimals {

    public int solution(int[] nums) {

        int answer=0;
        int sum;
        for (int i=0;i<nums.length;i++){
            for (int j=i+1;j<nums.length;j++) {
                for(int k=j+1;k<nums.length;k++){
                    //소수 판별 조건 2부터 자기자신의 제곱근까지 수중 나누어 딱 떨어지는값이 있으면 소수다.
                    sum = nums[i]+nums[j]+nums[k];
                    //소수 찾기(소수이면 +1)
                    answer += isPrime(sum) ? 1 : 0;
                }
            }
        }
        return answer;
    }
    private boolean isPrime(int num)
    {
        for (int i = 2; i <= Math.sqrt(num); i++)
        {
            // 나눠 떨어질 경우
            if (num % i == 0)
            {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        MakeDecimals makeDecimals =new MakeDecimals();
        System.out.println(makeDecimals.solution(new int[]{1,2,7,6,4}));

    }
}
