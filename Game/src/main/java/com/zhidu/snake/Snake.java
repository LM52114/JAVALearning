package com.zhidu.snake;

import javax.swing.*;

/**
 * @Author Li Hao
 * @Date 2021/2/20 17:45
 * @Version 1.0
 */
public class Snake {
    public static void main(String[] args) {
        JFrame frame=new JFrame();
        frame.setBounds(400,200,900,720);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SnakePanel snakePanel=new SnakePanel();
        frame.add(snakePanel);
        frame.setVisible(true);
    }
}
