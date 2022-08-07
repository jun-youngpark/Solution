package level1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

// 2099. Find Subsequence of Length K With the Largest Sum
public class LeetCode2099 {


    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>
                (Comparator.comparingInt(i -> nums[i]));
        for (int i = 0; i < nums.length; ++i) {
            pq.offer(i);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.stream().sorted().mapToInt(i -> nums[i]).toArray();
    }

    public static void main(String[] args) {
        LeetCode2099 main =new LeetCode2099();
        int[] nums = {-1,-2,3,4};
        int k = 3;
        Arrays.stream(main.maxSubsequence(nums, k)).forEach(System.out::println);


    }
}
