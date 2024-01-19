package leetcode;

/**
 * Author: Karanjot Singh
 * User:karanjotsingh
 * Date:2024-01-19
 * Time:00:08
 */
public class PalindromeLinkedList {
    ListNode temp;
    public boolean isPalindrome(ListNode head) {
        temp = head;
        return test(head);
    }

    public boolean test(ListNode head) {
        if(head == null) return true;
        boolean ans = test(head.next);
        boolean check = temp.val == head.val;
        temp = temp.next;
        return ans && check;
    }
}
