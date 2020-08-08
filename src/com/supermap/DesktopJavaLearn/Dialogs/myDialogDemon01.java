package com.supermap.DesktopJavaLearn.Dialogs;

import com.supermap.DesktopJavaLearn.Tools.GridBagLayoutHelper;

import javax.swing.*;
import java.awt.*;

public class MyDialogDemon01 extends JDialog {
    public MyDialogDemon01() {
        init();
    }

    private void init() {
        JPanel panel = new JPanel();
        this.setTitle("李梦是个莽子");
        this.add(panel);
        JLabel labelSex = new JLabel("性别：");
        JTextField textFieldSex = new JTextField("母猪");
        JLabel labelName = new JLabel("姓名：");
        JTextField textFieldName = new JTextField("莽子猪");


        panel.setLayout(new GridBagLayout());
        panel.add(labelSex, new GridBagLayoutHelper(0, 0, 1, 1).setInsets(10, 10, 0, 0)
                .setFill(GridBagConstraints.HORIZONTAL));
        panel.add(textFieldSex, new GridBagLayoutHelper(1, 0, 1, 1).setInsets(10, 5, 0, 10)
                .setFill(GridBagConstraints.HORIZONTAL).setWeight(1, 0));
        panel.add(labelName, new GridBagLayoutHelper(0, 1, 1, 1).setInsets(5, 10, 0, 0)
                .setFill(GridBagConstraints.HORIZONTAL));
        panel.add(textFieldName, new GridBagLayoutHelper(1, 1, 1, 1).setInsets(5, 5, 0, 10)
                .setFill(GridBagConstraints.HORIZONTAL).setWeight(1, 0));
        panel.add(new JPanel(), new GridBagLayoutHelper(0, 2, 1, 1).setWeight(1, 1));

        this.setSize(200, 160);
        this.setLocation(500, 300);
    }


}
