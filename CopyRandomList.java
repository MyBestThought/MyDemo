/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class CopyRandomList {
    public Node copyRandomList(Node head) {
        if(head == null){
            return head;
        }
        // 空间复杂度O(1)，将克隆结点放在原结点后面
        Node node = head;
        // 1->2->3  ==>  1->1'->2->2'->3->3'
        while(node != null){
            Node clone = new Node(node.val,node.next,null);
            Node temp = node.next;
            node.next = clone;
            node = temp;
        }
        // 处理random指针
        node = head;
        while(node != null){
            // ！！
            node.next.random = node.random == null ? null : node.random.next;
            node = node.next.next;
        }
        // 还原原始链表，即分离原链表和克隆链表
        node = head;
        Node cloneHead = head.next;
        while(node.next != null){
            Node temp = node.next;
            node.next = node.next.next;
            node = temp;
        }
        return cloneHead;
    }
}