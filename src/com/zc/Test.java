package com.zc;

/**
 * @author zhangchi
 * @create 2019-04-11
 */
public class Test {
    public static void main(String[] args) {


        Thread th1 = new Thread(new kjThre());
        Thread th2 = new Thread(new Zcthread());


       th1.start();
       th2.start();

    }
}
