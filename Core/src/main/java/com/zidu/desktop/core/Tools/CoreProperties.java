package com.zidu.desktop.core.Tools;

import java.util.ResourceBundle;

public class CoreProperties extends Properties {

    public static  String CORE = "Core";

    public static  String getString(String key) {
        return getString(CORE, key);
    }

    public static  String getString(String baseName, String key) {
        String result = "";

        ResourceBundle resourceBundle = ResourceBundle.getBundle(baseName, getLocale());
        if (resourceBundle != null) {
            try {
                result = new String(resourceBundle.getString(key).getBytes("ISO-8859-1"), "GBK");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
