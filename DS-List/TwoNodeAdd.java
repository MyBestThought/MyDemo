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
	public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode list1 = reverseList(l1);
        ListNode list2 = reverseList(l2);
        ListNode head = new ListNode(0);
        ListNode temp = head;
        int val = 0;
        while(list1 != null || list2 != null){
            if(list1 != null){
                val += list1.val;
                list1 = list1.next;
            }
            if(list2 != null){
                val += list2.val;
                list2 = list2.next;
            }
            ListNode node = new ListNode(val % 10);
            val /= 10;
            temp.next = node;
            temp = temp.next;
        }
        if(val != 0){
            ListNode node = new ListNode(val);
            temp.next = node;
            temp = temp.next;
        }
        return reverseList(head.next);
    }
    public ListNode reverseList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode slow = null, fast = null, mid = head;
        while(mid != null){
            fast = mid.next;
            mid.next = slow;
            slow = mid;
            mid = fast;
        }
        return slow;
    }
}