package com.zidu.desktop.startup.Event;

import java.util.EventObject;

public class TalkingEvent extends EventObject {
    private String words="";
    public TalkingEvent(Object o,String words) {
        super(o);
        this.words=words;
    }

    public String getWords() {
        return words;
    }

    public void setWords(String words) {
        this.words = words;
    }
}
