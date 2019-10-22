package com.listtable;

import java.util.Arrays;

/**
 * 模拟实现ArrayList
 *
 */
public class MyArrayList implements MyList{
    //对象数组，ArrayList的底层实现是数组
    private Object[] elementData;
    //统计当前数组元素的个数
    private int size;
    //无参构造，默认初始化数组大小为0，当第一次添加元素的时候改变数组大小
    public MyArrayList() {
        this(0);
    }
    //有参构造，根据传入的参数指定数组的大小
    public MyArrayList(int initCapitity){
        elementData = new Object[initCapitity];
    }

    //添加元素
    @Override
    public void add(Object o) {
        //如果当前数组大小为0，默认初始化容量为10
        if(size == 0){
            elementData = new Object[10];
        }
        add(size,o);

    }
    //添加元素
    @Override
    public void add(int index, Object o) {
        //判断传入的位置是否合理
        if(index < 0 || index > elementData.length){
            try {
                throw  new Exception("索引异常");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //如果数组元素大小达到数组的容量，进行扩容
        if(size == elementData.length){
            ensureCapitity();
        }
        //移动元素
        for(int i=size; i > index; i--){
            elementData[i] = elementData[i-1];
        }
        //添加元素
        elementData[index] = o;
        size++;
    }

    //扩容，扩容机制：数组扩容为原数组大小的1.5倍
    private void ensureCapitity() {
        int len = elementData.length + (elementData.length >> 1);
        elementData = Arrays.copyOf(elementData, len);
    }

    //删除元素
    @Override
    public void remove() {
        remove(size);
    }

    //删除元素
    @Override
    public void remove(int index) {
        //判断传入的索引是否正确
        if(index < 0){
            try {
                throw new Exception("当前索引不存在");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //删除元素
        for(int i=index; i < size-1; i++){
            elementData[i] = elementData[i+1];
        }
        size--;
    }

    //修改指定位置的值
    @Override
    public boolean set(int index, Object o) {
        //判断传入的索引是否正确
        if(index < 0){
            try {
                throw new Exception("当前索引不存在");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        elementData[index] = o;
        return true;
    }
    //获取指定位置的值
    @Override
    public Object get(int index) {
        //判断传入的索引是否正确
        if(index < 0){
            try {
                throw new Exception("当前索引不存在");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return elementData[index];
    }

    //判断数组是否为空
    @Override
    public boolean isEmpty() {
        return size==0;
    }

    //返回数组元素个数
    @Override
    public int size() {
        return this.size;
    }

    //清空
    @Override
    public void clear() {
        elementData = null;
        size = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if(size == 0){
            return "[]";
        }
        sb.append("[");
        for(int i=0; i < size; i++){
            if(i == size-1){
                sb.append(elementData[i] + "]");
            }else{
                sb.append(elementData[i] + " ,");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(1);
        myArrayList.add(1);
        myArrayList.add(1);
        myArrayList.add(1);
        myArrayList.add(1);
        myArrayList.add(1);
        System.out.println(myArrayList);
        myArrayList.remove();
        System.out.println(myArrayList);
    }
}
