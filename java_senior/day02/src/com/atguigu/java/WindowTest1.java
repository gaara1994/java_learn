package com.atguigu.java;

/**
 * ���ӣ���������������Ʊ����Ʊ��Ϊ100��.ʹ��ʵ��Runnable�ӿڵķ�ʽ
 *
 * 1.���⣺��Ʊ�����У���������Ʊ����Ʊ -->�������̵߳İ�ȫ����
 * 2.������ֵ�ԭ�򣺵�ĳ���̲߳�����Ʊ�Ĺ����У���δ�������ʱ�������̲߳��������Ҳ������Ʊ��
 * 3.��ν������һ���߳�a�ڲ���ticket��ʱ�������̲߳��ܲ��������ֱ���߳�a������ticketʱ������
 *            �̲߳ſ��Կ�ʼ����ticket�����������ʹ�߳�a������������Ҳ���ܱ��ı䡣
 *
 *
 * 4.��Java�У�����ͨ��ͬ�����ƣ�������̵߳İ�ȫ���⡣
 *
 *  ��ʽһ��ͬ�������
 *
 *   synchronized(ͬ��������){
 *      //��Ҫ��ͬ���Ĵ���
 *
 *   }
 *  ˵����1.�����������ݵĴ��룬��Ϊ��Ҫ��ͬ���Ĵ��롣  -->���ܰ���������ˣ�Ҳ���ܰ����������ˡ�
 *       2.�������ݣ�����̹߳�ͬ�����ı��������磺ticket���ǹ������ݡ�
 *       3.ͬ�����������׳ƣ������κ�һ����Ķ��󣬶����Գ䵱����
 *          Ҫ�󣺶���̱߳���Ҫ����ͬһ������
 *
 *       ���䣺��ʵ��Runnable�ӿڴ������̵߳ķ�ʽ�У����ǿ��Կ���ʹ��this�䵱ͬ����������
 *  ��ʽ����ͬ��������
 *     ��������������ݵĴ���������������һ�������У����ǲ������˷�������ͬ���ġ�
 *
 *
 *  5.ͬ���ķ�ʽ��������̵߳İ�ȫ���⡣---�ô�
 *    ����ͬ������ʱ��ֻ����һ���̲߳��룬�����̵߳ȴ����൱����һ�����̵߳Ĺ��̣�Ч�ʵ͡� ---������
 *
 * @author shkstart
 * @create 2019-02-13 ���� 4:47
 */
class Window1 implements Runnable{

    private int ticket = 100;
    //    Object obj = new Object();
//    Dog dog = new Dog();
    @Override
    public void run() {
//        Object obj = new Object();
        while(true){
            synchronized (this){//��ʱ��this:Ψһ��Window1�Ķ���
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":��Ʊ��Ʊ��Ϊ��" + ticket);


                    ticket--;

                } else {
                    break;
                }
            }
        }
    }
}


public class WindowTest1 {
    public static void main(String[] args) {
        Window1 w = new Window1();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("����1");
        t2.setName("����2");
        t3.setName("����3");

        t1.start();
        t2.start();
        t3.start();
    }

}


class Dog{

}