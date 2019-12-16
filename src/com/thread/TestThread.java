package com.thread;

/**
 * @author zhangchi
 * @create 2019-12-07
 */
public class TestThread {

    public static void main(String[] args) {

        new Thread(new thread1()).start();

        new Thread(new thread2()).start();


    }

}
