package leetcode;

/**
 * Author: Karanjot Singh
 * User:karanjotsingh
 * Date:2024-01-10
 * Time:20:24
 * Problem link: https://leetcode.com/problems/swap-nodes-in-pairs/
 */
public class SwapNodes {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode temp = head.next;
        head.next = temp.next;
        temp.next = head;
        head.next = swapPairs(head.next);
        return temp;
    }
}
