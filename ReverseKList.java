/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class ReverseKList {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = new ListNode(0);
        cur.next = head;
        ListNode fast = cur, slow = cur;
        while(true){
            int count = 0;
            while(slow != null && count != k){
                count ++;
                slow =slow.next;
            }
            if(slow == null){
                break;
            }
            ListNode node = fast.next;
            while(fast.next != slow){
                ListNode temp = fast.next;
                fast.next = temp.next;
                temp.next = slow.next;
                slow.next = temp;
            }
            fast = node; slow = node;
        }
        return cur.next;
    }
}