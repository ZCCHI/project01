package com.thead2;

/**
 * @author zhangchi
 * @create 2019-12-07
 */
public class Famer implements Runnable {

    @Override
    public void run() {

        while(true){

            synchronized (Kuang.kuang){

                if(Kuang.kuang.size() == 10){
                    try {
                        Kuang.kuang.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                    Kuang.kuang.add("app");
                    System.out.println("农夫向框中添加一个苹果 当前框中有"+Kuang.kuang.size() + "个");
                    Kuang.kuang.notify();//通知小孩吃苹果
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }



        }



    }
}
