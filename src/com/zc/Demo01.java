package com.zc;

/**
 * @author zhangchi
 * @create 2019-04-06
 */
public class Demo01 {
    public static void main(String[] args) {
        /**
         * 该类的作用是将数值等于-128-127(默认)区间的Integer实例缓存到cache数组中。
         * 通过valueOf()方法很明显发现，当再次创建值在-128到127区间的Integer实例时，
         * 会复用缓存中的实例，也就是直接指向缓存中的Integer实例
         * static final int low = -128;
         * static final int high;
         * static final Integer cache[];
         */
        Integer i = 129;  //
        Integer j = 129; Integer.valueOf(i);//自动装箱
        //Byte，Short，Integer，Long为 -128 到 127，Character范围为 0 到 127。

        System.out.println(i == j);//fasle

        //--------------------------------------------

        Integer x = new Integer(10);
        Integer y = new Integer(10);
        System.out.println(x == y); //false

    }


}
