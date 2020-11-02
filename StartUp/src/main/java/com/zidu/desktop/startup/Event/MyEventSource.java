package com.zidu.desktop.startup.Event;

import javax.swing.event.EventListenerList;

public class MyEventSource {
    private EventListenerList eventListener=new EventListenerList();

    public MyEventSource() {
    }
    public void addMyListListener(TalkingCommonEventListener e){
        eventListener.add(TalkingCommonEventListener.class,e);
    }
    public void removeMyListListener(TalkingCommonEventListener e){
        eventListener.remove(TalkingCommonEventListener.class,e);
    }
    public TalkingCommonEventListener[] getMyListeners(){
        return (TalkingCommonEventListener[])eventListener.getListeners(TalkingCommonEventListener.class);
    }
}
