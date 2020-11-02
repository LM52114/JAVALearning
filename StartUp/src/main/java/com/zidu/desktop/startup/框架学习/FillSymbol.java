package com.zidu.desktop.startup.框架学习;

/**
 * @Author Li Hao
 * @Date 2020/10/25 14:33
 * @Version 1.0
 */
public class FillSymbol extends LHSymbol implements ISymbol {
    public FillSymbol(int ID,  String name) {
        super(ID, SymbolType.FillSymbol, name);
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
        return SymbolType.FillSymbol;
    }
}
