package com.tableH;

/**
 * 哈希表的简单实现
 *
 * 解决哈希冲突的办法：链地址法；线性探测法；再哈希法
 */
public class MyHashTable {

    private class Node{
        int val;
        Node next;

        public Node(){}

        public Node(int val){
            this.val = val;
        }
        public Node(int val, Node next){
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        MyHashTable myHashTable = new MyHashTable();
        int[] nums = new int[]{3,13,23,4,0,41,7,12,1};//1
        System.out.println("线性探测法：");
        myHashTable.linearProbing(nums);
        System.out.println();
        System.out.println("=====================");
        System.out.println("平方探测法：");
        System.out.println();
        System.out.println("=====================");
        myHashTable.squareProbing(nums);
        System.out.println("链地址法：");
        myHashTable.linkAddress(nums);
    }

    /**
     * 线性探测法
     * @param nums
     */
    public void linearProbing(int[] nums){
        int[] storeNum = new int[10];
        int count = 0;
        for (int i = 0; i < storeNum.length; i++) {
            storeNum[i] = -1;
        }
        for (int i = 0; i < nums.length; i++) {
            int index = perturbation1(nums[i]);
            if(storeNum[index] == -1){
                storeNum[index] = nums[i];
                count ++;
            }else{
                int temp = index;
                while(storeNum[temp] != -1){
                    if(temp == storeNum.length-1){
                        if(count == 10){
                            return;
                        }
                        temp = 0;
                    }
                    temp ++;
                }
                storeNum[temp] = nums[i];
                count ++;
            }
        }
        show(storeNum);
    }

    /**
     * 平方探测法
     * @param nums
     */
    //0	41	12	3	13	4	1	7	23	-1	-1	-1	-1	-1	-1	-1
    //0	1	-1	3	4	-1	-1	23	7	41	-1	-1	12	13	-1	-1
    public void squareProbing(int[] nums){
        int[] storeNum = new int[16];
        int count = 0;
        for (int i = 0; i < storeNum.length; i++) {
            storeNum[i] = -1;
        }
        for (int i = 0; i < nums.length; i++) {
            int index = perturbation2(nums[i]);
            int proNum = 0;
            if(storeNum[index] == -1){
                storeNum[index] = nums[i];
                count ++;
            }else{
                int temp = index;
                while(storeNum[temp] != -1){
                    proNum++;
                    if(temp == storeNum.length-1){
                        if(count == 10){
                            return;
                        }
                        temp = 0;
                    }
                    temp = (temp + proNum*proNum)%16;
                }
                storeNum[temp] = nums[i];
                count++;
            }
        }
        show(storeNum);
    }

    /**
     * 链地址法
     * @param nums
     */
    public void linkAddress(int[] nums){
        Node[] nodes = new Node[16];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node(i);
        }
        for (int i = 0; i < nums.length; i++) {
            int index = perturbation2(nums[i]);
            Node newNode = new Node(nums[i]);
            if(nodes[index].next == null){
                nodes[index].next = newNode;
            }else{
                newNode.next = nodes[index].next;
                nodes[index].next = newNode;
            }
        }
        for (int i = 0; i < nodes.length; i++) {
            if(nodes[i].next != null){
                for (Node node = nodes[i]; node != null; node = node.next) {
                    System.out.print(node.val + "\t");
                }
                System.out.println();
            }
        }
    }


    /**
     * 打印数组
     * @param nums
     */
    public void show(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + "\t");
        }
    }


    /**
     * 扰动函数
     * @param key
     * @return
     */
    public int perturbation1(int key){
        return key % 10;
    }
    public int perturbation2(int key){
        return  key % 16;
    }
}
