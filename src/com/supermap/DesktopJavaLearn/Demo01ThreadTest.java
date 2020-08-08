package com.supermap.DesktopJavaLearn;

public class Demo01ThreadTest {
    public static void main(String[] args) {
        MyThread myThread1 = new MyThread("线程1");
        myThread1.start();
        MyThread myThread2 = new MyThread("线程2");
        myThread2.start();
    }

}
