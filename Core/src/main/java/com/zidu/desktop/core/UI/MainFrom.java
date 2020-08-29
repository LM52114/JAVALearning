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
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initLayout() {
        this.setSize(800,600);
        JPanel panelMain=new JPanel();
        JSplitPane splitPane1=new JSplitPane();
        splitPane1.setOrientation(JSplitPane.VERTICAL_SPLIT);
        splitPane1.setOneTouchExpandable(true);
        splitPane1.setTopComponent(panelMainFormShow);
        splitPane1.setBottomComponent(panelMainFormProperties);

        JSplitPane splitPane2=new JSplitPane();
        splitPane2.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
        splitPane2.setOneTouchExpandable(true);
        splitPane2.setLeftComponent(panelMainFormTree);
        splitPane2.setBottomComponent(splitPane1);

        JSplitPane splitPane3=new JSplitPane();
        splitPane3.setOrientation(JSplitPane.VERTICAL_SPLIT);
        splitPane3.setOneTouchExpandable(true);
        splitPane3.setPreferredSize(new Dimension(800,600));
        splitPane3.setDividerLocation(100);
        splitPane3.setDividerSize(3);
        splitPane3.setTopComponent(splitPane2);
        splitPane3.setBottomComponent(panelMainFormOutput);




        panelMain.setLayout(new GridBagLayout());
        panelMain.add(mainFromMenuBar,new GridBagLayoutHelper(0,0,8,1).setAnchor(GridBagConstraints.NORTHWEST).setFill(GridBagConstraints.BOTH).setWeight(1,0));

        panelMain.add(panelMainFormTree,new GridBagLayoutHelper(0,1,1,2).setAnchor(GridBagConstraints.WEST).setFill(GridBagConstraints.BOTH).setWeight(1,1));
        panelMain.add(panelMainFormShow,new GridBagLayoutHelper(1,1,7,1).setAnchor(GridBagConstraints.EAST).setFill(GridBagConstraints.BOTH).setWeight(1,1));
        panelMain.add(panelMainFormProperties,new GridBagLayoutHelper(1,2,7,1).setAnchor(GridBagConstraints.EAST).setFill(GridBagConstraints.BOTH).setWeight(1,1));
        panelMain.add(panelMainFormOutput,new GridBagLayoutHelper(0,3,8,1).setAnchor(GridBagConstraints.SOUTH).setFill(GridBagConstraints.BOTH).setWeight(1,1));
        this.getContentPane().add(splitPane3);
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
