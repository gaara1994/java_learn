package com.atguigu.exer;

/**
 * 练习：创建两个分线程，其中一个线程遍历100以内的偶数，另一个线程遍历1000以内的奇数
 * 1.创建一个继承于Thread类的子类
 * 2.重写Thread的run方法
 * 3.创建Thread的类对象
 * 4.通过对象调用start方法
 */
public class ThreadDemo {
    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1();
        MyThread2 myThread2 = new MyThread2();

        myThread1.start();
        myThread1.setName("线程1");

        myThread2.start();
        myThread2.setName("线程2");

    }
}

class MyThread1 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            if (i % 2 == 0){
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

class MyThread2 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            if (i % 2 != 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}
