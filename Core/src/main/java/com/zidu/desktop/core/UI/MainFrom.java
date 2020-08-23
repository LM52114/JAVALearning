package com.zidu.desktop.core.UI;

import com.zidu.desktop.core.Tools.CoreProperties;
import com.zidu.desktop.core.Tools.GridBagLayoutHelper;

import javax.swing.*;
import java.awt.*;

public class MainFrom extends JFrame {

    private PanelMainFormOutput panelMainFormOutput;
    private PanelMainFormProperties panelMainFormProperties;
    private PanelMainFormShow panelMainFormShow;
    private PanelMainFormTree panelMainFormTree;
    private MainFromMenuBar mainFromMenuBar;


    public MainFrom() throws HeadlessException {
        initParameter();
        initLayout();
    }

    private void initLayout() {
        this.setSize(800,600);
        JPanel panelMain=new JPanel();
        panelMain.setLayout(new GridBagLayout());
        panelMain.add(mainFromMenuBar,new GridBagLayoutHelper(0,0,8,1).setAnchor(GridBagConstraints.NORTHWEST).setFill(GridBagConstraints.BOTH).setWeight(1,0));

        panelMain.add(panelMainFormTree,new GridBagLayoutHelper(0,1,1,2).setAnchor(GridBagConstraints.WEST).setFill(GridBagConstraints.BOTH).setWeight(1,1));
        panelMain.add(panelMainFormShow,new GridBagLayoutHelper(1,1,7,1).setAnchor(GridBagConstraints.EAST).setFill(GridBagConstraints.BOTH).setWeight(1,1));
        panelMain.add(panelMainFormProperties,new GridBagLayoutHelper(1,2,7,1).setAnchor(GridBagConstraints.EAST).setFill(GridBagConstraints.BOTH).setWeight(1,1));
        panelMain.add(panelMainFormOutput,new GridBagLayoutHelper(0,3,8,1).setAnchor(GridBagConstraints.SOUTH).setFill(GridBagConstraints.BOTH).setWeight(1,1));
        this.getContentPane().add(panelMain);
    }

    private void initParameter() {
        this.setTitle(CoreProperties.getString("String_MyApplication"));
        panelMainFormOutput=new PanelMainFormOutput();
        panelMainFormProperties=new PanelMainFormProperties();
        panelMainFormShow=new PanelMainFormShow();
        panelMainFormTree=new PanelMainFormTree();
        mainFromMenuBar=new MainFromMenuBar();

    }

}
