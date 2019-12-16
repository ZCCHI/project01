package com.thead2;

/**
 * @author zhangchi
 * @create 2019-12-07
 */
public class Test {

    public static void main(String[] args) {

        new Thread(new Famer()).start();

        new Thread(new Child()).start();

    }

}
