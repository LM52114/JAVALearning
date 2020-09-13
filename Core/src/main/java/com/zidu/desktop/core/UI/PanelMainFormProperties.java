package com.zidu.desktop.core.UI;

import com.zidu.desktop.core.Controls.Table.HSymbolTable.HSymbolTable;
import com.zidu.desktop.core.Controls.Table.HSymbolTable.SymbolInfo;
import com.zidu.desktop.core.Tools.GridBagLayoutHelper;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelMainFormProperties extends JPanel {
    private JScrollPane scrollPane;
    private HSymbolTable table;
    public PanelMainFormProperties() {
        this.setPreferredSize(new Dimension(200,200));
        initParameter();
        initLayout();
    }

    private void initLayout() {
        this.setLayout(new GridBagLayout());
        this.add(scrollPane,new GridBagLayoutHelper(0,0,1,1).setFill(GridBagConstraints.BOTH).setWeight(1,1).setAnchor(GridBagConstraints.WEST));
//        this.add(new JPanel(),new GridBagLayoutHelper(0,1,1,1).setWeight(1,1));
    }

    private void initParameter() {
        this.setBorder(BorderFactory.createLineBorder(Color.red));
        ArrayList<SymbolInfo> symbolInfos=new ArrayList<SymbolInfo>();
        symbolInfos.add(new SymbolInfo(0,"Symbol1"));
        symbolInfos.add(new SymbolInfo(1,"Symbol2"));
        symbolInfos.add(new SymbolInfo(2,"Symbol2"));
        symbolInfos.add(new SymbolInfo(3,"Symbol3"));
        symbolInfos.add(new SymbolInfo(4,"Symbol4"));
        symbolInfos.add(new SymbolInfo(5,"Symbol5"));
        symbolInfos.add(new SymbolInfo(6,"Symbol6"));
        symbolInfos.add(new SymbolInfo(7,"Symbol7"));

        table = new HSymbolTable(symbolInfos);
        scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
    }
}
