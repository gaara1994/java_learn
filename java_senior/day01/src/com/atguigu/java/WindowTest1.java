package com.atguigu.java;

/**
 * ���ӣ���������������Ʊ����Ʊ��Ϊ100��.ʹ��ʵ��Runnable�ӿڵķ�ʽ
 * �����̵߳İ�ȫ���⣬�������
 */

class Window1 implements Runnable{

    private int ticket = 100;

    @Override
    public void run() {
        // TODO Auto-generated method stub
        while(true){
            if(ticket > 0){
                System.out.println(Thread.currentThread().getName() + ":��Ʊ��Ʊ��Ϊ��" + ticket);
                ticket--;
            }else{
                break;
            }
        }

        
    }
    
}
public class WindowTest1 {
    public static void main(String[] args) {
        Window1 w = new Window1();

        Thread t1 = new Thread(w);
        t1.setName("����1");

        Thread t2 = new Thread(w);
        t2.setName("����2");

        t1.start();
        t2.start();
    }
}




