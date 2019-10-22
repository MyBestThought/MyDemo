/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class InsertSortList {
    public ListNode insertionSortList(ListNode head) {
        ListNode newHead = new ListNode(0);
        ListNode cur = null;
        newHead.next = head;
        while(head != null && head.next != null){
            if(head.val < head.next.val){
                head = head.next;
                continue;
            }
            cur = newHead;
            while(cur.next.val < head.next.val){
                cur = cur.next;
            }
            ListNode temp = head.next;
            head.next = temp.next;
            temp.next = cur.next;
            cur.next = temp;
        }
        return newHead.next;
    }
}