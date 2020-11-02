package com.zidu.desktop.startup.Event;

import java.util.EventListener;

public interface TalkingCommonEventListener extends EventListener {
    public void talkingChangedEvent(TalkingEvent talkingEvent);
}
