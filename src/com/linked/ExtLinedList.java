package com.linked;

import com.Array.ExArrayList;

import java.util.LinkedList;

/**
 * @author zhangchi
 * @create 2019-05-22
 */
public class ExtLinedList<E> {

    private int size;

    private Node first;

    private Node last;

    //添加方法
    public void add(E e){
        Node node = new Node();
        node.object = e;
        if(first == null){ //添加的第一个元素
            first = node;
            last = node;
        }else{ //添加第二个或者以上
            node.prev = last;
            last.next = node;
        }
        last = node;
        size ++;
    }
    //get方法
    public Object get(int index){
        checkElementIndex(index);//校验索引是否越界
        return getNode(index).object;
    }

    //remove
    public void remove(int index){
        checkElementIndex(index);

        Node node = getNode(index);//获取要删除元素

        //要删除元素的上一个节点
        Node oldPrevNode =  node.prev;
        //要删除元素的下一个节点
        Node oldNextNode = node.next;

        if(oldPrevNode == null){
            first = oldNextNode;//若删除的第一个元素
        }else {
            oldPrevNode.next = oldNextNode;
            node.prev = null;
        }
        if(oldNextNode == null){
            last = oldPrevNode; //若删除的最后一个元素
        }else {
            oldNextNode.prev = oldPrevNode;
            node.next = null;
        }
        node.object = null; //垃圾回收
        size --;
    }

    //根据下标获取node元素
    public Node getNode(int index){
        Node node = null;
        if(first != null){
            node = first;//默认取第一个节点
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        }
        return node;
    }

    public int getSize(){
        return size;
    }

    private void checkElementIndex(int index) {
        if (!isElementIndex(index))
            throw new IndexOutOfBoundsException("索引越界了");
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }


    private class Node{

        Object object;

        Node prev; //上一个节点

        Node next;//下一个节点

    }

    public static void main(String[] args) {

        ExtLinedList<String> extLinedList = new ExtLinedList<>();
        extLinedList.add("A");
        extLinedList.add("B");
        extLinedList.add("C");
        extLinedList.add("D");
        extLinedList.remove(3);
       /* System.out.println(extLinedList.first.object);
        System.out.println(extLinedList.first.next.object);
        System.out.println(extLinedList.first.next.next.object);*/
        for (int i = 0; i < extLinedList.getSize() ; i++) {

            System.out.println(extLinedList.get(i));
        }


        //LinkedList linkedList = new LinkedList();

        //linkedList.get(1);

    }

}
