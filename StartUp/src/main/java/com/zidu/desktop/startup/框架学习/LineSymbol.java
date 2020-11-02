package com.zidu.desktop.startup.框架学习;

/**
 * @Author Li Hao
 * @Date 2020/10/25 14:33
 * @Version 1.0
 */
public class LineSymbol extends LHSymbol implements ISymbol {
    public LineSymbol(int ID,  String name) {
        super(ID, SymbolType.LineSymbol, name);
    }

    @Override
    public int getSymbolID() {
        return 0;
    }

    @Override
    public String getSymbolName() {
        return null;
    }

    @Override
    public SymbolType getSymbolType() {
        return null;
    }
}
