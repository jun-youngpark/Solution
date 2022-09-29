package LeetCode;

import java.util.Arrays;

public class SearchInsertPosition {

    // 요구사항 1 int 배열에서 target이 있으면 index 번호 호출
    // 요구사항 2 없으면 추가했을때 몇번인지
    //nums 1,3,5,6   target 5
    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] > target) high = mid-1;
            else low = mid+1;
        }
        return low;
        }



    public static void main(String[] args) {
        SearchInsertPosition searchInsertPosition = new SearchInsertPosition();
        int value = searchInsertPosition.searchInsert(new int[]{1,3,5,6},7);
        System.out.println(value);
    }
}
