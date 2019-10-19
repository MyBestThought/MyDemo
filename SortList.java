/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class SortList {
    public ListNode sortList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        for(ListNode node = head; node != null; node = node.next){
            list.add(node.val);
        }
        Collections.sort(list);
        ListNode newHead = new ListNode(0);
        ListNode temp = newHead;
        for(int i=0; i < list.size(); i++){
            ListNode node = new ListNode(list.get(i));
            temp.next = node;
            temp = temp.next;
        }
        return newHead.next;
    }
}