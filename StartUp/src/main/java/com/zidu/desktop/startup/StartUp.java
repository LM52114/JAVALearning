package com.zidu.desktop.startup;

import com.zidu.desktop.core.Dialogs.DialogSymbol;
import com.zidu.desktop.core.Tools.CoreProperties;
import com.zidu.desktop.core.UI.MainFrom;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class StartUp {
    public static void main(String[] args) {
            try {
                //(文件完整路径),编码格式
                BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\xianshi_1101_1105_0.csv"), "utf-8"));//GBK
//                 reader.readLine();//显示标题行,没有则注释掉
                String line = null;
                while((line=reader.readLine())!=null){
                    String item[] = line.split(",");//CSV格式文件时候的分割符,我使用的是,号
                    String last = item[item.length-1];//CSV中的数据,如果有标题就不用-1
                    System.out.println(last);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
























//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
////                闪屏先关闭，调试有bug
//                MainFrom mainFrom=new MainFrom();
//                mainFrom.setVisible(true);
//                DialogSymbol dialogSymbol=new DialogSymbol();
//                dialogSymbol.setVisible(true);
//            }
//        });

//    }

}
