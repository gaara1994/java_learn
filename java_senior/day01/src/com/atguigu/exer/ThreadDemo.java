package com.atguigu.exer;

/**
 * ��ϰ�������������̣߳�����һ���̱߳���100���ڵ�ż������һ���̱߳���1000���ڵ�����
 * 1.����һ���̳���Thread�������
 * 2.��дThread��run����
 * 3.����Thread�������
 * 4.ͨ���������start����
 */
public class ThreadDemo {
    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1();
        MyThread2 myThread2 = new MyThread2();

        myThread1.start();
        myThread1.setName("�߳�1");

        myThread2.start();
        myThread2.setName("�߳�2");

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
