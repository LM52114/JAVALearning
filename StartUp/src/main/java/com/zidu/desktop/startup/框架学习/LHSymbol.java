package com.zidu.desktop.startup.框架学习;

import javax.swing.*;

/**
 * @Author Li Hao
 * @Date 2020/10/25 14:16
 * @Version 1.0
 */
public class LHSymbol {
    private int ID;
    private SymbolType type;
    private String name;
    private Icon symbolIcon;

    public LHSymbol(int ID, SymbolType type, String name) {
        this.ID = ID;
        this.type = type;
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public SymbolType getType() {
        return type;
    }

    public void setType(SymbolType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Icon getSymbolIcon() {
        return symbolIcon;
    }

    public void setSymbolIcon(Icon symbolIcon) {
        this.symbolIcon = symbolIcon;
    }
}
