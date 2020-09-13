package com.zidu.desktop.core.Controls.Panel;

import com.zidu.desktop.core.Tools.GridBagLayoutHelper;

import javax.swing.*;
import java.awt.*;

public class SymbolPanel extends JPanel {
    private JLabel name;
    private JLabel icon;

    public SymbolPanel() {
        initParameter();
        initLayout();
    }

    private void initLayout() {
        this.setLayout(new GridBagLayout());
        this.add(icon,new GridBagLayoutHelper(0,0,1,1).setFill(GridBagConstraints.BOTH));
        this.add(name,new GridBagLayoutHelper(0,1,1,1).setFill(GridBagConstraints.CENTER));
    }

    private void initParameter() {
        name=new JLabel("name");
        icon=new JLabel("This is an icon");
    }
    public void setSelect(){
        this.setBackground(Color.BLACK);
    }
    public void setUnSelect(){
        this.setBackground(null);
    }
}
