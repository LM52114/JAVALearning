package com.zidu.desktop.core.Controls.Table.HSymbolTable;

import com.zidu.desktop.core.Tools.CoreProperties;

import javax.swing.*;
import java.awt.*;

public class SymbolInfo {

    private boolean isSelect;
    private int symbolId;
    private String symbolName;

    private Icon symbolIcon;
    private String group;

    public SymbolInfo(int symbolId, String symbolName) {
        this.symbolId = symbolId;
        this.symbolName = symbolName;
    }
    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }

    public Icon getSymbolIcon() {
        if(symbolIcon==null){
            return new Icon() {
                @Override
                public void paintIcon(Component c, Graphics g, int x, int y) {
                    g.fillOval(0,0,4,4);
                }

                @Override
                public int getIconWidth() {
                    return 4;
                }

                @Override
                public int getIconHeight() {
                    return 4;
                }
            };
        }
        return symbolIcon;
    }

    public void setSymbolIcon(Icon symbolIcon) {
        this.symbolIcon = symbolIcon;
    }

    public String getGroup() {
        if(group==null){
            return null;
        }
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
    public int getSymbolId() {
        return symbolId;
    }

    public String getSymbolName() {
        return symbolName;
    }
}
