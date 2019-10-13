/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 //删除链表中的重复元素
class DeleteNodes {
	//示例 1:
	//输入: 1->1->2
	//输出: 1->2
	//示例 2:
	//输入: 1->1->2->3->3
	//输出: 1->2->3
    public ListNode deleteDuplicates(ListNode head) {
        List<Integer> list = new ArrayList<>();
        if(head == null || head.next == null){
            return head;
        }
        ListNode newHead = new ListNode(0);
        ListNode temp = newHead;
        ListNode fast = head, slow = head;
        while(fast != null){
            while(fast != null &&fast.val == slow.val){
                fast = fast.next;
            }
            slow.next = fast;
            slow = slow.next;
        }
        return head;
    }
	//示例 1:
	//输入: 1->2->3->3->4->4->5
	//输出: 1->2->5
	//示例 2:
	//输入: 1->1->1->2->3
	//输出: 2->3
	public ListNode deleteDuplicatesNode(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        head = newHead;
        ListNode fast = null, slow = null;
        while(newHead.next != null){
            slow = newHead.next;
            fast = slow;
            while(fast.next != null && fast.next.val == slow.val){
                fast = fast.next;
            }
            if(fast == slow){
                newHead = newHead.next;
            }else{
                newHead.next = fast.next;
            }
        }
        return head.next;
    }
}