package level2.sort;

import level2.stack_queue.Printer;

import java.util.*;

public class LargestNumber {

    public String solution(int[] numbers) {
        String[] nums = new String[numbers.length];

        for (int i=0; i<nums.length; i++)
            nums[i] = numbers[i] + "";

        Arrays.sort(nums, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });

        String ans = "";
        for (int i=0; i<numbers.length; i++)
            ans += nums[i];

        return ans.charAt(0) == '0' ? "0" : ans;
    }

    public static void main(String[] args) {
        int[] priorities = {2, 1, 3, 2};
        LargestNumber test =new LargestNumber();
        String result = test.solution(priorities);
        System.out.println(result);
    }
}
