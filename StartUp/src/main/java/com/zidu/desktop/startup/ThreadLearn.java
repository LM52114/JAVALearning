package com.zidu.desktop.startup;

import javax.swing.*;

public class ThreadLearn {
    public static void main(String[] args) {

        final Object object=new Object();
        new Thread(){
            @Override
            public void run() {
                synchronized (object){
                    System.out.println("顾客：老板，我要两个豆芽包！");
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("顾客：谢谢，老板，钱转给你了");
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                synchronized (object){
                    try {
                        System.out.println("老板：好的我给你拿！");
                        Thread.sleep(5000);
                        System.out.println("老板：包子给你");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    object.notify();

                }
            }
        }.start();
    }
}
