package LeetCode;

import java.util.List;

/*leetCode 26
*
* */
public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode node = new ListNode(0);
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        while(list1  != null && list2 !=null){
            if(list1.val > list2.val){
                node.next = list2;
                list2 = list2.next;
            }else{
                node.next = list1;
                list1 = list1.next;
            }
        }

        return node;
    }
    private static ListNode go1;
    private static ListNode go2;

    public static void main(String[] args) {

    }

   public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
