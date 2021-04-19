package com.zhidu.snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @Author Li Hao
 * @Date 2021/2/20 20:54
 * @Version 1.0
 */
public class SnakePanel extends JPanel implements KeyListener, ActionListener {
    ImageIcon up = new ImageIcon("C:\\Users\\asus\\Desktop\\JAVALearning\\Game\\head.jpg");
    ImageIcon down = new ImageIcon("C:\\Users\\asus\\Desktop\\JAVALearning\\Game\\head.jpg");
    ImageIcon left = new ImageIcon("C:\\Users\\asus\\Desktop\\JAVALearning\\Game\\head.jpg");
    ImageIcon right = new ImageIcon("C:\\Users\\asus\\Desktop\\JAVALearning\\Game\\head.jpg");
    ImageIcon title = new ImageIcon("C:\\Users\\asus\\Desktop\\JAVALearning\\Game\\head.jpg");
    ImageIcon food = new ImageIcon("C:\\Users\\asus\\Desktop\\JAVALearning\\Game\\head.jpg");
    ImageIcon body = new ImageIcon("C:\\Users\\asus\\Desktop\\JAVALearning\\Game\\head.jpg");

    //蛇的数据结构
    int[] snakeX = new int[750];
    int[] snakeY = new int[750];
    int len = 3;
    Direction direction = Direction.RIGHT;
    boolean isStarted = false;
    Timer timer = new Timer(150, this);

    //初始化蛇
    private void initSnake() {
        len = 3;
        direction = Direction.RIGHT;
        snakeX[0] = 100;
        snakeY[0] = 100;
        snakeX[1] = 75;
        snakeY[1] = 100;
        snakeX[2] = 50;
        snakeY[2] = 100;
    }

    public SnakePanel() {
        this.setFocusable(true);
        initSnake();
        registrEvents();
        timer.start();
    }

    private void registrEvents() {
        this.addKeyListener(this);
    }

    @Override
    public void paint(Graphics graphics) {
        this.setBackground(Color.BLACK);
        graphics.fillRect(25, 75, 850, 600);
        title.paintIcon(this, graphics, 25, 11);

        //画蛇头
        if (direction == Direction.RIGHT) {
            right.paintIcon(this, graphics, snakeX[0], snakeY[0]);
        } else if (direction == Direction.LEFT) {
            left.paintIcon(this, graphics, snakeX[0], snakeY[0]);
        } else if (direction == Direction.UP) {
            up.paintIcon(this, graphics, snakeX[0], snakeY[0]);
        } else if (direction == Direction.DOWN) {
            down.paintIcon(this, graphics, snakeX[0], snakeY[0]);
        }
        //画蛇身
        for (int i = 0; i < len; i++) {
            body.paintIcon(this, graphics, snakeX[i], snakeY[i]);
        }
        //画提示语
        if (!isStarted) {
            graphics.setColor(Color.white);
            graphics.setFont(new Font("arial",Font.BOLD,30));
            graphics.drawString("Press Space to Start/Pause",300,300);
        }
    }

    public void keyTyped(KeyEvent keyEvent) {

    }

    public void keyPressed(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == KeyEvent.VK_SPACE) {
            isStarted = !isStarted;
            repaint();
        }
    }

    public void keyReleased(KeyEvent keyEvent) {

    }

    public void actionPerformed(ActionEvent actionEvent) {
        timer.start();
        for (int i = len; i > 0; i--) {
            snakeX[i] = snakeX[i - 1];
            snakeY[i] = snakeY[i - 1];
        }

        if (direction == Direction.RIGHT) {
            snakeX[0] = snakeX[0] + 25;
            if (snakeX[0] > 850) {
                snakeX[0] = 25;
            }
        } else if (direction == Direction.LEFT) {
            snakeX[0] = snakeX[0] - 25;
            if (snakeX[0] < 25) {
                snakeX[0] = 850;
            }
        } else if (direction == Direction.UP) {
            snakeY[0] = snakeY[0] - 25;
            if (snakeY[0] < 75) {
                snakeY[0] = 650;
            }
        } else if (direction == Direction.DOWN) {
            snakeY[0] = snakeY[0] + 25;
            if (snakeY[0] > 650) {
                snakeY[0] = 75;
            }
        }
    }
}
