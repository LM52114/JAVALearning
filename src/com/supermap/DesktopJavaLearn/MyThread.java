package com.supermap.DesktopJavaLearn;

public class MyThread extends Thread {
    private String Name;

    public MyThread(String name) {
        Name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(Name + " " + i);
        }
    }
}
