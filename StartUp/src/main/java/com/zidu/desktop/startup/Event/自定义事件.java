package com.zidu.desktop.startup.Event;

import javax.swing.event.EventListenerList;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Java的事件机制/自定义事件.

 运行结果:
 do something interesting in source here.
 listener detects [event]:wintys.event.MyEvent[source=wintys.event.MySource@18158
 59] [occur at]:2012-10-11 16:27:49
 listener detects [event]:wintys.event.MyEvent[source=wintys.event.MySource@18158
 59] [occur at]:2012-10-11 16:27:49

 */
public class 自定义事件 implements MyListener{
    public static void main(String[] args){
        MySource source = new MySource();

        ActionListener al=new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                System.out.println("allllllllllllllll");
            }

        };

        自定义事件 mtn=new 自定义事件();
        source.addMyListener(mtn);
        source.addMyListener(al);
        source.doSomething();
    }

    @Override
    public void doMyAction(MyEvent e) {
        System.out.println("listener detects " + e);

    }
}

/**
 * 自定义的事件.
 */
class MyEvent extends java.util.EventObject{
    private Date date;//记录事件发生的时间

    public MyEvent(Object source , Date date){
        super(source);

        this.date = date;
    }

    public String toString(){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dt = df.format(date);

        return "[event]:" + super.toString() + " [occur at]:" + dt;
    }
}

/**
 * 自定义事件监听器接口.
 */
interface MyListener extends java.util.EventListener{
    void doMyAction(MyEvent e);
}

/**
 * 自定义事件源.
 */
class MySource{
    /**
     * 保存注册的监听器列表.
     * 子类可以使用它保存自己的事件监听器(非MyListener监听器)列表.
     */
    protected EventListenerList listenerList = new EventListenerList();
    private MyEvent myEvent = null;//fireDoMyAction()使用此变量

    /**
     * 没有做任何事
     */
    public MySource(){
    }
    /**
     * 添加一个MyListener监听器
     */
    public void addMyListener(MyListener listener){
        listenerList.add(MyListener.class , listener);
    }

    /**
     * 添加一个MyListener监听器
     */
    public void addMyListener(ActionListener al){
        listenerList.add(ActionListener.class , al);
    }

    /**
     * 移除一个已注册的MyListener监听器.
     * 如果监听器列表中已有相同的监听器listener1、listener2,
     * 并且listener1==listener2,
     * 那么只移除最近注册的一个监听器。
     */
    public void removeMyListener(MyListener listener){
        listenerList.remove(MyListener.class , listener);
    }

    /**
     * @return 在此对象上监听的所有MyListener类型的监听器
     */
    public MyListener[] getMyListeners(){
        return (MyListener[])listenerList.getListeners(MyListener.class);
    }


    protected void fireDoMyAction() {
        // getListenerList() Guaranteed to return a non-null array
        Object[] listeners = listenerList.getListenerList();
        // Process the listeners last to first, notifying
        // those that are interested in this event
        for (int i = listeners.length-2; i>=0; i-=2) {
            if (listeners[i]==MyListener.class) {
                // Lazily create the event:
                if (myEvent == null)
                    myEvent = new MyEvent(this , new Date());
                ((MyListener)listeners[i+1]).doMyAction(myEvent);
            }  else if(listeners[i]==ActionListener.class) {
                System.out.println("hahahahahaha");
            }
        }
    }

    /**
     * 做一些事件源应该做的有意义的事，然后通知监听器.
     * 这里只是一个示例方法.
     * 例如:MySource如果是一个按钮，则doSomething()就可以命名为click(),
     * 当用户点击按钮时调用click()方法.
     */
    public void doSomething() {
        System.out.println("do something interesting here.");

        fireDoMyAction();//通知监听器
    }
}
