package com.Array;

import java.util.Arrays;

/**
 * ArrayList的简单实现
 * @author zhangchi
 * @create 2019-05-02
 */
public class ExArrayList {

    //初始容量
    private static final int DEFAULT_CAPACITY = 10;
    //
    private static  Object[] elementData = {};

    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    private int size;
    //有参构造函数
    public ExArrayList(int initialCapacity){
        if (initialCapacity < 0) {
            this.elementData = new Object[initialCapacity];
            throw new IllegalArgumentException("Illegal Capacity: "+ "不合法！！！");
        }
        elementData = new Object[initialCapacity];
    }
    //无参构造
    public ExArrayList(){
        this(DEFAULT_CAPACITY);
    }

    //add方法
    public void add(Object object){

        ensureCapacityInternal(size + 1); //作用 1.判断用户是否给了给了初始容量，若无给默认初始容量10
                                                    //2.判断数组是否需要扩容
        //使用下标进行赋值
        elementData[size++] = object;
    }

    //判断用户是否没有初始化elementData数组
    private void ensureCapacityInternal(int minCapacity) {  //minCapacity 需要的最小容量

        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) { //判读用户是否初始化了elementData
            minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity); //若没有我们默认给它10个初始容量
        }

        ensureExplicitCapacity(minCapacity);//判读是否需要扩容
    }

    private void ensureExplicitCapacity(int minCapacity) {
      //  modCount++;
        // overflow-conscious code
        if (minCapacity - elementData.length > 0) //如果需要的最小容量大于数组本身的容量，肯定需要扩容了
            grow(minCapacity); //执行扩容方法
    }

    //数组的扩容
    private void grow(int minCapacity) {
        // overflow-conscious code
        int oldCapacity = elementData.length;//取出数组里面能存放数组的长度
        int newCapacity = oldCapacity + (oldCapacity >> 1); //把 oldCapacity扩容1.5倍
        if (newCapacity - minCapacity < 0) //比较扩容的容量和实际需要的容量
            newCapacity = minCapacity; //若扩容后的容量还小于实际需要的容量 则把实际需要的容量复制给扩容后的容量
        if (newCapacity - MAX_ARRAY_SIZE > 0) //防止扩容的大小超过Integer的最大值
        //    newCapacity = hugeCapacity(minCapacity);
        // minCapacity is usually close to size, so this is a win:
        elementData = Arrays.copyOf(elementData, newCapacity);  //数组的扩容
    }

    //get方法
    public Object get(int index){
        rangeCheck(index);
        return elementData[index];
    }

    public void add(int index,Object object){
        rangeCheck(index);

        ensureCapacityInternal(size + 1);//判读是否需要扩容

        System.arraycopy(elementData,index,elementData,index+1,size - index); //在插入指定index的后面的元素向后移动

        elementData[index] = object;

        size ++ ;
    }

    //通过下标删除元素
    public Object remove(int index){
        Object oldValue = this.get(index);//获取要删除的值
        int numMoved = size - index - 1; //获取要删除值后面的元素个数
        if (numMoved > 0) //若后面还有元素则数组进行向前移动 若numMoved=0 则表示它删除是数组中最后一个元素不需要数组的移动
            System.arraycopy(elementData, index+1, elementData, index,
                    numMoved);
        elementData[--size] = null; // clear to let GC do its work //将最后一个置空
        return oldValue;
    }

    //通过元素删除
    public boolean remove(Object value){
        if(value == null){
            for (int i = 0; i < size; i++) {
                if (elementData[i] == null) {
                    remove(i);
                    return true;
                }
            }
        }else {
            for (int i = 0; i < size; i++) {
                if(elementData[i].equals(value)){
                    remove(i);//删除
                    return true;
                }
            }
        }
        return false;
    }

    //判读数组是否越界
    private void rangeCheck(int index) {
        if (index >= size)
            throw new IndexOutOfBoundsException("越界啦！");
    }
}
