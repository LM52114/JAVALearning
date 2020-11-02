package com.zidu.desktop.core.Controls.Panel;

import com.zidu.desktop.core.Tools.GridBagLayoutHelper;

import javax.swing.*;
import java.awt.*;

public class SymbolPanel extends JPanel {
    private JLabel name;
    private String stringName="name";
    private JLabel icon;
    private String stringIcon="This is an icon";

    public SymbolPanel() {
        initParameter();
        initLayout();
    }

    public SymbolPanel(String stringName, String stringIcon) {
        this.stringName = stringName;
        this.stringIcon = stringIcon;
        initParameter();
        initLayout();
    }

    private void initLayout() {
        this.setLayout(new GridBagLayout());
        this.add(icon,new GridBagLayoutHelper(0,0,1,1).setFill(GridBagConstraints.BOTH));
        this.add(name,new GridBagLayoutHelper(0,1,1,1).setFill(GridBagConstraints.CENTER));
    }

    private void initParameter() {
        name=new JLabel(stringName);
        icon=new JLabel(stringIcon);
    }
    public void setSelect(){
        this.setBackground(Color.BLACK);
    }
    public void setUnSelect(){
        this.setBackground(null);
    }
}
