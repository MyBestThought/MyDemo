/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class RemoveNode {
    public ListNode removeZeroSumSublists(ListNode head) {
       //生成带头结点的链表
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode h = dummyHead;
        
        while(h.next != null){
            ListNode p = h.next;
            ListNode q = p;
            int sum = p.val;    //sum是p至q的总和
            while(q.next != null || sum == 0){   // 加个sum==0的条件，用来处理链表最后n个节点的和为0时的情形如：[1, 2, -2]
                if(sum == 0){   // 先判断sum的值再求和，可以不用对值为0的节点特殊处理
                    h.next = q.next;
                    break;
                }
                q = q.next;
                sum += q.val;
            }
            if(sum != 0) h = h.next;   // sum的值可以代替flag的作用
        }
        return dummyHead.next;
    }
}