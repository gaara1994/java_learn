package com.atguigu.java;

public class ThreadTest {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        myThread.start();
        /**
         * 一 个线程对象只能调用一次 start() 方法启动，如果重复调用了，则将抛出以上
         * 的异常“ IllegalThreadStateException
         */

        //再启动一个线程
        MyThread myThread1 = new MyThread();
        myThread1.start();

        //再启动一个线程
        MyThread myThread2 = new MyThread();
        myThread2.start();


        //如下操作仍然是在main线程中执行的。
        for (int i = 0; i < 1000; i++) {
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + i + "***********main()************");
            }
        }
    }
}

class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 500; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
}
