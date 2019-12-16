package com.thread;

/**
 * @author zhangchi
 * @create 2019-12-07
 */
public class thread1 implements Runnable {


    @Override
    public void run() {

        for (int i = 0; i<10 ;i++){
            synchronized (MyLock.o){

                try {
                    System.out.println(1);
                    MyLock.o.notify();
                    MyLock.o.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }
    }
}
