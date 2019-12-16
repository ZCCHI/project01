package com;

import java.util.HashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.DoubleAdder;
import java.util.concurrent.locks.Lock;

/**
 * @author zhangchi
 * @create 2019-04-10
 */
public class TestMap {

    public static void main(String[] args) {


        StringBuffer sb = new StringBuffer("hello ");

        updateString(sb);



        System.out.println(sb);



    }

    public static void updateString(StringBuffer sb2){

        sb2 = new StringBuffer("world");

        sb2.append("1");

    }

}
