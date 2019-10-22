/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
//给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
//你应当保留两个分区中每个节点的初始相对位置。
//示例:
//输入: head = 1->4->3->2->5->2, x = 3
//输出: 1->2->2->4->3->5
class DividedList {
    public ListNode partition(ListNode head, int x) {
        ListNode head1 = new ListNode(0);
        ListNode head2 = new ListNode(0);
        ListNode cur1 = head1, cur2 = head2;
        for(ListNode node = head; node != null; node = node.next){
            ListNode newNode = new ListNode(node.val);
            if(node.val < x){
                cur1.next = newNode;
                cur1 = cur1.next;
            }else{
                cur2.next = newNode;
                cur2 = cur2.next;
            }
        }
        cur1.next = head2.next;
        return head1.next;
    }
}