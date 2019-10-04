package com.listtable;

public class MyLinkedList implements MyList {
    //创建头结点
    private Node head = new Node();
    //统计元素个数
    private int size;
    //结点类
    private class Node{

        Object val;
        Node next;
        public Node() {
        }

        public Node(Object object) {
            this.val = object;
        }

        public Node(Object object, Node next) {
            this.val = object;
            this.next = next;
        }
    }

    //添加元素
    @Override
    public void add(Object o) {
        add(size, o);
    }

    @Override
    public void add(int index, Object o) {
        if(index < 0 || index > size){
            try {
                throw new Exception("索引异常");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //遍历找到位置，进行插入
        Node temp = head;
        for(int i=0; i < index; i++){
            temp = temp.next;
        }
        Node newNode = new Node(o, null);
        newNode.next = temp.next;
        temp.next = newNode;
        size++;
    }

    //删除元素
    @Override
    public void remove() {
        remove(size);
    }

    @Override
    public void remove(int index) {
        Node temp = head;
        for (int i = 0; i < index-1; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        size--;
    }

    //修改元素值
    @Override
    public boolean set(int index, Object o) {
        Node temp = head;
        //向后遍历，找到需要修改的结点
        while(index-- > 0){
            temp = temp.next;
        }
        temp.val = o;
        return  true;
    }

    //获取元素值
    @Override
    public Object get(int index) {
        Node temp = head;
        while(index-- > 0){
            temp = temp.next;
        }
        return temp.val;
    }

    //判断链表是否为空
    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    //获取链表中元素个数
    @Override
    public int size() {
        return this.size;
    }

    //清空
    @Override
    public void clear() {
        head.next = null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if(size == 0){
            return "[]";
        }
        sb.append("[");
        for(Node node = head.next; node!= null; node = node.next){
            if(node.next == null){
                sb.append(node.val + "]");
            }else{
                sb.append(node.val + " ,");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(1);
        list.add(1);
        System.out.println(list);
        list.remove(2);
        System.out.println(list);
    }
}
