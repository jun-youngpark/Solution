package level1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

public class Hash2 {
    //System.out.println(hashMap.size());

    /*

    return Arrays.stream(nums)
                .boxed()
                .collect(Collectors.collectingAndThen(Collectors.toSet(),
                        phonekemons -> Integer.min(phonekemons.size(), nums.length / 2)));

     */
    public int solution(int[] nums) {

        int canTakeCount = Math.abs(nums.length/2);
        Map<Integer, Integer> hashMap
                = new HashMap<Integer, Integer>();
        for(int i=0; i<nums.length; i++){
            hashMap.put(nums[i],1);
        }
        int answer = hashMap.size()>canTakeCount?canTakeCount:hashMap.size();
        return answer;
    }

    public static void main(String[] args) {
        Hash2 hash = new Hash2();
        int[] nums = {3,3,3,2,2,4};
        System.out.println(hash.solution(nums));

    }

}
