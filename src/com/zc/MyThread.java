package com.zc;

/**
 * @author zhangchi
 * @create 2019-04-07
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println("我被执行了");
    }
}
