package com.zidu.desktop.startup.Event;

public class MyTalkingEventListener implements TalkingCommonEventListener {

    @Override
    public void talkingChangedEvent(TalkingEvent talkingEvent) {
        System.out.println("listener detects " + talkingEvent);
    }
}
