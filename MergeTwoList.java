/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class MergeTwoList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode temp = head;
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        while(l1 != null && l2 != null){
            ListNode newNode = new ListNode(0);
            if(l1.val < l2.val){
                newNode.val = l1.val;
                l1 = l1.next;
            }else{
                newNode.val = l2.val;
                l2 = l2.next;
            }
            temp.next = newNode;
            temp = temp.next;
        }
        if(l1 == null){
            temp.next = l2;
        }
        if(l2 == null){
            temp.next = l1;
        }
        return head.next;
    }
}