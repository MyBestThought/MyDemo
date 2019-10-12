/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class SwapTwoNode {
    public ListNode swapPairs(ListNode head) {
        if(head ==null || head.next == null){
            return head;
        }
        ListNode slow = head.next;
        ListNode temp = slow.next;
        slow.next = head;
        head.next = swapPairs(temp);
        return slow;
    }
}