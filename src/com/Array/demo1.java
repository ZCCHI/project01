package com.Array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 数组扩容技术
 * @author zhangchi
 * @create 2019-05-02
 */
public class demo1 {

    public static void main(String[] args) {

        //1.数组的扩容技术
        Object[] objects = {1,2};
        Object[] newObjects = Arrays.copyOf(objects, 10); //将原来的集合扩充为10

        //2.数组的扩容技术
        int[] fun = {0,1,2,3,4,5,6};
        //src原始数组 起始位置   dest目标数组 目标起始位置 复制长度
        System.arraycopy(fun,3,fun,0,4);
        System.out.println(fun);

        /**
         * jdk1.7之后 数组默认大小在add方法中初始化的(jdk1.6默认大小在构造方法初始化的是否创建 elementDate[])
         * ArraryList 底层采用的数组实现的 数组名为elementDate 初始容量为10
         */
       /* ArrayList<String> list = new ArrayList<String>(1);
        list.add("zhangsan");*/

        ExArrayList li = new ExArrayList(1);
        li.add("zhangs");
        li.add("lisi");
        li.add("wangwu");
        System.out.println(li.get(2));

    }

}
