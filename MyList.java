package com.listtable;

public interface MyList {
    //添加元素
    void add(Object o);
    //在指定位置添加元素
    void add(int index, Object o);
    //删除元素
    void remove();
    //删除指定位置的元素
    void remove(int index);
    //修改指定位置的值
    boolean set(int index, Object o);
    //获取指定位置的值
    Object get(int index);
    //判断是否为空
    boolean isEmpty();
    //获取当前集合大小
    int size();
    //清空
    void clear();

}
