/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class TwoNodeAdd {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode temp = head;
        int sum = 0;
        while(l1 != null || l2 != null){
            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }
            ListNode node = new ListNode(sum%10);
            sum /= 10;
            temp.next = node;
            temp = temp.next;
        }
        if(sum != 0){
            ListNode node = new ListNode(sum);
            temp.next = node;
        }
        return head.next;
    }
}