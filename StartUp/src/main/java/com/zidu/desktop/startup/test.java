package com.zidu.desktop.startup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

//public class AppFrame extends JFrame implements ComponentListener {
//    private JButton[] jbt = new JButton[100];
//    private JPanel panel = new JPanel();
//    private JScrollPane scrollPane = new JScrollPane();
//    private int len = 150;
//    public AppFrame() {
//        Container containerPane = getContentPane();
//        containerPane.setLayout(new BoxLayout(containerPane, BoxLayout.Y_AXIS));
//        scrollPane = new JScrollPane();
//        scrollPane.setBounds(12, 10, 816, 433);
//        getContentPane().add(scrollPane);
//        scrollPane.setViewportView(panel);
//        for (int i = 0; i < jbt.length; i++) {
//            jbt[i] = new JButton("OK" + i);
//            jbt[i].setPreferredSize(new Dimension(len, len));
//            panel.add(jbt[i]);
//        }
//        containerPane.add(scrollPane);
//        setVisible(true);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        setSize(848, 480);
//        setLocationRelativeTo(null);
//        this.addComponentListener(this);
//    }
//    public static void main(String[] args) {
//        new AppFrame();
//    }
//    public void componentHidden(ComponentEvent arg0) {
//    }
//    public void componentMoved(ComponentEvent arg0) {
//    }
//    public void componentResized(ComponentEvent arg0) {
//// 竖滚动条的宽是20，减去以后，就没有横向滚动条了。
//        int width = scrollPane.getWidth() - 20;
//        int number = width / len;
//        int row = jbt.length / number + 1;
//        int height = len * row;
//        int intr = 0;
//        if (jbt.length % number != 0) {
//            intr = 100;
//        }
//        height += intr;
//        panel.setPreferredSize(new Dimension(width, height));
//        repaint();
//    }
//    public void componentShown(ComponentEvent arg0) {
//    }
//}
