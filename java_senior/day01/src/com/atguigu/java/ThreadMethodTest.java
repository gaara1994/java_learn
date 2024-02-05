package com.atguigu.java;
/**
 * ����Thread�еĳ��÷�����
 * 1. start():������ǰ�̣߳����õ�ǰ�̵߳�run()
 * 2. run(): ͨ����Ҫ��дThread���еĴ˷��������������߳�Ҫִ�еĲ��������ڴ˷�����
 * 3. currentThread():��̬����������ִ�е�ǰ������߳�
 * 4. getName():��ȡ��ǰ�̵߳�����
 * 5. setName():���õ�ǰ�̵߳�����
 * 6. yield():�ͷŵ�ǰcpu��ִ��Ȩ
 * 7. join():���߳�a�е����߳�b��join(),��ʱ�߳�a�ͽ�������״̬��ֱ���߳�b��ȫִ�����Ժ��߳�a��
 *           ��������״̬��
 * 8. stop():�ѹ�ʱ����ִ�д˷���ʱ��ǿ�ƽ�����ǰ�̡߳�
 * 9. sleep(long millitime):�õ�ǰ�̡߳�˯�ߡ�ָ����millitime���롣��ָ����millitime����ʱ���ڣ���ǰ
 *                          �߳�������״̬��
 * 10. isAlive():�жϵ�ǰ�߳��Ƿ���
 *
 *
 * �̵߳����ȼ���
 * 1.
 * MAX_PRIORITY��10
 * MIN _PRIORITY��1
 * NORM_PRIORITY��5  -->Ĭ�����ȼ�
 * 2.��λ�ȡ�����õ�ǰ�̵߳����ȼ���
 *   getPriority():��ȡ�̵߳����ȼ�
 *   setPriority(int p):�����̵߳����ȼ�
 *
 *   ˵���������ȼ����߳�Ҫ��ռ�����ȼ��߳�cpu��ִ��Ȩ������ֻ�ǴӸ����Ͻ��������ȼ����̸߳߸��ʵ������
 *   ��ִ�С�������ζ��ֻ�е������ȼ����߳�ִ�����Ժ󣬵����ȼ����̲߳�ִ�С�
 *
 *
 * @author shkstart
 * @create 2019-02-13 ���� 2:26
 */
public class ThreadMethodTest {
    public static void main(String[] args) {
        HelloThread h1 = new HelloThread();
        h1.start();
        System.out.println(h1.isAlive());
        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName() + "-" + i);
            //��i��20�ı���ʱ�������߳�һ
            if (i == 20){
                try {
                    h1.join();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println(h1.isAlive());
    }


}

class HelloThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "-" + i);
            Thread.currentThread().setName("�߳�һ");
            System.out.println(Thread.currentThread().getName() + "-" + i);

            //��20�ı���ʱ���ó��߳�
            if (i % 20 == 0){
                System.out.println("�ó�cpuִ��Ȩ�߳�");
                yield();
            }

            //slepp����1��
//            try {
//                sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

        }

    }
}
