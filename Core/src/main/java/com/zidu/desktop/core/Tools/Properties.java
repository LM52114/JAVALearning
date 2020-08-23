package com.zidu.desktop.core.Tools;

import java.util.Locale;

public class Properties {
    private static Locale locale = Locale.getDefault();

    public static Locale getLocale() {
        return locale;
    }

    public static void setLocale(String language, String country) {
        locale = new Locale(language, country);
    }
}
