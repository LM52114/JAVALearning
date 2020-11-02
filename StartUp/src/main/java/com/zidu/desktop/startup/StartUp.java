package com.zidu.desktop.startup;

import com.zidu.desktop.core.Dialogs.DialogSymbol;
import com.zidu.desktop.core.Tools.CoreProperties;
import com.zidu.desktop.core.UI.MainFrom;

import javax.swing.*;
import java.awt.*;

public class StartUp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
//                闪屏先关闭，调试有bug
//                init();
                MainFrom mainFrom=new MainFrom();
                mainFrom.setVisible(true);
                DialogSymbol dialogSymbol=new DialogSymbol();
                dialogSymbol.setVisible(true);
            }
        });

    }
//    private static void init(){
//        SplashScreen splashScreen=SplashScreen.getSplashScreen();
//        if(splashScreen==null){
//            System.out.println("没有指定闪屏图片");
//        }
//        Graphics2D g2 = splashScreen.createGraphics();//绘制闪屏
//        Rectangle bounds = splashScreen.getBounds();//返回闪屏边界
//
//        splashScreen.update();
//        Toolkit toolkit=Toolkit.getDefaultToolkit();
//        final Image image=toolkit.getImage(splashScreen.getImageURL());
//        final JFrame splashFrame=new JFrame();
//        //去掉外边框
//        splashFrame.setUndecorated(true);
//        final JPanel splashPanel=new JPanel(){
//            private static final long serialVersionUID = 6966819038480336218L;
//            @Override
//            protected void paintChildren(Graphics g) {
//                g.drawImage(image,0,0,null);
//            }
//        };
//        final JProgressBar progressBar=new JProgressBar();
//        progressBar.setStringPainted(true);//在进度条上可以显示文本
//        splashPanel.setLayout(new BorderLayout());
//        splashPanel.add(progressBar,BorderLayout.SOUTH);
//        splashFrame.add(splashPanel);
//
//        Dimension splashSize=new Dimension(splashScreen.getSize().width,splashScreen.getSize().height+20);
//        splashFrame.setSize(splashSize);
//
//        Dimension screenSize=toolkit.getScreenSize();
//        splashFrame.setLocation((int) (screenSize.getWidth()-splashSize.getWidth())/2,(int) (screenSize.getHeight()-splashSize.getHeight())/2);
//
//        splashFrame.setVisible(true);
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i <100 ; i++) {
//                    progressBar.setString(CoreProperties.getString("String_ProgressBarMessage")+i+"%");
//                    progressBar.setValue(i);
//                    splashPanel.repaint();
//                    try{
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//                splashFrame.setVisible(false);
//            }
//        }).start();
//    }

}
