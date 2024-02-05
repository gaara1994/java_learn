package com.atguigu.java;

public class ThreadTest {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        myThread.start();
        /**
         * һ ���̶߳���ֻ�ܵ���һ�� start() ��������������ظ������ˣ����׳�����
         * ���쳣�� IllegalThreadStateException
         */

        //������һ���߳�
        MyThread myThread1 = new MyThread();
        myThread1.start();

        //������һ���߳�
        MyThread myThread2 = new MyThread();
        myThread2.start();


        //���²�����Ȼ����main�߳���ִ�еġ�
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
