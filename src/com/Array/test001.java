package com.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangchi
 * @create 2019-05-19
 */
public class test001 {

    public static void main(String[] args) {

        List<String> list1 = new ArrayList<>();
        list1.add("222");

        JDKArrayList<String> list = new JDKArrayList<String>(3);

        list.add("bbb");

        list.add("ccc");
        list.add("333");
        list.add("444");
        list.add("ccc");
        list.add("bbb");
        list.add("ggggg");
    }


}
