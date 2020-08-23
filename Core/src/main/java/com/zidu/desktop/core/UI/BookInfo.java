package com.zidu.desktop.core.UI;

public class BookInfo {
    private String name;

    public String getName() {
        return name;
    }

    public String getDescribe() {
        return describe;
    }

    private String describe;

    public BookInfo(String name, String describe) {
        this.name = name;
        this.describe = describe;
    }
}
