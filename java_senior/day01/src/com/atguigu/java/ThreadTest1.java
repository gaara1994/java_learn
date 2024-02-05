package com.atguigu.java;

/**
 * �������̵߳ķ�ʽ����ʵ��Runnable�ӿ�
 * 1. ����һ��ʵ����Runnable�ӿڵ���
 * 2. ʵ����ȥʵ��Runnable�еĳ��󷽷���run()
 * 3. ����ʵ����Ķ���
 * 4. ���˶�����Ϊ�������ݵ�Thread��Ĺ������У�����Thread��Ķ���
 * 5. ͨ��Thread��Ķ������start()
 *
 *
 * �Ƚϴ����̵߳����ַ�ʽ��
 * �����У�����ѡ��ʵ��Runnable�ӿڵķ�ʽ
 * ԭ��1. ʵ�ֵķ�ʽû����ĵ��̳��Եľ�����
 *      2. ʵ�ֵķ�ʽ���ʺ����������߳��й������ݵ������
 *
 * ��ϵ��public class Thread implements Runnable
 * ��ͬ�㣺���ַ�ʽ����Ҫ��дrun(),���߳�Ҫִ�е��߼�������run()�С�
 */


//1. ����һ��ʵ����Runnable�ӿڵ���
class MThread implements Runnable{
    //2. ʵ����ȥʵ��Runnable�еĳ��󷽷���run()
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}


public class ThreadTest1 {
    public static void main(String[] args) {
        //3. ����ʵ����Ķ���
        MThread mThread = new MThread();
        //4. ���˶�����Ϊ�������ݵ�Thread��Ĺ������У�����Thread��Ķ���
        Thread t1 = new Thread(mThread);
        t1.start();

        //������һ���̣߳�����100���ڵ�ż��
        Thread t2 = new Thread(mThread);
        t2.setName("�߳�2");
        t2.start();
    }
}


