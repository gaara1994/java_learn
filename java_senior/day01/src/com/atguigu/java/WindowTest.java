package com.atguigu.java;
/**
 *
 * ���ӣ���������������Ʊ����Ʊ��Ϊ100��.ʹ�ü̳�Thread��ķ�ʽ
 *
 * �����̵߳İ�ȫ���⣬�������
 *
 * @author shkstart
 * @create 2019-02-13 ���� 4:20
 */

public class WindowTest {
    public static void main(String[] args) {
        Window w1 = new Window();
        Window w2 = new Window();
        Window w3 = new Window();

        w1.start();
        w2.start();
        w3.start();
    }
}

class Window extends Thread{
    public static int ticket = 100;

    @Override
    public void run() {
        while (true){
            if (ticket > 0){
                System.out.println(getName() + "����Ʊ��Ʊ��Ϊ��" + ticket);
                ticket--;
                
            }else {
                break;
            }
        }

    }
}
