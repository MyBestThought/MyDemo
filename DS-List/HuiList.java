/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class HuiList {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head, mid = null;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        while(slow != null){
            ListNode temp = slow.next;
            slow.next = mid;
            mid = slow;
            slow = temp;
        }
        while(head != null && mid != null){
            if(head.val != mid.val){
                return false;
            }
            head = head.next;
            mid = mid.next;
        }
        return true;
    }
}