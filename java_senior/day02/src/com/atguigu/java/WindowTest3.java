package com.atguigu.java;

/**
 * @author yantao
 * @create 2022-04-22 11:17
 */

class Window3 implements Runnable{
    private int ticket = 100;

    @Override
    public void run() {
        while (true){
            show();
        }

    }

    private synchronized void show(){
        if (ticket > 0){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + ":ÂôÆ±£¬Æ±ºÅÎª£º" + ticket);
            ticket--;
        }

    }
}
public class WindowTest3 {
    public static void main(String[] args) {
        Window3 w = new Window3();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.start();
        t2.start();
        t3.start();
    }

}
