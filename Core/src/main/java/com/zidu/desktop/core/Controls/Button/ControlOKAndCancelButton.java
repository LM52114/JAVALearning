package com.zidu.desktop.core.Controls.Button;

import com.zidu.desktop.core.Tools.GridBagLayoutHelper;

import javax.swing.*;
import java.awt.*;

public class ControlOKAndCancelButton extends JPanel {
    final JButton buttonOk = new JButton("确认");
    final JButton buttonCancel = new JButton("取消");

    public ControlOKAndCancelButton() {
        initLayout();
    }

    private void initLayout() {
        this.setLayout(new GridBagLayout());
        this.add(buttonOk, new GridBagLayoutHelper(0, 0, 1, 1).setInsets(10, 10, 10, 0));
        this.add(buttonCancel, new GridBagLayoutHelper(1, 0, 1, 1).setInsets(10, 5, 10, 0));
    }


}
