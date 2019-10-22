/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class IntersectList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode cur1 = headA, cur2 = headB;
        int len1 = 0, len2 = 0;
        while(cur1 != null){
            len1++;
            cur1 = cur1.next;
        }
        while(cur2 != null){
            len2 ++;
            cur2 = cur2.next;
        }
        cur1 = headA; cur2 = headB;
        int val = 0;
        if(len1 > len2){
            val = len1 - len2;
            while(val-- > 0){
                cur1 = cur1.next;
            }
        }
        if(len2 > len1){
            val = len2 - len1;
            while(val-- > 0){
                cur2 = cur2.next;
            }
        }
        while(cur1 != cur2){
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
        
    }
}