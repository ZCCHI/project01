package com.thead2;

/**
 * @author zhangchi
 * @create 2019-12-07
 */
public class Child implements Runnable {

    @Override
    public void run() {

        while(true){

            synchronized (Kuang.kuang){

                if(Kuang.kuang.size() == 0){
                    try {
                        Kuang.kuang.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Kuang.kuang.remove("app");
                System.out.println("小孩吃掉一个苹果当前框中剩余"+ Kuang.kuang.size() + "个");
                Kuang.kuang.notify();
            }

            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }

    }
}
