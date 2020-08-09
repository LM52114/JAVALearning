package com.zidu.DesktopJavaLearn.Tools;

import java.util.ResourceBundle;

public class CoreProperties extends Properties {

    public static final String CORE = "Core";

    public static final String getString(String key) {
        return getString(CORE, key);
    }

    public static final String getString(String baseName, String key) {
        String result = "";

        ResourceBundle resourceBundle = ResourceBundle.getBundle(baseName, getLocale());
        if (resourceBundle != null) {
            try {
                result = resourceBundle.getString(key);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
