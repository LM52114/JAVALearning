package com.zidu.desktop.core.Controls.Table.HSymbolTable;

import com.zidu.desktop.core.Controls.Table.HTable;
import com.zidu.desktop.core.Tools.GridBagLayoutHelper;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.util.ArrayList;

public class HSymbolTable extends HTable {
    private HSymbolTableModel symbolTableModel;
    private ArrayList<SymbolInfo> symbolInfos;


    public void setSymbolInfos(ArrayList<SymbolInfo> symbolInfos) {
        symbolTableModel.setSymbolInfos(symbolInfos);
        ((HSymbolTableModel)this.getModel()).fireTableDataChanged();
    }

    public HSymbolTable(ArrayList<SymbolInfo> symbolInfos) {
        this.symbolInfos = symbolInfos;
        init();
    }

    private void init() {
        symbolTableModel=new HSymbolTableModel();
        symbolTableModel.setSymbolInfos(symbolInfos);
        this.setModel(symbolTableModel);
        this.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);



        this.getColumnModel().getColumn(0).setCellRenderer(new DefaultTableCellRenderer(){

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                JCheckBox checkBox=new JCheckBox();
                checkBox.setSelected(isSelected);
                return checkBox;
            }
        });
        this.getColumnModel().getColumn(2).setCellRenderer(new DefaultTableCellRenderer(){
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                JPanel panel=new JPanel();
                panel.setLayout(new GridBagLayout());
                JLabel labelIcon=new JLabel(symbolInfos.get(row).getSymbolIcon());
                panel.add(labelIcon,new GridBagLayoutHelper(0,0,1,1).setFill(GridBagConstraints.HORIZONTAL));
                JLabel label=new JLabel(value.toString());
                panel.add(label,new GridBagLayoutHelper(1,0,1,1).setFill(GridBagConstraints.HORIZONTAL));
                return panel;
            }
        });

    }

}
