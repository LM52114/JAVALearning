package com.zidu.desktop.core.Controls.Table.HSymbolTable;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class HSymbolTableModel extends AbstractTableModel {
    private String[] columnName={"是否选择","ID","名称","所在分组"};

    public void setSymbolInfos(ArrayList<SymbolInfo> symbolInfos) {
        this.symbolInfos = symbolInfos;
    }

    private ArrayList<SymbolInfo> symbolInfos;
    @Override
    public int getRowCount() {
        if(symbolInfos==null){
            return 0;
        }
        return symbolInfos.size();
    }

    @Override
    public int getColumnCount() {
        return columnName.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0: return symbolInfos.get(rowIndex).isSelect();
            case 1: return symbolInfos.get(rowIndex).getSymbolId();
            case 2: return symbolInfos.get(rowIndex).getSymbolName();
            case 3: return symbolInfos.get(rowIndex).getGroup();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        switch (column){
            case 0:return columnName[0];
            case 1:return columnName[1];
            case 2:return columnName[2];
            case 3:return columnName[3];
        }
        return null;
    }


    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if(columnIndex==0){
            return Boolean.class;
        }else if(columnIndex==1){
            return Integer.class;
        }
        return String.class;
    }
}
