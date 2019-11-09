package com.interview1;

import java.util.Stack;

public class MaxStack {
    public static void main(String[] args){
        int[] nums = new int[]{3,2,6,1,0,7, 5};
        getMaxStack(nums);
    }
    //3 2 6 1 0 7 5
    //3 3 6 6 6 7 7
    public static void getMaxStack(int[] nums){
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> maxStack = new Stack<>();
        stack.push(nums[0]);
        maxStack.push(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            stack.push(nums[i]);
            int max = maxStack.peek();
            if(max < nums[i]){
                maxStack.push(nums[i]);
            }else{
                maxStack.push(max);
            }
        }
        while(!stack.isEmpty()){
            System.out.println(stack.pop() + "===" + maxStack.pop());
        }
    }
}
