package com.atguigu.java;
/**
 *
 * 例子：创建三个窗口卖票，总票数为100张.使用继承Thread类的方式
 *
 * 存在线程的安全问题，待解决。
 *
 * @author shkstart
 * @create 2019-02-13 下午 4:20
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
                System.out.println(getName() + "：卖票，票号为：" + ticket);
                ticket--;
                
            }else {
                break;
            }
        }

    }
}
