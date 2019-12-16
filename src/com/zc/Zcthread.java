package com.zc;

/**
 * @author zhangchi
 * @create 2019-04-11
 */
public class Zcthread extends Thread{

    @Override
    public void run() {
        for(int i =1;i<100;i++){
            System.out.println("啦啦啦啦");
        }

    }
}
