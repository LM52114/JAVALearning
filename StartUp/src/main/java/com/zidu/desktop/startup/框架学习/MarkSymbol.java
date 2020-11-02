package com.zidu.desktop.startup.框架学习;

/**
 * @Author Li Hao
 * @Date 2020/10/25 14:16
 * @Version 1.0
 */
public class MarkSymbol extends LHSymbol implements ISymbol  {

    public MarkSymbol(int ID, String name) {
        super(ID, SymbolType.MarkSymbol, name);
    }

    @Override
    public int getSymbolID() {
        return getID();
    }

    @Override
    public String getSymbolName() {
        return getName();
    }

    @Override
    public SymbolType getSymbolType() {
        return SymbolType.MarkSymbol;
    }
}
