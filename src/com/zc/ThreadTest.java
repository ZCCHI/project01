package com.zc;

/**
 * @author zhangchi
 * @create 2019-04-07
 */
public class ThreadTest {

    public static void main(String[] args) {
        Thread thread = new Thread(new MyThread());
        thread.start();

        Thread thread1 = new Thread(new MyThread2());
        thread1.start();
    }
}
